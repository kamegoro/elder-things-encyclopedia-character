package com.example.elder_things_encyclopedia_character.rest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ElderThingsEncyclopediaDataSourceConfig {
    String url = "jdbc:postgresql://localhost:10090/elder_things_encyclopedia";
    String user = "developer";
    String password = "developer";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
