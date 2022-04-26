package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AddUser {

	Connection conn = null;
	static String name = Sign.name;
	static String email = Sign.email;
	static String password = Sign.pwd;
	static int reddit_age = 1;
	static int karma = 0;
	static String signed_in_date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	
	public void add() {
		
		
        try {
        	/* Set connection */
            String url = "jdbc:sqlite:C:/sqlite3/db/dbreddit.db";
            conn = DriverManager.getConnection(url);
            /* insert data */
            String addUser = "INSERT INTO users (user_name , reddit_age , email , password , karma_points, signed_in)"
            				 + " VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(addUser);
            pstmt.setString(1, name);
            pstmt.setInt(2, reddit_age);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.setInt(5, karma);
            pstmt.setString(6, signed_in_date);
            // update 
            pstmt.executeUpdate();
            // close connection
    		pstmt.close();
    		conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
    }
    
    
    
}
