package yimin.log.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import yimin.log.dao.LoginDao;
import yimin.log.pojo.User;

public class LoginDaoImpl implements LoginDao{

	@Override
	public User checkLoginDao(String uname, String pwd) {
		User u = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql = "select * from t_user where uname = ? and pwd = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUnameString(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
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
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return u;
	}

	@Override
	public User checkUidService(String uid) {
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		User u = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql = "select * from t_user where uid = ?";
			pStatement = (PreparedStatement) conn.prepareStatement(sql);
			pStatement.setString(1, uid);
			rs = pStatement.executeQuery();
			while(rs.next()){
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUnameString(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pStatement.close();
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
		return u;
	}
	
}
