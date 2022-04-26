package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ViewPosts {
	
	static Connection conn;
	static Statement st;
	
	static int post_index = DB.posts_count;
	
	static String subreddit, post_title, post_content, tag, who_posted_this, posted_in;
	static int post_id;
	
	static HashMap<Integer, List<String>> allPosts = new HashMap<>(); // to put all posts from db in
	
	public void getPosts() {
		
		try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            st = conn.createStatement();
            /* Get data */
    		ResultSet postSet = st.executeQuery("SELECT * FROM posts;");
    		while(postSet.next()) {
	    		int post_id = postSet.getInt("post_id");
	    		ViewPosts.subreddit = postSet.getString("subreddit");
	    		ViewPosts.post_title = postSet.getString("title");
	    		ViewPosts.post_content = postSet.getString("post_content");
	    		ViewPosts.tag = postSet.getString("tags");
	    		ViewPosts.who_posted_this = postSet.getString("user_name");
	    		ViewPosts.posted_in = postSet.getString("posted_in");
	    		/* add to all posts list */
	    		String[] post_info = {subreddit, post_title, post_content, tag, who_posted_this, posted_in};
	    		allPosts.put(post_id, Arrays.asList(post_info));
    		}
    		    		
    		postSet.close();

    		st.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
		
	}
	
	public void viewPosts() {
		try {
		
			//get post info
			List<String> post_info = allPosts.get(post_index);
			ViewPosts.post_id = post_index;
			String[] get_post_info_arr = new String[post_info.size()];
			get_post_info_arr = post_info.toArray(get_post_info_arr);
			
			// get post score
			List<Integer> votes_list = DB.votes.get(ViewPosts.post_id);
			int[] get_votes_arr = votes_list.stream().mapToInt(Integer::intValue).toArray();
			int upvotes = get_votes_arr[0];
			int downvotes = get_votes_arr[1];
			int score = upvotes - downvotes;
			
			String color = null;
			if(score < 0) {
				color = Styling.RED_BOLD;
			} else if (score > 0) {
				color = Styling.CYAN_BOLD;
			} else if(score == 0) {
				color = Styling.WHITE_BOLD;
			}
			
			// display post data
			System.out.println("-------------------------------------------------------");
			System.out.println(Styling.YELLOW_BRIGHT + "r/" + Styling.TEXT_RESET + get_post_info_arr[0] + "\t" + Styling.YELLOW_BRIGHT + "u/" + Styling.TEXT_RESET + get_post_info_arr[4] + "\t" + Styling.YELLOW_BRIGHT + CalcTimeSincePost.calcAge() + Styling.TEXT_RESET);
			System.out.println("\n" + Styling.setBoldText + get_post_info_arr[1] + Styling.setPlainText);
			System.out.println(get_post_info_arr[2] + "\n");
			System.out.println(Styling.YELLOW_BRIGHT +"Post score : " +Styling.setPlainText+ color + score + Styling.TEXT_RESET);
			System.out.println(Styling.YELLOW_BRIGHT + "Tags: " + Styling.TEXT_RESET + get_post_info_arr[3]);
			System.out.println("----------------------"+ Styling.YELLOW_BRIGHT +"Comments"+ Styling.TEXT_RESET +"-------------------------");
			ViewComments vc = new ViewComments();
			vc.viewComments();
			System.out.println("-------------------------------------------------------");

			post_index--;

			if(post_index == 0) {
				System.out.println("-----" + Styling.RED_BRIGHT + "there's no more posts" + Styling.TEXT_RESET + "-----");
				System.out.println("-------------------------------------------------------");
				MainMenu.newsfeedMenu();
			}
			
		} catch(Exception e) {
				System.out.println("-----------------" + Styling.RED_BRIGHT + "there's no more posts" + Styling.TEXT_RESET + "-----------------");
				System.out.println("-------------------------------------------------------");
				MainMenu.newsfeedMenu();

			}
		}

	
	
}
