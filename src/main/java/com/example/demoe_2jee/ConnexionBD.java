package com.example.demoe_2jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {

    private static final String HOST = "mysql-12b32e23-abd-7ca3.a.aivencloud.com";
    private static final String PORT = "22033";
    private static final String DATABASE = "defaultdb";

    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_-YGAD-AMoSZn8ut_D2V";

    private static Connection connection;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE,USER, PASSWORD);

        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
