package unswbook.controller;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import unswbook.model.Admin;
import unswbook.model.Message;
import unswbook.model.User;
import unswbook.service.AdminService;
import unswbook.service.MessageService;
import unswbook.service.UserService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("adminSession")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	
	public String Login(@ModelAttribute Admin admin, ModelMap model) {
		
		if (adminService.adminLogin(admin)) {
			Admin adminSession = new Admin();
			adminSession = adminService.findAdminByUsername(admin.getUsername());
			adminSession.setPassword(null);
			model.put("adminSession",adminSession);
			
			return "adminIndex";
		}
		else {
			return "adminLogin";
		}
		
	}
	
	@RequestMapping(value="/findAllUsers")
	public String findAllUsers(Map<String, Object> model) {
		
		ArrayList<User> users = adminService.findAllUsers();
		
		model.put("users", users);
		
		return "adminListUsers";
	}
	
	@RequestMapping(value="/findUsers", method = RequestMethod.POST)
	public String findUsers(HttpServletRequest request, Map<String, Object> model) {
		
		String keywords = request.getParameter("keywords");
		String selection = request.getParameter("selection");
		
		ArrayList<User> users = new ArrayList<User>();
		if( selection.equals("username") ) {
			users = adminService.findUserByUsername(keywords);
		}
		else if ( selection.equals("name") ) {
			users = adminService.findUserByName(keywords);
		}
		else if ( selection.equals("email") ) {
			users = adminService.findUserByEmail(keywords);
		}
		
		model.put("users", users);
		
		return "adminListUsers";
	}
	
	@RequestMapping(value="/findAllMessages")
	public String findAllMessages(Map<String, Object> model) {
		
		ArrayList<Message> messages = messageService.findAllMessages();
		
		model.put("messages", messages);
		
		return "adminListMessages";
	}
	
	@RequestMapping("/getReport")
	public String getReport(HttpServletRequest request, ModelMap model) {
		
		Integer userid = Integer.valueOf(request.getParameter("id"));
		
		//user info
		User user = adminService.findUserById(userid).get(0);
		String time = userService.formatTime(user.getTime());
		user.setTime(time);
		//messages
		ArrayList<Message> messages = messageService.findMessagesByUserId(userid);
		//friends
		ArrayList<User> friends = userService.findFriendsByID(userid);
		for(User f:friends) {
			String friendTime = userService.formatTime(f.getTime());
			f.setTime(friendTime);
		}
		
		model.put("user", user);
		model.put("messages", messages);
		model.put("friends", friends);
		
		return "adminReport";
	}
	
	@RequestMapping("/banUser")
	public String banUser(HttpServletRequest request, ModelMap model) {
		
		Integer userid = Integer.valueOf(request.getParameter("id"));
		
		String username = adminService.banUser(userid);

		model.put("username", username);
		
		return "adminBanUser";
	}
	
	@RequestMapping("/activeUser")
	public String activeUser(HttpServletRequest request, ModelMap model) {
		
		Integer userid = Integer.valueOf(request.getParameter("id"));
		
		String username = adminService.activeUser(userid);

		model.put("username", username);
		
		return "adminActiveUser";
	}
	
}
