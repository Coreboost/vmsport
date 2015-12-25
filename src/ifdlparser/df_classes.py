class Symbol:
    def generate(self):
        raise NotImplementedError("Error: generate/ must be implemented for sub-classes.")

class ContainerSymbol(Symbol):
    def __init__(self):
        self.contents = []
    def add_child(self, child):
        self.contents.append(child)
    def generate_children(self):
        for item in self.contents:
            item.generate()

class NamedSymbol(Symbol):
    def __init__(self, name):
        self.name = name

class Form(NamedSymbol, ContainerSymbol):
    def __init__(self, name):
        ContainerSymbol.__init__(self)
        NamedSymbol.__init__(self, name)

    def generate(self):
        print "FORM " + self.name
        self.generate_children()
        print "END FORM"

class Form_data(ContainerSymbol):
    def generate(self):
        print "FORM DATA"
        self.generate_children()
        print "END DATA"

class Tracked(Symbol):
    def generate(self):
        print "TRACKED"

class Untracked(Symbol):
    def generate(self):
        print "UNTRACKED"

class Byte_integer(Symbol):
    def generate(self):
        print "BYTE INTEGER"

class Dfloating(Symbol):
    def generate(self):
        print "DFLOATING"

class Ffloating(Symbol):
    def generate(self):
        print "FFLOATING"

class Gfloating(Symbol):
    def generate(self):
        print "GFLOATING"

class HFloating(Symbol):
    def generate(self):
        print "HFLOATING"

class Long_float(Symbol):
    def generate(self):
        print "LONG FLOAT"

class Longword_integer(Symbol):
    def generate(self):
        print "LONGWORD INTEGER"

class Quadword_integer(Symbol):
    def generate(self):
        print "QUADWORD INTEGER"

class Sfloating(Symbol):
    def generate(self):
        print "SFLOATING"

class Short_float(Symbol):
    def generate(self):
        print "SHORT FLOAT"

class Tfloating(Symbol):
    def generate(self):
        print "TFLOATING"

class Unsigned_byte(Symbol):
    def generate(self):
        print "UNSIGNED BYTE"

class Unsigned_longword(Symbol):
    def generate(self):
        print "UNSIGNED LONGWORD"

class Unsigned_word(Symbol):
    def generate(self):
        print "UNSIGNED WORD"

class Word_integer(Symbol):
    def generate(self):
        print "WORD INTEGER"

class Xfloating(Symbol):
    def generate(self):
        print "XFLOATING"

class Character_data(NamedSymbol):
    def __init__(self, name, length, varying, null_terminated):
        NamedSymbol.__init__(self, name)
        self.length = length
        self.varying = varying
        self.null_terminated = null_terminated
    def generate(self):
        suffix = ""
        if (self.varying):
            suffix = " VARYING"
        if (self.null_terminated):
            suffix = " NULL TERMINATED"
        print self.name + " CHARACTER(" + self.length + ")" + suffix

class Integer_data(NamedSymbol):
    def __init__(self, name, length, packed):
        NamedSymbol.__init__(self, name)
        self.length = length
        self.packed = packed
    def generate(self):
        suffix = ""
        if (self.packed):
            suffix = " PACKED"
        print self.name + " INTEGER(" + self.length + ")" + suffix

class Decimal(Symbol):
    def generate(self):
        print "DECIMAL"

class Float(Symbol):
    def generate(self):
        print "FLOAT"

class Packed(Symbol):
    def generate(self):
        print "PACKED"

class Adt(Symbol):
    def generate(self):
        print "ADT"

class Date(Symbol):
    def generate(self):
        print "DATE"

class Time(Symbol):
    def generate(self):
        print "Time"

class Current(Symbol):
    def generate(self):
        print "CURRENT"

class Datetime(Symbol):
    def __init__(self, int_value):
        self.value = int_value
    def generate(self):
        print "DATETIME(" + self.value + ")"

class Integer_literal(Symbol):
    def __init__(self, int_value):
        self.value = int_value
    def generate(self):
        print self.value

class Form_record(NamedSymbol, ContainerSymbol):
    def __init__(self, name):
        ContainerSymbol.__init__(self)
        NamedSymbol.__init__(self, name)
    def generate(self):
        print "FORM RECORD " + self.name
        self.generate_children()
        print "END RECORD"

class Layout(NamedSymbol, ContainerSymbol):
    def __init__(self, name):
        ContainerSymbol.__init__(self)
        NamedSymbol.__init__(self, name)
    def generate(self):
        print "LAYOUT " + self.name
        self.generate_children()
        print "END LAYOUT"

def test():
    form = Form("My form")
    form.add_child(Form_data())
    form.add_child(Form_record("My record"))
    form.add_child(Layout("My layout"))
    form.generate()

if __name__ == '__main__':
    from sys import argv, stdin
    test()
