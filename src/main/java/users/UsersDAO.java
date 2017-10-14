package users;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database_access.DatabaseAccessManager;

public class UsersDAO {
	/*
	table users:
		id  INT AL PK
		mail VARCHAR(45)
		pass VARCHAR(45)
		first_name VARCHAR(45)
		last_name VARCHAR(45)
		phone_number VARCHAR(45)
		birthday DATE
		agree_with_general_terms TINYINT(3)
		want_notifications TINYINT(3)
		user_type_id INT FK
		city_id INT FK
	 */
	private static final String INSERT_INTO_USERS = "INSERT INTO users VALUES(null,?,?,?,?,?,?,?,?,?,?)";
	
	public static synchronized int insertIntoUsers(UsersPOJO user) throws FileNotFoundException, SQLException {
		Connection conn = DatabaseAccessManager.getInstance().getConnection();
		
		// convert from LocalDate to Date to be compatible with database type
		PreparedStatement st = conn.prepareStatement(INSERT_INTO_USERS,Statement.RETURN_GENERATED_KEYS);
		
		
		st.setString(1, user.getMail());
		st.setString(2, user.getPass());
		st.setString(3, user.getFirstName());
		st.setString(4, user.getLastName());
		st.setString(5, user.getPhoneNumber());
		st.setDate(6, Date.valueOf(user.getDate()));
		st.setBoolean(7, user.isAgree());
		st.setBoolean(8, user.isWantNotification());
		st.setInt(9, user.getUserTypeId());
		st.setInt(10, user.getCityId());
		
		st.executeQuery();
		
		ResultSet rs = st.getGeneratedKeys();
		rs.next();
		
		return rs.getInt(1);
	}

}
