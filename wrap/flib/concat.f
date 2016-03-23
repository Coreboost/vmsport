      SUBROUTINE CONCAT(STR1, STR2, STR3)
      IMPLICIT NONE
      CHARACTER STR1*(*), STR2*(*)
      CHARACTER STR3*100
Cf2py intent(in) str1
Cf2py intent(in) str2
Cf2py intent(out) str3
      STR3 = STR1//STR2
      RETURN
      END
