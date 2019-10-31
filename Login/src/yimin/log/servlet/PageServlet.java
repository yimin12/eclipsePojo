package yimin.log.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		set the format of encoding
			resp.setContentType("text/html; charset=utf-8");
//		get the request informtion
//		handle the request
//		use the response to handle the result
//			In order to handle the error page, you should know the request region
				String string = (String) req.getAttribute("str") == null ? "":(String) req.getAttribute("str");
				resp.getWriter().write("<html>");
				resp.getWriter().write("<head>");
				resp.getWriter().write("</head>");
				resp.getWriter().write("<body>");
				resp.getWriter().write("<font color='red' size='20px'>"+string+"</font>");
				resp.getWriter().write("<form action='login' method='post'>");
				resp.getWriter().write("用户名:<input type='text' name='uname' value=''/><br/>");
				resp.getWriter().write("密码:<input type='password' name='pwd' value=''/><br/>");
				resp.getWriter().write("<input type='submit'  value='登录'/><br/>");
				resp.getWriter().write("</form>");
				resp.getWriter().write("</body>");
				resp.getWriter().write("</html>");

	}
}
