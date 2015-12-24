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
    token FORM:           "FORM"
    token END_FORM:       "END[ \t]+FORM"
    token NAME:           "\\w+"
    token FORM_DATA:      "FORM[ \t]+DATA"
    token END_DATA:       "END[ \t]+DATA"
    token FORM_RECORD:    "FORM[ \t]+RECORD"
    token END_RECORD:     "END[ \t]+RECORD"
    token LAYOUT:         "LAYOUT"
    token END_LAYOUT:     "END[ \t]+LAYOUT"

    rule form_declaration:        FORM NAME {{ push(df_classes.Form(NAME)) }}
                                    form_data_declaration*
                                    form_record_declaration*
                                    layout_declaration*
                                  END_FORM {{ pop() }}

    rule form_data_declaration:   FORM_DATA {{ push(df_classes.Form_data()) }}
                                  END_DATA {{ pop() }}

    rule form_record_declaration: FORM_RECORD NAME {{ push(df_classes.Form_record(NAME)) }}
                                  END_RECORD {{ pop() }}

    rule layout_declaration:      LAYOUT NAME {{ push(df_classes.Layout(NAME)) }}
                                  END_LAYOUT {{ pop() }}
