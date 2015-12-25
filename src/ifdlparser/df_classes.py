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
