package mainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
	static Scanner sc = new Scanner(System.in);
	
	public static void login() {
		DB db = new DB();
		db.connect();
		Login lg = new Login(); // to input info 
		lg.login(); // to check info 
		RedditAge rg = new RedditAge(); // to calc reddit age
		ViewPosts vp = new ViewPosts();
		vp.getPosts();
	}
	
	public static void signup() {
		Sign s = new Sign();
		AddUser ad = new AddUser();
		ad.add();
	}
	
	public static void mainMenu() {
		UpdateThis ut = new UpdateThis();
		int opt = 1;
		try {
			System.out.println(Styling.GREEN_BRIGHT + "1 - Login    2 - Sign up" + Styling.TEXT_RESET);
			System.out.print(Styling.GREEN_BOLD_BRIGHT + "your choice: " + Styling.TEXT_RESET);
			opt = sc.nextInt();
		} catch(InputMismatchException e) {
			sc.next();
			mainMenu();
		}
		System.out.println("");

		if(opt == 1) {
			login(); // display login 
			ut.updateAge(); // to update age
			afterLoginMenu();
			
		} else if ( opt == 2) {
			signup();
			login();
			ut.updateAge(); // to update age
			afterLoginMenu();
		} else {
			mainMenu();
		}
	}
	
	public static void viewProfile() {
		ViewProfile vp = new ViewProfile();
		System.out.println("---------------------------------------------------");
		vp.viewProfile();
		System.out.println("---------------------------------------------------");
		afterLoginMenu();
	}
	
	public static void afterLoginMenu() {
		System.out.println(Styling.GREEN_BRIGHT + "1 - Newsfeed\t2 - View profile\t3 - Log out\t4 - Exit" + Styling.TEXT_RESET);
		System.out.print(Styling.GREEN_BOLD_BRIGHT + "your choice: " + Styling.TEXT_RESET);
		
		int mChoice = 1;
		try {
			mChoice = sc.nextInt();
		} catch(InputMismatchException e) {
			sc.next();
			afterLoginMenu();
		}
		
		if(mChoice == 1) {
			while(ViewPosts.post_index != 0) {
				newsfeedMenu();
			}
		} else if (mChoice == 2) {
			viewProfile();
		} else if(mChoice == 3) {
			System.out.println("╭--------------------------------╮");
			System.out.println("|    Logged out successfully     |");
			System.out.println("╰--------------------------------╯");
			mainMenu();
		} else if (mChoice == 4) {
			System.out.println("see you later, " + Login.name);
		}	
	}
	
	public static void newsfeedMenu() {
		System.out.println(Styling.GREEN_BRIGHT + "1 - Write post\t2 - Browse your newsfeed\t3 - Search by tags\t4 - Log out\t5 - Exit" + Styling.TEXT_RESET);
		System.out.print(Styling.GREEN_BOLD_BRIGHT + "your choice: " + Styling.TEXT_RESET);
		
		int nfmChoice = 1;
		try {
			nfmChoice = sc.nextInt();
		} catch(InputMismatchException e) {
			sc.next();
			newsfeedMenu();
		}
		
		if(nfmChoice == 1) {
			WritePost wp = new WritePost();
			wp.writePost();
			wp.addPostToDB();
		}
		else if(nfmChoice == 2) {
			ViewPosts vp = new ViewPosts();
			vp.viewPosts();
			postMenu();
		}
		else if(nfmChoice == 3) {
			SearchByTag.searchByTag();
			SearchByTag.viewSearchedPosts();
		}
		else if(nfmChoice == 4) {
			System.out.println("+----------------------------+");
			System.out.println("|--Logged out successfully---|");
			System.out.println("+----------------------------+");
			mainMenu();
		} else if(nfmChoice == 5) {
			ViewPosts.post_index = 0;
			System.out.println("---------------------------------------------------");
			System.out.println("see you later, " + Styling.D_Blue + Login.name);
		} else if(nfmChoice == 3) {
			SearchByTag st = new SearchByTag();
			SearchByTag.searchByTag();
			SearchByTag.viewSearchedPosts();
		}
		else {
			newsfeedMenu();
		}
	}
	
	public static void postMenu() {
		UpdateThis ut = new UpdateThis();
		System.out.println(Styling.GREEN_BRIGHT + "1 - Upvote\t2 - Downvote\t3 - Comment\t4 - Next post" + Styling.TEXT_RESET);
		System.out.print(Styling.GREEN_BOLD_BRIGHT +"your choice: " + Styling.TEXT_RESET);
		int pmChoice = 0;
		try {
			pmChoice = sc.nextInt();
		} catch(InputMismatchException e) {
			sc.next();
			postMenu();
		}
		if(pmChoice == 1) {
			ut.updateVotes("up");
			System.out.println("+----"+Styling.CYAN_BRIGHT+"Upvote added"+Styling.TEXT_RESET+"----+\n");
	        ut.updateKarma();
		} else if (pmChoice == 2) {
			ut.updateVotes("down");
			System.out.println("+----"+Styling.CYAN_BRIGHT+"Downvote added"+Styling.TEXT_RESET+"----+\n");
		} else if(pmChoice == 3) {
			WriteComments wc = new WriteComments();
			wc.writeComment();
	        ut.updateKarma();
	        System.out.println("+----"+Styling.CYAN_BRIGHT+"Comment added"+Styling.TEXT_RESET+"----+\n");
		}
		
		else if (pmChoice == 4) {
			ViewPosts vp = new ViewPosts();
			vp.viewPosts();
			postMenu();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(Styling.logo);

				
		/* display main menu */
		mainMenu();
		
		
	}

}
