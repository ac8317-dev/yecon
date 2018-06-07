package com.autochips.bluetooth.util;

import java.util.ArrayList;

import android.R.integer;

public class Util {
	
	
	public static final  int ESCAPE = 1;
	public static final  int key2 = 2;
	public static final  int key3 = 3;
	public static final  int key4 = 4;
	public static final  int key5 = 5;
	public static final  int key6 = 6;
	public static final  int key7 = 7;
	public static final  int key8 = 8;
	public static final  int key9 = 9;
	public static final  int key10 = 10;
	public static final  int key11 =11;
	public static final  int MINUS =12;
	public static final  int EQUALS=13;
	public static final  int DEL = 14;
	public static final  int TAB =15;
	public static final  int Q =16;
	public static final  int W = 17;
	public static final  int E = 18;
	public static final  int R = 19;
	public static final  int T = 20;
	public static final  int Y =21;
	public static final  int U =22;
	public static final  int I =23;
	public static final  int O =24;
	public static final  int P =25;
	public static final  int LEFT_BRACKET =26;
	public static final  int RIGHT_BRACKET =27;
	public static final  int ENTER =28;
	public static final  int CTRL_LEFT =29;
	public static final  int A =30;
	public static final  int S =31;
	public static final  int D =32;
	public static final  int F =33;
	public static final  int G =34;
	public static final  int H =35;
	public static final  int J =36;
	public static final  int K =37;
	public static final  int L =38;
	public static final  int SEMICOLON =39;
	public static final  int APOSTROPHE =40;
	public static final  int GRAVE =41;
	public static final  int SHIFT_LEFT =42;
	public static final  int BACKSLASH =43;
	public static final  int Z =44;
	public static final  int X =45;
	public static final  int C =46;
	public static final  int V =47;
	public static final  int B =48;
	public static final  int N =49;
	public static final  int M =50;
	public static final  int COMMA =51;
	public static final  int PERIOD =52;
	public static final  int SLASH =53;
	public static final  int SHIFT_RIGHT =54;
	public static final  int NUMPAD_MULTIPLY =55;
	public static final  int ALT_LEFT =56;
	public static final  int SPACE =57;
	public static final  int CAPS_LOCK =58;
	public static final  int F1 =59;
	public static final  int F2 =60;
	public static final  int F3 =61;
	public static final  int F4 =62;
	public static final  int F5 =63;
	public static final  int F6 =64;
	public static final  int F7 =65;
	public static final  int F8 =66;
	public static final  int F9 =67;
	public static final  int F10 =68;
	public static final  int NUM_LOCK =69;
	public static final  int SCROLL_LOCK =70;
	public static final  int NUMPAD_7 =71;
	public static final  int NUMPAD_8 =72;
	public static final  int NUMPAD_9 =73;
	public static final  int NUMPAD_SUBTRACT =74 ;
	public static final  int NUMPAD_4 =75;
	public static final  int NUMPAD_5 =76;
	public static final  int NUMPAD_6 =77;
	public static final  int NUMPAD_ADD =78;
	public static final  int NUMPAD_1 =79;
	public static final  int NUMPAD_2 =80;
	public static final  int NUMPAD_3 =81;
	public static final  int NUMPAD_0 =82;
	public static final  int NUMPAD_DOT =83;
	public static final  int ZENKAKU_HANKAKU=85;
	public static final  int BACKSLASH1 = 86;
	public static final  int F11 =87;
	public static final  int F12 =88;
	public static final  int RO =89;
	public static final  int KEY_KATAKANA = 90;
    public static final  int KEY_HIRAGANA = 91;
	public static final  int HENKAN =92;
	public static final  int KATAKANA_HIRAGANA =93;
	public static final  int MUHENKAN =94;
	public static final  int NUMPAD_COMMA =95;
	public static final  int NUMPAD_ENTER =96;
	public static final  int CTRL_RIGHT =97;
	public static final  int NUMPAD_DIVIDE =98;
	public static final  int SYSRQ =99;
	public static final  int ALT_RIGHT =100;
	public static final  int KEY_LINEFEED = 101;
	public static final  int MOVE_HOME =102;
	public static final  int DPAD_UP =103;
	public static final  int PAGE_UP =104;
	public static final  int DPAD_LEFT =105;
	public static final  int DPAD_RIGHT =106;
	public static final  int MOVE_END =107;
	public static final  int DPAD_DOWN =108;
	public static final  int PAGE_DOWN =109;
	public static final  int INSERT =110;
	public static final  int FORWARD_DEL =111;
	public static final  int KEY_MACRO = 112;
	public static final  int VOLUME_MUTE =113;
	public static final  int VOLUME_DOWN =114;
	public static final  int VOLUME_UP =115;
	public static final  int POWER_WAKE3 =116;
	public static final  int NUMPAD_EQUALS =117;
	public static final  int KEY_KPPLUSMINUS = 118;
	public static final  int BREAK =119;
	public static final  int NUMPAD_COMMA1 = 121;
	public static final  int KANA =122;
	public static final  int EISU =123;
	public static final  int YEN =124;
	public static final  int META_LEFT =125;
	public static final  int META_RIGHT =126;
	public static final  int WAKE_DROPPED =127;
	public static final  int MEDIA_STOP =128;
	public static final  int KEY_AGAIN =129;
	public static final  int KEY_PROPS = 130;
	public static final  int KEY_UNDO = 131;
	public static final  int KEY_FRONT = 132;
	public static final  int KEY_COPY = 133;
	public static final  int KEY_OPEN = 134;
	public static final  int KEY_PASTE = 135;
	public static final  int KEY_FIND = 136;
	public static final  int KEY_CUT = 137;
	public static final  int KEY_HELP = 138;
	public static final  int WAKE_DROPPED2 =139;
	public static final  int CALCULATOR =140;
	public static final  int KEY_SETUP = 141;
	public static final  int POWER_WAKE2 =142;
	//public static final  int POWER WAKE =143;
	public static final  int KEY_FILE = 144;
	public static final  int KEY_SENDFILE = 145;
	public static final  int KEY_DELETEFILE = 146;
	public static final  int KEY_XFER = 147;
	public static final  int KEY_PROG1 = 148;
	public static final  int KEY_PROG2 = 149;
	public static final  int EXPLORER = 150;
	public static final  int KEY_MSDOS = 151;
	public static final  int POWER_WAKE =152;
	public static final  int KEY_DIRECTION = 153;
	public static final  int KEY_CYCLEWINDOWS = 154;
	public static final  int ENVELOPE =155;
	public static final  int BOOKMARK =156;
	public static final  int KEY_COMPUTER = 157;
    public static final  int BACK_WAKE_DROPPED =158;
	public static final  int FORWARD =159;
	public static final  int MEDIA_CLOSE =160;
	public static final  int MEDIA_EJECT =161;
//	public static final  int  MEDIA_EJECT =162;
	public static final  int MEDIA_NEXT =163;
	public static final  int MEDIA_PLAY_PAUSE =164;
	public static final  int MEDIA_PREVIOUS =165;
	public static final  int MEDIA_STOP1 =166;
	public static final  int MEDIA_RECORD =167;
	public static final  int MEDIA_REWIND =168;
	public static final  int CALL =169;
	public static final  int KEY_ISO = 170;
	public static final  int MUSIC =171;
	public static final  int HOME =172;
	public static final  int KEY_REFRESH = 173;
	public static final  int KEY_EXIT = 174;
	public static final  int KEY_MOVE = 175;
	public static final  int KEY_EDIT = 176;
//	public static final  int PAGE_UP =177;
	//public static final  int PAGE_DOWN =178;
	public static final  int NUMPAD_LEFT_PAREN =179;
	public static final  int NUMPAD_RIGHT_PAREN =180;
	public static final  int KEY_NEW = 181;
	public static final  int KEY_REDO = 182;
	public static final  int F13 = 183;
	public static final  int F14 = 184;
	public static final  int F15 =185;
	public static final  int F16 =186;
	public static final  int F17 =187;
	public static final  int F18 = 188;
	public static final  int F19 =189;
	public static final  int F20 =190;
	public static final  int F21 = 191;
	public static final  int F22 =192;
	public static final  int F23 =193;
	public static final  int F24 = 194;
	public static final  int MEDIA_PLAY =200;
	public static final  int MEDIA_PAUSE =201;
	public static final  int KEY_PROG3=202;
	public static final  int KEY_PROG4 = 203;
	public static final  int KEY_SUSPEND = 205;
	public static final  int KEY_CLOSE12 = 206;
	public static final  int MEDIA_PLAY1 =207;
	public static final  int MEDIA_FAST_FORWARD =208;
	public static final  int KEY_BASSBOOST = 209;
	public static final  int KEY_PRINT = 210;
	public static final  int KEY_HP = 211;
	public static final  int CAMERA =212;
	public static final  int MUSIC1 =213;
	public static final  int KEY_QUESTION = 214;
	public static final  int ENVELOPE1 =215;
	public static final  int KEY_CHAT = 216;
	public static final  int SEARCH =217;
	public static final  int KEY_CONNECT =218;
	public static final  int KEY_FINANCE = 219;
	public static final  int KEY_SPORT =220;
	public static final  int KEY_SHOP =221;
	public static final  int KEY_ALTERASE =222;
	public static final  int KEY_CANCEL =223;
	public static final  int KEY_BRIGHTNESSDOWN = 224;
	public static final  int KEY_BRIGHTNESSUP = 225;
	public static final  int HEADSETHOOK =226;
//	public static final  int APP_SWITCH WAKE_DROPPED =229;

