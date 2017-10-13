package database_access;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;

public class DatabaseAccessManager {
    private Connection connection;

    private DatabaseAccessManager databaseAccessManager;

    final String s = File.separator;
    final File path = new File("." + s + "src" + s + "main" + s + "java" + s + "database_access" + s);
    final File f = new File(path, "DB_INFO.json");

    final Gson gson = new Gson();
    BufferedReader db_param = new BufferedReader(new FileReader(f));
    JsonParser parser = new JsonParser();
    JsonArray db_values = parser.parse(db_param).getAsJsonArray();


    private final String DRIVER = db_values.get(0).toString();
    private final String HOSTNAME = db_values.get(1).toString();
    private final String DB_PORT = db_values.get(2).toString();
    private final String DATABASE = db_values.get(3).toString();
    private final String DB_USER = db_values.get(4).toString();
    private final String DB_PASSWORD = db_values.get(5).toString();


    private DatabaseAccessManager() throws FileNotFoundException {
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

    public synchronized DatabaseAccessManager getInstance() throws FileNotFoundException {
        return (databaseAccessManager == null) ? new DatabaseAccessManager() : databaseAccessManager;
    }

    public Connection getConnection() {
        return connection;
    }
}