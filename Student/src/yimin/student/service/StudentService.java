/**
 * 
 */
package yimin.student.service;

import yimin.student.pojo.PageInfo;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time��2019��11��15�� ����2:34:59
* Description:
*/
public interface StudentService {
	PageInfo showPage(String sname, String tname, String pageSize, String pageNumber);
}
