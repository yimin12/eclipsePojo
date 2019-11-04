package yimin.manager.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.omg.CORBA.Request;

import yimin.manager.pojo.User;
import yimin.manager.service.UserService;
import yimin.manager.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

//	static declear the Logger function
	Logger logger = Logger.getLogger(UserServlet.class);
//	create the instance of user service
	UserService us = new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
//			get the required operation from request
		String oper = req.getParameter("oper");
		if("login".equals(oper)){
//			call funtion of checkUserlogin
			checkUserLogin(req,resp);
		} else if ("out".equals(oper)){
			userLogOut(req, resp);
		} else if ("show".equals(oper)){
			userShow(req, resp);
		} else if ("pwd".equals(oper)){
			userChangePwd(req, resp);
		} else if ("reg".equals(oper)){
			userReg(req, resp);
		} else {
			logger.debug("No corresponding operation: " + oper);
		}
	}
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		int age = req.getParameter("age") != "" ? Integer.parseInt(req.getParameter("age")):0;
		String birth = req.getParameter("birth");
		String[] bs = null;
		if(birth != ""){
			bs = birth.split("/");
			birth = bs[2] + "-" + bs[0] + "-" + bs[1];
		}
		System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
		User user = new User(0, uname, pwd, sex, age, birth);
//		call the function from service layer
		int index = us.userRegService(user);
		if(index > 0){
//			get the session object
			HttpSession hs = req.getSession();
			hs.setAttribute("reg", "true");
			resp.sendRedirect("/mg/Login.jsp");
		}
	}
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		use the service
		List<User> lu = us.userShowService();
		if(lu != null){
//			save the information to the request object
			req.setAttribute("lu", lu);
			req.getRequestDispatcher("user/showUser.jsp").forward(req, resp);
			return;
		}
	}
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String newPwd = req.getParameter("newPwd");
		User user = (User)req.getSession().getAttribute("user");
		int uid = user.getUid();
		int index = us.userCHangePwdService(newPwd, uid);
		if(index > 0){
			HttpSession hs = req.getSession();
			hs.setAttribute("pwd", "true");
			resp.sendRedirect("/mg/Login.jsp");
		}
	}
	private void userLogOut(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		HttpSession hs = req.getSession();
//		when you try to logout, you should terminate the session 
		hs.invalidate();
		resp.sendRedirect("/mg/Login.jsp");
	}
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User user = us.CheckUserLoginService(uname, pwd);
		if(user!=null){
			HttpSession hs = req.getSession();
			hs.setAttribute("user", user);
			resp.sendRedirect("/mg/main/main.jsp");
			return;
		} else {
//			you need to send the request to login page, check whether the password is correct, so set a flag
			req.setAttribute("flag", 0);
			req.getRequestDispatcher("/Login.jsp").forward(req, resp);
			return;
		}
	}
}
