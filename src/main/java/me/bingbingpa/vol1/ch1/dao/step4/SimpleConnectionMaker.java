package me.bingbingpa.vol1.ch1.dao.step4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:13306/springbook?characterEncoding=UTF-8", "spring", "book");
        return c;
    }
}
