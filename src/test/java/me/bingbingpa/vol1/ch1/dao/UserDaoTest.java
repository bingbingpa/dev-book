package me.bingbingpa.vol1.ch1.dao;

import me.bingbingpa.vol1.ch1.dao.step1.UserDao;
import me.bingbingpa.vol1.ch1.domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void databaseTest() throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("bingbingpa");
        user.setName("박승현");
        user.setPassword("11111");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println("userName =========== " + user2.getName());
        System.out.println("userPassword ============ " + user.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}