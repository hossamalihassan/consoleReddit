package mainPackage;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Login {

	static Scanner sc = new Scanner(System.in);
	static boolean login = false;
	static String name, pwd;
	static HashMap<String,String> user = DB.user;

	
	public void login() {
		/* to check if the user entered the right info */
		boolean loginCont = false;
		while(!loginCont) {
			System.out.print(Styling.GREEN_BOLD_BRIGHT + "username: " + Styling.TEXT_RESET);
			Login.name = sc.next();
			System.out.print(Styling.GREEN_BOLD_BRIGHT + "password: " + Styling.TEXT_RESET);
			sc.nextLine();
			Login.pwd = sc.next();
			
			for(Entry<String, String> set : user.entrySet()) {
				if(set.getKey().equals(name) && set.getValue().equals(pwd) ) {
					Login.login = true;
				}
			}
			
			
			if(login) {
				loginCont = true;
				System.out.println("-------------------------------------------------------");
				System.out.println("----------------"+Styling.CYAN_BRIGHT+"Logged in successfully"+ Styling.TEXT_RESET +"-----------------");
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("!----" + Styling.RED_BRIGHT +"incorrect username or password"+ Styling.TEXT_RESET);
			}
		}
		
		
	}
	
}
