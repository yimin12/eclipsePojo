package yimin.bank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yimin.bank.pojo.Account;
import yimin.bank.service.AccountService;
import yimin.bank.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	private AccountService accountService = new AccountServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Account accOut = new Account();
		accOut.setAccNo(req.getParameter("accOutAccNo"));
		accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		Account accIn = new Account();
		accIn.setAccNo(req.getParameter("accInAccNo"));
		accIn.setName(req.getParameter("accInName"));
		int index = accountService.transfer(accIn, accOut);
		if(index == AccountService.SUCCESS) {
			resp.sendRedirect("/Bank/show");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("code", index);
			resp.sendRedirect("/Bank/error/error.jsp");
		}
	}
}
