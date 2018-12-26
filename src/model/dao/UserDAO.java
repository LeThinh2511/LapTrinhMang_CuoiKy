package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.DatabaseManager;
import model.bean.User;

public class UserDAO {
	public User getItem(String userName, String password) {
		Connection connection = DatabaseManager.getConnection();
		String sql = "SELECT * FROM user WHERE email=? AND password=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User item = new User();
				item.setId(rs.getLong("idUser"));
				item.setEmail(rs.getString("email"));
				item.setPass(rs.getString("password"));
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
		Connection connection = DatabaseManager.getConnection();
		String sql = "SELECT * FROM user WHERE idUser=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User item = new User();
				item.setId(rs.getLong("idUser"));
				item.setEmail(rs.getString("email"));
				item.setPass(rs.getString("password"));
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
		User u = dao.getItem("lethinh@gmail.com", "lethinh");
		System.out.println(u.getEmail());
	}
}
