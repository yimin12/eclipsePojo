/**
 * 
 */
package yimin.student.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import yimin.student.mapper.StudentMapper;
import yimin.student.mapper.TeacherMapper;
import yimin.student.pojo.PageInfo;
import yimin.student.pojo.Student;
import yimin.student.service.StudentService;
import yimin.student.util.MyBatisUtil;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月15日 下午2:36:00
* Description:
*/
public class StudentServiceImpl implements StudentService{

	@Override
	public PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) {
		int pageSize=2;
		if(pageSizeStr!=null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber=1;
		if(pageNumberStr!=null && !pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNumber-1)*pageSize);
		pi.setSname(sname);
		pi.setTname(tname);
		
		List<Student> list = studentMapper.selByPage(pi);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		for(Student student:list) {
			student.setTeacher(teacherMapper.selById(student.getTid()));
		}
		pi.setList(list);
		long count = studentMapper.selCountByPageInfo(pi);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}
	
}
