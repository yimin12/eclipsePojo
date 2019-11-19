/**
 * 
 */
package yimin.student.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月15日 下午3:01:36
* Description:
*/

/**
 * @author 61771
 *
 */
public class MyBatisUtil {
	// lazy instantiation
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSession() {
		SqlSession session = tl.get();
		if(session == null) {
			tl.set(factory.openSession());
		}
		return tl.get();
	}
	public static void closeSession() {
		SqlSession session = tl.get();
		if(session!=null) {
			session.close();
		}
		tl.set(null);
	}
}
