package me.bingbingpa.vol1.ch1.dao.step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDao extends UserDao {
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:13306/springbook?characterEncoding=UTF-8", "spring", "book");
        return c;
    }
}
