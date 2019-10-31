package yimin.log.service.impl;

import yimin.log.dao.LoginDao;
import yimin.log.dao.impl.LoginDaoImpl;
import yimin.log.pojo.User;
import yimin.log.service.LoginService;

public class LoginServiceImpl implements LoginService{
//	create the dao object
	LoginDao ld = new LoginDaoImpl();
//	check the login information
	@Override
	public User checkLoginService(String uname, String pwd) {
		return ld.checkLoginDao(uname, pwd);
	}
	@Override
	public User checkUidService(String uid) {
		return ld.checkUidService(uid);
	}

}
