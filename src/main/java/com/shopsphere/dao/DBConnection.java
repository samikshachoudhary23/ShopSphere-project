package com.shopsphere.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
        System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/shopsphere");

    private static final String USER =
        System.getenv().getOrDefault("DB_USER", "root");

    private static final String PASSWORD =
        System.getenv("DB_PASSWORD");
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(
                    "MySQL JDBC driver was not found by the application.", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
