/**
 * 
 */
package yimin.student.pojo;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月15日 下午1:46:07
* Description:
* 	basic information of Student
*/

public class Student {
	// Student id 
	private int id;
	// Studnet name
	private String name;
	// Student age
	private int age;
	// Foreign key's id
	private int tid;
	// Corresponding Teacher for student
	private Teacher teacher;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
