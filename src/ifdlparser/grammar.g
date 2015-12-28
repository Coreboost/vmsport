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
    token LIST:                 "(?i)LIST"
    token END_LIST:             "(?i)END[ \t]+LIST"
    token VIEWPORT:             "(?i)VIEWPORT"
    token END_VIEWPORT:         "(?i)END[ \t]+VIEWPORT"
    token THROUGH:              "(?i)THROUGH"
    token LINES:                "(?i)LINES"
    token THRU:                 "(?i)THRU"
    token FUNCTION:             "(?i)FUNCTION"
    token END_FUNCTION:         "(?i)END[ \t]+FUNCTION"
    token IS:                   "(?i)IS"
    token KEY_NAME:             "(?i)%PF1|%PF4|%F8|%KP_PERIOD|%KP_8|%CARRIAGE_RETURN|%ENTER|%DOWN|%HORIZONTAL_TAB|%UP|%DO|%SELECT|%CONTROL_P"
    token BUILT_IN_FUNCTION:    "(?i)EXIT[ \t]+GROUP[ \t]+NEXT|INSERT[ \t]+LINE"
    token INTERNAL_RESPONSE:    "(?i)INTERNAL[ \t]+RESPONSE"
    token DISABLE_RESPONSE:    "(?i)DISABLE[ \t]+RESPONSE"
    token RECEIVE_RESPONSE:    "(?i)RECEIVE[ \t]+RESPONSE"
    token END_RESPONSE:         "(?i)END[ \t]+RESPONSE"
    token ACTIVATE:             "(?i)ACTIVATE"
    token SIGNAL:               "(?i)SIGNAL"
    token BELL_SIGNAL:          "(?i)%BELL"
    token REVERSE_SIGNAL:       "(?i)%REVERSE"
    token MESSAGE:              "(?i)MESSAGE"
    token POSITION:             "(?i)POSITION"
    token TO:                   "(?i)TO"
    token PANEL:                "(?i)PANEL"
    token RESET:                "(?i)RESET"
    token ALL:                  "(?i)ALL"
    token REMOVE:               "(?i)REMOVE"
    token RETURN:               "(?i)RETURN"
    token IMMEDIATE:            "(?i)IMMEDIATE"
    token CALL:                 "(?i)CALL"
    token USING:                "(?i)USING"
    token BY_REFERENCE:         "(?i)BY[ \t]+REFERENCE"
    token VALUE:                "(?i)VALUE"
    token LONGWORD_INTEGER:     "(?i)LONGWORD[ \t]+INTEGER"
    token UNSIGNED_LONGWORD:    "(?i)UNSIGNED[ \t]+LONGWORD"
    token CHARACTER:            "(?i)CHARACTER"
    token INTEGER:              "(?i)INTEGER"
    token DATETIME:             "(?i)DATETIME"
    token INTEGER_LITERAL:      "\d+"
    token DECIMAL_LITERAL:      "\d*\.\d+(E\d+)?"
    token DATETIME_LITERAL:     "\d+"
    token TEXT_LITERAL:         "(\"([^\"\r\n]|\"\")+\")|(\'([^\'\r\n]|\'\')+\')"
    token NAME:                 "\w+"
    token DATA_REFERENCE:       "\w+(\(\w+\))?(\.\w+(\(\w+\))?)*"

    rule form_decl:                   FORM NAME {{ push(df_classes.Form_decl(NAME)) }}
                                        form_data_decl*
                                        form_record_decl*
                                        layout_decl*
                                      END_FORM {{ pop() }}

    rule form_data_decl:              FORM_DATA {{ push(df_classes.Form_data_decl()) }}
                                        (form_data_item_decl | form_data_group_decl)*
                                      END_DATA {{ pop() }}

    rule form_data_item_decl:         NAME (text_data_clause<<NAME>> | atomic_clause<<NAME>> | datetime_data_clause<<NAME>>)

    rule form_data_group_decl:        GROUP NAME {{ push(df_classes.Group_decl(NAME)) }}
                                        [occurs_clause]
                                        (form_data_item_decl | form_data_group_decl)*
                                      END_GROUP {{ pop() }}

    rule occurs_clause:               OCCURS INTEGER_LITERAL {{occurs_clause = add_child(df_classes.Occurs_clause(INTEGER_LITERAL))}}
                                      [CURRENT NAME {{occurs_clause.set_current(NAME)}}]

    rule text_data_clause<<NM>>:      CHARACTER "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Character_data(NM, INTEGER_LITERAL))}} |
                                      INTEGER "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Integer_data(NM, INTEGER_LITERAL))}}

    rule atomic_clause<<NM>>:         LONGWORD_INTEGER {{add_child(df_classes.Longword_integer(NM))}} |
                                      UNSIGNED_LONGWORD {{add_child(df_classes.Unsigned_longword(NM))}}

    rule datetime_data_clause<<NM>>:  DATETIME "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Datetime_data(NM, INTEGER_LITERAL))}}

    rule form_record_decl:            FORM_RECORD NAME {{ push(df_classes.Form_record_decl(NAME)) }}
                                        (record_field_description | record_group_description)*
                                      END_RECORD {{ pop() }}

    rule record_field_description:    NAME (text_record_field<<NAME>> | atomic_clause<<NAME>> | datetime_field_clause<<NAME>>) [data_transfer_clause]

    rule datetime_field_clause<<NM>>:  DATETIME "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Datetime_data(NM, INTEGER_LITERAL))}}

    rule text_record_field<<NM>>:     CHARACTER "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Character_data(NM, INTEGER_LITERAL))}}

    rule data_transfer_clause:        USING DATA_REFERENCE {{add_child_to_last_added(df_classes.Transfer_clause(DATA_REFERENCE))}}

    rule record_group_description:    GROUP NAME {{ push(df_classes.Group_decl(NAME)) }}
                                        [OCCURS INTEGER_LITERAL {{add_child(df_classes.Occurs_clause(INTEGER_LITERAL))}}]
                                        (record_field_description | record_group_description)*
                                      END_GROUP {{ pop() }}

    rule layout_decl:                 LAYOUT NAME {{ push(df_classes.Layout_decl(NAME)) }}
                                        device_decl
                                        size_decl
                                        list_decl*
                                        viewport_decl*
                                        function_decl*
                                        (internal_response_decl | external_response_decl)*
                                      END_LAYOUT {{ pop() }}

    rule device_decl:                 DEVICE TERMINAL {{ device_decl = df_classes.Device_decl(None) }}
                                        [NAME {{device_decl.set_name(NAME)}}]
                                        TYPE (VT100 {{ device_decl.set_type(VT100) }} | VT400 {{ device_decl.set_type(VT400) }})
                                      END_DEVICE {{ add_child(device_decl) }}

    rule size_decl:                   SIZE INTEGER_LITERAL {{lines = INTEGER_LITERAL}} LINES_BY INTEGER_LITERAL {{columns = INTEGER_LITERAL}} COLUMNS {{add_child(df_classes.Size_decl(lines, columns))}}

    rule list_decl:                   LIST NAME {{list_decl = df_classes.List_decl(NAME)}}
                                        (TEXT_LITERAL {{list_decl.add_list_item(TEXT_LITERAL[1:-1])}})*
                                      END_LIST {{add_child(list_decl)}}

    rule viewport_decl:               VIEWPORT NAME
                                        LINES INTEGER_LITERAL {{lines_start=INTEGER_LITERAL}} (THROUGH|THRU) INTEGER_LITERAL {{lines_end=INTEGER_LITERAL}}
                                        COLUMNS INTEGER_LITERAL {{columns_start=INTEGER_LITERAL}} (THROUGH|THRU) INTEGER_LITERAL {{columns_end=INTEGER_LITERAL}}
                                      END_VIEWPORT {{add_child(df_classes.Viewport_decl(NAME, lines_start, lines_end, columns_start, columns_end))}}

    rule function_decl:               FUNCTION {{function_decl = df_classes.Function_decl()}}
                                        (NAME {{function_decl.set_name(NAME)}} | BUILT_IN_FUNCTION {{function_decl.set_builtin(BUILT_IN_FUNCTION)}})
                                        IS (KEY_NAME {{function_decl.set_key_1(KEY_NAME)}} | "\(" KEY_NAME {{function_decl.set_key_1(KEY_NAME)}} [KEY_NAME {{function_decl.set_key_2(KEY_NAME)}}] "\)")+
                                      END_FUNCTION {{add_child(function_decl)}}

    rule internal_response_decl:      INTERNAL_RESPONSE NAME {{ push(df_classes.Internal_response_decl(NAME)) }}
                                        (response_step {{add_child(response_step)}})*
                                      END_RESPONSE {{ pop() }}

    rule external_response_decl:      (disable_response_decl | receive_response_decl)

    rule disable_response_decl:       DISABLE_RESPONSE {{ push(df_classes.Disable_response_decl()) }}
                                        (response_step {{add_child(response_step)}})*
                                      END_RESPONSE {{ pop() }}

    rule receive_response_decl:       RECEIVE_RESPONSE NAME {{ push(df_classes.Receive_response_decl(NAME)) }}
                                        (response_step {{add_child(response_step)}})*
                                      END_RESPONSE {{ pop() }}

    rule response_step:               (signal_response_step {{step = signal_response_step}} |
                                      message_response_step {{step = message_response_step}} |
                                      activate_response_step {{step = activate_response_step}} |
                                      position_response_step {{step = position_response_step}} |
                                      reset_response_step {{step = reset_response_step}} |
                                      remove_response_step {{step = remove_response_step}} |
                                      return_response_step {{step = return_response_step}} |
                                      call_response_step {{step = call_response_step}})
                                      {{return step}}

    rule signal_response_step:        SIGNAL {{signal_step = df_classes.Signal_step()}} [BELL_SIGNAL {{signal_step.set_bell()}} | REVERSE_SIGNAL {{signal_step.set_reverse()}}] {{return signal_step}}

    rule activate_response_step:      ACTIVATE {{activate_step = df_classes.Activate_step() }}(ALL {{activate_step.set_all()}}|
                                      (PANEL NAME {{activate_step.set_panel(NAME)}})
                                      ){{return activate_step}}

    rule message_response_step:       MESSAGE {{message_step = df_classes.Message_step()}} (TEXT_LITERAL{{message_step.add_line(TEXT_LITERAL[1:-1])}})* {{return message_step}}

    rule position_response_step:      POSITION {{position_step = df_classes.Position_step()}} TO PANEL NAME {{return position_step.set_panel(NAME)}}

    rule reset_response_step:         RESET {{reset_step = df_classes.Reset_step()}} ALL {{return reset_step.set_all()}}

    rule remove_response_step:        REMOVE {{remove_step = df_classes.Remove_step()}} ALL {{return remove_step.set_all()}}

    rule return_response_step:        RETURN {{return_step = df_classes.Return_step()}} IMMEDIATE {{return return_step.set_immediate()}}

    rule call_response_step:          CALL TEXT_LITERAL {{call_step = df_classes.Call_step(TEXT_LITERAL[1:-1])}} [USING (([BY_REFERENCE{{convention = BY_REFERENCE}}] NAME) {{call_step.add_parameter(convention, NAME); convention = None}})+] {{return call_step}}
