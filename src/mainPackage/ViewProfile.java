package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ViewProfile {

	Connection conn = null;
	Statement st;
	
	public void viewProfile() {
	
		
		try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            st = conn.createStatement();
            /* Get data */
            String query = "SELECT * FROM users WHERE user_name = '" + Login.name + "';";
    		ResultSet rs = st.executeQuery(query);
			/* User data */
			String user_name = rs.getString("user_name");
			int reddit_age = rs.getInt("reddit_age");
			String email = rs.getString("email");
			int karma_points = rs.getInt("karma_points");
		
    		/* View Profile */
    		System.out.println(Styling.GREEN_BRIGHT + "Username: " + Styling.TEXT_RESET + user_name);
    		System.out.println(Styling.GREEN_BRIGHT+ "Karma points: " + Styling.TEXT_RESET + karma_points + "\t\t" + Styling.GREEN_BRIGHT + "Reddit age: " + Styling.TEXT_RESET + reddit_age + " months");
    		System.out.println(Styling.GREEN_BRIGHT + "Email: " + Styling.TEXT_RESET + email);
    		
    		rs.close();
    		st.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
    }
    
    
    
}
