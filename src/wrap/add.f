      SUBROUTINE ADD(A,B,C,N)
      INTEGER A(*), B(*), C(*), N
      DO 20 J = 1, N
         C(J) = A(J)+B(J)
 20   CONTINUE
      END
