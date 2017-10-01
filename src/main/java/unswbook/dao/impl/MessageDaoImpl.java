package unswbook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import unswbook.dao.MessageDao;
import unswbook.model.Message;

public class MessageDaoImpl implements MessageDao {

	@Autowired
	DataSource dataSource;
	
	private ArrayList<Message> RsToMessage(ResultSet rs) throws SQLException {
		ArrayList<Message> messages = new ArrayList<Message>();
		while(rs.next()) {
			Message message = new Message();
			message.setId(rs.getInt("ID"));
			message.setUserid(rs.getInt("UserID"));
			message.setText(rs.getString("Text"));
			message.setImage(rs.getString("Image"));
			message.setTime(rs.getString("Time"));
			messages.add(message);
		}
		return messages;
	}
	
	public ArrayList<Message> findMessagesByUserId(Integer id) {
		String sql = "SELECT * FROM Message Where UserID = ?";
		Connection connection = null;
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			messages = RsToMessage(rs);
			return messages;
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

	public ArrayList<Message> findMessageById(Integer id) {
		String sql = "SELECT * FROM Message WHERE ID = ?";
		Connection connection = null;
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			messages = RsToMessage(rs);
			return messages;
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

	public ArrayList<Message> findAllMessagesByUserID(String ids) {
		String sql = "SELECT Message.*,User.Username,User.Photo,count(`Like`.ID) AS Likes FROM Message INNER JOIN User ON Message.userID = User.ID AND User.ID IN (" + ids + ") LEFT JOIN `Like` ON `Like`.MessageID = Message.ID GROUP BY Message.ID ORDER BY Message.Time DESC";
		Connection connection = null;
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("ID"));
				message.setUserid(rs.getInt("UserID"));
				message.setText(rs.getString("Text"));
				message.setImage(rs.getString("Image"));
				message.setTime(rs.getString("Time"));
				message.setUsername(rs.getString("Username"));
				message.setPhoto(rs.getString("Photo"));
				message.setIsliked(rs.getInt("Likes"));
				messages.add(message);
			}
			return messages;
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

	public ArrayList<Message> findLikedMessages(Integer id) {
		String sql = "SELECT * FROM `Like` Where UserID = " + id;
		Connection connection = null;
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("MessageID"));
				messages.add(message);
			}
			return messages;
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
