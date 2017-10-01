package unswbook.service;

import java.util.ArrayList;

import unswbook.model.Admin;
import unswbook.model.User;

public interface AdminService {
	
	boolean adminLogin(Admin admin);
	
	String banUser(Integer ID);
	
	String activeUser(Integer ID);
	
	Admin findAdminByUsername(String username);
	
	ArrayList<User> findAllUsers();
	
	ArrayList<User> findUserById(Integer ID);
	
	ArrayList<User> findUserByUsername(String Username);
	
	ArrayList<User> findUserByName(String Name);
	
	ArrayList<User> findUserByEmail(String Email);
}
