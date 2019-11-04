package yimin.manager.dao;

import java.util.List;

import yimin.manager.pojo.User;

public interface UserDao {
	/**
	 * check the login information in database
	 * @param uname Username
	 * @param pwd	password
	 * @return return the information of user
	 */
	User checkUserLoginDao(String uname, String pwd);
	/**
	 * change the password based on user ID
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	int userChangePwdDao(String newPwd, int uid);
	/**
	 * acuqire all user's information
	 * @return
	 */
	List<User> userShowDao();
	/**
	 * User registration
	 * @param u
	 * @return
	 */
	int userRegDao(User u);
}
