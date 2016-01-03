      PROGRAM HELLO
      IMPLICIT NONE
      INTEGER A(3), B(3), C(3), I
      A(1) = 1
      A(2) = 2
      A(3) = 3
      B(1) = 4
      B(2) = 5
      B(3) = 6
      C(1) = 0
      C(2) = 0
      C(3) = 0
      CALL ADD(A, B, C, 3)
      DO 10 I=1, 3
        WRITE(*, *)C(I)
10    CONTINUE
      END
