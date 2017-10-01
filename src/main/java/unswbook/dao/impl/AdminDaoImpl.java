package unswbook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import unswbook.dao.AdminDao;
import unswbook.model.Admin;

public class AdminDaoImpl implements AdminDao {

	@Autowired
	DataSource dataSource;

	public boolean validAdmin(Admin admin) {

		String sql = "SELECT * FROM Admin WHERE Username = ? and Password = ?";
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
	}

	public Admin findAdminByUsername(String username) {
		String sql = "SELECT * FROM Admin WHERE Username = ?";
		Connection connection = null;
		Admin admin = new Admin();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				admin.setId(rs.getInt("ID"));
				admin.setUsername(rs.getString("Username"));
				admin.setPassword(rs.getString("Password"));
			}
			return admin;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
