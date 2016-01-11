var MRF_FORM_form = {
  name: 'MRF_FORM',
  form_data: {
    EMPLOYEE_NAME: undefined,
  },
  // More likely we need some kind of send/receive methods for the records.
  form_records: [
    name: 'HEADER_INFO_RECORD',
    fields: {
      EMPLOYEE_NAME: undefined,
    }
  ],
  layouts: [
    {
      name: 'VT_LAYOUT',
      device: {
        terminal_type: '%VT100',
      },
      lines: 24,
      columns: 80,
      lists: {
        LOCATION_CODES: ["ACT", "BXB", "LTN", "MKO", "ZKO"]
      }
      viewports: {
        MAIN_VIEWPORT: {line_from: 1, line_to: 22, col_from: 1, col_to: 80},
        DEFAULT_MESSAGE_VIEWPORT: {line_from: 23, line_to: 24, col_from: 1, col_to: 80},
      }

    }
  ]
}
