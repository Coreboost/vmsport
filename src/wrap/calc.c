
#include <stdio.h>

int add(a, b) {
  return a+b;
}

int main() {
    int a = 2;
    int b = 1;
    int c;
    c = add(a, b);
    printf("Result:%d\n", c);
    return 0;
}
