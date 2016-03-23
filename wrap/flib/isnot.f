      FUNCTION ISNOT(A)
      IMPLICIT NONE
      LOGICAL ISNOT, A
      IF (A) THEN
        ISNOT = .FALSE.
      ELSE
        ISNOT = .TRUE.
      ENDIF
      END
