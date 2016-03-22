/* HblTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. HblTokenManager.java */
package se.atg.tabs.hblcompiler;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
         if ((active0 & 0xf800000030000L) != 0L)
            return 2;
         if ((active0 & 0x107ffffffc0000L) != 0L)
         {
            jjmatchedKind = 53;
            return 2;
         }
         return -1;
      case 1:
         if ((active0 & 0x7fc000000000L) != 0L)
            return 2;
         if ((active0 & 0x11803fffff0000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 1;
            }
            return 2;
         }
         return -1;
      case 2:
         if ((active0 & 0x780010800000L) != 0L)
            return 2;
         if ((active0 & 0x65000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 1;
            }
            return -1;
         }
         if ((active0 & 0x11803f8a7f0000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 2;
            }
            return 2;
         }
         return -1;
      case 3:
         if ((active0 & 0x400000000000L) != 0L)
            return 2;
         if ((active0 & 0x3f8a000000L) != 0L)
         {
            if (jjmatchedPos < 2)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 2;
            }
            return -1;
         }
         if ((active0 & 0x65000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 1;
            }
            return -1;
         }
         if ((active0 & 0x118000007f0000L) != 0L)
         {
            jjmatchedKind = 53;
            jjmatchedPos = 3;
            return 2;
         }
         return -1;
      case 4:
         if ((active0 & 0x10000000000000L) != 0L)
            return 2;
         if ((active0 & 0x3f8a000000L) != 0L)
         {
            if (jjmatchedPos < 2)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 2;
            }
            return -1;
         }
         if ((active0 & 0x5000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 1;
            }
            return -1;
         }
         if ((active0 & 0x18000007f0000L) != 0L)
         {
            jjmatchedKind = 53;
            jjmatchedPos = 4;
            return 2;
         }
         return -1;
      case 5:
         if ((active0 & 0x8000000c0000L) != 0L)
            return 2;
         if ((active0 & 0xa000000L) != 0L)
         {
            if (jjmatchedPos < 2)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 2;
            }
            return -1;
         }
         if ((active0 & 0x5000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 1;
            }
            return -1;
         }
         if ((active0 & 0x1000000730000L) != 0L)
         {
            jjmatchedKind = 53;
            jjmatchedPos = 5;
            return 2;
         }
         return -1;
      case 6:
         if ((active0 & 0x1000000730000L) != 0L)
            return 2;
         if ((active0 & 0x4000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 53;
               jjmatchedPos = 1;
            }
            return -1;
         }
         if ((active0 & 0xa000000L) != 0L)
         {
            if (jjmatchedPos < 2)
            {
               jjmatchedKind = 53;
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
         return jjStopAtPos(0, 13);
      case 41:
         return jjStopAtPos(0, 14);
      case 45:
         jjmatchedKind = 12;
         return jjMoveStringLiteralDfa1_0(0x12L);
      case 46:
         return jjStopAtPos(0, 11);
      case 65:
         jjmatchedKind = 51;
         return jjMoveStringLiteralDfa1_0(0x30000L);
      case 66:
         return jjMoveStringLiteralDfa1_0(0x10000010000000L);
      case 68:
         return jjMoveStringLiteralDfa1_0(0x65000000L);
      case 70:
         jjmatchedKind = 50;
         return jjMoveStringLiteralDfa1_0(0x1000000000000L);
      case 72:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 73:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 76:
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 77:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 82:
         jjmatchedKind = 49;
         return jjMoveStringLiteralDfa1_0(0x800000000000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 86:
         return jjMoveStringLiteralDfa1_0(0x3f8a000000L);
      case 88:
         return jjMoveStringLiteralDfa1_0(0x7fc000000000L);
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
         if ((active0 & 0x4000000000L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x480000000000L);
      case 50:
         if ((active0 & 0x8000000000L) != 0L)
         {
            jjmatchedKind = 39;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000000L);
      case 51:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 40, 2);
         break;
      case 52:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 41, 2);
         break;
      case 53:
         if ((active0 & 0x40000000000L) != 0L)
         {
            jjmatchedKind = 42;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x200000000000L);
      case 55:
         return jjMoveStringLiteralDfa2_0(active0, 0x3f8a000000L);
      case 68:
         return jjMoveStringLiteralDfa2_0(active0, 0x65000000L);
      case 99:
         return jjMoveStringLiteralDfa2_0(active0, 0x30000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x800010c00000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x11000000040000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x280000L);
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
         return jjMoveStringLiteralDfa3_0(active0, 0x65000000L);
      case 48:
         if ((active0 & 0x80000000000L) != 0L)
         {
            jjmatchedKind = 43;
            jjmatchedPos = 2;
         }
         else if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 44, 2);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 45, 2);
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000000L);
      case 53:
         return jjMoveStringLiteralDfa3_0(active0, 0x3f8a000000L);
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x130000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
      case 103:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(2, 23, 2);
         break;
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000200000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000040000L);
      case 116:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(2, 28, 2);
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
         return jjMoveStringLiteralDfa4_0(active0, 0x3f8a000000L);
      case 48:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 46, 2);
         break;
      case 49:
         if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(3, 29);
         break;
      case 50:
         if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(3, 30);
         break;
      case 66:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000L);
      case 76:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000L);
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000000L);
      case 103:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x30000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000040000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000400000L);
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
         if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(4, 31);
         break;
      case 50:
         if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(4, 32);
         break;
      case 51:
         if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(4, 33);
         break;
      case 52:
         if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(4, 34);
         break;
      case 53:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(4, 35);
         break;
      case 54:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(4, 36);
         break;
      case 55:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStopAtPos(4, 37);
         break;
      case 66:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000L);
      case 76:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000000000L);
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x5040000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000L);
      case 107:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000L);
      case 116:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 52, 2);
         break;
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000130000L);
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
         return jjMoveStringLiteralDfa6_0(active0, 0x200000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x100000L);
      case 101:
         return jjMoveStringLiteralDfa6_0(active0, 0xa000000L);
      case 103:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000000L);
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x1000000430000L);
      case 115:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(5, 18, 2);
         else if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(5, 19, 2);
         break;
      case 116:
         if ((active0 & 0x1000000L) != 0L)
            return jjStopAtPos(5, 24);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 47, 2);
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
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 48, 2);
         break;
      case 101:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(6, 20, 2);
         break;
      case 103:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(6, 22, 2);
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000L);
      case 109:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(6, 21, 2);
         break;
      case 115:
         if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(6, 26);
         break;
      case 116:
         if ((active0 & 0x20000L) != 0L)
         {
            jjmatchedKind = 17;
            jjmatchedPos = 6;
         }
         else if ((active0 & 0x2000000L) != 0L)
            return jjStopAtPos(6, 25);
         return jjMoveStringLiteralDfa7_0(active0, 0x10000L);
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
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(7, 16, 2);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(7, 27);
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
                     if (kind > 15)
                        kind = 15;
                     { jjCheckNAdd(0); }
                  }
                  else if (curChar == 34)
                     { jjCheckNAddTwoStates(4, 5); }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  { jjCheckNAdd(0); }
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 53)
                     kind = 53;
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
                  if (curChar == 34 && kind > 54)
                     kind = 54;
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
                  if (kind > 53)
                     kind = 53;
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
"", null, null, null, null, null, null, null, null, null, null, "\56", "\55", 
"\50", "\51", null, "\101\143\143\157\165\156\164\163", 
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
       if (jjmatchedPos == 0 && jjmatchedKind > 55)
       {
          jjmatchedKind = 55;
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
   -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xfffffffffff801L, 
};
static final long[] jjtoSkip = {
   0x7feL, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[6];
    static private final int[] jjstateSet = new int[2 * 6];

    
    static protected int curChar;
}
