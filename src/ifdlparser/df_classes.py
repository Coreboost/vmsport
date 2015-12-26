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

class Tracked(Symbol):
    def generate(self, indent):
        self.print_indented("TRACKED", indent)

class Untracked(Symbol):
    def generate(self, indent):
        self.print_indented("UNTRACKED", indent)

class Atomic_type(Named_symbol):
    def __init__(self, name, symbol_name):
        Named_symbol.__init__(self, name)
        self.symbol_name = symbol_name
    def generate(self, indent):
        self.print_indented(self.name + " " + self.symbol_name, indent)

class Byte_integer(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "BYTE INTEGER")

class Dfloating(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "DFLOATING")

class Ffloating(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "FFLOATING")

class Gfloating(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "GFLOATING")

class HFloating(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "HFLOATING")

class Long_float(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "LONG FLOAT")

class Longword_integer(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "LONGWORD INTEGER")

class Quadword_integer(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "QUADWORD INTEGER")

class Sfloating(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "SFLOATING")

class Short_float(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "SHORT FLOAT")

class Tfloating(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "TFLOATING")

class Unsigned_byte(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "UNSIGNED BYTE")

class Unsigned_longword(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "UNSIGNED LONGWORD")

class Unsigned_word(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "UNSIGNED WORD")

class Word_integer(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "WORD INTEGER")

class Xfloating(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "XFLOATING")

class Character_data(Named_symbol):
    def __init__(self, name, length, varying, null_terminated):
        Named_symbol.__init__(self, name)
        self.length = length
        self.varying = varying
        self.null_terminated = null_terminated
    def generate(self, indent):
        suffix = ""
        if (self.varying):
            suffix = " VARYING"
        if (self.null_terminated):
            suffix = " NULL TERMINATED"
        self.print_indented(self.name + " CHARACTER(" + self.length + ")" + suffix, indent)

class Integer_data(Named_symbol):
    def __init__(self, name, length, packed):
        Named_symbol.__init__(self, name)
        self.length = length
        self.packed = packed
    def generate(self, indent):
        suffix = ""
        if (self.packed):
            suffix = " PACKED"
        self.print_indented(self.name + " INTEGER(" + self.length + ")" + suffix, indent)

class Decimal_data(Named_symbol):
    def __init__(self, name, whole_places, dec_places, packed):
        Named_symbol.__init__(self, name)
        self.whole_places = whole_places
        self.dec_places = dec_places
        self.packed = packed
    def generate(self, indent):
        suffix = ""
        if (self.packed):
            suffix = " PACKED"
        self.print_indented(self.name + " DECIMAL(" + self.whole_places + ", " + self.dec_places + ")" + suffix, indent)

class Float_data(Named_symbol):
    def __init__(self, name, base_places, exponent_places):
        Named_symbol.__init__(self, name)
        self.base_places = base_places
        self.exponent_places = exponent_places
    def generate(self, indent):
        exp_part = ""
        if (self.exponent_places != -1):
            exp_part = ", " + self.exponent_places
        self.print_indented(self.name + " FLOAT(" + self.base_places + exp_part + ")", indent)

class Adt_data(Named_symbol):
    def __init__(self, name, current):
        Named_symbol.__init__(self, name)
        self.current = current
    def generate(self, indent):
        suffix = ""
        if (self.current):
            suffix = " CURRENT"
        self.print_indented(self.name + " ADT" + suffix, indent)

class Date_data(Named_symbol):
    def __init__(self, name, current):
        Named_symbol.__init__(self, name)
        self.current = current
    def generate(self, indent):
        suffix = ""
        if (self.current):
            suffix = " CURRENT"
        self.print_indented(self.name + " DATE" + suffix, indent)

class Time_data(Named_symbol):
    def __init__(self, name, current):
        Named_symbol.__init__(self, name)
        self.current = current
    def generate(self, indent):
        suffix = ""
        if (self.current):
            suffix = " CURRENT"
        self.print_indented(self.name + " TIME" + suffix, indent)

class Datetime(Named_symbol):
    def __init__(self, name, int_value):
        Named_symbol.__init__(self, name)
        self.value = int_value
    def generate(self, indent):
        self.print_indented(self.name + " DATETIME(" + self.value + ")", indent)

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