	public static final  int  BUTTON_1 =256;
	public static final  int  BUTTON_2 =257;
	public static final  int  BUTTON_3 =258;
	public static final  int  BUTTON_4 =259;
	public static final  int  BUTTON_5 =260;
	public static final  int  BUTTON_6 =260;
	public static final  int  BUTTON_7 =262;
	public static final  int  BUTTON_8 =263;
	public static final  int  BUTTON_9 =264;
	public static final  int  BUTTON_10 =265;
	public static final  int  BUTTON_11 =266;
	public static final  int  BUTTON_12 =267;
	public static final  int  BUTTON_13 =268;
	public static final  int  BUTTON_14 =269;
	public static final  int  BUTTON_15 =270;
	public static final  int  BUTTON_16 =271;

	/*
	public static final  int  BUTTON_1 =288;
	public static final  int  BUTTON_2 =289;
	public static final  int  BUTTON_3 =290;
	public static final  int  BUTTON_4 =291;
	public static final  int  BUTTON_5 =292;
	public static final  int  BUTTON_6 =293;
	public static final  int  BUTTON_7 =294;
	public static final  int  BUTTON_8 =295;
	public static final  int  BUTTON_9 =296;
	public static final  int  BUTTON_10 =297;
	public static final  int  BUTTON_11 =298;
	public static final  int  BUTTON_12 =299;
	public static final  int  BUTTON_13 =300;
	public static final  int  BUTTON_14 =301;
	public static final  int  BUTTON_15 =302;
	public static final  int  BUTTON_16 =303;*/


