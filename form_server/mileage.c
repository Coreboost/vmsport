#include <stdio.h>
#include <formsdef.h>
#define EMPNAME 32
#define EMPBADGE 6
#define EMPCC 3
#define EMPADDRESS 120
#define EMPREASON 64
#define TRIPDATE 8
#define TRIPFROM 3
#define TRIPTO 3
#define TRIPRECORD 36
/*
* Structure format declarations for records that will be sent to the form
*/
typedef struct {
  char employee_name[EMPNAME], badge_number[EMPBADGE], cost_center[EMPCC], address[EMPADDRESS], reason[EMPREASON];
} Hdr_Info_Record;

typedef struct {
  char trip_date[TRIPDATE], trip_from[TRIPFROM], trip_to[TRIPTO];
  unsigned long miles, amount, toll, subtotal;
} Trip_Record;

typedef struct {
  unsigned long total_miles, total_amount, total_tolls, form_total;
} Totals_Record;

Hdr_Info_Record header_info_record;
Trip_Record trips_record[TRIPRECORD];
Totals_Record totals_record;

Forms_Session_Id session_id;
Forms_Form_Object MRF_FORM;
Forms_Status status;
Forms_Record_Data header_info_record_descr;
Forms_Record_Data trips_record_descr;
Forms_Record_Data totals_record_descr;
Forms_Request_Options request_options[2];
Forms_Session_Id print_session;

int main (void) {
  request_options[0].option = forms_c_opt_form;
  request_options[0].form.object = MRF_FORM;
  request_options[1].option = forms_c_opt_end;
  status = forms_enable (session_id, NULL, NULL, "MRF_FORM", request_options);

  header_info_record_descr.data_record = &header_info_record;
  header_info_record_descr.data_length = sizeof(header_info_record);
  header_info_record_descr.shadow_record = NULL;
  header_info_record_descr.shadow_length = 0;
  status = forms_receive (session_id, "header_info_record", &header_info_record_descr, NULL);

  trips_record_descr.data_record = &trips_record;
  trips_record_descr.data_length = sizeof(trips_record);
  trips_record_descr.shadow_record = NULL;
  trips_record_descr.shadow_length = 0;
  status = forms_receive (session_id, "trips_record", &trips_record_descr, NULL);

  totals_record_descr.data_record = &totals_record;
  totals_record_descr.data_length = sizeof(totals_record);
  totals_record_descr.shadow_record = NULL;
  totals_record_descr.shadow_length = 0;
  status = forms_receive (session_id, "totals_record", &totals_record_descr, NULL);

  status = forms_enable (print_session, "prin_mrf.doc", NULL, "MRF_FORM", request_options);

  status = forms_send (print_session, "header_info_record", &header_info_record_descr, NULL);
  status = forms_send (print_session, "trips_record", &trips_record_descr, NULL);

  status = forms_send (print_session, "totals_record", &totals_record_descr, NULL);

  status = forms_disable (print_session, NULL);
  return 1;
  
  status = forms_disable (session_id, NULL);
  return 1;
}

void Forms_Callback update_row (Trip_Record *trip) {
  trip->amount = (unsigned long)(((float)trip->miles * 22.5) + 0.5);
  return;
}
void Forms_Callback do_totals (Trip_Record (*trips)[TRIPRECORD], unsigned long *miles, unsigned long *amount, unsigned long *tolls, unsigned long *total) {
  unsigned n;
  *miles = *amount = *tolls = *total = 0;
  for (n = 0; n < TRIPRECORD; n++) {
    if ((*trips)[n].miles != 0) {
      *miles = *miles + (*trips)[n].miles;
      *amount = *amount + (*trips)[n].amount;
      *tolls = *tolls + (*trips)[n].toll;
      *total = *total + (*trips)[n].subtotal;
    }
  }
  return;
}
