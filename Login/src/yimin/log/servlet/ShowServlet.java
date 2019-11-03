package yimin.log.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yimin.log.pojo.User;

public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession hs = req.getSession();
		if(hs.getAttribute("user") == null){
			resp.sendRedirect("/login/ck");
			return;
		}
		User u = (User) hs.getAttribute("user");
//		handle the result
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<table border='1px'>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<td>用户名</td>");
		resp.getWriter().write("<td>"+u.getUnameString()+"</td>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<td>密码</td>");
		resp.getWriter().write("<td>"+u.getPwd()+"</td>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("</table>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");	
	}
}
