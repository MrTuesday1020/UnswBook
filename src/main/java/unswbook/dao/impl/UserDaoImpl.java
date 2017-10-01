package unswbook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import unswbook.dao.UserDao;
import unswbook.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

	private ArrayList<User> RsToUser(ResultSet rs) throws SQLException {
		ArrayList<User> users = new ArrayList<User>();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("ID"));
			user.setUsername(rs.getString("Username"));
			user.setPassword(null);
			user.setEmail(rs.getString("Email"));
			user.setName(rs.getString("Name"));
			user.setGender(rs.getString("Gender"));
			user.setDob(rs.getString("DoB"));
			user.setPhoto(rs.getString("Photo"));
			user.setActive(rs.getInt("Active"));
			user.setStatus(rs.getInt("Status"));
			user.setTime(rs.getString("Time"));
			users.add(user);
		}
		return users;
	}
	
	public ArrayList<User> findUserById(Integer ID) {
		String sql = "SELECT * FROM User WHERE ID = ?";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			users = RsToUser(rs);
			return users;
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

	public ArrayList<User> findUserByUsernameStrict(String Username) {
		String sql = "SELECT * FROM User WHERE Username = ?";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, Username);
			ResultSet rs = ps.executeQuery();
			users = RsToUser(rs);
			return users;
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
	
	public ArrayList<User> findUserByUsername(String Username) {
		String sql = "SELECT * FROM User WHERE Username LIKE '%" + Username + "%'";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			users = RsToUser(rs);
			return users;
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

	public ArrayList<User> findUserByEmail(String Email) {
		String sql = "SELECT * FROM User WHERE Email LIKE '%" + Email + "%'";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			users = RsToUser(rs);
			return users;
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

	public ArrayList<User> findUserByName(String Name) {
		String sql = "SELECT * FROM User WHERE Name LIKE '%" + Name + "%'";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			users = RsToUser(rs);
			return users;
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
	
	public boolean updateUser(User user) {
		String sql = "UPDATE User SET Name = ? , Gender = ? , DoB = ? , Email = ? WHERE Username = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getDob());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getUsername());
			int result = ps.executeUpdate();
			ps.close();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
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

	public boolean insertUser(User user) {
		String sql = "INSERT INTO User (Username, Password, Email, Active, Status) VALUES (?, ?, ?, ?, ?)";
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, 1);
			ps.setInt(5, 1);
			int result = ps.executeUpdate();
			ps.close();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
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

	public ArrayList<User> findAllUsers() {
		String sql = "SELECT * FROM User";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			users = RsToUser(rs);
			return users;
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

	public boolean validUser(User user) {
		String sql = "SELECT * FROM User WHERE Username = ? and Password = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
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

	public ArrayList<User> findFriendsById(Integer ID) {
		String sql1 = "SELECT User.ID, User.Username, User.Email, User.Name, User.Gender, User.DoB, User.Photo, User.Active, User.Status, Friend.Time FROM Friend,User  WHERE Friend.UserID2 = User.ID AND Friend.UserID1 = " + ID;
		String sql2 = "SELECT User.ID, User.Username, User.Email, User.Name, User.Gender, User.DoB, User.Photo, User.Active, User.Status, Friend.Time FROM Friend,User  where Friend.UserID1 = User.ID and Friend.UserID2 = " + ID;
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
			ArrayList<User> users1 = new ArrayList<User>();
			users1 = RsToUser(rs1);
			
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			ArrayList<User> users2 = new ArrayList<User>();
			users2 = RsToUser(rs2);
			
			users.addAll(users1);
			users.addAll(users2);
			return users;
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

	public boolean banUser(Integer ID) {
		String sql = "UPDATE User SET Active = 0 WHERE ID = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ID);
			int result = ps.executeUpdate();
			ps.close();
			if (result == 1) {
				return true;
			} else {
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

	public boolean activeUser(Integer ID) {
		String sql = "UPDATE User SET Active = 1 WHERE ID = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ID);
			int result = ps.executeUpdate();
			ps.close();
			if (result == 1) {
				return true;
			} else {
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

	public boolean changePassword(User user) {
		String sql = "UPDATE User SET Password = ? WHERE ID = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setInt(2, user.getId());
			int result = ps.executeUpdate();
			ps.close();
			if (result == 1) {
				return true;
			} else {
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

	public boolean changePhoto(User user) {
		String sql = "UPDATE User SET Photo = ? WHERE ID = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getPhoto());
			ps.setInt(2, user.getId());
			int result = ps.executeUpdate();
			ps.close();
			if (result == 1) {
				return true;
			} else {
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

	public Integer friendRequested(Integer myid, Integer userid) {
		String sql = "SELECT * FROM AddFriend WHERE RequestFrom = ? and RequestTo = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, myid);
			ps.setInt(2, userid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("ID");
			}
			else {
				return null;
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

	public Integer isfriend(Integer useid1, Integer userid2) {
		String sql = "SELECT * FROM Friend WHERE UserID1 = ? and UserID2 = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, Math.min(useid1, userid2));
			ps.setInt(2, Math.max(useid1, userid2));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("ID");
			}
			else {
				return null;
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

	public void addFriend(Integer myid, Integer userid) {
		String sql = "INSERT INTO AddFriend (RequestFrom, RequestTo) VALUES (" + myid + ", " + userid + ")";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
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

	public void deleteFriend(Integer isFriendId) {
		String sql = "DELETE From Friend Where ID = " + isFriendId;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
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

	public ArrayList<User> findUsersByAdvSearch(String name, String email, String gender, String dob) {
		String sql = "SELECT * FROM User WHERE Name LIKE '%" + name + "%' AND Email LIKE '%" + email + "%' AND Gender Like '%"+ gender + "%' AND dob Like '%" + dob + "%'";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			users = RsToUser(rs);
			return users;
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

	public ArrayList<User> findFriendNoticeById(Integer id) {
		String sql = "SELECT User.* FROM User,AddFriend Where AddFriend.RequestTo = "+ id +" and AddFriend.RequestFrom = User.ID order by AddFriend.Time desc";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			users = RsToUser(rs);
			return users;
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

	public ArrayList<User> findMessageNoticeById(Integer id) {
		String sql = "select User.*,Message.ID as MessageID,`Like`.Time as LikeTime,Message.Text as Text from User,`Like`,Message where Message.UserID = " + id + " and Message.ID = `Like`.MessageID and  User.ID = `Like`.UserID order by liketime desc;";
		Connection connection = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("ID"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(null);
				user.setEmail(rs.getString("Email"));
				user.setName(rs.getString("Name"));
				user.setGender(rs.getString("Gender"));
				user.setDob(rs.getString("DoB"));
				user.setPhoto(rs.getString("Photo"));
				user.setActive(rs.getInt("Active"));
				user.setStatus(rs.getInt("Status"));
				user.setTime(rs.getString("Time"));
				user.setMessageid(rs.getInt("MessageID"));
				user.setLiketime(rs.getString("LikeTime"));
				user.setMessagetext(rs.getString("Text"));
				users.add(user);
			}
			return users;
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

	public void deleteFriendRequestedId(Integer friendRequestedId) {
		String sql = "DELETE From AddFriend Where ID = " + friendRequestedId;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
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

	public void confirmFriend(Integer userID1, Integer userID2) {
		String sql = "INSERT INTO Friend (UserID1, UserID2) VALUES (?,?)";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userID1);
			ps.setInt(2, userID2);
			ps.executeUpdate();
			ps.close();
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

	public void insertLike(Integer myid, Integer messageid) {
		String sql = "INSERT INTO `Like` (UserID, MessageID) VALUES (?,?)";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, myid);
			ps.setInt(2, messageid);
			ps.executeUpdate();
			ps.close();
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

	public Integer findLikeID(Integer myid, Integer messageid) {
		String sql = "SELECT * FROM `Like` WHERE UserID = ? and MessageID = ?";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, myid);
			ps.setInt(2, messageid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("ID");
			}
			else {
				return null;
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

	public void dislike(Integer likeid) {
		String sql = "DELETE From `Like` Where ID = " + likeid;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
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
	
}
