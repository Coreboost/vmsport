How to make cross language calls on Linux
-----------------------------------------

Calling Fortran 77 code compiled with gfortran from cc (GNU)
------------------------------------------------------------
- gfortran mangles subroutine and function names by lowercasing the name and
  adding an underscore at the end of the name. I.e., a Fortran function or
  Subroutine called A can be called from C as a_.
- Fortrans functions and subroutines use pas by reference for parameters
  while C uses pass by valur for reference. See the examples for details of how
  to make cross-language calls with different parameter types.
