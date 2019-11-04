package yimin.manager.service;

import java.util.List;

import yimin.manager.pojo.User;

public interface UserService {
	
	/**
	 * Check the login service of system
	 * @param uname UserName
	 * @param pwd	Passwork
	 * @return	return all user's information
	 */
	User CheckUserLoginService(String uname, String pwd);
	/**
	 * Change user's password
	 * @param newPwd newPassword
	 * @param uid	 User Id
	 * @return
	 */
	int userCHangePwdService(String newPwd, int uid);
	/**
	 * return all the information of user
	 * @return
	 */
	List<User> userShowService();
	/**
	 * User registry
	 * @param u
	 * @return
	 */
	int userRegService(User u);
}
