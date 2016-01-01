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
        self.print_indented("FORM " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END FORM", indent)

class Form_data_decl(Container_clause):
    def __init__(self):
        Container_clause.__init__(self)
    def generate(self, indent):
        self.print_indented("FORM DATA", indent)
        self.generate_children(indent)
        self.print_indented("END DATA", indent)
        return self

class Group_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def additional_generate(self, indent):
        return self
    def generate(self, indent):
        self.print_indented("GROUP " + self.name, indent)
        self.additional_generate(indent+1)
        self.generate_children(indent)
        self.print_indented("END GROUP", indent)
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
            trail = (" DISPLAYS " + self.displays) if self.displays else ""
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
        self.print_indented("OCCURS " + self.length , indent)
        if self.name:
            self.print_indented("CURRENT " + self.name , indent+1)
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
        Atomic_type.__init__(self, name, "LONGWORD INTEGER")

class Unsigned_longword(Atomic_type):
    def __init__(self, name):
        Atomic_type.__init__(self, name, "UNSIGNED LONGWORD")

class Character_data(Named_clause, Container_clause):
    def __init__(self, name, length):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
        self.length = length
    def generate(self, indent):
        self.print_indented(self.name + " CHARACTER(" + self.length + ")", indent)
        self.generate_children(indent)
        return self

class Integer_data(Named_clause, Container_clause):
    def __init__(self, name, length):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
        self.length = length
    def generate(self, indent):
        self.print_indented(self.name + " INTEGER(" + self.length + ")", indent)
        self.generate_children(indent)
        return self

class Datetime_data(Named_clause, Container_clause):
    def __init__(self, name, int_value):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
        self.int_value = int_value
    def generate(self, indent):
        self.print_indented(self.name + " DATETIME(" + self.int_value + ")", indent)
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
        self.print_indented("FORM RECORD " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END RECORD", indent)
        return self

class Transfer_clause(Clause):
    def __init__(self, reference):
        self.reference = reference
    def generate(self, indent):
        self.print_indented("USING " + self.reference, indent)
        return self

class Layout_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def generate(self, indent):
        self.print_indented("LAYOUT " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END LAYOUT", indent)
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
        self.print_indented("DEVICE", indent)
        self.print_indented("TERMINAL" + name_part, indent+1)
        self.print_indented("TYPE " + self.type, indent+1)
        self.print_indented("END DEVICE", indent)
        return self

class Size_decl(Clause):
    def __init__(self, lines, columns):
        self.lines = lines
        self.columns = columns
    def generate(self, indent):
        self.print_indented("SIZE " + self.lines + " LINES BY " + self.columns + " COLUMNS", indent)
        return self

class List_decl(Named_clause):
    def __init__(self, name):
        Named_clause.__init__(self, name)
        self.list_items = []
    def add_list_item(self, list_item):
        self.list_items.append(list_item)
        return self
    def generate(self, indent):
        self.print_indented("LIST " + self.name, indent)
        for item in self.list_items:
            self.print_indented('"' + item + '"', indent+1)
        self.print_indented("END LIST", indent)
        return self

class Viewport_decl(Named_clause):
    def __init__(self, name, lines_start, lines_end, columns_start, columns_end):
        Named_clause.__init__(self, name)
        self.lines_start = lines_start
        self.lines_end = lines_end
        self.columns_start = columns_start
        self. columns_end = columns_end
    def generate(self, indent):
        self.print_indented("VIEWPORT " + self.name, indent)
        self.print_indented("LINES " + self.lines_start + " THROUGH " + self.lines_end, indent+1)
        self.print_indented("COLUMNS " + self.columns_start + " THROUGH " + self.columns_end, indent+1)
        self.print_indented("END VIEWPORT", indent)
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
        self.print_indented("FUNCTION " + self.name + " IS", indent)
        for sequence in self.key_sequences:
            if len(sequence) == 1:
                self.print_indented(sequence[0], indent+1)
            else:
                self.print_indented ("(" + sequence[0] + " " + sequence[1] + ")", indent+1)
        self.print_indented("END FUNCTION", indent)
        return self

class Internal_response_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def generate(self, indent):
        self.print_indented("INTERNAL RESPONSE " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END RESPONSE", indent)
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
            self.print_indented("FUNCTION RESPONSE " + self.name, indent)
            self.generate_children(indent)
            self.print_indented("END RESPONSE", indent)
        elif self.fmt == 2:
            self.print_indented("BUITIN FUNCTION RESPONSE " + self.name, indent)
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
        self.print_indented("Exit RESPONSE", indent)
        self.generate_children(indent)
        self.print_indented("END RESPONSE", indent)
        return self

class Disable_response_decl(Response_decl):
    def __init__(self):
        Response_decl.__init__(self)
    def generate(self, indent):
        self.print_indented("DISABLE RESPONSE", indent)
        self.generate_children(indent)
        self.print_indented("END RESPONSE", indent)
        return self

class Receive_response_decl(Response_decl):
    def __init__(self, record_name):
        Response_decl.__init__(self)
        self.record_name = record_name
    def generate(self, indent):
        self.print_indented("RECEIVE RESPONSE " + self.record_name, indent)
        self.generate_children(indent)
        self.print_indented("END RESPONSE", indent)
        return self

class Activate_step(Clause):
    def __init__(self):
        self.panel_name = None
        self.target_type = None
    def set_all(self):
        self.target_type = "ALL"
        return self
    def set_panel(self, panel_name):
        self.target_type = "PANEL"
        self.panel_name = panel_name
        return self
    def generate(self, indent):
        def undefined_target_type():
            raise NotImplementedError("The specified target type for activate step not supported")
        target_types = {
            "ALL": lambda: self.print_indented("ACTIVATE ALL", indent),
            "PANEL": lambda: self.print_indented("ACTIVATE PANEL " + self.panel_name, indent)
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
        self.print_indented("MESSAGE", indent)
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
            self.print_indented("SIGNAL ", indent)
        else:
            self.print_indented("SIGNAL %REVERSE", indent)
        return self

class Position_step(Clause):
    def __init__(self):
        self.panel = None
        self.target_type = None
        self.named_position = None
    def set_panel(self, panel):
        self.panel = panel
        self.target_type = "PANEL"
        return self
    def set_named_position(self, named_position):
        self.named_position = named_position
        self.target_type = "NAMED POSITION"
        return self
    def generate(self, indent):
        def undefined_target_type():
            raise NotImplementedError("The specified target type for position step not supported")
        target_types = {
            "PANEL":          lambda: self.print_indented("POSITION TO PANEL " + self.panel, indent),
            "NAMED POSITION": lambda: self.print_indented("POSITION TO " + self.named_position, indent)
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
            self.print_indented("RESET ALL", indent)
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
            self.print_indented("REMOVE ALL", indent)
        elif self.help:
            self.print_indented("REMOVE HELP", indent)
        return self

class Enter_help_step(Clause):
    def generate(self, indent):
        self.print_indented("ENTER HELP", indent)
        return self

class Exit_help_step(Clause):
    def generate(self, indent):
        self.print_indented("EXIT HELP", indent)
        return self

class Return_step(Clause):
    def __init__(self):
        self.immediate = False
    def set_immediate(self):
        self.immediate = True
        return self
    def generate(self, indent):
        self.print_indented("RETURN" + " IMMEDIATE" if self.immediate else "", indent)
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
        self.print_indented('CALL "' + self.subroutine_name + '"' + ("" if len(self.parameters) == 0 else " USING"), indent)
        for parameter in self.parameters:
            self.print_indented((parameter['convention'].upper() + " " if parameter['convention'] else "") + parameter['name'], indent+1)
        return self

class Include_step(Clause):
    def __init__(self, response_name):
        self.response_name = response_name
    def generate(self, indent):
        self.print_indented("INCLUDE " + self.response_name, indent)
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
        self.print_indented("PRINT " + ("IMMEDIATE " if self.immediate else "") + self.panel_name, indent)
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
        self.print_indented("IF " + self.conditional.to_string() + " THEN", indent)
        for step in self.then_steps:
            step.generate(indent+1)
        if len(self.else_steps) > 0:
            self.print_indented("ELSE", indent)
            for step in self.else_steps:
                step.generate(indent+1)
        self.print_indented("END IF", indent)
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
        lead = ("NOT " if self.negated else "") + "(" if self.subexpression else ""
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
        return ("NOT " if self.negated else "") + self.expression_1.to_string() + self.relational_op + self.expression_2.to_string()

class Elementary_condition:
    def __init__(self, elementary_condition):
        self.negated = False
        self.elementary_condition = elementary_condition
    def set_negated(self, value):
        self.negated = value
        return self
    def to_string(self):
        return ("NOT " if self.negated else "") + self.elementary_condition

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
            self.print_indented("USE HELP PANEL " + self.help_panel_name, indent)
        else:
            self.print_indented("NO HELP PANEL", indent)
        return self

class Field_default_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Named_clause.__init__(self, name)
        Container_clause.__init__(self)
    def generate(self, indent):
        self.print_indented("FIELD DEFAULT " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END DEFAULT", indent)
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
            self.print_indented("APPLY FIELD DEFAULT " + self.named_default, indent)
        elif len(self.contents) == 0:
            self.print_indented("APPLY NO FIELD DEFAULT", indent)
        else:
            self.print_indented("APPLY FIELD DEFAULT OF", indent)
            self.generate_children(indent)
            self.print_indented("END DEFAULT", indent)
        return self

class Active_highlight_clause(Clause):
    def __init__(self):
        self.elementary_attribute = None
    def set_elementary_attribute(self, elementary_attribute):
        self.elementary_attribute = elementary_attribute
        return self
    def generate(self, indent):
        if self.elementary_attribute:
            self.print_indented("ACTIVE HIGHLIGHT " + self.elementary_attribute, indent)
        else:
            self.print_indented("NO ACTIVE HIGHLIGHT", indent)
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
        self.print_indented("MESSAGE PANEL " + self.name, indent)
        Abstract_panel_decl.generate(self, indent+1)
        self.generate_children(indent)
        self.print_indented("END PANEL", indent)
        return self

class Help_panel_decl(Abstract_panel_decl):
    def __init__(self, name):
        Abstract_panel_decl.__init__(self, name)
    def generate(self, indent):
        self.print_indented("HELP PANEL " + self.name, indent)
        Abstract_panel_decl.generate(self, indent+1)
        self.generate_children(indent)
        self.print_indented("END PANEL", indent)
        return self

class Panel_decl(Abstract_panel_decl):
    def __init__(self, name):
        Abstract_panel_decl.__init__(self, name)
    def generate(self, indent):
        self.print_indented("PANEL " + self.name, indent)
        Abstract_panel_decl.generate(self, indent+1)
        self.generate_children(indent)
        self.print_indented("END PANEL", indent)
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
        self.print_indented("LITERAL TEXT", indent)
        if self.location:
            self.location.generate(indent+1)
        self.print_indented('VALUE "' + self.text + '"', indent+1)
        Literal.generate(self, indent+1)
        self.print_indented("END LITERAL", indent)
        return self

class Literal_polyline(Literal):
    def __init__(self):
        Literal.__init__(self)
        self.locations = []
    def add_location(self, location):
        self.locations.append(location)
        return self
    def generate(self, indent):
        self.print_indented("LITERAL POLYLINE", indent)
        for location in self.locations:
            location.generate(indent+1)
        Literal.generate(self, indent+1)
        self.print_indented("END LITERAL", indent)
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
        self.print_indented("LITERAL RECTANGLE", indent)
        self.first_corner.generate(indent+1)
        self.second_corner.generate(indent+1)
        Literal.generate(self, indent+1)
        self.print_indented("END LITERAL", indent)
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
        return "COLUMN " + self.value

class Vertical_loc_clause(Clause):
    def __init__(self, value):
        self.value = value
    def to_string(self):
        return "LINE " + self.value

class Icon_decl(Named_clause, Container_clause):
    def __init__(self, name):
        Container_clause.__init__(self)
        Named_clause.__init__(self, name)
    def generate(self, indent):
        self.print_indented("ICON " + self.name, indent)
        self.generate_children(indent)
        self.print_indented("END ICON", indent)
        return self

class Display_elementary_attribute(Clause):
    def __init__(self, attribute_name):
        self.attribute_name = attribute_name
    def generate(self, indent):
        self.print_indented("DISPLAY " + self.attribute_name, indent)
        return self

class Display_implementor_attribute(Clause):
    def __init__(self, attribute_name):
        self.attribute_name = attribute_name
    def generate(self, indent):
        self.print_indented("DISPLAY " + self.attribute_name, indent)
        return self

class Viewport_reference(Clause):
    def __init__(self, viewport_name):
        self.viewport_name = viewport_name
    def generate(self, indent):
        self.print_indented("VIEWPORT " + self.viewport_name, indent)
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
            self.print_indented("DISPLAY FONT FAMILY " + self.font_family, indent)
        if self.font_style:
            self.print_indented("DISPLAY FONT STYLE " + self.font_style, indent)
        if self.font_weight:
            self.print_indented("DISPLAY FONT WEIGHT " + self.font_weight, indent)
        if self.font_size_named:
            self.print_indented("DISPLAY FONT SIZE " + self.font_size_named, indent)
        if self.font_size_points:
            self.print_indented("DISPLAY FONT SIZE " + self.font_size_points, indent)
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
            self.print_indented("AUTOSKIP", indent)
        if self.uppercase:
            self.print_indented("UPPERCASE", indent)
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
        self.print_indented("FIELD " + self.name, indent)
        Field_decl.generate(self, indent+1)
        for entry in self.editing_entries:
            entry.generate(indent+1)
        if self.input_picture:
            for_date = "FOR DATE " if (self.input_picture_for_date) else ""
            self.print_indented("INPUT PICTURE " + for_date +self.input_picture, indent+1)
        if self.output_picture:
            self.print_indented("OUTPUT PICTURE " + self.output_picture, indent+1)
        if (self.protected):
            trail = (" WHEN " + self.protected_when.to_string()) if (self.protected_when) else ""
            self.print_indented("PROTECTED" + trail, indent+1)
        if self.justification:
            self.print_indented("JUSTIFICATION " + self.justification, indent+1)
        if self.output_when:
            self.print_indented("OUTPUT " + '"' + self.output_when["output"] + '"' + " WHEN " + self.output_when["when"].to_string(), indent+1)
        self.print_indented("END FIELD", indent)
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
        self.print_indented("TEXTFIELD " + self.name, indent)
        Field_decl.generate(self, indent+1)
        if self.rows:
            self.print_indented("ROWS " + self.rows, indent+1)
        if self.columns:
            self.print_indented("COLUMNS " + self.columns, indent+1)
        self.print_indented("END FIELD", indent)
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
            self.print_indented("SEARCH " + self.search + message_spec, indent)
        if self.range_lower:
            self.print_indented("RANGE " + self.range_lower["value"] + " THROUGH " + self.range_upper["value"] + message_spec, indent)
        return self

class Editing_entry(Clause):
    def __init__(self):
        self.scale = None
    def set_scale(self, scale):
        self.scale = scale
        return self
    def generate(self, indent):
        if self.scale:
            self.print_indented("SCALE " + self.scale, indent)
        return self

class Message_clause(Clause):
    def __init__(self):
        self.string = None
    def set_string(self, string):
        self.string = string
        return self
    def to_string(self):
        if self.string:
            return "MESSAGE " + self.string
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
