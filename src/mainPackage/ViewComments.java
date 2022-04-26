package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewComments {
	
	Connection conn;
	Statement st;

	
	public void viewComments() {
		try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            st = conn.createStatement();
            /* Get data */
    		ResultSet commentSet = st.executeQuery("SELECT * FROM comments WHERE post_id=" + ViewPosts.post_id +";");
    		int numComments = 0;
    		while(commentSet.next()) {
    			numComments += 1;
	    		String comment_content = commentSet.getString("comment_content");
	    		String username = commentSet.getString("username");
	    		// display comments
	    		System.out.println(Styling.CYAN_BOLD + username + Styling.TEXT_RESET + ": " + comment_content);
    		}
    		if(numComments == 0) {
    			System.out.println("-----------------" + Styling.RED_BRIGHT +"there's no comments" + Styling.TEXT_RESET +"-------------------");
    		}
    		    		
    		
    		commentSet.close();
    		st.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
		
	}
}
