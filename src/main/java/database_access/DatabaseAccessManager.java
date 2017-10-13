package database_access;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccessManager {
    private Connection connection;
    private static DatabaseAccessManager databaseAccessManager;

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOSTNAME = "http://localhost";
    private static final String DB_PORT = ":3306";
    private static final String DATABASE = "/masichka";
    private static final String DB_USER = "root";
    //TEST
    private static final String DB_PASSWORD = "root";

    private DatabaseAccessManager() {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://" + HOSTNAME + DB_PORT;
        try {
            this.connection = DriverManager.getConnection(url + DATABASE, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.printf("Connection to %s%s fail!\n", url, DATABASE);
        }

    }

    public synchronized static DatabaseAccessManager getInstance() {
        return (databaseAccessManager == null) ? new DatabaseAccessManager() : databaseAccessManager;
    }

    public Connection getConnection() {
        return connection;
    }
}