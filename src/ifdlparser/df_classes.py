class Form:
    def __init__(self, name):
        self.name = name
        self.contents = []
    def add_child(self, child):
        self.contents.append(child)
    def generate(self):
        print "FORM " + self.name
        for item in self.contents:
            item.generate()
        print "END FORM"

class Form_data:
    def __init__(self):
        self.contents = []
    def add_child(self, child):
        self.contents.append(child)
    def generate(self):
        print "FORM DATA"
        for item in self.contents:
            item.generate()
        print "END DATA"

class Form_record:
    def __init__(self, name):
        self.name = name
        self.contents = []
    def add_child(self, child):
        self.contents.append(child)
    def generate(self):
        print "FORM RECORD " + self.name
        for item in self.contents:
            item.generate()
        print "END RECORD"

class Layout:
    def __init__(self, name):
        self.name = name
        self.contents = []
    def add_child(self, child):
        self.contents.append(child)
    def generate(self):
        print "LAYOUT " + self.name
        for item in self.contents:
            item.generate()
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
