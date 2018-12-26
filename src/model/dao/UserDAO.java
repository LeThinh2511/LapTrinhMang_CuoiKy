package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.DatabaseManager;
import model.bean.User;

public class UserDAO {
	public User getUser(String userName, String password) {
		Connection connection = DatabaseManager.getConnection();
		String sql = "SELECT * FROM user WHERE email=? AND password=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("idUser"));
				user.setEmail(rs.getString("email"));
				user.setPass(rs.getString("password"));
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public User getUser(long idUser) {
		Connection connection = DatabaseManager.getConnection();
		String sql = "SELECT * FROM user WHERE idUser=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setLong(1, idUser);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("idUser"));
				user.setEmail(rs.getString("email"));
				user.setPass(rs.getString("password"));
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
