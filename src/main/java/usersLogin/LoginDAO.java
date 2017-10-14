package usersLogin;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database_access.DatabaseAccessManager;

public class LoginDAO {
	
	private static final String SELECT_SPECIFIC_MAIL_AND_PASS = "SELECT mail,pass FROM users "
			+ "WHERE mail = ? AND pass = ?";


	public static synchronized boolean isCorrect(LoginPOJO login) throws FileNotFoundException, SQLException {

		Connection conn = DatabaseAccessManager.getInstance().getConnection();

		PreparedStatement st = conn.prepareStatement(SELECT_SPECIFIC_MAIL_AND_PASS);
		
		st.setString(1, login.getMail());
		st.setString(2, login.getPass());
		
		ResultSet rs = st.executeQuery();
		
		return rs.first();
		
	}
	
	
}	
