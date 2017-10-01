package unswbook.dao;

import java.util.ArrayList;

import unswbook.model.User;

public interface UserDao {

	ArrayList<User> findAllUsers();
	
	ArrayList<User> findUserById(Integer ID);
	
	ArrayList<User> findUserByUsernameStrict(String Username);
	
	ArrayList<User> findUserByUsername(String Username);
	
	ArrayList<User> findUserByName(String Name);
	
	ArrayList<User> findUserByEmail(String Email);
	
	ArrayList<User> findFriendsById(Integer ID);
	
	boolean validUser(User user);
	
	boolean updateUser(User user);
	
	boolean insertUser(User user);

	boolean banUser(Integer ID);

	boolean activeUser(Integer ID);
	
	boolean changePassword(User user);
	
	boolean changePhoto(User user);
	
	Integer friendRequested(Integer myid, Integer userid);
	
	Integer isfriend(Integer userid1, Integer userid2);

	void addFriend(Integer myid, Integer userid);

	void deleteFriend(Integer isFriendId);

	ArrayList<User> findUsersByAdvSearch(String name, String email, String gender, String dob);

	ArrayList<User> findFriendNoticeById(Integer id);

	ArrayList<User> findMessageNoticeById(Integer id);

	void deleteFriendRequestedId(Integer friendRequestedId);

	void confirmFriend(Integer myid, Integer userid);

	void insertLike(Integer myid, Integer messageid);

	Integer findLikeID(Integer myid, Integer messageid);

	void dislike(Integer likeid);

}
