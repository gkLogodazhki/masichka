package users;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
		PreparedStatement st = conn.prepareStatement(INSERT_INTO_USERS,Statement.RETURN_GENERATED_KEYS);
		
		return 0;
		
	}
}
