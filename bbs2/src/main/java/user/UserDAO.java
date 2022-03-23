package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";			
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String uID, String uPass) {
		String SQL = "SELECT uPass FROM USER WHERE uID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  uID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(uPass)) {
					return 100;
				} else {
					return -100;
				}
			}
			return -200;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -300; 
	}
	
	
	public int join(User user) {
		String SQL = "insert into user values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			Connection.prepareStatement(SQL).setString(1,user.getUserID());
			pstmt.setString(2,user.getUserPassword());
			pstmt.setString(3,user.getUserName());
			pstmt.setString(4,user.getUserEmail());
			pstmt.setString(5,user.getUserPhone());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -300;
	}
	
	
	
}









