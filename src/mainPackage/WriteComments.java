package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class WriteComments {
	Scanner sc = new Scanner(System.in);
	static String comment_content;
	Connection conn;
	
	WriteComments() {
		System.out.print(Styling.GREEN_BOLD_BRIGHT + "write your comment: " + Styling.TEXT_RESET);
		WriteComments.comment_content = sc.nextLine();
	}

	public void writeComment() {
		
		try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            /* insert data */
            String addUser = "INSERT INTO comments (comment_id , post_id , username , comment_content)"
            				 + " VALUES (null, ?, ?, ?);";
            PreparedStatement commentST = conn.prepareStatement(addUser);
            commentST.setInt(1, ViewPosts.post_id);
            commentST.setString(2, Login.name);
            commentST.setString(3, WriteComments.comment_content);
            UpdateThis ut = new UpdateThis();
	        ut.updateKarma();
	        
            // update 
            commentST.executeUpdate();
            // close connection
            commentST.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
		
	}
	
	
}
