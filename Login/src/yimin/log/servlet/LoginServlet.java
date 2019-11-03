package yimin.log.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import yimin.log.pojo.User;
import yimin.log.service.LoginService;
import yimin.log.service.impl.LoginServiceImpl;
/**
 * 请求中文乱码解决:
 * 	1、使用String进行数据重新编码
 * 			uname=new String(uname.getBytes("iso8859-1"),"utf-8");
 *  2、使用公共配置
 * 		get方式：
 * 			步骤一：req.setCharacterEncoding("utf-8");
 * 			步骤二：
 * 				在tomcat的目录下的conf目录中修改server.xml文件：在Connector标签中增加属性 useBodyEncodingForURI="true"
 * 		post方式：
 * 			req.setCharacterEncoding("utf-8");
 * Servlet流程总结:
 * 		浏览器发起请求到服务器(请求)
 *      服务器接受浏览器的请求，进行解析，创建request对象存储请求数据
 *      服务器调用对应的servlet进行请求处理，并将request对象作为实参传递给servlet的方法
 *      servlet的方法执行进行请求处理
 *      		//设置请求编码格式
 *      		//设置响应编码格式
 *      		//获取请求信息
 *      		//处理请求信息
 *      			//创建业务层对象
 *      			//调用业务层对象的方法
 *      		//响应处理结果
 *请求转发学习：
 *		作用:实现多个servlet联动操作处理请求，这样避免代码冗余，让servlet的职责更加明确。
 *		使用：
 *				req.getRequestDispatcher("要转发的地址").forward(req, resp);
 *				地址：相对路径，直接书写servlet的别名即可。
 *		特点:
 *			一次请求，浏览器地址栏信息不改变。
 *		注意：
 *			请求转发后直接return结束即可。
 *reuqet作用域：
 *		解决了一次请求内的servlet的数据共享问题
 *重定向：
 *		解决了表单重复提交的问题，以及当前servlet无法处理的请求的问题。
 *		使用:
 *			resp.sendRedirect(String uri);
 *		示例:
 *			resp.sendRedirect("/login/main");
 *		特点：
 *			两次请求，两个request对象。
 *			浏览器地址栏信息改变
 *		时机：
 *			如果请求中有表单数据，而数据又比较重要，不能重复提交，建议使用重定向。
 *			如果请求被Servlet接收后，无法进行处理，建议使用重定向定位到可以处理的资源。	
 *
 * @author ymh
 */
public class LoginServlet extends HttpServlet {
	@SuppressWarnings("unused")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//			set the request format of the encoding
			req.setCharacterEncoding("utf-8");
//			set the encoding format
				resp.setContentType("text/html;charset=utf-8");
//			gain the information of request
//				The default char set is iso8859-1, if you need other information of different charset, 
//				you need to make a change
				String uname = req.getParameter("uname");
//				uname = new String(uname.getBytes("iso8859-1"),"utf-8");
				String pwd = req.getParameter("pwd");
				System.out.println(uname + ":" + pwd);
//			handle the request
				LoginService ls = new LoginServiceImpl();
				User u = ls.checkLoginService(uname, pwd);
				System.out.println(u);
//			handle the response's result
				if(u != null){
//					创建cookie信息，实现三天免登陆
					Cookie cookie = new Cookie("uid", u.getUid()+"");
					cookie.setMaxAge(3*24*60*60);
					cookie.setPath("/login/ck");
					resp.addCookie(cookie);
//					请求转发,带着数据req还有resp信息转回
//					req.getRequestDispatcher("main").forward(req, resp);
//					add the data to the session object
					HttpSession hs = req.getSession();
					hs.setAttribute("user", u);
//					Create an counter in the login servlet
					ServletContext sc = this.getServletContext();
					if (sc.getAttribute("nums") != null) {
						 int nums = Integer.parseInt((String) sc.getAttribute("nums"));
//						increase the counter and then put back to Servletcontext
						nums++;
						sc.setAttribute("nums", nums);
					} else {
//						if you first visit the servlet, the attribute "nums" should null
						sc.setAttribute("nums", 1);
					}
					
//					重定向
					resp.sendRedirect("/login/main");
					return;
				} else {
//					resp.getWriter().write("wrong userName or wrong password!");
//					使用request对象实现不同Servlet的数据流转
					req.setAttribute("str", "pwd or Usname is invalid");
//					使用请求转发,当登陆失败的时候重新回到页面
					req.getRequestDispatcher("page").forward(req, resp);
				}
				
	}
}
