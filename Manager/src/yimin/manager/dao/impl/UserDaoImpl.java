package yimin.manager.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import yimin.manager.dao.UserDao;
import yimin.manager.pojo.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql = "select * from t_user where uname = ? and pwd = ?";
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return u;
	}

	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		Connection conn = null;
		PreparedStatement ps = null;
		int index = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql = "update t_user set pwd=? where uid=?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
			index = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}

	@Override
	public List<User> userShowDao() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> users = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql = "select * from t_user";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			users = new ArrayList<>();
			while(rs.next()){
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setBirth(rs.getString("birth"));
				users.add(user);
			}
 		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public int userRegDao(User u) {
		Connection conn = null;
		PreparedStatement ps = null;
		int index = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql = "insert into t_user values(default,?,?,?,?,?)";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirth());
			index = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}

}
