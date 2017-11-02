package com.websystique.springmvc.usersReg;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Scope("singleton")
public class DBManager {
    private static final String LOCALHOST = "jdbc:mysql://localhost:3306/spring";
    private static final String NAME = "root";
    private static final String PASS = "4561234m";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(LOCALHOST, NAME, PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
