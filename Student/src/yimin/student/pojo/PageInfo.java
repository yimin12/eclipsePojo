/**
 * 
 */
package yimin.student.pojo;

import java.util.List;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月15日 下午2:14:07
* Description:
*/

public class PageInfo {
	private int pageSize;
	private int pageNumber;
	private long total;
	private List<?> list;
	// student name
	private String sname;
	// teacher name
	private String tname;
	private int pageStart;
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}
	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}
	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
	/**
	 * @return the pageStart
	 */
	public int getPageStart() {
		return pageStart;
	}
	/**
	 * @param pageStart the pageStart to set
	 */
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", total=" + total + ", list=" + list
				+ ", sname=" + sname + ", tname=" + tname + ", pageStart=" + pageStart + "]";
	}
	
}
