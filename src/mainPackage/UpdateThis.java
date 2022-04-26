package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class UpdateThis {

	Connection conn = null;
	
	public void updateAge() {
		String name = Login.name;
		int reddit_age = (RedditAge.months == 0) ? 1 : RedditAge.months;
		
        try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            /* update data */
            String updateAge = "UPDATE users SET reddit_age=? WHERE user_name=?;";
            PreparedStatement updateAgeST = conn.prepareStatement(updateAge);
            updateAgeST.setInt(1, reddit_age);
            updateAgeST.setString(2, name);
            // update 
            updateAgeST.executeUpdate();
            
            // close connection
            updateAgeST.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
    }
	
	public void updateVotes(String type) {
		
		List<Integer> votes_list = DB.votes.get(ViewPosts.post_id);
		int[] get_votes_arr = votes_list.stream().mapToInt(Integer::intValue).toArray();
		int upvotes = get_votes_arr[0];
		int downvotes = get_votes_arr[1];
        if(type == "up") {
        	upvotes += 1;
        } else if(type == "down") {
        	downvotes += 1;
        }
		
		try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            
            /* update data */
        	String updateVotes = "UPDATE posts SET upvotes=?, downvotes=? WHERE post_id=?;";
        	PreparedStatement updateVotesST = conn.prepareStatement(updateVotes);
        	updateVotesST.setInt(1, upvotes);
        	updateVotesST.setInt(2, downvotes);
        	updateVotesST.setInt(3, ViewPosts.post_id);
            // update 
            updateVotesST.executeUpdate();
            
            // close connection
            updateVotesST.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
		
		
	}
	
	public void updateKarma() {
		
		int karma_points = DB.karma.get(Login.name);
		karma_points++;
		
		try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            
            /* update data */
        	String updateKarma = "UPDATE users SET karma_points=? WHERE user_name=?;";
        	PreparedStatement updateKarmaST = conn.prepareStatement(updateKarma);
        	updateKarmaST.setInt(1, karma_points);
        	updateKarmaST.setString(2, Login.name);
            // update 
        	updateKarmaST.executeUpdate();
            
            // close connection
        	updateKarmaST.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
	}
    
    
    
}
