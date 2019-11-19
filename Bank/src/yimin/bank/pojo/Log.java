/**
 * 
 */
package yimin.bank.pojo;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月12日 下午9:51:01
* Description:
* 	That is the login information you need to login an bank account
*/

public class Log {
	private int id;
	private String accIn;
	private String accOut;
	private double money;
	/**
	 * @param id
	 * @param accIn
	 * @param accOut
	 * @param money
	 */
	public Log(int id, String accIn, String accOut, double money) {
		super();
		this.id = id;
		this.accIn = accIn;
		this.accOut = accOut;
		this.money = money;
	}
	/**
	 * 
	 */
	public Log() {
		super();
	}
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
	 * @return the accIn
	 */
	public String getAccIn() {
		return accIn;
	}
	/**
	 * @param accIn the accIn to set
	 */
	public void setAccIn(String accIn) {
		this.accIn = accIn;
	}
	/**
	 * @return the accOut
	 */
	public String getAccOut() {
		return accOut;
	}
	/**
	 * @param accOut the accOut to set
	 */
	public void setAccOut(String accOut) {
		this.accOut = accOut;
	}
	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accIn == null) ? 0 : accIn.hashCode());
		result = prime * result + ((accOut == null) ? 0 : accOut.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (accIn == null) {
			if (other.accIn != null)
				return false;
		} else if (!accIn.equals(other.accIn))
			return false;
		if (accOut == null) {
			if (other.accOut != null)
				return false;
		} else if (!accOut.equals(other.accOut))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", accIn=" + accIn + ", accOut=" + accOut + ", money=" + money + "]";
	}
	
}
