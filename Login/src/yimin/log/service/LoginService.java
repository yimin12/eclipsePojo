package yimin.log.service;

import yimin.log.pojo.User;


public interface LoginService {
	User checkLoginService(String uname, String pwd);
	User checkUidService(String uid);
}
