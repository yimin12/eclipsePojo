package yimin.log.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<h3>welcome "+req.getParameter("uname")+", this is ym show</h3>");
		resp.getWriter().write("<hr>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
	}
}
