/**
 * 
 */
package yimin.bank.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import yimin.bank.pojo.Log;
import yimin.bank.pojo.PageInfo;
import yimin.bank.service.LogService;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月12日 下午10:06:23
* Description:
* 	implementation of LogService
*/


public class LogServiceImpl implements LogService{

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("pageStart", pageSize*(pageNumber-1));
		param.put("pageSize", pageSize);
		List<Log> list = session.selectList("yimin.bank.mapper.LogMapper.selByPage",param);
		long count = session.selectOne("yimin.bank.mapper.LogMapper.selCount");
		PageInfo pi = new PageInfo();
		pi.setList(list);
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

}
