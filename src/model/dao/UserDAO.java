package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.DBConnect;
import model.bean.User;

public class UserDAO {
	public User getItem(String userName, String password) {
		Connection connection = DBConnect.getConnection();
		String sql = "SELECT * FROM user WHERE user_email=? AND user_pass=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User item = new User();
				item.setId(rs.getLong("user_id"));
				item.setEmail(rs.getString("user_email"));
				item.setPass(rs.getString("user_pass"));
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return item;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public User getItem(long id) {
		Connection connection = DBConnect.getConnection();
		String sql = "SELECT * FROM user WHERE user_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User item = new User();
				item.setId(rs.getLong("user_id"));
				item.setEmail(rs.getString("user_email"));
				item.setPass(rs.getString("user_pass"));
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return item;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		User u = dao.getItem("admin@gmail.com", "123456");
		System.out.println(u.getEmail());
	}
}
