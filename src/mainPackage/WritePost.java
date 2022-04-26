package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;


public class WritePost {
	static Scanner sc = new Scanner(System.in);
	static String subreddit, post_title, post_content, tag;
	static String tags[];
	Connection conn;
	
	public void writePost() {
		System.out.println("---------------------------------------------------");
		System.out.print(Styling.GREEN_BOLD_BRIGHT+"Subreddit: "+Styling.TEXT_RESET);
		WritePost.subreddit = sc.nextLine();
		System.out.print(Styling.GREEN_BOLD_BRIGHT+"Title: "+Styling.TEXT_RESET);
		WritePost.post_title = sc.nextLine();
		System.out.print(Styling.GREEN_BOLD_BRIGHT+"Content: "+Styling.TEXT_RESET);
		WritePost.post_content = sc.nextLine();
		System.out.print(Styling.GREEN_BOLD_BRIGHT+"Tags (Seprate them with ','): "+Styling.TEXT_RESET);
		tag = sc.nextLine();
		WritePost.tags = tag.split(",");
	}
	
	public void addPostToDB() {
		 try {
			String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
	        conn = DriverManager.getConnection(url);
	        /* insert data */
	        String addPost = "INSERT INTO posts (post_id , user_id , post_content , upvotes , downvotes, subreddit, tags, title, user_name, posted_in)"
	        				 + " VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	        PreparedStatement addPostSt = conn.prepareStatement(addPost);
	        int user_id = DB.user_id.get(Login.name);
	        addPostSt.setInt(1, user_id);
	        addPostSt.setString(2, WritePost.post_content);
	        addPostSt.setInt(3, 0);
	        addPostSt.setInt(4, 0);
	        addPostSt.setString(5, camelCaseThis.camelCase( WritePost.subreddit));
	        addPostSt.setString(6, WritePost.tag.toLowerCase());
	        addPostSt.setString(7, WritePost.post_title);
	        addPostSt.setString(8, Login.name);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			String posted_in = formatter.format(LocalDateTime.now());
			addPostSt.setString(9, posted_in);
	        UpdateThis ut = new UpdateThis();
	        ut.updateKarma();
			System.out.println("---------------------------------------------------");
	        System.out.println("-------"+Styling.CYAN_BRIGHT+"your post has been added successfully"+Styling.TEXT_RESET+"-------");
			System.out.println("---------------------------------------------------\n");
			
			String[] new_post_info = {subreddit, post_title, post_content, tag, Login.name, posted_in};
    		int newPostIndex = (DB.posts_count++);
    		ViewPosts.allPosts.put(newPostIndex, Arrays.asList(new_post_info));
	        
    		addPostSt.executeUpdate(); // add post

    		ViewPosts.post_index = newPostIndex;
	        	        
	        MainMenu.newsfeedMenu();
	        
	        // close connection
	        addPostSt.close();
			conn.close();
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	}
	
}
