      FUNCTION CONTAINSCHAR(STRING, LEN, CH)
      IMPLICIT NONE
      INTEGER LEN, I
      CHARACTER STRING(*), CH
      LOGICAL CONTAINSCHAR
      CONTAINSCHAR = .FALSE.
      DO 10 I=1, LEN
        IF (STRING(I).EQ.CH) THEN
          CONTAINSCHAR = .TRUE.
          GOTO 11
        END IF
10    CONTINUE
11    CONTINUE
      RETURN
      END