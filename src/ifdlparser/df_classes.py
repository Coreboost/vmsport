class Symbol:
    def generate(self, indent):
        raise NotImplementedError("Error: generate/ must be implemented for sub-classes.")
    def print_indented(self, str, indent):
        print indent * '  ' + str

class Container_symbol(Symbol):
    def __init__(self):
        self.contents = []
    def add_child(self, child):
        self.contents.append(child)
    def generate_children(self, indent):
        for item in self.contents:
            item.generate(indent+1)

class Named_symbol(Symbol):
    def __init__(self, name):
        self.set_name(name)
    def set_name(self, name):
        self.name = name

class Form(Named_symbol, Container_symbol):
    def __init__(self, name):
        Container_symbol.__init__(self)
        Named_symbol.__init__(self, name)

    def generate(self, indent):
        self.print_indented("FORM " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END FORM", indent)

class Form_data(Container_symbol):
    def generate(self, indent):
        self.print_indented("FORM DATA", indent)
        self.generate_children(indent)
        self.print_indented("END DATA", indent)

class Group(Named_symbol, Container_symbol):
    def __init__(self, name):
        Container_symbol.__init__(self)
        Named_symbol.__init__(self, name)
    def generate(self, indent):
        self.print_indented("GROUP " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END GROUP", indent)

class Occurs(Symbol):
    def __init__(self, length):
        self.length = length
        self.name = None
    def set_current(self, name):
        self.name = name
    def generate(self, indent):
        self.print_indented("OCCURS " + self.length , indent)
        if (self.name):
            self.print_indented("CURRENT " + self.name , indent+1)

class Atomic_type(Named_symbol, Container_symbol):
    def __init__(self, name, symbol_name):
        Named_symbol.__init__(self, name)
        Container_symbol.__init__(self)
        self.symbol_name = symbol_name
    def generate(self, indent):
        self.print_indented(self.name + " " + self.symbol_name, indent)
        self.generate_children(indent)


class Longword_integer(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "LONGWORD INTEGER")

class Unsigned_longword(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "UNSIGNED LONGWORD")

class Character_data(Named_symbol, Container_symbol):
    def __init__(self, name, length):
        Named_symbol.__init__(self, name)
        Container_symbol.__init__(self)
        self.length = length
    def generate(self, indent):
        self.print_indented(self.name + " CHARACTER(" + self.length + ")", indent)
        self.generate_children(indent)

class Integer_data(Named_symbol, Container_symbol):
    def __init__(self, name, length):
        Named_symbol.__init__(self, name)
        Container_symbol.__init__(self)
        self.length = length
    def generate(self, indent):
        self.print_indented(self.name + " INTEGER(" + self.length + ")", indent)
        self.generate_children(indent)

class Datetime_data(Named_symbol, Container_symbol):
    def __init__(self, name, int_value):
        Named_symbol.__init__(self, name)
        Container_symbol.__init__(self)
        self.int_value = int_value
    def generate(self, indent):
        self.print_indented(self.name + " DATETIME(" + self.int_value + ")", indent)
        self.generate_children(indent)

class Integer_literal(Symbol):
    def __init__(self, int_value):
        self.value = int_value
    def generate(self, indent):
        self.print_indented(self.value, indent)

class Form_record(Named_symbol, Container_symbol):
    def __init__(self, name):
        Container_symbol.__init__(self)
        Named_symbol.__init__(self, name)
    def generate(self, indent):
        self.print_indented("FORM RECORD " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END RECORD", indent)

class Transfer_clause(Symbol):
    def __init__(self, reference):
        self.reference = reference
    def generate(self, indent):
        self.print_indented("USING " + self.reference, indent)

class Layout(Named_symbol, Container_symbol):
    def __init__(self, name):
        Container_symbol.__init__(self)
        Named_symbol.__init__(self, name)
    def generate(self, indent):
        self.print_indented("LAYOUT " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END LAYOUT", indent)

class Device(Named_symbol):
    def __init__(self, name):
        Named_symbol.__init__(self, name)
        self.type = None
    def set_type(self, type):
        self.type = type
    def generate(self, indent):
        name_part = ""
        if (self.name):
            name_part = " " + self.name
        self.print_indented("DEVICE", indent)
        self.print_indented("TERMINAL" + name_part, indent+1)
        self.print_indented("TYPE " + self.type, indent+1)
        self.print_indented("END DEVICE", indent)

class Size(Symbol):
    def __init__(self, lines, columns):
        self.lines = lines
        self.columns = columns
    def generate(self, indent):
        self.print_indented("SIZE " + self.lines + " LINES BY " + self.columns + " COLUMNS", indent)

class List(Named_symbol):
    def __init__(self, name):
        Named_symbol.__init__(self, name)
        self.list_items = []
    def add_list_item(self, list_item):
        self.list_items.append(list_item)
    def generate(self, indent):
        self.print_indented("LIST " + self.name, indent)
        for item in self.list_items:
            self.print_indented('"' + item + '"', indent+1)
        self.print_indented("END LIST", indent)

class Viewport(Named_symbol):
    def __init__(self, name, lines_start, lines_end, columns_start, columns_end):
        Named_symbol.__init__(self, name)
        self.lines_start = lines_start
        self.lines_end = lines_end
        self.columns_start = columns_start
        self. columns_end = columns_end
    def generate(self, indent):
        self.print_indented("VIEWPORT " + self.name, indent)
        self.print_indented("LINES " + self.lines_start + " THROUGH " + self.lines_end, indent+1)
        self.print_indented("COLUMNS " + self.columns_start + " THROUGH " + self.columns_end, indent+1)
        self.print_indented("END VIEWPORT", indent)

class Function_decl(Named_symbol):
    def __init__(self):
        Named_symbol.__init__(self, None)
        self.key_sequences = []
        self.builtin = False
    def set_builtin(self, name):
        self.builtin = True
        self.set_name(name)
    def set_key_1(self, key1):
        self.key_sequences.append([key1])
    def set_key_2(self, key2):
        self.key_sequences[-1].append(key2)
    def generate(self, indent):
        self.print_indented("FUNCTION " + self.name + " IS", indent)
        for sequence in self.key_sequences:
            if len(sequence) == 1:
                self.print_indented(sequence[0], indent+1)
            else:
                self.print_indented ("(" + sequence[0] + " " + sequence[1] + ")", indent+1)
        self.print_indented("END FUNCTION", indent)

class Internal_response(Named_symbol, Container_symbol):
    def __init__(self, name):
        Container_symbol.__init__(self)
        Named_symbol.__init__(self, name)
    def generate(self, indent):
        self.print_indented("INTERNAL RESPONSE " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END RESPONSE", indent)

class Message_step(Symbol):
    def __init__(self):
        self.lines = []
    def add_line(self, line):
        self.lines.append(line)
        return self
    def generate(self, indent):
        self.print_indented("MESSAGE", indent)
        for line in self.lines:
            self.print_indented('"' + line + '"', indent+1)
        return self

class Signal_step(Symbol):
    def __init__(self):
        self.bell = True
    def set_bell(self):
        self.bell = True
        return self
    def set_reverse(self):
        self.bell = False
        return self
    def generate(self, indent):
        if (self.bell):
            self.print_indented("SIGNAL ", indent)
        else:
            self.print_indented("SIGNAL %REVERSE", indent)
        return self

class Position_step(Symbol):
    def __init__(self):
        self.panel = None
        self.target_type = None
    def set_panel(self, panel):
        self.panel = panel
        self.target_type = "PANEL"
        return self
    def generate(self, indent):
        def undefined_target_type():
            raise NotImplementedError("The specified target type for position step not supported")

        target_types = {
            "PANEL": lambda: self.print_indented("POSITION TO PANEL " + self.panel, indent)
        }
        target_types.get(self.target_type, undefined_target_type)()
        return self

class Reset_step(Symbol):
    def __init__(self):
        self.all = False
    def set_all(self):
        self.all = True
        return self
    def generate(self, indent):
        if self.all:
            self.print_indented("RESET ALL", indent)
        return self

class Return_step(Symbol):
    def __init__(self):
        self.immediate = False
    def set_immediate(self):
        self.immediate = True
        return self
    def generate(self, indent):
        self.print_indented("RETURN" + " IMMEDIATE" if self.immediate else "", indent)

class Call_step(Symbol):
    def __init__(self, subroutine_name):
        self.subroutine_name = subroutine_name
        self.parameters = []
    def add_parameter(self, convention, name):
        self.parameters.append({'convention': convention, 'name': name})
        return self
    def generate(self, indent):
        self.print_indented('CALL "' + self.subroutine_name + '"' + ("" if len(self.parameters) == 0 else " USING"), indent)
        for parameter in self.parameters:
            self.print_indented((parameter['convention'].upper() + " " if parameter['convention'] else "") + parameter['name'], indent+1)

def test():
    form = Form("My form")
    form.add_child(Form_data())
    form.add_child(Form_record("My record"))
    form.add_child(Layout("My layout"))
    form.generate()

if __name__ == '__main__':
    from sys import argv, stdin
    test()
