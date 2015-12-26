import df_classes

stack = []

def add_child(item):
  if len(stack) > 0:
    stack[-1].add_child(item)

def push(item):
  add_child(item)
  stack.append(item)

def pop():
  popped = stack.pop()
  if len(stack) == 0:
    popped.generate(0)

%%

parser IFDL:
    ignore: '[ \r\t\n]+'
    token FORM:                 "(?i)FORM"
    token END_FORM:             "(?i)END[ \t]+FORM"
    token FORM_DATA:            "(?i)FORM[ \t]+DATA"
    token END_DATA:             "(?i)END[ \t]+DATA"
    token GROUP:                "(?i)GROUP"
    token END_GROUP:            "(?i)END[ \t]+GROUP"
    token CURRENT:              "(?i)CURRENT"
    token FORM_RECORD:          "(?i)FORM[ \t]+RECORD"
    token END_RECORD:           "(?i)END[ \t]+RECORD"
    token LAYOUT:               "(?i)LAYOUT"
    token END_LAYOUT:           "(?i)END[ \t]+LAYOUT"
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
    token NAME:                 "\\w+"

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

    rule occurs_clause:               OCCURS INTEGER_LITERAL
                                      [CURRENT]

    rule text_data_clause<<NM>>:      CHARACTER "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Character_data(NM, INTEGER_LITERAL))}} |
                                      INTEGER "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Integer_data(NM, INTEGER_LITERAL))}}

    rule atomic_clause<<NM>>:         LONGWORD_INTEGER {{add_child(df_classes.Longword_integer(NM))}} |
                                      UNSIGNED_LONGWORD {{add_child(df_classes.Unsigned_longword(NM))}}

    rule datetime_data_clause<<NM>>:  DATETIME "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Datetime_data(NM, INTEGER_LITERAL))}}

    rule form_record_declaration:     FORM_RECORD NAME {{ push(df_classes.Form_record(NAME)) }}
                                      END_RECORD {{ pop() }}

    rule layout_declaration:          LAYOUT NAME {{ push(df_classes.Layout(NAME)) }}
                                      END_LAYOUT {{ pop() }}
