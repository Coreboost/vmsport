import df_classes

stack = []

def push(item):
  if len(stack) > 0:
    stack[-1].add_child(item)
  stack.append(item)

def pop():
  popped = stack.pop()
  if len(stack) == 0:
    popped.generate()


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

    rule track_clause_1:              TRACKED {{push(df_classes.Tracked()); pop()}} |
                                      UNTRACKED {{push(df_classes.Untracked()); pop()}}

    rule form_data_item_declaration:  NAME (text_data_clause<<NAME>> | atomic_clause<<NAME>> | datetime_data_clause<<NAME>>) [VALUE literal]

    rule literal:                     INTEGER_LITERAL | DECIMAL_LITERAL | DATETIME_LITERAL | TEXT_LITERAL

    rule text_data_clause<<NM>>:      CHARACTER "\(" INTEGER_LITERAL "\)" [ NULL_TERMINATED | VARYING ] {{push(df_classes.Character_data(NM, INTEGER_LITERAL, "VARYING" in locals(), "NULL_TERMINATED" in locals())); pop()}} |
                                      INTEGER "\(" INTEGER_LITERAL "\)" [PACKED] {{push(df_classes.Integer_data(NM, INTEGER_LITERAL, "PACKED" in locals())); pop()}}|
                                      DECIMAL "\(" INTEGER_LITERAL {{ integer_3 = INTEGER_LITERAL}} "," INTEGER_LITERAL {{ integer_4 = INTEGER_LITERAL}} "\)" [PACKED] {{push(df_classes.Decimal_data(NM, integer_3, integer_4, "PACKED" in locals())); pop()}} |
                                      FLOAT "\(" INTEGER_LITERAL {{ integer_5 = INTEGER_LITERAL; integer_6 = -1}} ["," INTEGER_LITERAL {{integer_6 = INTEGER_LITERAL}} ] "\)" {{push(df_classes.Float_data(NM, integer_5, integer_6)); pop()}}

    rule atomic_clause<<NM>>:         BYTE_INTEGER {{push(df_classes.Byte_integer(NM)); pop()}} |
                                      DFLOATING {{push(df_classes.Dfloating(NM)); pop()}} |
                                      FFLOATING {{push(df_classes.Ffloating(NM)); pop()}} |
                                      GFLOATING {{push(df_classes.Gfloating(NM)); pop()}} |
                                      HFLOATING {{push(df_classes.HFloating(NM)); pop()}} |
                                      LONG_FLOAT {{push(df_classes.Long_float(NM)); pop()}} |
                                      LONGWORD_INTEGER {{push(df_classes.Longword_integer(NM)); pop()}} |
                                      QUADWORD_INTEGER {{push(df_classes.Quadword_integer(NM)); pop()}} |
                                      SFLOATING {{push(df_classes.Sfloating(NM)); pop()}} |
                                      SHORT_FLOAT {{push(df_classes.Short_float(NM)); pop()}} |
                                      TFLOATING {{push(df_classes.Tfloating(NM)); pop()}} |
                                      UNSIGNED_BYTE {{push(df_classes.Unsigned_byte(NM)); pop()}} |
                                      UNSIGNED_LONGWORD {{push(df_classes.Unsigned_longword(NM)); pop()}} |
                                      UNSIGNED_WORD {{push(df_classes.Unsigned_word(NM)); pop()}} |
                                      WORD_INTEGER {{push(df_classes.Word_integer(NM)); pop()}} |
                                      XFLOATING {{push(df_classes.Xfloating(NM)); pop()}}

    rule datetime_data_clause<<NM>>:  ADT [CURRENT] {{push(df_classes.Adt_data(NM, "CURRENT" in locals())); pop()}} |
                                      DATE [CURRENT] {{push(df_classes.Date_data(NM, "CURRENT" in locals())); pop()}} |
                                      TIME [CURRENT] {{push(df_classes.Time_data(NM, "CURRENT" in locals())); pop()}} |
                                      DATETIME "\(" INTEGER_LITERAL "\)" {{push(df_classes.Datetime(NM, INTEGER_LITERAL)); pop()}}

    rule form_record_declaration:     FORM_RECORD NAME {{ push(df_classes.Form_record(NAME)) }}
                                      END_RECORD {{ pop() }}

    rule layout_declaration:          LAYOUT NAME {{ push(df_classes.Layout(NAME)) }}
                                      END_LAYOUT {{ pop() }}
