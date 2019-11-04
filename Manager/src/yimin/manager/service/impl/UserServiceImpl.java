package yimin.manager.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import yimin.manager.dao.UserDao;
import yimin.manager.dao.impl.UserDaoImpl;
import yimin.manager.pojo.User;
import yimin.manager.service.UserService;

public class UserServiceImpl implements UserService{

//	You need to use the logger to log the information
	Logger logger = Logger.getLogger(UserService.class);
	UserDao ud = new UserDaoImpl();
	
	@Override
	public User CheckUserLoginService(String uname, String pwd) {
		logger.debug(uname + " request to login!");
		User u = ud.checkUserLoginDao(uname, pwd);
		if(u != null){
			logger.debug(uname + " login successfully");
		} else {
			logger.debug(uname + " login failed");
		}
		return u;
	}

	@Override
	public int userCHangePwdService(String newPwd, int uid) {
		logger.debug(uid + " request to change the password");
		int index = ud.userChangePwdDao(newPwd, uid);
		if(index > 0){
			logger.debug(uid + " change the password successfully");
		} else {
			logger.debug(uid + " change the password failed");
		}
		return index;
	}

	@Override
	public List<User> userShowService() {
		List<User> users = ud.userShowDao();
		logger.debug("All Personal Information: " + users);
		return users;
	}

	@Override
	public int userRegService(User u) {
		return ud.userRegDao(u);
	}

}
