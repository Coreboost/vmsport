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

class Atomic_type(Named_symbol):
    def __init__(self, name, symbol_name):
        Named_symbol.__init__(self, name)
        self.symbol_name = symbol_name
    def generate(self, indent):
        self.print_indented(self.name + " " + self.symbol_name, indent)

class Longword_integer(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "LONGWORD INTEGER")

class Unsigned_longword(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "UNSIGNED LONGWORD")

class Character_data(Named_symbol):
    def __init__(self, name, length):
        Named_symbol.__init__(self, name)
        self.length = length
    def generate(self, indent):
        self.print_indented(self.name + " CHARACTER(" + self.length + ")", indent)

class Integer_data(Named_symbol):
    def __init__(self, name, length):
        Named_symbol.__init__(self, name)
        self.length = length
    def generate(self, indent):
        self.print_indented(self.name + " INTEGER(" + self.length + ")", indent)

class Datetime_data(Named_symbol):
    def __init__(self, name, int_value):
        Named_symbol.__init__(self, name)
        self.int_value = int_value
    def generate(self, indent):
        self.print_indented(self.name + " DATETIME(" + self.int_value + ")", indent)

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

class Layout(Named_symbol, Container_symbol):
    def __init__(self, name):
        Container_symbol.__init__(self)
        Named_symbol.__init__(self, name)
    def generate(self, indent):
        self.print_indented("LAYOUT " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END LAYOUT", indent)

def test():
    form = Form("My form")
    form.add_child(Form_data())
    form.add_child(Form_record("My record"))
    form.add_child(Layout("My layout"))
    form.generate()

if __name__ == '__main__':
    from sys import argv, stdin
    test()
