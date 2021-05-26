package me.bingbingpa.vol1.ch1.dao.step6;

import me.bingbingpa.vol1.ch1.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new UserDaoFactory().userDao();

        User user = new User();
        user.setId("bingbingpa");
        user.setName("박승현");
        user.setPassword("test");

        dao.delete();
        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