	public static final  int   BUTTON_A =304;
	public static final  int   BUTTON_B =305;
	public static final  int   BUTTON_C =306;
	public static final  int   BUTTON_X =307;
	public static final  int   BUTTON_Y =308;
	public static final  int   BUTTON_Z =309;
	public static final  int   BUTTON_L1 =310;
	public static final  int   BUTTON_R1 =311;
	public static final  int   BUTTON_L2 =312;
	public static final  int   BUTTON_R2 =313;
	public static final  int   BUTTON_SELECT =314;
	public static final  int   BUTTON_START =315;
	public static final  int   BUTTON_MODE =316;
	public static final  int   BUTTON_THUMBL =317;
	public static final  int   BUTTON_THUMBR =318;


	public static final  int KEY_OK = 352;
	public static final  int DPAD_CENTER =353;
	public static final  int KEY_GOTO = 354;
	public static final  int KEY_CLEAR = 355;
	public static final  int KEY_POWER2 =356;
	public static final  int KEY_OPTION =357;
	public static final  int KEY_INFO = 358;
	public static final  int KEY_TIME =359;
	public static final  int KEY_VENDOR =360;
	public static final  int KEY_ARCHIVE =361;
	public static final  int GUIDE =362;
	public static final  int KEY_CHANNEL =363;
	public static final  int KEY_FAVORITES=364;
	public static final  int KEY_EPG=365;
	public static final  int DVR =366;
	public static final  int KEY_MHP = 367;
	public static final  int KEY_LANGUAGE = 368;
	public static final  int KEY_TITLE = 369;
	public static final  int KEY_SUBTITLE = 370;
	public static final  int KEY_ANGLE = 371;
	public static final  int KEY_ZOOM =372;
	public static final  int KEY_MODE =373;
	public static final  int KEY_KEYBOARD = 374;
	public static final  int KEY_SCREEN = 375;
	public static final  int KEY_PC = 376;
	public static final  int TV =377;
	public static final  int KEY_TV2 =378;
	public static final  int KEY_VCR =379;
	public static final  int KEY_VCR2 =380;
	public static final  int KEY_SAT =381;
	public static final  int KEY_SAT2 =382;
	public static final  int KEY_CD =383;
	public static final  int KEY_TAPE =384;
	public static final  int KEY_RADIO =385;
	public static final  int KEY_TUNER =386;
	public static final  int KEY_PLAYER = 387;
	public static final  int KEY_TEXT =388;
	public static final  int KEY_DVD =389;
	public static final  int KEY_AUX = 390;
	public static final  int KEY_MP3 =391;
	public static final  int KEY_AUDIO = 392;
	public static final  int KEY_VIDEO =393;
	public static final  int KEY_DIRECTORY =394;
	public static final  int KEY_LIST =395;
	public static final  int KEY_MEMO =396;
	public static final  int CALENDAR =397;
	public static final  int KEY_RED =398;
	public static final  int KEY_GREEN =399;
	public static final  int KEY_YELLOW =400;
	public static final  int KEY_BLUE =401;
	public static final  int CHANNEL_UP =402;
	public static final  int CHANNEL_DOWN =403;
	public static final  int KEY_FIRST =404;
	public static final  int KEY_LAST =405;
	public static final  int KEY_AB =406;
	public static final  int KEY_NEXT =407;
	public static final  int KEY_RESTART =408;
	public static final  int KEY_SLOW =409;
	public static final  int KEY_SHUFFLE =410;
	public static final  int KEY_BREAK = 411;
	public static final  int KEY_PREVIOUS =412;
	public static final  int KEY_DIGITS= 413;
	public static final  int KEY_TEEN =414;
	public static final  int KEY_TWEN =415;

