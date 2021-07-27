package com.beglyak_project.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnect() throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();

        try (InputStream in = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        String driver = properties.getProperty("db.driver");

        Class.forName(driver);
        return DriverManager.getConnection(url,username,password);
    }
}
