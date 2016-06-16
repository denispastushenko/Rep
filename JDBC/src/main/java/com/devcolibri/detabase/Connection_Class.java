package com.devcolibri.detabase;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.sql.Timestamp;

public class Connection_Class {
    private static final String URL = "jdbc:mysql://localhost:3306/instagramtestjdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String REQUEST = "insert into photos (Name,Date,Time,Photos)values(?,?,?,?)";

    public void connectMethod(String link) throws SQLException, ClassNotFoundException, IOException {
        Date today = new Date();
        Timestamp currentTime = new Timestamp(today.getTime());
        Class.forName("com.mysql.jdbc.Driver");
        URL url = new URL(link);
        String filename = FilenameUtils.getName(link);
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            InputStream input = url.openStream();
            PreparedStatement preparedStatement = connection.prepareStatement(REQUEST);
            preparedStatement.setString(1, filename);
            preparedStatement.setTimestamp(2, currentTime);
            preparedStatement.setTimestamp(3, currentTime);
            preparedStatement.setBlob(4, input);
            preparedStatement.executeUpdate();
        }
    }
}