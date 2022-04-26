package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DB {

	Connection conn = null;
	static Statement st;
	static HashMap<String, String> user = new HashMap<>();
	static HashMap<String, String> emails = new HashMap<>();
	static HashMap<String, String> age = new HashMap<>();
	static HashMap<String, Integer> user_id = new HashMap<>();
	static HashMap<Integer, List<Integer>> votes = new HashMap<>();
	static HashMap<String, Integer> karma = new HashMap<>();
	
	static int posts_count = 0;
		
	public void connect() {

        try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            st = conn.createStatement();
            /* Get data */
    		ResultSet getAllUsersSet = st.executeQuery("SELECT * FROM users;");
    		while(getAllUsersSet.next()) {
    			/* User data */
    			String user_name = getAllUsersSet.getString("user_name");

    			String email = getAllUsersSet.getString("email");
    			String user_pwd = getAllUsersSet.getString("password");
    			int karma_points = getAllUsersSet.getInt("karma_points");
    			int id = getAllUsersSet.getInt("user_id");

    			user_id.put(user_name, id);
    			String signed_in_date = getAllUsersSet.getString("signed_in");
    			user.put(user_name, user_pwd); // to check user info when he logs in
    			emails.put(email, user_name);
    			age.put(user_name, signed_in_date);
    			karma.put(user_name, karma_points);
    		}
    		
    		/* a result set to get number of posts */
    		ResultSet numOfPostsSet = st.executeQuery("SELECT count(*) FROM posts;");
    		DB.posts_count = Integer.parseInt(numOfPostsSet.getString(1));
    	
    		// a result set to get number of upvotes, downvotes
    		ResultSet getVotesSet = st.executeQuery("SELECT upvotes, downvotes, post_id FROM posts;");
    		while(getVotesSet.next()) {
    			int post_id = getVotesSet.getInt("post_id");
    			int upvotes = getVotesSet.getInt("upvotes");
    			int downvotes = getVotesSet.getInt("downvotes");
    			int[] votesScore = {upvotes, downvotes};
    			List<Integer> votes_list = Arrays.stream(votesScore).boxed().collect(Collectors.toList());
    			votes.put(post_id, votes_list);
    		}
    		

        		
    		/* close result set */
    		getAllUsersSet.close();
    		numOfPostsSet.close();
    		getVotesSet.close();
    		
    		st.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
    }
    
    
    
}
