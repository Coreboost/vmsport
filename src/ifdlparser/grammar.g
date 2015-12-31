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
    token USE_HELP_PANEL:       "(?i)USE[ \t]+HELP[ \t]+PANEL"
    token NO_HELP_PANEL:        "(?i)NO[ \t]+HELP[ \t]+PANEL"
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
    token SIMPLE_TEXT_ATTR:     "(?i)BOLD|UNDERLINED"
    token FONT:                 "(?i)FONT"
    token FAMILY:               "(?i)FAMILY"
    token FONT_FAMILY:          "(?i)COURIER|HELVETICA"
    token STYLE:                "(?i)STYLE"
    token FONT_STYLE:           "(?i)ROMAN|ITALIC|OBLIQUE"
    token WEIGHT:               "(?i)WEIGHT"
    token FONT_WEIGHT:          "(?i)MEDIUM|BOLD"
    token SIZE:                 "(?i)SIZE"
    token FONT_SIZE:            "(?i)SINGLE|NORMAL|DOUBLE[ \t]+HIGH|DOUBLE[ \t]+WIDE"
    token IMPLEMENTOR_ATTR:     "(?i)%KEYPAD_APPLICATION"
    token BUILT_IN_FUNCTION:    "(?i)EXIT[ \t]+GROUP[ \t]+NEXT|INSERT[ \t]+LINE|NEXT[ \t]+HELP|CURSOR[ \t]+UP|CURSOR[ \t]+DOWN|TRANSMIT"
    token INTERNAL_RESPONSE:    "(?i)INTERNAL[ \t]+RESPONSE"
    token DISABLE_RESPONSE:     "(?i)DISABLE[ \t]+RESPONSE"
    token RECEIVE_RESPONSE:     "(?i)RECEIVE[ \t]+RESPONSE"
    token FUNCTION_RESPONSE:    "(?i)FUNCTION[ \t]+RESPONSE"
    token BUILTIN_FUNCTION_RESPONSE:    "(?i)BUILTIN[ \t]+FUNCTION[ \t]+RESPONSE"
    token ENTRY_RESPONSE:       "(?i)ENTRY[ \t]+RESPONSE"
    token EXIT_RESPONSE:        "(?i)EXIT[ \t]+RESPONSE"
    token END_RESPONSE:         "(?i)END[ \t]+RESPONSE"
    token FIELD:                "(?i)FIELD"
    token TEXTFIELD:            "(?i)TEXTFIELD"
    token END_FIELD:            "(?i)END[ \t]+FIELD"
    token AUTOSKIP:             "(?i)AUTOSKIP"
    token NO_AUTOSKIP:          "(?i)NO[ \t]AUTOSKIP"
    token UPPERCASE:            "(?i)UPPERCASE"
    token MIXED_CASE:           "(?i)MIXED[ \t]CASE"
    token ROWS:                 "(?i)ROWS"
    token COLUMNS:              "(?i)COLUMNS"
    token INPUT_PICTURE:        "(?i)INPUT[ \t]PICTURE"
    token OUTPUT_PICTURE:       "(?i)OUTPUT[ \t]PICTURE"
    token PICTURE_SPEC:         "(\w|\.|(\"([^\"\r\n]|\"\")+\")|(\'([^\'\r\n]|\'\')+\'))+"
    token PROTECTED:            "(?i)PROTECTED"
    token WHEN:                 "(?i)WHEN"
    token SEARCH:               "(?i)SEARCH"
    token RANGE:                "(?i)RANGE"
    token SCALE:                "(?i)SCALE"
    token JUSTIFICATION:        "(?i)JUSTIFICATION"
    token JUSTIFICATION_VALUE:  "(?i)LEFT|RIGHT|DECIMAL"
    token FIELD_DEFAULT:        "(?i)FIELD[ \t]+DEFAULT"
    token END_DEFAULT:          "(?i)END[ \t]+DEFAULT"
    token APPLY:                "(?i)APPLY"
    token NO_FIELD_DEFAULT:     "(?i)NO[ \t]+FIELD[ \t]+DEFAULT"
    token FIELD_DEFAULT_OF:     "(?i)FIELD[ \t]+DEFAULT[ \t]+OF"
    token ACTIVE_HIGHLIGHT:     "(?i)ACTIVE[ \t]+HIGHLIGHT"
    token NO_ACTIVE_HIGHLIGHT:  "(?i)NO[ \t]+ACTIVE[ \t]+HIGHLIGHT"
    token PANEL:                "(?i)PANEL"
    token HELP_PANEL:           "(?i)HELP[ \t]+PANEL"
    token MESSAGE_PANEL:        "(?i)MESSAGE[ \t]+PANEL"
    token END_PANEL:            "(?i)END[ \t]+PANEL"
    token LITERAL_TEXT:         "(?i)LITERAL[ \t]+TEXT"
    token LITERAL_POLYLINE:     "(?i)LITERAL[ \t]+POLYLINE"
    token LITERAL_RECTANGLE:    "(?i)LITERAL[ \t]+RECTANGLE"
    token END_LITERAL:          "(?i)END[ \t]+LITERAL"
    token COLUMN:               "(?i)COLUMN"
    token LINE:                 "(?i)LINE"
    token ICON:                 "(?i)ICON"
    token END_ICON:             "(?i)END[ \t]+ICON"
    token DISPLAY:              "(?i)DISPLAY"
    token ACTIVATE:             "(?i)ACTIVATE"
    token SIGNAL:               "(?i)SIGNAL"
    token BELL_SIGNAL:          "(?i)%BELL"
    token REVERSE_SIGNAL:       "(?i)%REVERSE"
    token MESSAGE:              "(?i)MESSAGE"
    token POSITION:             "(?i)POSITION"
    token TO:                   "(?i)TO"
    token NAMED_POSITION:       "(?i)UP[ \t]+ITEM|DOWN[ \t]+ITEM"
    token RESET:                "(?i)RESET"
    token ALL:                  "(?i)ALL"
    token HELP:                 "(?i)HELP"
    token REMOVE:               "(?i)REMOVE"
    token EXIT_HELP:            "(?i)EXIT[ \t]+HELP"
    token RETURN:               "(?i)RETURN"
    token IMMEDIATE:            "(?i)IMMEDIATE"
    token CALL:                 "(?i)CALL"
    token USING:                "(?i)USING"
    token BY_REFERENCE:         "(?i)BY[ \t]+REFERENCE"
    token INCLUDE:              "(?i)INCLUDE"
    token PRINT:                "(?i)PRINT"
    token IF:                   "(?i)IF"
    token THEN:                 "(?i)THEN"
    token ELSE:                 "(?i)ELSE"
    token END_IF:               "(?i)END[ \t]+IF"
    token AND:                  "(?i)AND"
    token OR:                   "(?i)OR"
    token XOR:                  "(?i)XOR"
    token NOT:                  "NOT"
    token LOGICAL_OP:            "(?i)AND|OR|XOR"
    token RELATIONAL_OP:        "<=|<>|<|>=|>|="
    token SIGN:                 "-|\+"
    token ARITHMETIC_OP:        "-|\+|\*|/"
    token LOWERMOST_ITEM:       "(?i)LOWERMOST[ \t]+ITEM"
    token UPPERMOST_ITEM:       "(?i)UPPERMOST[ \t]+ITEM"
    token VALUE:                "(?i)VALUE"
    token LONGWORD_INTEGER:     "(?i)LONGWORD[ \t]+INTEGER"
    token UNSIGNED_LONGWORD:    "(?i)UNSIGNED[ \t]+LONGWORD"
    token CHARACTER:            "(?i)CHARACTER"
    token INTEGER:              "(?i)INTEGER"
    token DATETIME:             "(?i)DATETIME"
    token INTEGER_LITERAL:      "\d+"
    token DECIMAL_LITERAL:      "\d*\.\d+(E\d+)?"
    token DATETIME_LITERAL:     "\d+"
    token STRING_LITERAL:         "(\"([^\"\r\n]|\"\")+\")|(\'([^\'\r\n]|\'\')+\')"
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

    rule datetime_field_clause<<NM>>: DATETIME "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Datetime_data(NM, INTEGER_LITERAL))}}

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
                                        (internal_response_decl | external_response_decl | function_response_decl {{add_child(function_response_decl)}})*
                                        [USE_HELP_PANEL NAME {{add_child(df_classes.Help_panel_reference(NAME))}} | NO_HELP_PANEL {{add_child(df_classes.Help_panel_reference(None))}}]
                                        (field_default_decl)*
                                        (field_default_appl)*
                                        [message_panel_decl]
                                        (panel_decl|help_panel_decl)*
                                      END_LAYOUT {{ pop() }}

    rule message_panel_decl:          MESSAGE_PANEL NAME {{panel_decl=df_classes.Message_panel_decl(NAME)}}
                                        (panel_property {{panel_decl.add_panel_property(panel_property)}})*
                                      END_PANEL {{add_child(panel_decl)}}

    rule panel_decl:                  PANEL NAME {{panel_decl=push(df_classes.Panel_decl(NAME))}}
                                        (panel_property {{panel_decl.add_panel_property(panel_property)}})*
                                        (field_default_appl)*
                                        (literal_decl|icon_decl|picture_field_decl|text_field_decl)*
                                      END_PANEL {{ pop() }}

    rule help_panel_decl:             HELP_PANEL NAME {{panel_decl=push(df_classes.Help_panel_decl(NAME))}}
                                        (panel_property {{panel_decl.add_panel_property(panel_property)}})*
                                        (literal_decl|icon_decl)*
                                      END_PANEL {{ pop() }}

    rule picture_field_decl:          FIELD NAME {{field_decl=push(df_classes.Picture_field_decl(NAME))}}
                                        loc_clause {{field_decl.set_location(loc_clause)}}
                                        (pic_field_desc_entry<<field_decl>>)*
                                      END_FIELD {{pop()}}

    rule text_field_decl:             TEXTFIELD NAME {{field_decl=push(df_classes.Text_field_decl(NAME))}}
                                        loc_clause {{field_decl.set_location(loc_clause)}}
                                        (txt_field_desc_entry<<field_decl>>)*
                                      END_FIELD {{pop()}}

    rule txt_field_desc_entry<<FDE>>: ((item_description_entry{{FDE.add_item_description_entry(item_description_entry)}})|
                                      (field_validation_entry {{FDE.add_field_validation_entry(field_validation_entry)}})|
                                      (AUTOSKIP {{FDE.set_autoskip(True)}})|
                                      (NO_AUTOSKIP {{FDE.set_autoskip(False)}})|
                                      (UPPERCASE {{FDE.set_uppercase(True)}})|
                                      (MIXED_CASE {{FDE.set_uppercase(False)}})|
                                      (ROWS INTEGER_LITERAL {{FDE.set_rows(INTEGER_LITERAL)}})|
                                      (COLUMNS INTEGER_LITERAL {{FDE.set_columns(INTEGER_LITERAL)}}))

    rule pic_field_desc_entry<<FDE>>: ((item_description_entry{{FDE.add_item_description_entry(item_description_entry)}})|
                                      (field_validation_entry {{FDE.add_field_validation_entry(field_validation_entry)}})|
                                      (editing_entry {{FDE.add_editing_entry(editing_entry)}})|
                                      (AUTOSKIP {{FDE.set_autoskip(True)}})|
                                      (NO_AUTOSKIP {{FDE.set_autoskip(False)}})|
                                      (UPPERCASE {{FDE.set_uppercase(True)}})|
                                      (MIXED_CASE {{FDE.set_uppercase(False)}})|
                                      (INPUT_PICTURE PICTURE_SPEC {{FDE.set_input_picture(PICTURE_SPEC)}})|
                                      (OUTPUT_PICTURE PICTURE_SPEC {{FDE.set_output_picture(PICTURE_SPEC)}})|
                                      (PROTECTED {{FDE.set_protected(True)}} [WHEN conditional_expression {{FDE.set_protected_when(conditional_expression)}}])|
                                      (JUSTIFICATION JUSTIFICATION_VALUE {{FDE.set_justification(JUSTIFICATION_VALUE)}}))

    rule field_validation_entry:      ((SEARCH NAME {{return df_classes.Field_validation_entry().set_search(NAME)}})|
                                      (RANGE {{r=df_classes.Field_validation_entry()}}
                                        (STRING_LITERAL {{r.set_range_lower({"type": "string", "value": STRING_LITERAL})}}|
                                        INTEGER_LITERAL {{r.set_range_lower({"type": "integer", "value": INTEGER_LITERAL})}}|
                                        DATA_REFERENCE {{r.set_range_lower({"type": "reference", "value": DATA_REFERENCE})}})
                                        (THROUGH|THRU)
                                        (STRING_LITERAL {{r.set_range_upper({"type": "string", "value": STRING_LITERAL})}}|
                                        INTEGER_LITERAL {{r.set_range_upper({"type": "integer", "value": INTEGER_LITERAL})}}|
                                        DATA_REFERENCE {{r.set_range_upper({"type": "reference", "value": DATA_REFERENCE})}})
                                      {{return r}}))

    rule editing_entry:               SCALE INTEGER_LITERAL {{return df_classes.Editing_entry().set_scale(INTEGER_LITERAL)}}

    rule icon_decl:                   ICON NAME {{icon_decl = push(df_classes.Icon_decl(NAME))}}
                                        (field_default_appl)*
                                        (function_response_decl {{add_child(function_response_decl)}})*
                                        (item_description_entry {{add_child(item_description_entry)}})*
                                        literal_decl*
                                      END_ICON {{pop()}}

    rule literal_decl:                text_literal_decl|polyline_literal_decl|rectangle_literal_decl

    rule text_literal_decl:           LITERAL_TEXT {{literal=add_child(df_classes.Literal_text())}}
                                        [loc_clause {{literal.set_location(loc_clause)}}]
                                        VALUE STRING_LITERAL {{literal.set_text(STRING_LITERAL[1:-1])}}
                                        [display_clause {{literal.set_display_clause(display_clause)}}]
                                      END_LITERAL

    rule polyline_literal_decl:       LITERAL_POLYLINE {{literal=add_child(df_classes.Literal_polyline())}}
                                        full_loc_clause {{literal.add_location(full_loc_clause)}}
                                        (full_loc_clause {{literal.add_location(full_loc_clause)}})+
                                        [display_clause {{literal.set_display_clause(display_clause)}}]
                                      END_LITERAL

    rule rectangle_literal_decl:      LITERAL_RECTANGLE {{literal=add_child(df_classes.Literal_rectangle())}}
                                        full_loc_clause {{literal.set_first_corner(full_loc_clause)}}
                                        full_loc_clause {{literal.set_second_corner(full_loc_clause)}}
                                        [display_clause {{literal.set_display_clause(display_clause)}}]
                                      END_LITERAL

    rule display_clause:              DISPLAY (disp_implementor_attr{{return disp_implementor_attr}}|disp_text_attr{{return disp_text_attr}})

    rule disp_implementor_attr:       IMPLEMENTOR_ATTR {{return df_classes.Display_implementor_attribute(IMPLEMENTOR_ATTR)}}

    rule disp_text_attr:              ((SIMPLE_TEXT_ATTR {{return df_classes.Display_elementary_attribute(SIMPLE_TEXT_ATTR)}})|
                                      (font_decl {{return font_decl}}))

    rule font_decl:                   FONT
                                      ((FAMILY FONT_FAMILY {{return df_classes.Font_decl().set_font_family(FONT_FAMILY)}})|
                                      (STYLE FONT_STYLE {{return df_classes.Font_decl().set_font_style(FONT_STYLE)}})|
                                      (WEIGHT FONT_WEIGHT {{return df_classes.Font_decl().set_font_weight(FONT_WEIGHT)}})|
                                      (SIZE ((FONT_SIZE {{return df_classes.Font_decl().set_font_size_named(FONT_SIZE)}})|(INTEGER_LITERAL {{return df_classes.Font_decl().set_font_size_points(INTEGER_LITERAL)}}))))

    rule loc_clause:                  full_loc_clause {{return full_loc_clause}}

    rule full_loc_clause:             (horizontal_loc_clause vertical_loc_clause {{return df_classes.Full_loc_clause(horizontal_loc_clause, vertical_loc_clause)}})|
                                      (vertical_loc_clause horizontal_loc_clause {{return df_classes.Full_loc_clause(horizontal_loc_clause, vertical_loc_clause)}})

    rule horizontal_loc_clause:       COLUMN INTEGER_LITERAL {{return df_classes.Horizontal_loc_clause(INTEGER_LITERAL)}}

    rule vertical_loc_clause:         LINE INTEGER_LITERAL {{return df_classes.Vertical_loc_clause(INTEGER_LITERAL)}}

    rule panel_property:              viewport_reference {{return viewport_reference}}|
                                      display_clause {{return display_clause}} |
                                      entry_response_decl {{return entry_response_decl}} |
                                      exit_response_decl {{return exit_response_decl}} |
                                      function_response_decl {{ return function_response_decl}}

    rule viewport_reference:          VIEWPORT NAME {{return df_classes.Viewport_reference(NAME)}}

    rule field_default_appl:          APPLY (
                                      NO_FIELD_DEFAULT {{add_child(df_classes.Field_default_appl())}}|
                                      FIELD_DEFAULT NAME {{add_child(df_classes.Field_default_appl().set_named_default(NAME))}}|
                                      FIELD_DEFAULT_OF {{push(df_classes.Field_default_appl())}} (item_description_entry {{add_child(item_description_entry)}})* END_DEFAULT {{pop()}})

    rule field_default_decl:          FIELD_DEFAULT NAME {{push(df_classes.Field_default_decl(NAME))}}
                                        (item_description_entry {{add_child(item_description_entry)}})*
                                      END_DEFAULT {{ pop() }}

    rule item_description_entry:      ((active_highlight_clause {{entry=active_highlight_clause}})|
                                      (accept_response_decl {{entry=accept_response_decl}}))
                                      {{return entry}}

    rule accept_response_decl:        (entry_response_decl{{return entry_response_decl}})|(exit_response_decl{{return exit_response_decl}})|(function_response_decl{{return function_response_decl}})

    rule active_highlight_clause:     (ACTIVE_HIGHLIGHT SIMPLE_TEXT_ATTR {{clause = df_classes.Active_highlight_clause().set_elementary_attribute(SIMPLE_TEXT_ATTR)}}|
                                      NO_ACTIVE_HIGHLIGHT {{clause = df_classes.Active_highlight_clause()}})
                                      {{return clause}}

    rule device_decl:                 DEVICE TERMINAL {{ device_decl = df_classes.Device_decl(None) }}
                                        [NAME {{device_decl.set_name(NAME)}}]
                                        TYPE (VT100 {{ device_decl.set_type(VT100) }} | VT400 {{ device_decl.set_type(VT400) }})
                                      END_DEVICE {{ add_child(device_decl) }}

    rule size_decl:                   SIZE INTEGER_LITERAL {{lines = INTEGER_LITERAL}} LINES_BY INTEGER_LITERAL {{columns = INTEGER_LITERAL}} COLUMNS {{add_child(df_classes.Size_decl(lines, columns))}}

    rule list_decl:                   LIST NAME {{list_decl = df_classes.List_decl(NAME)}}
                                        (STRING_LITERAL {{list_decl.add_list_item(STRING_LITERAL[1:-1])}})*
                                      END_LIST {{add_child(list_decl)}}

    rule viewport_decl:               VIEWPORT NAME
                                        LINES INTEGER_LITERAL {{lines_start=INTEGER_LITERAL}} (THROUGH|THRU) INTEGER_LITERAL {{lines_end=INTEGER_LITERAL}}
                                        COLUMNS INTEGER_LITERAL {{columns_start=INTEGER_LITERAL}} (THROUGH|THRU) INTEGER_LITERAL {{columns_end=INTEGER_LITERAL}}
                                      END_VIEWPORT {{add_child(df_classes.Viewport_decl(NAME, lines_start, lines_end, columns_start, columns_end))}}

    rule function_decl:               FUNCTION {{function_decl = df_classes.Function_decl()}}
                                        ((BUILT_IN_FUNCTION {{function_decl.set_builtin(BUILT_IN_FUNCTION)}})|(NAME {{function_decl.set_name(NAME)}}))
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

    rule function_response_decl:      (function_response_decl_1{{return function_response_decl_1}})|(function_response_decl_2{{return function_response_decl_2}})

    rule function_response_decl_1:    FUNCTION_RESPONSE {{function_response_decl = df_classes.Function_response_decl()}}
                                        ((BUILT_IN_FUNCTION {{function_response_decl.set_builtin(BUILT_IN_FUNCTION, 1)}})|(NAME {{function_response_decl.set_name(NAME)}}))
                                        (response_step {{function_response_decl.add_child(response_step)}})*
                                      END_RESPONSE {{ return function_response_decl }}

    rule function_response_decl_2:    BUILTIN_FUNCTION_RESPONSE BUILT_IN_FUNCTION {{return df_classes.Function_response_decl().set_builtin(BUILT_IN_FUNCTION, 2)}}

    rule entry_response_decl:         ENTRY_RESPONSE {{entry_response_decl = df_classes.Entry_response_decl()}}
                                        (response_step {{entry_response_decl.add_child(response_step)}})*
                                      END_RESPONSE {{ return entry_response_decl }}

    rule exit_response_decl:          EXIT_RESPONSE {{exit_response_decl = df_classes.Exit_response_decl()}}
                                        (response_step {{exit_response_decl.add_child(response_step)}})*
                                      END_RESPONSE {{ return exit_response_decl }}

    rule response_step:               (signal_response_step {{step = signal_response_step}} |
                                      message_response_step {{step = message_response_step}} |
                                      activate_response_step {{step = activate_response_step}} |
                                      position_response_step {{step = position_response_step}} |
                                      reset_response_step {{step = reset_response_step}} |
                                      remove_response_step {{step = remove_response_step}} |
                                      exit_help_response_step {{step = exit_help_response_step}} |
                                      return_response_step {{step = return_response_step}} |
                                      include_response_step {{step = include_response_step}} |
                                      print_response_step {{step = print_response_step}} |
                                      if_response_step {{step = if_response_step}} |
                                      call_response_step {{step = call_response_step}})
                                      {{return step}}

    rule signal_response_step:        SIGNAL {{signal_step = df_classes.Signal_step()}} [BELL_SIGNAL {{signal_step.set_bell()}} | REVERSE_SIGNAL {{signal_step.set_reverse()}}] {{return signal_step}}

    rule activate_response_step:      ACTIVATE {{activate_step = df_classes.Activate_step() }}(ALL {{activate_step.set_all()}}|
                                      (PANEL NAME {{activate_step.set_panel(NAME)}})
                                      ){{return activate_step}}

    rule message_response_step:       MESSAGE {{message_step = df_classes.Message_step()}} (STRING_LITERAL{{message_step.add_line(STRING_LITERAL[1:-1])}})* {{return message_step}}

    rule position_response_step:      POSITION {{position_step = df_classes.Position_step()}} TO
                                        (PANEL NAME {{position_step.set_panel(NAME)}} |
                                        NAMED_POSITION {{position_step.set_named_position(NAMED_POSITION)}})
                                        {{return position_step}}

    rule reset_response_step:         RESET {{reset_step = df_classes.Reset_step()}} ALL {{return reset_step.set_all()}}

    rule remove_response_step:        REMOVE {{remove_step = df_classes.Remove_step()}} ((ALL {{return remove_step.set_all()}})|(HELP {{return remove_step.set_help()}}))

    rule exit_help_response_step:     EXIT_HELP {{return df_classes.Exit_help_step()}}

    rule return_response_step:        RETURN {{return_step = df_classes.Return_step()}} IMMEDIATE {{return return_step.set_immediate()}}

    rule include_response_step:       INCLUDE NAME {{return df_classes.Include_step(NAME)}}

    rule print_response_step:         PRINT {{print_step = df_classes.Print_step()}} [IMMEDIATE {{print_step.set_immediate()}}] NAME {{return print_step.set_panel_name(NAME)}}

    rule if_response_step:            IF conditional_expression THEN {{if_step = df_classes.If_step(conditional_expression)}}
                                        (response_step {{if_step.add_then_step(response_step)}})*
                                      [ELSE
                                        (response_step {{if_step.add_else_step(response_step)}})*
                                      ]
                                      END_IF {{return if_step}}

    rule conditional_expression:      conditional_term {{conditional_expression = df_classes.Conditional_expression(conditional_term)}}
                                      [LOGICAL_OP
                                      conditional_term {{conditional_expression.set_logical_op(LOGICAL_OP, conditional_term)}}]
                                      {{return conditional_expression}}

    rule conditional_term:            {{negated=False}}[NOT {{negated=True}}] (
                                      elementary_condition {{term = elementary_condition}} |
                                      relational_expression {{term = relational_expression}} |
                                      "\(" conditional_expression {{term = conditional_expression.set_subexpression()}} "\)")
                                      {{return term.set_negated(negated)}}

    rule relational_expression:       (value_expression {{expression_1 = value_expression}})
                                      RELATIONAL_OP
                                      (value_expression {{expression_2 = value_expression}})
                                      {{return df_classes.Relational_expression(expression_1, RELATIONAL_OP, expression_2)}}

    rule value_expression:            (numeric_expression {{expression = numeric_expression}} |
                                      string_expression {{expression = string_expression}} |
                                      DATA_REFERENCE {{expression = df_classes.Data_reference(DATA_REFERENCE)}})
                                      {{return expression}}

    rule elementary_condition:        (LOWERMOST_ITEM {{ condition=df_classes.Elementary_condition(LOWERMOST_ITEM) }} |
                                      UPPERMOST_ITEM {{ condition=df_classes.Elementary_condition(UPPERMOST_ITEM) }} )
                                      {{ return condition }}

    rule numeric_expression:          [SIGN] simple_numeric_term {{sign = SIGN if SIGN in locals() else None; expression = df_classes.Numeric_expression(sign, simple_numeric_term)}}
                                      [ARITHMETIC_OP simple_numeric_term {{term=simple_numeric_term}} {{expression.set_arithmetic_op(ARITHMETIC_OP, term)}}]
                                      {{return numeric_expression}}

    rule numeric_term:                INTEGER_LITERAL {{term = df_classes.Integer_Literal(INTEGER_LITERAL)}} |
                                      "\(" value_expression "\)" {{ term = value_expression.set_subexpression()}}
                                      {{return term}}

    rule simple_numeric_term:         INTEGER_LITERAL {{return df_classes.Integer_Literal(INTEGER_LITERAL)}}

    rule string_expression:           STRING_LITERAL {{return df_classes.String_literal(STRING_LITERAL)}}

    rule call_response_step:          CALL STRING_LITERAL {{call_step = df_classes.Call_step(STRING_LITERAL[1:-1])}} [USING (([BY_REFERENCE{{convention = BY_REFERENCE}}] NAME) {{call_step.add_parameter(convention, NAME); convention = None}})+] {{return call_step}}
