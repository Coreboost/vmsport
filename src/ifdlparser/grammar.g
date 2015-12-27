import df_classes

stack = []
last_added = None

def add_child_to_last_added(child):
  global last_added
  last_added.add_child(child)
  last_added = child
  return child

def add_child(child):
  global last_added, stack
  last_added = child
  if len(stack) > 0:
    stack[-1].add_child(child)
  return child

def push(item):
  global stack
  add_child(item)
  stack.append(item)
  return item

def pop():
  global stack
  popped = stack.pop()
  if len(stack) == 0:
    popped.generate(0)
  return popped

%%

parser IFDL:
    ignore: '[ \r\t\n]+|/\*(.|\n|\r)*\*/'
    token FORM:                 "(?i)FORM"
    token END_FORM:             "(?i)END[ \t]+FORM"
    token FORM_DATA:            "(?i)FORM[ \t]+DATA"
    token END_DATA:             "(?i)END[ \t]+DATA"
    token GROUP:                "(?i)GROUP"
    token END_GROUP:            "(?i)END[ \t]+GROUP"
    token OCCURS:               "(?i)OCCURS"
    token CURRENT:              "(?i)CURRENT"
    token FORM_RECORD:          "(?i)FORM[ \t]+RECORD"
    token END_RECORD:           "(?i)END[ \t]+RECORD"
    token USING:                "(?i)USING"
    token LAYOUT:               "(?i)LAYOUT"
    token END_LAYOUT:           "(?i)END[ \t]+LAYOUT"
    token DEVICE:               "(?i)DEVICE"
    token END_DEVICE:           "(?i)END[ \t]+DEVICE"
    token TERMINAL:             "(?i)TERMINAL"
    token TYPE:                 "(?i)TYPE"
    token VT100:                "(?i)%VT100"
    token VT400:                "(?i)%VT400"
    token SIZE:                 "(?i)SIZE"
    token LINES_BY:             "(?i)LINES[ \t]+BY"
    token COLUMNS:              "(?i)COLUMNS"
    token VALUE:                "(?i)VALUE"
    token LONGWORD_INTEGER:     "(?i)LONGWORD[ \t]+INTEGER"
    token UNSIGNED_LONGWORD:    "(?i)UNSIGNED[ \t]+LONGWORD"
    token CHARACTER:            "(?i)CHARACTER"
    token INTEGER:              "(?i)INTEGER"
    token DATETIME:             "(?i)DATETIME"
    token INTEGER_LITERAL:      "\d+"
    token DECIMAL_LITERAL:      "\d*\.\d+(E\d+)?"
    token DATETIME_LITERAL:     "\d+"
    token TEXT_LITERAL:         "\"[^\"\r\n]|\"\"\"|\'[^\'\r\n]|\'\'\'"
    token NAME:                 "\w+"
    token DATA_REFERENCE:       "\w+(\(\w+\))?(\.\w+(\(\w+\))?)*"

    rule form_declaration:            FORM NAME {{ push(df_classes.Form(NAME)) }}
                                        form_data_declaration*
                                        form_record_declaration*
                                        layout_declaration*
                                      END_FORM {{ pop() }}

    rule form_data_declaration:       FORM_DATA {{ push(df_classes.Form_data()) }}
                                        (form_data_item_declaration | form_data_group_declaration)*
                                      END_DATA {{ pop() }}

    rule form_data_item_declaration:  NAME (text_data_clause<<NAME>> | atomic_clause<<NAME>> | datetime_data_clause<<NAME>>)

    rule form_data_group_declaration: GROUP NAME {{ push(df_classes.Group(NAME)) }}
                                        [occurs_clause]
                                        (form_data_item_declaration | form_data_group_declaration)*
                                      END_GROUP {{ pop() }}

    rule occurs_clause:               OCCURS INTEGER_LITERAL {{occurs = add_child(df_classes.Occurs(INTEGER_LITERAL))}}
                                      [CURRENT NAME {{occurs.set_current(NAME)}}]

    rule text_data_clause<<NM>>:      CHARACTER "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Character_data(NM, INTEGER_LITERAL))}} |
                                      INTEGER "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Integer_data(NM, INTEGER_LITERAL))}}

    rule atomic_clause<<NM>>:         LONGWORD_INTEGER {{add_child(df_classes.Longword_integer(NM))}} |
                                      UNSIGNED_LONGWORD {{add_child(df_classes.Unsigned_longword(NM))}}

    rule datetime_data_clause<<NM>>:  DATETIME "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Datetime_data(NM, INTEGER_LITERAL))}}

    rule form_record_declaration:     FORM_RECORD NAME {{ push(df_classes.Form_record(NAME)) }}
                                        (record_field_description | record_group_description)*
                                      END_RECORD {{ pop() }}

    rule record_field_description:    NAME (text_record_field<<NAME>> | atomic_clause<<NAME>> | datetime_field_clause<<NAME>>) [data_transfer_clause]

    rule datetime_field_clause<<NM>>:  DATETIME "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Datetime_data(NM, INTEGER_LITERAL))}}

    rule text_record_field<<NM>>:     CHARACTER "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Character_data(NM, INTEGER_LITERAL))}}

    rule data_transfer_clause:        USING DATA_REFERENCE {{add_child_to_last_added(df_classes.Transfer_clause(DATA_REFERENCE))}}

    rule record_group_description:    GROUP NAME {{ push(df_classes.Group(NAME)) }}
                                        [OCCURS INTEGER_LITERAL {{add_child(df_classes.Occurs(INTEGER_LITERAL))}}]
                                        (record_field_description | record_group_description)*
                                      END_GROUP {{ pop() }}

    rule layout_declaration:          LAYOUT NAME {{ push(df_classes.Layout(NAME)) }}
                                        device_declaration
                                        size_declaration
                                      END_LAYOUT {{ pop() }}

    rule device_declaration:          DEVICE TERMINAL {{ device = df_classes.Device(None) }}
                                        [NAME {{device.set_name(NAME)}}]
                                        TYPE (VT100 {{ device.set_type(VT100) }} | VT400 {{ device.set_type(VT400) }})
                                      END_DEVICE {{ add_child(device) }}

    rule size_declaration:            SIZE INTEGER_LITERAL {{lines = INTEGER_LITERAL}} LINES_BY INTEGER_LITERAL {{columns = INTEGER_LITERAL}} COLUMNS {{add_child(df_classes.Size(lines, columns))}}
