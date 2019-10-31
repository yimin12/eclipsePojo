package yimin.log.pojo;

// In order to store the information 
public class User {
	private int uid;
	private String unameString;
	private String pwd;
	public User(int uid, String unameString, String pwd) {
		super();
		this.uid = uid;
		this.unameString = unameString;
		this.pwd = pwd;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUnameString() {
		return unameString;
	}
	public void setUnameString(String unameString) {
		this.unameString = unameString;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", unameString=" + unameString + ", pwd="
				+ pwd + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + uid;
		result = prime * result
				+ ((unameString == null) ? 0 : unameString.hashCode());
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
		User other = (User) obj;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (uid != other.uid)
			return false;
		if (unameString == null) {
			if (other.unameString != null)
				return false;
		} else if (!unameString.equals(other.unameString))
			return false;
		return true;
	}
	
}
