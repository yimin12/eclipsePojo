package yimin.log.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yimin.log.pojo.User;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
//		get the information from session		
		User user= (User) req.getSession().getAttribute("user");
		System.out.println(user);
//		count the number that it was searched
		int nums=(int) this.getServletContext().getAttribute("nums");
		
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<h3>welcome "+user.getUnameString()+", this is ym show</h3>");
		resp.getWriter().write("当前网页浏览次数为:"+nums);
		resp.getWriter().write("<hr>");
//		The personal information should be stored in session Object
		resp.getWriter().write("<form action='show' method='get'>");
		resp.getWriter().write("<input type='submit' value='Personal Information'>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
	}
}
