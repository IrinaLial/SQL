package config;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/miracle";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "a3a85e498a7a";

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
