/* Generated By:JJTree&JavaCC: Do not edit this line. HblTokenManager.java */

/** Token Manager. */
public class HblTokenManager implements HblConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x7fc00000L) != 0L)
         {
            jjmatchedKind = 31;
            return 2;
         }
         return -1;
      case 1:
         if ((active0 & 0x7fc00000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 31;
               jjmatchedPos = 1;
            }
            return 2;
         }
         return -1;
      case 2:
         if ((active0 & 0x10000000L) != 0L)
            return 2;
         if ((active0 & 0x4fc00000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 2;
            return 2;
         }
         return -1;
      case 3:
         if ((active0 & 0xfc00000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 3;
            return 2;
         }
         return -1;
      case 4:
         if ((active0 & 0xfc00000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 4;
            return 2;
         }
         return -1;
      case 5:
         if ((active0 & 0xfc00000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 5;
            return 2;
         }
         return -1;
      case 6:
         if ((active0 & 0xe400000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 6;
            return 2;
         }
         return -1;
      case 7:
         if ((active0 & 0x400000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 7;
            return 2;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 13:
         jjmatchedKind = 13;
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 40:
         return jjStopAtPos(0, 19);
      case 41:
         return jjStopAtPos(0, 20);
      case 44:
         return jjStopAtPos(0, 16);
      case 45:
         jjmatchedKind = 18;
         return jjMoveStringLiteralDfa1_0(0x102L);
      case 46:
         return jjStopAtPos(0, 15);
      case 58:
         return jjStopAtPos(0, 17);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 68:
         return jjMoveStringLiteralDfa1_0(0x20000000L);
      case 72:
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 73:
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 76:
         return jjMoveStringLiteralDfa1_0(0x10000000L);
      case 77:
         return jjMoveStringLiteralDfa1_0(0x4000000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x8000000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 86:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      default :
         return jjMoveNfa_0(1, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 10:
         if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(1, 14);
         break;
      case 45:
         if ((active0 & 0x100L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x2L);
      case 55:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000L);
      case 68:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000L);
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000L);
      case 99:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x14000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 45:
         if ((active0 & 0x2L) != 0L)
            return jjStopAtPos(2, 1);
         break;
      case 53:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000L);
      case 58:
         if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(2, 29);
         break;
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0xa400000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000L);
      case 103:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(2, 28, 2);
         break;
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 58:
         if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(3, 30);
         break;
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 68:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000L);
      case 107:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000L);
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x2400000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000L);
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x4400000L);
      case 115:
         return jjMoveStringLiteralDfa6_0(active0, 0x1800000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 58:
         if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(6, 23);
         else if ((active0 & 0x1000000L) != 0L)
            return jjStopAtPos(6, 24);
         break;
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000000L);
      case 103:
         return jjMoveStringLiteralDfa7_0(active0, 0x4000000L);
      case 116:
         return jjMoveStringLiteralDfa7_0(active0, 0x400000L);
      case 121:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 58:
         if ((active0 & 0x2000000L) != 0L)
            return jjStopAtPos(7, 25);
         else if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(7, 26);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(7, 27);
         break;
      case 115:
         return jjMoveStringLiteralDfa8_0(active0, 0x400000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 58:
         if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(8, 22);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 6;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 21)
                        kind = 21;
                     jjCheckNAdd(0);
                  }
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAdd(0);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 3:
                  if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 4:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 5:
                  if (curChar == 34 && kind > 32)
                     kind = 32;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
               case 2:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAdd(2);
                  break;
               case 4:
                  jjAddStates(0, 1);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(0, 1);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 6 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static private int jjMoveStringLiteralDfa0_4()
{
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 9);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa0_3()
{
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 6);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 2);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 45:
         return jjMoveStringLiteralDfa1_2(0x10L);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa1_2(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 45:
         return jjMoveStringLiteralDfa2_2(active0, 0x10L);
      default :
         return 2;
   }
}
static private int jjMoveStringLiteralDfa2_2(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 2;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 2;
   }
   switch(curChar)
   {
      case 45:
         if ((active0 & 0x10L) != 0L)
            return jjStopAtPos(2, 4);
         break;
      default :
         return 3;
   }
   return 3;
}
static final int[] jjnextStates = {
   4, 5, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, "\56", "\54", "\72", "\55", "\50", "\51", null, 
"\101\143\143\157\165\156\164\163\72", "\110\157\162\163\145\163\72", "\124\162\141\143\153\163\72", 
"\111\156\143\154\165\144\145\72", "\115\145\145\164\151\156\147\72", "\122\141\143\145\104\141\171\72", 
"\114\145\147", "\104\104\72", "\126\67\65\72", null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "FirstlineMultilineComment",
   "WithinMultilineComment",
   "LastlineMultilineComment",
   "SinglelineComment",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, 1, 2, -1, 3, -1, 0, -1, 4, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x1ffff8001L, 
};
static final long[] jjtoSkip = {
   0x7ffeL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[6];
static private final int[] jjstateSet = new int[12];
static protected char curChar;
/** Constructor. */
public HblTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public HblTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 6; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 5 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   switch(curLexState)
   {
     case 0:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100000400L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       break;
     case 1:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos == 0 && jjmatchedKind > 3)
       {
          jjmatchedKind = 3;
       }
       break;
     case 2:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_2();
       if (jjmatchedPos == 0 && jjmatchedKind > 5)
       {
          jjmatchedKind = 5;
       }
       break;
     case 3:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_3();
       if (jjmatchedPos == 0 && jjmatchedKind > 7)
       {
          jjmatchedKind = 7;
       }
       break;
     case 4:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_4();
       if (jjmatchedPos == 0 && jjmatchedKind > 10)
       {
          jjmatchedKind = 10;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

}
