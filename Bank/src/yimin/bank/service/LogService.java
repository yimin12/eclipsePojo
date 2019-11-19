/**
 * 
 */
package yimin.bank.service;

import java.io.IOException;

import yimin.bank.pojo.PageInfo;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月12日 下午10:02:42
* Description: 
	Pagination (show the information accordingly)
*/

public interface LogService {
	
	PageInfo showPage(int pageSize, int pageNumber) throws IOException;
}
