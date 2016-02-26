/* Generated By:JJTree&JavaCC: Do not edit this line. Hbl.java */
  public class Hbl/*@bgen(jjtree)*/implements HblTreeConstants, HblConstants {/*@bgen(jjtree)*/
  protected static JJTHblState jjtree = new JJTHblState();public static void main( String[] args ) {
      System.out.println("Reading from standard input...");
      Hbl parser = new Hbl( System.in );
      try {
        SimpleNode node = parser.Start();
        System.out.println(node.generate().toString());
        System.out.println("Thank you.");
      } catch (Exception e) {
        System.out.println("Oops.");
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }

  static final public SimpleNode Start() throws ParseException {
                      /*@bgen(jjtree) Start */
  ASTStart jjtn000 = new ASTStart(JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ACCOUNTS:
        case HORSES:
        case TRACKS:
        case INCLUDE:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ACCOUNTS:
          Accounts();
          break;
        case HORSES:
          Horses();
          break;
        case TRACKS:
          Tracks();
          break;
        case INCLUDE:
          Include();
          break;
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MEETING:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_2;
        }
        Meeting();
      }
      jj_consume_token(0);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void Name() throws ParseException {
              /*@bgen(jjtree) Name */
  ASTName jjtn000 = new ASTName(JJTNAME);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        jj_consume_token(IDENTIFIER);
        break;
      case STRING_LITERAL:
        jj_consume_token(STRING_LITERAL);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void Include() throws ParseException {
                  /*@bgen(jjtree) Include */
  ASTInclude jjtn000 = new ASTInclude(JJTINCLUDE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(INCLUDE);
      jj_consume_token(STRING_LITERAL);
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void AccountSpec() throws ParseException {
 /*@bgen(jjtree) AccountSpec */
  ASTAccountSpec jjtn000 = new ASTAccountSpec(JJTACCOUNTSPEC);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token number;
    try {
      Name();
      jj_consume_token(COLON);
      number = jj_consume_token(NUMBER);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.setAmount(number.image);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void Accounts() throws ParseException {
                   /*@bgen(jjtree) Accounts */
  ASTAccounts jjtn000 = new ASTAccounts(JJTACCOUNTS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(ACCOUNTS);
      AccountSpec();
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_3;
        }
        jj_consume_token(COMMA);
        AccountSpec();
      }
      jj_consume_token(PERIOD);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void HorseSpec() throws ParseException {
                    /*@bgen(jjtree) HorseSpec */
  ASTHorseSpec jjtn000 = new ASTHorseSpec(JJTHORSESPEC);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Name();
      jj_consume_token(COLON);
      jj_consume_token(NUMBER);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void Horses() throws ParseException {
                 /*@bgen(jjtree) Horses */
  ASTHorses jjtn000 = new ASTHorses(JJTHORSES);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(HORSES);
      HorseSpec();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_4;
        }
        jj_consume_token(COMMA);
        HorseSpec();
      }
      jj_consume_token(PERIOD);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void TrackSpec() throws ParseException {
                    /*@bgen(jjtree) TrackSpec */
  ASTTrackSpec jjtn000 = new ASTTrackSpec(JJTTRACKSPEC);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Name();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void Tracks() throws ParseException {
                 /*@bgen(jjtree) Tracks */
  ASTTracks jjtn000 = new ASTTracks(JJTTRACKS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(TRACKS);
      TrackSpec();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_5;
        }
        jj_consume_token(COMMA);
        TrackSpec();
      }
      jj_consume_token(PERIOD);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void Date() throws ParseException {
               /*@bgen(jjtree) Date */
  ASTDate jjtn000 = new ASTDate(JJTDATE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(NUMBER);
      jj_consume_token(DASH);
      jj_consume_token(NUMBER);
      jj_consume_token(DASH);
      jj_consume_token(NUMBER);
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void DDSpec() throws ParseException {
                 /*@bgen(jjtree) DDSpec */
  ASTDDSpec jjtn000 = new ASTDDSpec(JJTDDSPEC);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(DD);
      LegList();
      jj_consume_token(PERIOD);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void LegList() throws ParseException {
                  /*@bgen(jjtree) LegList */
  ASTLegList jjtn000 = new ASTLegList(JJTLEGLIST);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(NUMBER);
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_6;
        }
        jj_consume_token(COMMA);
        jj_consume_token(NUMBER);
      }
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void V75Spec() throws ParseException {
                  /*@bgen(jjtree) V75Spec */
  ASTV75Spec jjtn000 = new ASTV75Spec(JJTV75SPEC);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(V75);
      LegList();
      jj_consume_token(PERIOD);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void PoolSpecs() throws ParseException {
                    /*@bgen(jjtree) PoolSpecs */
  ASTPoolSpecs jjtn000 = new ASTPoolSpecs(JJTPOOLSPECS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DD:
        case V75:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_7;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DD:
          DDSpec();
          break;
        case V75:
          V75Spec();
          break;
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void StartList() throws ParseException {
                    /*@bgen(jjtree) StartList */
  ASTStartList jjtn000 = new ASTStartList(JJTSTARTLIST);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Name();
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[10] = jj_gen;
          break label_8;
        }
        jj_consume_token(COMMA);
        Name();
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void LegSpec() throws ParseException {
                  /*@bgen(jjtree) LegSpec */
  ASTLegSpec jjtn000 = new ASTLegSpec(JJTLEGSPEC);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(LEG);
      jj_consume_token(NUMBER);
      jj_consume_token(COLON);
      StartList();
      jj_consume_token(PERIOD);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void LegSpecs() throws ParseException {
                   /*@bgen(jjtree) LegSpecs */
  ASTLegSpecs jjtn000 = new ASTLegSpecs(JJTLEGSPECS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_9:
      while (true) {
        LegSpec();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LEG:
          ;
          break;
        default:
          jj_la1[11] = jj_gen;
          break label_9;
        }
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void Meeting() throws ParseException {
                  /*@bgen(jjtree) Meeting */
  ASTMeeting jjtn000 = new ASTMeeting(JJTMEETING);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(MEETING);
      Name();
      Date();
      PoolSpecs();
      LegSpecs();
      jj_consume_token(PERIOD);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public HblTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xf00000,0xf00000,0x1000000,0x30000000,0x10000,0x10000,0x10000,0x10000,0xc000000,0xc000000,0x10000,0x2000000,};
   }

  /** Constructor with InputStream. */
  public Hbl(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Hbl(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new HblTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Hbl(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new HblTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Hbl(HblTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(HblTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[30];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 30; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  }
