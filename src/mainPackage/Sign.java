package mainPackage;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign {
	static Scanner sc = new Scanner(System.in);
	
	static HashMap<String,String> user = DB.user;
	static HashMap<String,String> emails = DB.emails;
	
	static String name;
	static String pwd;
	static String email;
	
	
	boolean OK = false;
	
	static boolean valid(String type, String thing) {
		String regexEmail = "^(.+)@(.+)$";
		String regexPassword = "^(?=.*[0-9])"
                			 + "(?=.*[a-z])"
                			 + "(?=\\S+$).{8,20}$";
		Pattern patternEmail = Pattern.compile(regexEmail);
		Matcher matcherEmail = patternEmail.matcher(thing);
		Pattern patternPwd = Pattern.compile(regexPassword);
		Matcher matcherPwd = patternPwd.matcher(thing);
		if(type == "email" && matcherEmail.matches()) {
			return true;
		}
		else if (type == "password" && matcherPwd.matches()) {
			return true;
		}
		return false;
	}

	Sign() {
		/* user name validation */
		while(!OK) {
			System.out.print("username: ");
			Sign.name = sc.next();
			if(!user.containsKey(Sign.name)) {
				OK = true;
				break;
			}
			System.out.println("!--this username is used--!");
		}
		/* email validation */
		OK = false;
		while(!OK) {
			System.out.print("email: ");
			sc.nextLine();
			Sign.email = sc.next();
			if(valid("email", email) && !emails.containsKey(Sign.email)) {
				OK = true;
				break;
			}
			else if (emails.containsKey(Sign.email)) System.out.println("--this email is already in use");
			else System.out.println("!--this email is inconrrect--!");
		}
		/* password validation */
		OK = false;
		while(!OK) {
			System.out.print("password: ");
			Sign.pwd = sc.next();
			if(valid("password", pwd)) {
				OK = true;
				break;
			}
			else System.out.println("!--enter stronger password (include digits 0-9, don't write whitespaces, at least write 8 characters)--!");
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("-----------------"+Styling.CYAN_BRIGHT+"Signed up successfully"+ Styling.TEXT_RESET +"-----------------");
		System.out.println("-------------------"+Styling.CYAN_BRIGHT+"now you can login"+ Styling.TEXT_RESET +"-------------------");
		System.out.println("-------------------------------------------------------");
	
	}
	
	
}
