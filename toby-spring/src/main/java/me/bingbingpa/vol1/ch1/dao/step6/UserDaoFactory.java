package me.bingbingpa.vol1.ch1.dao.step6;

public class UserDaoFactory {
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}

	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
