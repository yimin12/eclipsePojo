package yimin.log.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import yimin.log.pojo.User;
import yimin.log.service.LoginService;
import yimin.log.service.impl.LoginServiceImpl;
/**
 * Cookie信息校验
 * 		判断请求中是否携带正确的Cookie信息
 * 		如果有则校验Cookie信息是否正确
 * 			如果校验正确则直接响应主页面给用户
 * 			如果校验不正确则响应登录页面给用户
 * 		没有则请求转发给登录页面
 * @author ymh
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		set the charset for response and request
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Cookie[] cks = req.getCookies();
		if(cks != null){
			String uid = "";
			for(Cookie c:cks){
				if("uid".equals(c.getName())){
					uid = c.getValue();
				}
			}
//			Test whether the uid exist
			if("".equals(uid)){
				req.getRequestDispatcher("page").forward(req, resp);
				return;
			} else {
				LoginService ls = new LoginServiceImpl();
				User user = ls.checkUidService(uid);
				if(user!=null){
//					need to add the information to session object as well
					req.getSession().setAttribute("user", user);
					int nums = (int) this.getServletContext().getAttribute("nums");
					nums++;
					this.getServletContext().setAttribute("nums", nums);
//					redirect
					resp.sendRedirect("/login/main");
					return;
				} else {
					req.getRequestDispatcher("page").forward(req, resp);
					return;
				}
				
			}
		} else {
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}
	}
}
