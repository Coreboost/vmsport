      SUBROUTINE ADDVECTOR(A, B, C, N)
      IMPLICIT NONE
      INTEGER N, A(N), B(N), C(N)
Cf2py intent(in) a
Cf2py intent(in) b
Cf2py intent(out) c
Cf2py intent(in) n
Cf2py depend(n) c
      C(1) = A(1) + B(1)
      C(2) = A(2) + B(2)
      RETURN
      END
