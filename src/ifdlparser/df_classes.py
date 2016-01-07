class Clause:
    def generate(self, indent):
        raise NotImplementedError("Error: generate/ must be implemented for sub-classes.")
    def print_indented(self, str, indent):
        print indent * '  ' + str
        return self

class Container_clause(Clause):
    def __init__(self):
        self.contents = []
    def add_child(self, child):
        self.contents.append(child)
        return self
    def generate_children(self, indent):
        for item in self.contents:
            item.generate(indent+1)
        return self

class Named_clause(Clause):
    def __init__(self, name):
        self.set_name(name)
    def set_name(self, name):
        self.name = name
        return self

class Form_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)

    def generate(self, indent):
        self.print_indented("Form " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("End Form", indent)

class Form_data_decl(Container_clause):
    def __init__(self):
        Container_clause.__init__(self)
    def generate(self, indent):
        self.print_indented("Form Data", indent)
        self.generate_children(indent)
        self.print_indented("End Data", indent)
        return self

class Group_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def additional_generate(self, indent):
        return self
    def generate(self, indent):
        self.print_indented("Group " + self.name, indent)
        self.additional_generate(indent+1)
        self.generate_children(indent)
        self.print_indented("End Group", indent)
        return self

class Form_data_group_decl(Group_decl):
    def __init__(self, name):
        Group_decl.__init__(self, name)

class Panel_group_decl(Group_decl):
    def __init__(self, name):
        Group_decl.__init__(self, name)
        self.orientation = None
        self.displays = None
        self.location = None
    def set_orientation(self, orientation):
        self.orientation = orientation
        return self
    def set_displays(self, displays):
        self.displays = displays
        return self
    def set_location(self, location):
        self.location = location
        return self
    def additional_generate(self, indent):
        if self.orientation:
            trail = (" Displays " + self.displays) if self.displays else ""
            self.print_indented(self.orientation + trail, indent)
        if self.location:
            location.generate(indent)
        return self

class Occurs_clause(Clause):
    def __init__(self, length):
        self.length = length
        self.name = None
    def set_current(self, name):
        self.name = name
        return self
    def generate(self, indent):
        self.print_indented("Occurs " + self.length , indent)
        if self.name:
            self.print_indented("Current " + self.name , indent+1)
        return self

class Atomic_type(Named_clause, Container_clause):
    def __init__(self, name, clause_name):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
        self.clause_name = clause_name
    def generate(self, indent):
        self.print_indented(self.name + " " + self.clause_name, indent)
        self.generate_children(indent)
        return self

class Longword_integer(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "Longword Integer")

class Unsigned_longword(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "Unsigned Longword")

class Character_data(Named_clause, Container_clause):
    def __init__(self, name, length):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
        self.length = length
    def generate(self, indent):
        self.print_indented(self.name + " Character(" + self.length + ")", indent)
        self.generate_children(indent)
        return self

class Integer_data(Named_clause, Container_clause):
    def __init__(self, name, length):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
        self.length = length
    def generate(self, indent):
        self.print_indented(self.name + " Integer(" + self.length + ")", indent)
        self.generate_children(indent)
        return self

class Datetime_data(Named_clause, Container_clause):
    def __init__(self, name, int_value):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
        self.int_value = int_value
    def generate(self, indent):
        self.print_indented(self.name + " Datetime(" + self.int_value + ")", indent)
        self.generate_children(indent)
        return self

class Integer_literal(Clause):
    def __init__(self, int_value):
        self.value = int_value
    def generate(self, indent):
        self.print_indented(self.value, indent)
        return self

class Form_record_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def generate(self, indent):
        self.print_indented("Form Record " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("End Record", indent)
        return self

class Transfer_clause(Clause):
    def __init__(self, reference):
        self.reference = reference
    def generate(self, indent):
        self.print_indented("Using " + self.reference, indent)
        return self

class Layout_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def generate(self, indent):
        self.print_indented("Layout " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("End Layout", indent)
        return self

class Device_decl(Named_clause):
    def __init__(self, name):
        Named_clause.__init__(self, name)
        self.type = None
    def set_type(self, type):
        self.type = type
        return self
    def generate(self, indent):
        name_part = ""
        if self.name:
            name_part = " " + self.name
        self.print_indented("Device", indent)
        self.print_indented("Terminal" + name_part, indent+1)
        self.print_indented("Type " + self.type, indent+1)
        self.print_indented("End Device", indent)
        return self

class Size_decl(Clause):
    def __init__(self, lines, columns):
        self.lines = lines
        self.columns = columns
    def generate(self, indent):
        self.print_indented("Size " + self.lines + " Lines By " + self.columns + " Columns", indent)
        return self

class List_decl(Named_clause):
    def __init__(self, name):
        Named_clause.__init__(self, name)
        self.list_items = []
    def add_list_item(self, list_item):
        self.list_items.append(list_item)
        return self
    def generate(self, indent):
        self.print_indented("List " + self.name, indent)
        for item in self.list_items:
            self.print_indented('"' + item + '"', indent+1)
        self.print_indented("End List", indent)
        return self

class Viewport_decl(Named_clause):
    def __init__(self, name, lines_start, lines_end, columns_start, columns_end):
        Named_clause.__init__(self, name)
        self.lines_start = lines_start
        self.lines_end = lines_end
        self.columns_start = columns_start
        self. columns_end = columns_end
    def generate(self, indent):
        self.print_indented("Viewport " + self.name, indent)
        self.print_indented("Lines " + self.lines_start + " Through " + self.lines_end, indent+1)
        self.print_indented("Columns " + self.columns_start + " Through " + self.columns_end, indent+1)
        self.print_indented("End Viewport", indent)
        return self

class Function_decl(Named_clause):
    def __init__(self):
        Named_clause.__init__(self, None)
        self.key_sequences = []
        self.builtin = False
    def set_builtin(self, name):
        self.builtin = True
        self.set_name(name)
        return self
    def set_key_1(self, key1):
        self.key_sequences.append([key1])
        return self
    def set_key_2(self, key2):
        self.key_sequences[-1].append(key2)
        return self
    def generate(self, indent):
        self.print_indented("Function " + self.name + " Is", indent)
        for sequence in self.key_sequences:
            if len(sequence) == 1:
                self.print_indented(sequence[0], indent+1)
            else:
                self.print_indented ("(" + sequence[0] + " " + sequence[1] + ")", indent+1)
        self.print_indented("End Function", indent)
        return self

class Internal_response_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def generate(self, indent):
        self.print_indented("Internal Response " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("End Response", indent)
        return self

class Response_decl(Container_clause):
    def __init__(self):
        Container_clause.__init__(self)

class Function_response_decl(Named_clause, Response_decl):
    def __init__(self):
        Response_decl.__init__(self)
        self.builtin = False
        self.fmt = 1
    def set_builtin(self, name, fmt):
        self.builtin = True
        self.fmt = fmt
        self.set_name(name)
        return self
    def generate(self, indent):
        if self.fmt == 1:
            self.print_indented("Function Response " + self.name, indent)
            self.generate_children(indent)
            self.print_indented("End Response", indent)
        elif self.fmt == 2:
            self.print_indented("Builtin Function Response " + self.name, indent)
        return self

class Entry_response_decl(Response_decl):
    def __init__(self):
        Response_decl.__init__(self)
    def generate(self, indent):
        self.print_indented("ENTRY RESPONSE", indent)
        self.generate_children(indent)
        self.print_indented("END RESPONSE", indent)
        return self

class Exit_response_decl(Response_decl):
    def __init__(self):
        Response_decl.__init__(self)
    def generate(self, indent):
        self.print_indented("Exit Response", indent)
        self.generate_children(indent)
        self.print_indented("End Response", indent)
        return self

class Disable_response_decl(Response_decl):
    def __init__(self):
        Response_decl.__init__(self)
    def generate(self, indent):
        self.print_indented("Disable Response", indent)
        self.generate_children(indent)
        self.print_indented("End Response", indent)
        return self

class Receive_response_decl(Response_decl):
    def __init__(self, record_name):
        Response_decl.__init__(self)
        self.record_name = record_name
    def generate(self, indent):
        self.print_indented("Receive Response " + self.record_name, indent)
        self.generate_children(indent)
        self.print_indented("End Response", indent)
        return self

class Activate_step(Clause):
    def __init__(self):
        self.panel_name = None
        self.target_type = None
    def set_all(self):
        self.target_type = "All"
        return self
    def set_panel(self, panel_name):
        self.target_type = "Panel"
        self.panel_name = panel_name
        return self
    def generate(self, indent):
        def undefined_target_type():
            raise NotImplementedError("The specified target type for activate step not supported")
        target_types = {
            "All": lambda: self.print_indented("Activate All", indent),
            "Panel": lambda: self.print_indented("Activate Panel " + self.panel_name, indent)
        }
        target_types.get(self.target_type, undefined_target_type)()
        return self

class Message_step(Clause):
    def __init__(self):
        self.lines = []
    def add_line(self, line):
        self.lines.append(line)
        return self
    def generate(self, indent):
        self.print_indented("Message", indent)
        for line in self.lines:
            self.print_indented('"' + line + '"', indent+1)
        return self

class Signal_step(Clause):
    def __init__(self):
        self.bell = True
    def set_bell(self):
        self.bell = True
        return self
    def set_reverse(self):
        self.bell = False
        return self
    def generate(self, indent):
        if self.bell:
            self.print_indented("Signal ", indent)
        else:
            self.print_indented("Signal %Reverse", indent)
        return self

class Position_step(Clause):
    def __init__(self):
        self.panel = None
        self.target_type = None
        self.named_position = None
    def set_panel(self, panel):
        self.panel = panel
        self.target_type = "Panel"
        return self
    def set_named_position(self, named_position):
        self.named_position = named_position
        self.target_type = "Named Position"
        return self
    def generate(self, indent):
        def undefined_target_type():
            raise NotImplementedError("The specified target type for position step not supported")
        target_types = {
            "Panel":          lambda: self.print_indented("Position To Panel " + self.panel, indent),
            "Named Position": lambda: self.print_indented("Position To " + self.named_position, indent)
        }
        target_types.get(self.target_type, undefined_target_type)()
        return self

class Reset_step(Clause):
    def __init__(self):
        self.all = False
    def set_all(self):
        self.all = True
        return self
    def generate(self, indent):
        if self.all:
            self.print_indented("Reset All", indent)
        return self

class Remove_step(Clause):
    def __init__(self):
        self.all = False
        self.help = False
    def set_all(self):
        self.all = True
        return self
    def set_help(self):
        self.help = True
        return self
    def generate(self, indent):
        if self.all:
            self.print_indented("Remove All", indent)
        elif self.help:
            self.print_indented("Remove Help", indent)
        return self

class Enter_help_step(Clause):
    def generate(self, indent):
        self.print_indented("Enter Help", indent)
        return self

class Exit_help_step(Clause):
    def generate(self, indent):
        self.print_indented("Exit Help", indent)
        return self

class Return_step(Clause):
    def __init__(self):
        self.immediate = False
    def set_immediate(self):
        self.immediate = True
        return self
    def generate(self, indent):
        self.print_indented("Return" + " Immediate" if self.immediate else "", indent)
        return self

class Let_step(Clause):
    def __init__(self, data_ref, value_expression):
        self.data_ref = data_ref
        self.value_expression = value_expression
    def generate(self, indent):
        self.print_indented(self.data_ref + " = " +  self.value_expression.to_string(), indent)
        return self

class Call_step(Clause):
    def __init__(self, subroutine_name):
        self.subroutine_name = subroutine_name
        self.parameters = []
    def add_parameter(self, convention, name):
        self.parameters.append({'convention': convention, 'name': name})
        return self
    def generate(self, indent):
        self.print_indented('Call "' + self.subroutine_name + '"' + ("" if len(self.parameters) == 0 else " Using"), indent)
        for parameter in self.parameters:
            self.print_indented((parameter['convention'].upper() + " " if parameter['convention'] else "") + parameter['name'], indent+1)
        return self

class Include_step(Clause):
    def __init__(self, response_name):
        self.response_name = response_name
    def generate(self, indent):
        self.print_indented("Include " + self.response_name, indent)
        return self

class Print_step(Clause):
    def __init__(self):
        self.immediate = False
        self.panel_name = None
    def set_immediate(self):
        self.immediate = True
        return self
    def set_panel_name(self, panel_name):
        self.panel_name = panel_name
        return self
    def generate(self, indent):
        self.print_indented("Print " + ("Immediate " if self.immediate else "") + self.panel_name, indent)
        return self

class If_step(Clause):
    def __init__(self, conditional):
        self.conditional = conditional
        self.then_steps = []
        self.else_steps = []
    def add_then_step(self, step):
        self.then_steps.append(step)
        return self
    def add_else_step(self, step):
        self.else_steps.append(step)
        return self
    def generate(self, indent):
        self.print_indented("If " + self.conditional.to_string() + " Then", indent)
        for step in self.then_steps:
            step.generate(indent+1)
        if len(self.else_steps) > 0:
            self.print_indented("Else", indent)
            for step in self.else_steps:
                step.generate(indent+1)
        self.print_indented("End If", indent)
        return self

class Conditional_expression:
    def __init__(self, term_1):
        self.term_1 = term_1
        self.logical_op = None
        self.term_2 = None
        self.subexpression = False
        self.negated = False
    def set_logical_op(self, logical_op, term_2):
        self.logical_op = logical_op
        self.term_2 = term_2
        return self
    def set_subexpression(self):
        self.subexpression = True
        return self
    def set_negated(self, value):
        self.negated = value
        return self
    def to_string(self):
        lead = ("Not " if self.negated else "") + "(" if self.subexpression else ""
        trail = ")" if self.subexpression else ""
        term_1 = self.term_1.to_string()
        term_2 = (" " + self.logical_op + " " + self.term_2.to_string()) if self.logical_op else ""
        return lead + term_1 + term_2 + trail

class Relational_expression:
    def __init__(self, expression_1, relational_op, expression_2):
        self.negated = False
        self.expression_1 = expression_1
        self.relational_op = relational_op
        self.expression_2 = expression_2
    def set_negated(self, value):
        self.negated = value
        return self
    def to_string(self):
        return ("Not " if self.negated else "") + self.expression_1.to_string() + self.relational_op + self.expression_2.to_string()

class Elementary_condition:
    def __init__(self, elementary_condition):
        self.negated = False
        self.elementary_condition = elementary_condition
    def set_negated(self, value):
        self.negated = value
        return self
    def to_string(self):
        return ("Not " if self.negated else "") + self.elementary_condition

class Numeric_expression:
    def __init__(self, sign, term_1):
        self.sign = sign
        self.term_1 = term_1
        self.arithmetic_op = None
        self.term_2 = None
        self.subexpression = False
    def set_arithmetic_op(self, arithmetic_op, term_2):
        self.arithmetic_op = arithmetic_op
        self.term_2 = term_2
        return self
    def set_subexpression(self):
        self.subexpression = True
        return self
    def to_string(self):
        lead = ("(" if self.subexpression else "") + (self.sign if self.sign else "")
        trail = ((self.arithmetic_op + self.term_2.to_string()) if self.arithmetic_op else "") + (")" if self.subexpression else "")
        return lead + self.term_1.to_string() + trail

class Integer_literal:
    def __init__(self, integer_literal):
        self.integer_literal = integer_literal
    def to_string(self):
        return self.integer_literal

class String_literal:
    def __init__(self, string_literal):
        self.string_literal = string_literal
    def to_string(self):
        return self.string_literal

class Data_reference:
    def __init__(self, data_reference):
        self.data_reference = data_reference
    def to_string(self):
        return self.data_reference

class Help_panel_reference(Clause):
    def __init__(self, help_panel_name):
        self.help_panel_name = help_panel_name
    def generate(self, indent):
        if self.help_panel_name:
            self.print_indented("Use Help Panel " + self.help_panel_name, indent)
        else:
            self.print_indented("No Help Panel", indent)
        return self

class Field_default_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
    def generate(self, indent):
        self.print_indented("Field Default " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("End Default", indent)
        return self

class Field_default_appl(Container_clause):
    def __init__(self):
        Container_clause.__init__(self)
        self.named_default = None
    def set_named_default(self, named_default):
        self.named_default = named_default
        return self
    def generate(self, indent):
        if self.named_default:
            self.print_indented("Apply Field Default " + self.named_default, indent)
        elif len(self.contents) == 0:
            self.print_indented("Apply No Field Default", indent)
        else:
            self.print_indented("Apply Field Default Of", indent)
            self.generate_children(indent)
            self.print_indented("End Default", indent)
        return self

class Active_highlight_clause(Clause):
    def __init__(self):
        self.elementary_attribute = None
    def set_elementary_attribute(self, elementary_attribute):
        self.elementary_attribute = elementary_attribute
        return self
    def generate(self, indent):
        if self.elementary_attribute:
            self.print_indented("Active Highlight " + self.elementary_attribute, indent)
        else:
            self.print_indented("No Active Highlight", indent)
        return self

class Abstract_panel_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
        self.panel_properties = []
    def add_panel_property(self, property):
        self.panel_properties.append(property)
    def generate(self, indent):
        for property in self.panel_properties:
            property.generate(indent)

class Message_panel_decl(Abstract_panel_decl):
    def __init__(self, name):
        Abstract_panel_decl.__init__(self, name)
    def generate(self, indent):
        self.print_indented("Message Panel " + self.name, indent)
        Abstract_panel_decl.generate(self, indent+1)
        self.generate_children(indent)
        self.print_indented("End Panel", indent)
        return self

class Help_panel_decl(Abstract_panel_decl):
    def __init__(self, name):
        Abstract_panel_decl.__init__(self, name)
    def generate(self, indent):
        self.print_indented("Help Panel " + self.name, indent)
        Abstract_panel_decl.generate(self, indent+1)
        self.generate_children(indent)
        self.print_indented("End Panel", indent)
        return self

class Panel_decl(Abstract_panel_decl):
    def __init__(self, name):
        Abstract_panel_decl.__init__(self, name)
    def generate(self, indent):
        self.print_indented("Panel " + self.name, indent)
        Abstract_panel_decl.generate(self, indent+1)
        self.generate_children(indent)
        self.print_indented("End Panel", indent)
        return self

class Literal(Clause):
    def __init__(self):
        self.display_clause = None
    def set_display_clause(self, display_clause):
        self.display_clause=display_clause
        return self
    def generate(self, indent):
        if self.display_clause:
            self.display_clause.generate(indent)
        return self

class Literal_text(Literal):
    def __init__(self):
        Literal.__init__(self)
        self.location = None
        self.text = None
    def set_location(self, location):
        self.location = location
        return self
    def set_text(self, text):
        self.text = text
        return self
    def generate(self, indent):
        self.print_indented("Literal Text", indent)
        if self.location:
            self.location.generate(indent+1)
        self.print_indented('Value "' + self.text + '"', indent+1)
        Literal.generate(self, indent+1)
        self.print_indented("End Literal", indent)
        return self

class Literal_polyline(Literal):
    def __init__(self):
        Literal.__init__(self)
        self.locations = []
    def add_location(self, location):
        self.locations.append(location)
        return self
    def generate(self, indent):
        self.print_indented("Literal Polyline", indent)
        for location in self.locations:
            location.generate(indent+1)
        Literal.generate(self, indent+1)
        self.print_indented("End Literal", indent)
        return self

class Literal_rectangle(Literal):
    def __init__(self):
        Literal.__init__(self)
        self.first_corner = None
        self.second_corner = None
    def set_first_corner(self, first_corner):
        self.first_corner = first_corner
        return self
    def set_second_corner(self, second_corner):
        self.second_corner = second_corner
        return self
    def generate(self, indent):
        self.print_indented("Literal Rectangle", indent)
        self.first_corner.generate(indent+1)
        self.second_corner.generate(indent+1)
        Literal.generate(self, indent+1)
        self.print_indented("End Literal", indent)
        return self

class Full_loc_clause(Clause):
    def __init__(self, horizontal_clause, vertical_clause):
        self.horizontal_clause = horizontal_clause
        self.vertical_clause = vertical_clause
    def generate(self, indent):
        self.print_indented(self.vertical_clause.to_string() + " " + self.horizontal_clause.to_string(), indent)
        return self

class Horizontal_loc_clause(Clause):
    def __init__(self, value):
        self.value = value
    def to_string(self):
        return "Column " + self.value

class Vertical_loc_clause(Clause):
    def __init__(self, value):
        self.value = value
    def to_string(self):
        return "Line " + self.value

class Icon_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def generate(self, indent):
        self.print_indented("Icon " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("End Icon", indent)
        return self

class Display_elementary_attribute(Clause):
    def __init__(self, attribute_name):
        self.attribute_name = attribute_name
    def generate(self, indent):
        self.print_indented("Display " + self.attribute_name, indent)
        return self

class Display_implementor_attribute(Clause):
    def __init__(self, attribute_name):
        self.attribute_name = attribute_name
    def generate(self, indent):
        self.print_indented("Display " + self.attribute_name, indent)
        return self

class Viewport_reference(Clause):
    def __init__(self, viewport_name):
        self.viewport_name = viewport_name
    def generate(self, indent):
        self.print_indented("Viewport " + self.viewport_name, indent)
        return self

class Font_decl(Clause):
    def __init__(self):
        self.font_family = None
        self.font_style = None
        self.font_weight = None
        self.font_size_named = None
        self.font_size_points = None
    def set_font_family(self, font_family):
        self.font_family = font_family
        return self
    def set_font_style(self, font_style):
        self.font_style = font_style
        return self
    def set_font_weight(self, font_weight):
        self.font_weight = font_weight
        return self
    def set_font_size_named(self, font_size_named):
        self.font_size_named = font_size_named
        return self
    def set_font_size_points(self, font_size_points):
        self.font_size_named = font_size_points
        return self
    def generate(self, indent):
        if self.font_family:
            self.print_indented("Display Font Family " + self.font_family, indent)
        if self.font_style:
            self.print_indented("Display Font Style " + self.font_style, indent)
        if self.font_weight:
            self.print_indented("Display Font Weight " + self.font_weight, indent)
        if self.font_size_named:
            self.print_indented("Display Font Size " + self.font_size_named, indent)
        if self.font_size_points:
            self.print_indented("Display Font Size " + self.font_size_points, indent)
        return self

class Field_decl(Named_clause):
    def __init__(self, name):
        Named_clause.__init__(self, name)
        self.item_description_entries = []
        self.field_validation_entries = []
        self.autoskip = False
        self.uppercase = False
        self.location = None
    def add_item_description_entry(self, item_description_entry):
        self.item_description_entries.append(item_description_entry)
        return self
    def add_field_validation_entry(self, field_validation_entry):
        self.field_validation_entries.append(field_validation_entry)
        return self
    def set_autoskip(self, autoskip):
        self.autoskip = autoskip
        return self
    def set_uppercase(self, uppercase):
        self.uppercase = uppercase
        return self
    def set_location(self, location):
        self.location = location
        return self
    def generate(self, indent):
        for entry in self.item_description_entries:
            entry.generate(indent)
        for entry in self.field_validation_entries:
            entry.generate(indent)
        if self.autoskip:
            self.print_indented("Autoskip", indent)
        if self.uppercase:
            self.print_indented("Uppercase", indent)
        if self.location:
            self.location.generate(indent)
        return self

class Picture_field_decl(Field_decl):
    def __init__(self, name):
        Field_decl.__init__(self, name)
        self.editing_entries = []
        self.input_picture = None
        self.input_picture_for_date = False
        self.output_picture = None
        self.protected = None
        self.protected_when = None
        self.justification = None
        self.output_when = None
    def add_editing_entry(self, editing_entry):
        self.editing_entries.append(editing_entry)
        return self
    def set_input_picture(self, input_picture):
        self.input_picture = input_picture
        return self
    def set_input_picture_for_date(self):
        self.input_picture_for_date = True
        return self
    def set_output_picture(self, output_picture):
        self.output_picture = output_picture
        return self
    def set_protected(self, protected):
        self.protected = protected
        return self
    def set_protected_when(self, protected_when):
        self.protected_when = protected_when
        return self
    def set_justification(self, justification):
        self.justification = justification
        return self
    def set_output_when(self, output_when):
        self.output_when = output_when
        return self
    def generate(self, indent):
        self.print_indented("Field " + self.name, indent)
        Field_decl.generate(self, indent+1)
        for entry in self.editing_entries:
            entry.generate(indent+1)
        if self.input_picture:
            for_date = "For Date " if (self.input_picture_for_date) else ""
            self.print_indented("Input Picture " + for_date +self.input_picture, indent+1)
        if self.output_picture:
            self.print_indented("Output Picture " + self.output_picture, indent+1)
        if (self.protected):
            trail = (" When " + self.protected_when.to_string()) if (self.protected_when) else ""
            self.print_indented("Protected" + trail, indent+1)
        if self.justification:
            self.print_indented("Justification " + self.justification, indent+1)
        if self.output_when:
            self.print_indented("Output " + '"' + self.output_when["output"] + '"' + " When " + self.output_when["when"].to_string(), indent+1)
        self.print_indented("End Field", indent)
        return self

class Text_field_decl(Field_decl):
    def __init__(self, name):
        Field_decl.__init__(self, name)
        self.rows = None
        self.columns = None
    def set_rows(self, rows):
        self.rows = rows
        return self
    def set_columns(self, columns):
        self.columns = columns
        return self
    def generate(self, indent):
        self.print_indented("Textfield " + self.name, indent)
        Field_decl.generate(self, indent+1)
        if self.rows:
            self.print_indented("Rows " + self.rows, indent+1)
        if self.columns:
            self.print_indented("Columns " + self.columns, indent+1)
        self.print_indented("End Field", indent)
        return self

class Field_validation_entry(Clause):
    def __init__(self):
        self.search = None
        self.range_lower = None
        self.range_upper = None
        self.message = None
    def set_search(self, search):
        self.search = search
        return self
    def set_range_lower(self, range_lower):
        self.range_lower = range_lower
        return self
    def set_range_upper(self, range_upper):
        self.range_upper = range_upper
        return self
    def set_message(self, message):
        self.message = message
    def generate(self, indent):
        message_spec = ((" " + self.message.to_string())) if self.message else ""
        if self.search:
            self.print_indented("Search " + self.search + message_spec, indent)
        if self.range_lower:
            self.print_indented("Range " + self.range_lower["value"] + " Through " + self.range_upper["value"] + message_spec, indent)
        return self

class Editing_entry(Clause):
    def __init__(self):
        self.scale = None
    def set_scale(self, scale):
        self.scale = scale
        return self
    def generate(self, indent):
        if self.scale:
            self.print_indented("Scale " + self.scale, indent)
        return self

class Message_clause(Clause):
    def __init__(self):
        self.string = None
    def set_string(self, string):
        self.string = string
        return self
    def to_string(self):
        if self.string:
            return "Message " + self.string
        else:
            return ""

def test():
    form = Form("My form")
    form.add_child(Form_data())
    form.add_child(Form_record("My record"))
    form.add_child(Layout("My layout"))
    form.generate()

if __name__ == '__main__':
    from sys import argv, stdin
    test()
