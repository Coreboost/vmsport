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
                                      DECIMAL {{push(df_classes.Decimal()); pop()}} "\(" INTEGER_LITERAL {{push(df_classes.Integer_literal(INTEGER_LITERAL)); pop()}} "," INTEGER_LITERAL {{push(df_classes.Integer_literal(INTEGER_LITERAL)); pop()}} "\)" [PACKED {{push(df_classes.Packed()); pop()}}] |
                                      FLOAT {{push(df_classes.Float()); pop()}} "\(" INTEGER_LITERAL {{push(df_classes.Integer_literal(INTEGER_LITERAL)); pop()}} ["," INTEGER_LITERAL {{push(df_classes.Integer_literal(INTEGER_LITERAL)); pop()}} ] "\)"

    rule atomic_clause<<NM>>:         BYTE_INTEGER {{push(df_classes.Byte_integer()); pop()}} |
                                      DFLOATING {{push(df_classes.Dfloating()); pop()}} |
                                      FFLOATING {{push(df_classes.Ffloating()); pop()}} |
                                      GFLOATING {{push(df_classes.Gfloating()); pop()}} |
                                      HFLOATING {{push(df_classes.HFloating()); pop()}} |
                                      LONG_FLOAT {{push(df_classes.Long_float()); pop()}} |
                                      LONGWORD_INTEGER {{push(df_classes.Longword_integer()); pop()}} |
                                      QUADWORD_INTEGER {{push(df_classes.Quadword_integer()); pop()}} |
                                      SFLOATING {{push(df_classes.Sfloating()); pop()}} |
                                      SHORT_FLOAT {{push(df_classes.Short_float()); pop()}} |
                                      TFLOATING {{push(df_classes.Tfloating()); pop()}} |
                                      UNSIGNED_BYTE {{push(df_classes.Unsigned_byte()); pop()}} |
                                      UNSIGNED_LONGWORD {{push(df_classes.Unsigned_longword()); pop()}} |
                                      UNSIGNED_WORD {{push(df_classes.Unsigned_word()); pop()}} |
                                      WORD_INTEGER {{push(df_classes.Word_integer()); pop()}} |
                                      XFLOATING {{push(df_classes.Xfloating()); pop()}}

    rule datetime_data_clause<<NM>>:  ADT {{push(df_classes.Adt()); pop()}} [ CURRENT {{push(df_classes.Current()); pop()}} ] |
                                      DATE {{push(df_classes.Date()); pop()}} [ CURRENT {{push(df_classes.Current()); pop()}} ] |
                                      TIME {{push(df_classes.Time()); pop()}} [ CURRENT {{push(df_classes.Current()); pop()}} ] |
                                      DATETIME "\(" INTEGER_LITERAL "\)" {{push(df_classes.Datetime(INTEGER_LITERAL)); pop()}}

    rule form_record_declaration:     FORM_RECORD NAME {{ push(df_classes.Form_record(NAME)) }}
                                      END_RECORD {{ pop() }}

    rule layout_declaration:          LAYOUT NAME {{ push(df_classes.Layout(NAME)) }}
                                      END_LAYOUT {{ pop() }}
