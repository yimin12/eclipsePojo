package yimin.log.dao;

import yimin.log.pojo.User;

public interface LoginDao {
	User checkLoginDao(String uname, String pwd);
//	check the information of cookie
	User checkUidService(String uid);
}
