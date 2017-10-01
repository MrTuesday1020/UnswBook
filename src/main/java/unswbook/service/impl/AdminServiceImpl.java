package unswbook.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import unswbook.dao.AdminDao;
import unswbook.dao.UserDao;
import unswbook.model.Admin;
import unswbook.model.User;
import unswbook.service.AdminService;

public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	UserDao userDao;
	
	public boolean adminLogin(Admin admin) {
		return adminDao.validAdmin(admin);
	}

	public ArrayList<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	public Admin findAdminByUsername(String username) {
		return adminDao.findAdminByUsername(username);
	}

	public ArrayList<User> findUserByUsername(String Username) {
		return userDao.findUserByUsername(Username);
	}

	public ArrayList<User> findUserByName(String Name) {
		return userDao.findUserByName(Name);
	}

	public ArrayList<User> findUserByEmail(String Email) {
		return userDao.findUserByEmail(Email);
	}

	public ArrayList<User> findUserById(Integer ID) {
		return userDao.findUserById(ID);
	}

	public String banUser(Integer ID) {
		
		String username = null;
		User user = userDao.findUserById(ID).get(0);
		
		if(user.getActive() == 1) {
			if(userDao.banUser(ID)) {
				username = user.getUsername();
			}
		}
		
		return username;
	}
	
	public String activeUser(Integer ID) {
		
		String username = null;
		User user = userDao.findUserById(ID).get(0);
		
		if(user.getActive() == 0) {
			if(userDao.activeUser(ID)) {
				username = user.getUsername();
			}
		}
		
		return username;
	}
	
}
