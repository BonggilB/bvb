package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
  private Connection conn;  
  private PreparedStatement pstmt;
  private ResultSet rs;

  
  
  // �����ͺ��̽� ���ٰ�ü
  public UserDAO() {
	  try {
		  String dbURL = "jdbc:mysql://localhost:3306/bbs";
		  String dbID="root";
		  String dbPassword = "root";
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
	  }catch (Exception e){
		  e.printStackTrace();
	  }
  }
  
  public int login(String userID, String userPassword) {
	  String SQL="SELECT userPassword FROM user WHERE userID=?";
	  try {
		  pstmt=conn.prepareStatement(SQL);
		  pstmt.setString(1, userID);
		  rs=pstmt.executeQuery();
		  if(rs.next()) {
			  //�ش� ���̵� ���翵��
			  if(rs.getString(1).equals(userPassword)) {
				  //�α��� ����
				  return 1;
			  }else {
				  //�н����� ����ġ
				  return -2;
			  }
		  }else {
			  //���̵� �������� �ʴ� ����
			  return -1;
		  }
		  
	  }catch (Exception e){
		  e.printStackTrace();
	  }
	  return -3;	  
  }
  
  
}






