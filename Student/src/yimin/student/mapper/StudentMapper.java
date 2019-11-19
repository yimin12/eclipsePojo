/**
 * 
 */
package yimin.student.mapper;

import java.util.List;

import yimin.student.pojo.PageInfo;
import yimin.student.pojo.Student;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月15日 下午4:38:59
* Description:
*/
public interface StudentMapper {
	List<Student> selByPage(PageInfo pi);
	long selCountByPageInfo(PageInfo pi);
}
