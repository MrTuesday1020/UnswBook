package unswbook.service;

import java.util.ArrayList;

import unswbook.model.User;

public interface UserService {
	
	ArrayList<User> findUserByID(Integer ID);
	
	ArrayList<User> findFriendsByUsername(String Username);
	
	ArrayList<User> findFriendsByID(Integer ID);
	
	ArrayList<User> findUserByUsernameStrict(String Username);
	
	boolean registerUser(User user);

	boolean loginUser(User user);

	boolean editProfile(User user);
	
	boolean changePassword(User user);
	
	boolean changePhoto(User user);

	String formatTime(String time);

	Integer friendStatus(Integer myid, Integer userid);
	
	void addFriend(Integer myid, Integer userid);

	void deleteFriend(Integer myid, Integer userid);

	ArrayList<User> findUsersByAdvSearch(String name, String email, String gender, String dob);

	ArrayList<User> findFriendNoticeById(Integer myid);

	ArrayList<User> findMessageNoticeById(Integer myid);

	void confirmFriend(Integer myid, Integer userid);

	void like(Integer myid, Integer messageid);

	void dislike(Integer myid, Integer messageid);
}
