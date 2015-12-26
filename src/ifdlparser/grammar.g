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
    token FORM_RECORD:          "(?i)FORM[ \t]+RECORD"
    token END_RECORD:           "(?i)END[ \t]+RECORD"
    token LAYOUT:               "(?i)LAYOUT"
    token END_LAYOUT:           "(?i)END[ \t]+LAYOUT"
    token TRACKED:              "(?i)TRACKED"
    token UNTRACKED:            "(?i)UNTRACKED"
    token VALUE:                "(?i)VALUE"
    token BYTE_INTEGER:         "(?i)BYTE[ \t]+INTEGER"
    token DFLOATING:            "(?i)DFLOATING"
    token FFLOATING:            "(?i)FFLOATING"
    token GFLOATING:            "(?i)GFLOATING"
    token HFLOATING:            "(?i)HFLOATING"
    token LONG_FLOAT:           "(?i)LONG[ \t]+FLOAT"
    token LONGWORD_INTEGER:     "(?i)LONGWORD[ \t]+INTEGER"
    token QUADWORD_INTEGER:     "(?i)QUADWORD[ \t]+INTEGER"
    token SFLOATING:            "(?i)SFLOATING"
    token SHORT_FLOAT:          "(?i)SHORT[ \t]+FLOAT"
    token TFLOATING:            "(?i)TFLOATING"
    token UNSIGNED_BYTE:        "(?i)UNSIGNED[ \t]+BYTE"
    token UNSIGNED_LONGWORD:    "(?i)UNSIGNED[ \t]+LONGWORD"
    token UNSIGNED_WORD:        "(?i)UNSIGNED[ \t]+WORD"
    token WORD_INTEGER:         "(?i)WORD[ \t]+INTEGER"
    token XFLOATING:            "(?i)XFLOATING"
    token CHARACTER:            "(?i)CHARACTER"
    token VARYING:              "(?i)VARYING"
    token NULL_TERMINATED:      "(?i)NULL[ \t]+TERMINATED"
    token INTEGER:              "(?i)INTEGER"
    token DECIMAL:              "(?i)DECIMAL"
    token FLOAT:                "(?i)FLOAT"
    token PACKED:               "(?i)PACKED"
    token ADT:                  "(?i)ADT"
    token DATE:                 "(?i)DATE"
    token TIME:                 "(?i)TIME"
    token DATETIME:             "(?i)DATETIME"
    token CURRENT:              "(?i)CURRENT"
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
                                        [track_clause_1]
                                        form_data_item_declaration*
                                      END_DATA {{ pop() }}

    rule track_clause_1:              TRACKED {{add_child(df_classes.Tracked())}} |
                                      UNTRACKED {{add_child(df_classes.Untracked())}}

    rule form_data_item_declaration:  NAME (text_data_clause<<NAME>> | atomic_clause<<NAME>> | datetime_data_clause<<NAME>>) [VALUE literal]

    rule literal:                     INTEGER_LITERAL | DECIMAL_LITERAL | DATETIME_LITERAL | TEXT_LITERAL

    rule text_data_clause<<NM>>:      CHARACTER "\(" INTEGER_LITERAL "\)" [ NULL_TERMINATED | VARYING ] {{add_child(df_classes.Character_data(NM, INTEGER_LITERAL, "VARYING" in locals(), "NULL_TERMINATED" in locals()))}} |
                                      INTEGER "\(" INTEGER_LITERAL "\)" [PACKED] {{add_child(df_classes.Integer_data(NM, INTEGER_LITERAL, "PACKED" in locals()))}}|
                                      DECIMAL "\(" INTEGER_LITERAL {{ integer_3 = INTEGER_LITERAL}} "," INTEGER_LITERAL {{ integer_4 = INTEGER_LITERAL}} "\)" [PACKED] {{add_child(df_classes.Decimal_data(NM, integer_3, integer_4, "PACKED" in locals()))}} |
                                      FLOAT "\(" INTEGER_LITERAL {{ integer_5 = INTEGER_LITERAL; integer_6 = -1}} ["," INTEGER_LITERAL {{integer_6 = INTEGER_LITERAL}} ] "\)" {{add_child(df_classes.Float_data(NM, integer_5, integer_6))}}

    rule atomic_clause<<NM>>:         BYTE_INTEGER {{add_child(df_classes.Byte_integer(NM))}} |
                                      DFLOATING {{add_child(df_classes.Dfloating(NM))}} |
                                      FFLOATING {{add_child(df_classes.Ffloating(NM))}} |
                                      GFLOATING {{add_child(df_classes.Gfloating(NM))}} |
                                      HFLOATING {{add_child(df_classes.HFloating(NM))}} |
                                      LONG_FLOAT {{add_child(df_classes.Long_float(NM))}} |
                                      LONGWORD_INTEGER {{add_child(df_classes.Longword_integer(NM))}} |
                                      QUADWORD_INTEGER {{add_child(df_classes.Quadword_integer(NM))}} |
                                      SFLOATING {{add_child(df_classes.Sfloating(NM))}} |
                                      SHORT_FLOAT {{add_child(df_classes.Short_float(NM))}} |
                                      TFLOATING {{add_child(df_classes.Tfloating(NM))}} |
                                      UNSIGNED_BYTE {{add_child(df_classes.Unsigned_byte(NM))}} |
                                      UNSIGNED_LONGWORD {{add_child(df_classes.Unsigned_longword(NM))}} |
                                      UNSIGNED_WORD {{add_child(df_classes.Unsigned_word(NM))}} |
                                      WORD_INTEGER {{add_child(df_classes.Word_integer(NM))}} |
                                      XFLOATING {{add_child(df_classes.Xfloating(NM))}}

    rule datetime_data_clause<<NM>>:  ADT [CURRENT] {{add_child(df_classes.Adt_data(NM, "CURRENT" in locals()))}} |
                                      DATE [CURRENT] {{add_child(df_classes.Date_data(NM, "CURRENT" in locals()))}} |
                                      TIME [CURRENT] {{add_child(df_classes.Time_data(NM, "CURRENT" in locals()))}} |
                                      DATETIME "\(" INTEGER_LITERAL "\)" {{add_child(df_classes.Datetime(NM, INTEGER_LITERAL))}}

    rule form_record_declaration:     FORM_RECORD NAME {{ push(df_classes.Form_record(NAME)) }}
                                      END_RECORD {{ pop() }}

    rule layout_declaration:          LAYOUT NAME {{ push(df_classes.Layout(NAME)) }}
                                      END_LAYOUT {{ pop() }}
