/* HblTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. HblTokenManager.java */
package se.atg.tabs.hblcompiler;
import java.io.InputStream;
import java.io.PrintStream;

/** Token Manager. */
@SuppressWarnings("unused")public class HblTokenManager implements HblConstants {

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x3e0000000c0000L) != 0L)
            return 2;
         if ((active0 & 0x41fffffff00000L) != 0L)
         {
            jjmatchedKind = 55;
            return 2;
         }
         return -1;
      case 1:
         if ((active0 & 0x1ff0000000000L) != 0L)
            return 2;
         if ((active0 & 0x4600fffffc0000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 1;
            }
            return 2;
         }
         return -1;
      case 2:
         if ((active0 & 0x1e00042000000L) != 0L)
            return 2;
         if ((active0 & 0x4600fe29fc0000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 2;
            }
            return 2;
         }
         if ((active0 & 0x194000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 1;
            }
            return -1;
         }
         return -1;
      case 3:
         if ((active0 & 0x1000000000000L) != 0L)
            return 2;
         if ((active0 & 0x46000001fc0000L) != 0L)
         {
            jjmatchedKind = 55;
            jjmatchedPos = 3;
            return 2;
         }
         if ((active0 & 0xfe28000000L) != 0L)
         {
            if (jjmatchedPos < 2)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 2;
            }
            return -1;
         }
         if ((active0 & 0x194000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 1;
            }
            return -1;
         }
         return -1;
      case 4:
         if ((active0 & 0x40000000000000L) != 0L)
            return 2;
         if ((active0 & 0xfe28000000L) != 0L)
         {
            if (jjmatchedPos < 2)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 2;
            }
            return -1;
         }
         if ((active0 & 0x14000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 1;
            }
            return -1;
         }
         if ((active0 & 0x6000001fc0000L) != 0L)
         {
            jjmatchedKind = 55;
            jjmatchedPos = 4;
            return 2;
         }
         return -1;
      case 5:
         if ((active0 & 0x4000001cc0000L) != 0L)
         {
            jjmatchedKind = 55;
            jjmatchedPos = 5;
            return 2;
         }
         if ((active0 & 0x2000000300000L) != 0L)
            return 2;
         if ((active0 & 0x28000000L) != 0L)
         {
            if (jjmatchedPos < 2)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 2;
            }
            return -1;
         }
         if ((active0 & 0x14000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 1;
            }
            return -1;
         }
         return -1;
      case 6:
         if ((active0 & 0x4000001cc0000L) != 0L)
            return 2;
         if ((active0 & 0x10000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 1;
            }
            return -1;
         }
         if ((active0 & 0x28000000L) != 0L)
         {
            if (jjmatchedPos < 2)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 2;
            }
            return -1;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 13:
         jjmatchedKind = 9;
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 40:
         return jjStopAtPos(0, 15);
      case 41:
         return jjStopAtPos(0, 16);
      case 44:
         return jjStopAtPos(0, 12);
      case 45:
         jjmatchedKind = 14;
         return jjMoveStringLiteralDfa1_0(0x12L);
      case 46:
         return jjStopAtPos(0, 11);
      case 58:
         return jjStopAtPos(0, 13);
      case 65:
         jjmatchedKind = 53;
         return jjMoveStringLiteralDfa1_0(0xc0000L);
      case 66:
         return jjMoveStringLiteralDfa1_0(0x40000040000000L);
      case 68:
         return jjMoveStringLiteralDfa1_0(0x194000000L);
      case 70:
         jjmatchedKind = 52;
         return jjMoveStringLiteralDfa1_0(0x4000000000000L);
      case 72:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 73:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 76:
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 77:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 82:
         jjmatchedKind = 51;
         return jjMoveStringLiteralDfa1_0(0x2000000000000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 86:
         return jjMoveStringLiteralDfa1_0(0xfe28000000L);
      case 88:
         return jjMoveStringLiteralDfa1_0(0x1ff0000000000L);
      default :
         return jjMoveNfa_0(1, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 10:
         if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(1, 10);
         break;
      case 45:
         if ((active0 & 0x10L) != 0L)
         {
            jjmatchedKind = 4;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x2L);
      case 49:
         if ((active0 & 0x10000000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x1200000000000L);
      case 50:
         if ((active0 & 0x20000000000L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x400000000000L);
      case 51:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 42, 2);
         break;
      case 52:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 43, 2);
         break;
      case 53:
         if ((active0 & 0x100000000000L) != 0L)
         {
            jjmatchedKind = 44;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000000L);
      case 55:
         return jjMoveStringLiteralDfa2_0(active0, 0xfe28000000L);
      case 68:
         return jjMoveStringLiteralDfa2_0(active0, 0x194000000L);
      case 99:
         return jjMoveStringLiteralDfa2_0(active0, 0xc0000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000043000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x44000000100000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0xa00000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0){
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
         return jjMoveStringLiteralDfa3_0(active0, 0x194000000L);
      case 48:
         if ((active0 & 0x200000000000L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 2;
         }
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 46, 2);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 47, 2);
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000000000L);
      case 53:
         return jjMoveStringLiteralDfa3_0(active0, 0xfe28000000L);
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x4c0000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000L);
      case 103:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(2, 25, 2);
         break;
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000800000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000100000L);
      case 116:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(2, 30, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 45:
         return jjMoveStringLiteralDfa4_0(active0, 0xfe28000000L);
      case 48:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 48, 2);
         break;
      case 49:
         if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(3, 31);
         break;
      case 50:
         if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(3, 32);
         break;
      case 66:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000L);
      case 76:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000000000L);
      case 103:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0xc0000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000100000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000001000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 49:
         if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(4, 33);
         break;
      case 50:
         if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(4, 34);
         break;
      case 51:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(4, 35);
         break;
      case 52:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(4, 36);
         break;
      case 53:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStopAtPos(4, 37);
         break;
      case 54:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStopAtPos(4, 38);
         break;
      case 55:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(4, 39);
         break;
      case 66:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 76:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000L);
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000000000L);
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x14100000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000L);
      case 107:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000L);
      case 116:
         if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 54, 2);
         break;
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000004c0000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0){
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
         return jjMoveStringLiteralDfa6_0(active0, 0x800000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x400000L);
      case 101:
         return jjMoveStringLiteralDfa6_0(active0, 0x28000000L);
      case 103:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000L);
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000010c0000L);
      case 115:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(5, 20, 2);
         else if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(5, 21, 2);
         break;
      case 116:
         if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(5, 26);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 49, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 50, 2);
         break;
      case 101:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(6, 22, 2);
         break;
      case 103:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(6, 24, 2);
         return jjMoveStringLiteralDfa7_0(active0, 0x20000000L);
      case 109:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(6, 23, 2);
         break;
      case 115:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(6, 28);
         break;
      case 116:
         if ((active0 & 0x80000L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 6;
         }
         else if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(6, 27);
         return jjMoveStringLiteralDfa7_0(active0, 0x40000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 115:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(7, 18, 2);
         else if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(7, 29);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
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
                     if (kind > 17)
                        kind = 17;
                     { jjCheckNAdd(0); }
                  }
                  else if (curChar == 34)
                     { jjCheckNAddTwoStates(4, 5); }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  { jjCheckNAdd(0); }
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 55)
                     kind = 55;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 3:
                  if (curChar == 34)
                     { jjCheckNAddTwoStates(4, 5); }
                  break;
               case 4:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(4, 5); }
                  break;
               case 5:
                  if (curChar == 34 && kind > 56)
                     kind = 56;
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
                  if (kind > 55)
                     kind = 55;
                  { jjCheckNAdd(2); }
                  break;
               case 4:
                  { jjAddStates(0, 1); }
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
                     { jjAddStates(0, 1); }
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
static private int jjMoveStringLiteralDfa0_2(){
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 5);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa0_1(){
   switch(curChar)
   {
      case 45:
         return jjMoveStringLiteralDfa1_1(0x4L);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa1_1(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 45:
         return jjMoveStringLiteralDfa2_1(active0, 0x4L);
      default :
         return 2;
   }
}
static private int jjMoveStringLiteralDfa2_1(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 2;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 2;
   }
   switch(curChar)
   {
      case 45:
         if ((active0 & 0x4L) != 0L)
            return jjStopAtPos(2, 2);
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
"", null, null, null, null, null, null, null, null, null, null, "\56", "\54", 
"\72", "\55", "\50", "\51", null, "\101\143\143\157\165\156\164\163", 
"\101\143\143\157\165\156\164", "\110\157\162\163\145\163", "\124\162\141\143\153\163", 
"\111\156\143\154\165\144\145", "\120\162\157\147\162\141\155", "\115\145\145\164\151\156\147", 
"\114\145\147", "\104\104\55\102\145\164", "\126\67\65\55\102\145\164", 
"\104\104\55\114\145\147\163", "\126\67\65\55\114\145\147\163", "\102\145\164", "\104\104\55\61", 
"\104\104\55\62", "\126\67\65\55\61", "\126\67\65\55\62", "\126\67\65\55\63", 
"\126\67\65\55\64", "\126\67\65\55\65", "\126\67\65\55\66", "\126\67\65\55\67", "\130\61", 
"\130\62", "\130\63", "\130\64", "\130\65", "\130\61\60", "\130\62\60", "\130\65\60", 
"\130\61\60\60", "\122\145\160\145\141\164", "\106\157\162\164\165\156\141", "\122", "\106", 
"\101", "\102\157\157\163\164", null, null, null, };
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
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
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
       if (jjmatchedPos == 0 && jjmatchedKind > 57)
       {
          jjmatchedKind = 57;
       }
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
       if (jjmatchedPos == 0 && jjmatchedKind > 6)
       {
          jjmatchedKind = 6;
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

    /** Constructor. */
    public HblTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public HblTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
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
  static public void ReInit( SimpleCharStream stream, int lexState)
  {
  
    ReInit( stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  static public void SwitchTo(int lexState)
  {
    if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "WithinMultilineComment",
   "SinglelineComment",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, 1, 0, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x3fffffffffff801L, 
};
static final long[] jjtoSkip = {
   0x7feL, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[6];
    static private final int[] jjstateSet = new int[2 * 6];

    
    static protected int curChar;
}
