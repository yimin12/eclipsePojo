/**
 * 
 */
package yimin.student.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.session.SqlSession;

import yimin.student.util.MyBatisUtil;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月15日 下午2:36:45
* Description: 
* 	use opensessioninview to optimize
*/
@WebServlet("/*")
public class OpenSessionInView implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		SqlSession session = MyBatisUtil.getSession();
		try {
			chain.doFilter(request, response);	
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		
	}

}