	public static final  int CONTACTS = 429;

	public static final  int KEY_DEL_EOL =448;
	public static final  int KEY_DEL_EOS =449;
	public static final  int KEY_INS_LINE =450;
	public static final  int KEY_DEL_LINE =451;
	
	  public static final int    YECON_EQ = 505;
	  public static final int    YECON_PHONE_ON= 506;
	  public static final int    YECON_PHONE_OFF= 507;
	  public static final int    YECON_SOURCE_MODE=508;
	  public static final int    YECON_HOME_FRONTSRC=509;
	  public static final int    YECON_DVD_EJECT=510;
	  public static final int    YECON_DVD_CLOSE=511;
	  public static final int    YECON_MUSIC=512;
	  public static final int    YECON_PHOTO=513;
	  public static final int    YECON_VIDEO=514;
	  public static final int    YECON_NAVI=515;
	  public static final int    YECON_TUNER=516;
	  public static final int    YECON_DVD=517;
	  public static final int    YECON_BLUETOOTH=518;
	  public static final int    YECON_SETTING=519;
	  public static final int    YECON_TV=520;
	  public static final int    YECON_USB=521;
	  public static final int    YECON_SD_CARD=522;
	  public static final int    YECON_TOUCH_MENU=523; 
      public static final int    YECON_PLAY=524;
	  public static final int    YECON_NEXT=525;
	  public static final int    YECON_PREV=526;
	  public static final int    YECON_BLACKOUT=527;
      public static final int    YECON_BACKLIGHT_OFF=529;
	  public static final int    YECON_BACKLIGHT_NIGHT=530;
	  public static final int    YECON_FASTF=531;
	  public static final int    YECON_FASTB=532;
	  public static final int    YECON_POWER=533;
	  public static final int    YECON_TOUCH_SCR=534;
	  public static final int    YECON_RADIO_FM=535;
	  public static final int    YECON_RADIO_AM=536;
	  public static final int    YECON_SET_EQ=537;
	  public static final int    YECON_LOUDNESS=538;
	  public static final int    YECON_ENTER=539;
	  public static final int    YECON_RADIO_AS=540;
	  public static final int    YECON_TEL=541;		
	  
	  public static final int    YECON_VOICE=542;//
	  public static final int    YECON_RADIO_PS=543;//
	  public static final int    YECON_ISSSR = 545;   
	  public static final int    YECON_APP_MANAGER=547;//
	  public static int          curKeyCode = 0;
	  
	  public static final int  delayTime = 500;
	  public static final int  PUBLIC_MSG_ID = 5000;
	  public static int        pos_threshold = 30;
	  public static int        con_fragment_type = 1;
	  public static int        mode_fragment_type = 2;
	  public static int        touch_key_listener_timer = 500;
	  public static boolean    netlink_opened = false;
	
}
