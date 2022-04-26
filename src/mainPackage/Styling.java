package mainPackage;


import java.awt.Color;

public class Styling {

	  static final String setPlainText = "\033[0;0m";
	  static final String setBoldText = "\033[0;1m";
	  
	  // colors
	  static final Color D_Black   = Color.getHSBColor( 0.000f, 0.000f, 0.000f );
	  static final Color D_Red     = Color.getHSBColor( 0.000f, 1.000f, 0.502f );
	  static final Color D_Blue    = Color.getHSBColor( 0.667f, 1.000f, 0.502f );
	  static final Color D_Magenta = Color.getHSBColor( 0.833f, 1.000f, 0.502f );
	  static final Color D_Green   = Color.getHSBColor( 0.333f, 1.000f, 0.502f );
	  static final Color D_Yellow  = Color.getHSBColor( 0.167f, 1.000f, 0.502f );
	  static final Color D_Cyan    = Color.getHSBColor( 0.500f, 1.000f, 0.502f );
	  static final Color D_White   = Color.getHSBColor( 0.000f, 0.000f, 0.753f );
	  
	  static final Color B_Black   = Color.getHSBColor( 0.000f, 0.000f, 0.502f );
	  static final Color B_Red     = Color.getHSBColor( 0.000f, 1.000f, 1.000f );
	  static final Color B_Blue    = Color.getHSBColor( 0.667f, 1.000f, 1.000f );
	  static final Color B_Magenta = Color.getHSBColor( 0.833f, 1.000f, 1.000f );
	  static final Color B_Green   = Color.getHSBColor( 0.333f, 1.000f, 1.000f );
	  static final Color B_Yellow  = Color.getHSBColor( 0.167f, 1.000f, 1.000f );
	  static final Color B_Cyan    = Color.getHSBColor( 0.500f, 1.000f, 1.000f );
	  static final Color B_White   = Color.getHSBColor( 0.000f, 0.000f, 1.000f );
	  static final Color cReset    = Color.getHSBColor( 0.000f, 0.000f, 1.000f );
	  
	  public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
      public static final String RED_BRIGHT = "\033[0;91m";    // RED
      public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
      public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
      public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
      public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
      public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
      public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
      
      public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
      public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
      public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
      public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
      public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
      public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
      public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
      public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
      
	  public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
      public static final String RED_BOLD = "\033[1;31m";    // RED
      public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
      public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
      public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
      public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
      public static final String WHITE_BOLD = "\033[1;37m";
	  public static final String TEXT_RESET = "\u001B[0m";
	  public static final String YELLOW_BOLD = "\033[1;33m";
	  
	  // logo
	  static String logo = "\r\n" +
			          YELLOW_BOLD+ "                           _     "+TEXT_RESET+YELLOW_BOLD_BRIGHT+"______         _     _ _ _   \r\n"+TEXT_RESET +
					  YELLOW_BOLD+ "                          | |    "+TEXT_RESET+YELLOW_BOLD_BRIGHT+"| ___ \\       | |   | (_) |  \r\n"+TEXT_RESET +
					  YELLOW_BOLD+ "  ___ ___  _ __  ___  ___ | | ___"+TEXT_RESET+YELLOW_BOLD_BRIGHT+"| |_/ /___  __| | __| |_| |_ \r\n"+TEXT_RESET +
					  YELLOW_BOLD+ " / __/ _ \\| '_ \\/ __|/ _ \\| |/ _ \\"+TEXT_RESET+YELLOW_BOLD_BRIGHT+"   // _ \\/ _` |/ _` | | __|\r\n"+TEXT_RESET +
					  YELLOW_BOLD+ "| (_| (_) | | | \\__ \\ (_) | |  __/"+TEXT_RESET+YELLOW_BOLD_BRIGHT+" |\\ \\  __/ (_| | (_| | | |_ \r\n"+TEXT_RESET +
					  YELLOW_BOLD+ " \\___\\___/|_| |_|___/\\___/|_|\\___"+TEXT_RESET+YELLOW_BOLD_BRIGHT+"\\_| \\_\\___|\\__,_|\\__,_|_|\\__|\r\n"+TEXT_RESET ;
	  
	
	
}
