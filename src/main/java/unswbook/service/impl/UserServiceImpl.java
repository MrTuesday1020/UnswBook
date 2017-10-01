package unswbook.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import unswbook.dao.UserDao;
import unswbook.model.User;
import unswbook.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public ArrayList<User> findUserByID(Integer ID) {
		return userDao.findUserById(ID);
	}
	
	public ArrayList<User> findUserByUsernameStrict(String Username) {
		return userDao.findUserByUsernameStrict(Username);
	}
	
	public boolean registerUser(User user) {
		ArrayList<User> u = userDao.findUserByUsernameStrict(user.getUsername());
		if(u.size() == 0){
			return userDao.insertUser(user);
		}
		else {
			return false;
		}
	}

	public boolean loginUser(User user) {
		boolean valid = userDao.validUser(user);
		if (valid) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean editProfile(User user) {
		return userDao.updateUser(user);
	}

	public ArrayList<User> findFriendsByID(Integer ID) {
		return userDao.findFriendsById(ID);
	}
	
	public ArrayList<User> findFriendsByUsername(String Username) {
		return userDao.findUserByUsername(Username);
	}

	public String formatTime(String time) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s").parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temptime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date oritime = null;
		try {
			oritime = dateFormat.parse(temptime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date nowtime = new Date();
		long difference = nowtime.getTime() - oritime.getTime();
		String results = "";
		long diffyears = difference / (12 * 30 * 24 * 60 * 60 * 1000);
		long diffmonths = difference / (30 * 24 * 60 * 60 * 1000);
		long diffweeks = difference / (7 * 24 * 60 * 60 * 1000);
		long diffdays = difference / (24 * 60 * 60 * 1000);
		long diffhours = difference / (60 * 60 * 1000);
		long diffminutes = difference / (60 * 1000);
		long diffseconds= difference / 1000;
		if ( 1 <= diffyears) {
			results = diffyears + " year(s)";
		}
		else if ( 1 <= diffmonths) {
			results = diffmonths + " month(s)";
		}
		else if ( 1 <= diffweeks) {
			results = diffweeks + " week(s)";
		}
		else if ( 1 <= diffdays) {
			results = diffdays + " day(s)";
		}
		else if ( 1 <= diffhours) {
			results = diffhours + " hour(s)";
		}
		else if ( 1 <= diffminutes) {
			results = diffminutes + " minute(s)";
		}
		else if ( 1 <= diffseconds) {
			results = diffseconds + " second(s)";
		}
		
		
		
		return results;
	}

	public boolean changePassword(User user) {
		return userDao.changePassword(user);
	}

	public boolean changePhoto(User user) {
		return  userDao.changePhoto(user);
	}

	public Integer friendStatus(Integer myid, Integer userid) {
		//return value: 0: not friend, 1: request sent, 2: is friend
		Integer isFriendId = userDao.isfriend(myid, userid);
		
		if(isFriendId != null) {
			return 2;
		}
		else {
			Integer friendRequestedId = userDao.friendRequested(myid, userid);
			if(friendRequestedId != null) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}

	public void addFriend(Integer myid, Integer userid) {
		userDao.addFriend(myid,userid);
	}

	public void deleteFriend(Integer myid, Integer userid) {
		Integer isFriendId = userDao.isfriend(myid, userid);
		
		if(isFriendId != null) {
			userDao.deleteFriend(isFriendId);
		}
		
	}

	public ArrayList<User> findUsersByAdvSearch(String name, String email, String gender, String dob) {
		//if gender is any
		if(gender.equals("a"))
			gender = "";
		
		return userDao.findUsersByAdvSearch(name, email, gender, dob);
	}

	public ArrayList<User> findFriendNoticeById(Integer id) {
		return userDao.findFriendNoticeById(id);
	}

	public ArrayList<User> findMessageNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findMessageNoticeById(id);
	}

	public void confirmFriend(Integer myid, Integer userid) {
		Integer friendRequestedId = userDao.friendRequested(userid, myid);
		userDao.deleteFriendRequestedId(friendRequestedId);
		userDao.confirmFriend(Math.min(myid, userid), Math.max(myid, userid));
	}

	public void like(Integer myid, Integer messageid) {
		userDao.insertLike(myid, messageid);
	}

	public void dislike(Integer myid, Integer messageid) {
		Integer likeid = userDao.findLikeID(myid, messageid);
		userDao.dislike(likeid);
	}

}
