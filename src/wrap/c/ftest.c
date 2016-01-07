#include "../minunit/minunit.h"
#include <string.h>

#define FALSE 0
#define TRUE 1

void test_setup() {
}

void test_teardown() {
}

MU_TEST(test_int_param_int_return) {
  int a = 1;
  int b = 1;
	mu_check(add_(&a, &b) == 2);
}

MU_TEST(test_int_array_param) {
  int a[2] = {0, 1};
  int b[2] = {1, 4};
  int c[2];
  addvector_(a, b, c);
  mu_check(c[0]==1);
  mu_check(c[1]==5);
}

MU_TEST(test_bool_return) {
  int one = 1;
  int zero = 0;
  mu_check(ispositive_(&one));
  mu_check(!ispositive_(&zero));
}

MU_TEST(test_bool_param) {
  int falsy = FALSE;
  int truey = TRUE;
  mu_check(isnot_(&falsy));
  mu_check(!isnot_(&truey));
}

MU_TEST(test_char_param) {
  char str[] = "abc";
  int len = strlen(str);
  char a = 'a';
  char d = 'd';
  mu_check(containschar_(str, &len , &a));
  mu_check(!containschar_(str, &len , &d));
}

MU_TEST(test_char_return) {
  char str1[] = "abc";
  char str2[] = "de";
  int len1 = strlen(str1);
  int len2 = strlen(str2);
  char str3[10];
  int len3 = strlen(str3);
  concat_(str1, &len1, str2, &len2, str3, &len3);
  mu_check(strlen(str3) == 5);
  mu_check(!strcmp("abcde", str3));
}

MU_TEST(test_float_param_and_return) {
  float f1 = 0.1;
  float f2 = 0.05;
  float f3;
  addfloat_(&f1, &f2, &f3);
  printf("%f\n", f3);
  mu_check(f3>0.1 && f3<0.2);
}

MU_TEST_SUITE(test_suite) {
	MU_SUITE_CONFIGURE(&test_setup, &test_teardown);

  MU_RUN_TEST(test_int_param_int_return);
	MU_RUN_TEST(test_int_array_param);
  MU_RUN_TEST(test_bool_return);
  MU_RUN_TEST(test_bool_param);
  MU_RUN_TEST(test_char_param);
  MU_RUN_TEST(test_char_return);
  MU_RUN_TEST(test_float_param_and_return);
}

int main(int argc, char *argv[]) {
	MU_RUN_SUITE(test_suite);
	MU_REPORT();
	return 0;
}
