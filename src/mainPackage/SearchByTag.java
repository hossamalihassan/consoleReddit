package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SearchByTag {

	static Scanner sc = new Scanner(System.in);
	static String searchedTag;
	static Statement st;
	static Connection conn;
	static int numPostsFound = 0;
	
	static HashMap<Integer, List<String>> searchedPosts = new HashMap<>();

	static void searchByTag() {
		
		System.out.print(Styling.GREEN_BOLD_BRIGHT + "enter tag: " + Styling.TEXT_RESET);
		SearchByTag.searchedTag = sc.next();
		
		try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            st = conn.createStatement();
            /* Get data */
    		ResultSet getSearch = st.executeQuery("SELECT * FROM posts WHERE tags LIKE '%" + SearchByTag.searchedTag.toLowerCase() + "%';");
    		while(getSearch.next()) {
    			numPostsFound += 1;
    			String subreddit = getSearch.getString("subreddit");
    			String content = getSearch.getString("post_content");
    			String title = getSearch.getString("title");
    			String username = getSearch.getString("user_name");
    			String[] postSearchedInfo = {subreddit, username, title, content};
    			List<String> post_age_list = Arrays.asList(postSearchedInfo);
    			searchedPosts.put(numPostsFound, post_age_list);
    		}
    		    
    		/* close result set */
    		getSearch.close();
    		
    		st.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
		
	}
	
	static String changeColorForEveryPostFound(int i) {
		if(i % 2 == 0) {
			return Styling.BLUE_BRIGHT;
		}
		return Styling.CYAN_BRIGHT;
		
	}
	
	static void viewSearchedPosts() {
		System.out.println("\n" + numPostsFound + " post(s) found");
		for(int i=0; i < searchedPosts.size(); i++) {
			List<String> postsFoundInfo = searchedPosts.get(numPostsFound--);
			String[] Searchedinfo = postsFoundInfo.toArray(new String[0]);
			System.out.print(changeColorForEveryPostFound(i));
			System.out.println("\nr/" + Searchedinfo[0] + "\tu/" + Searchedinfo[1]);
			System.out.println("\n" + Searchedinfo[2]);
			System.out.println(Searchedinfo[3]);
			System.out.print(Styling.TEXT_RESET);
			System.out.println("--------------------------------------------------");
		}
		
	}
	
}
