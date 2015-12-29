Notes about the parser implementation
=====================================
* The parser is not supporting the complete IFDL language but the first goal is just to be able to parse the Mileage example from the DecForms documentation.
* Some parts go a bit further, for example the parsing of logical/relational/value expressions. However, note in particular that paranthesis are not
  supported in numeric expressions in the current parse implementation. It may be that this is not possible to support given the IFDL language and the
  Yapps2 parser generator (only one token of look-ahead, it might be that infinite look-ahead is needed here.). Further analysis needed here but I would believe
  that this is an acceptanle limitation given the purpose of the parser/translator.
