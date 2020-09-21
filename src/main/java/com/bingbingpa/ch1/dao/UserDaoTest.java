package com.bingbingpa.ch1.dao;

import com.bingbingpa.ch1.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

//        User user = new User();
//        user.setId("bingbingpa");
//        user.setName("shpark");
//        user.setPassword("shpark");
//
//        dao.add(user);
//
//        System.out.println(user.getId() + "user1 id");
//
//        User user2 = dao.get(user.getId());
//        System.out.println(user2.getName());
//        System.out.println(user2.getPassword());
//
//        System.out.println(user2.getId() + "user2 id");
    }
}
