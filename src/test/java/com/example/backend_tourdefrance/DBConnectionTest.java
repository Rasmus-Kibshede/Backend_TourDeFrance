package com.example.backend_tourdefrance;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DBConnectionTest {

    @Test
    public void dbConnectionTest() throws SQLException {
       /* String user = System.getenv("db_username");
        String password = System.getenv("db_password");
        String url = System.getenv("db_url");

        Connection connection = DriverManager.getConnection(url, user, password);

        assertNotNull(connection);*/
    }
}
