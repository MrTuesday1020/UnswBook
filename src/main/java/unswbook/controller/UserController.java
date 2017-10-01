package unswbook.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import unswbook.email.Email;
import unswbook.model.Message;
import unswbook.model.User;
import unswbook.service.MessageService;
import unswbook.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("userSession")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String Login(@ModelAttribute User user, ModelMap model) {
		boolean login = userService.loginUser(user);
		
		if(login) {
			User userSession = userService.findUserByUsernameStrict(user.getUsername()).get(0);
			if(userSession.getActive() == 1) {
				userSession.setPassword(null);
				model.put("userSession", userSession);
				return "redirect:index";
			}
			else {
				return "banned";
			}
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String Register(@ModelAttribute User user, ModelMap model) {

		boolean registered = userService.registerUser(user);
		
		if (!registered) {
			return "register";
		}
		else {
			User userSession = userService.findUserByUsernameStrict(user.getUsername()).get(0);
			userSession.setPassword(null);
			model.put("userSession", userSession);
			return "editProfile";
		}
	}
	
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request, ModelMap model) {
		
		User userSession = (User)request.getSession().getAttribute("userSession");

		ArrayList<Message> messages = messageService.findAllMessagesByUserID(userSession.getId());
			
		model.put("messages", messages);
		
		return "index";
	}
	
	@RequestMapping(value="/editProfile",method = RequestMethod.POST)
	public String EditProfile(HttpServletRequest request, @ModelAttribute User user, ModelMap model) {

		User userSession = (User)request.getSession().getAttribute("userSession");
		
		user.setUsername(userSession.getUsername());
		
		boolean updated = userService.editProfile(user);
		
		if (updated) {
			userSession.setEmail(user.getEmail());
			userSession.setName(user.getName());
			userSession.setGender(user.getGender());
			userSession.setDob(user.getDob());
			model.put("userSession", userSession);
			return "profile";
		}
		else {
			return "editProfile";
		}
	}
	
	@RequestMapping(value="/changePwd", method = RequestMethod.POST)
	public String changePwd(HttpServletRequest request) {
		
		String password = request.getParameter("password");
		User userSession = (User)request.getSession().getAttribute("userSession");
		
		User user = new User();
		user.setId(userSession.getId());
		user.setPassword(password);
		
		boolean changed = userService.changePassword(user);
		
		if(changed)
			return "profile";
		else
			return "password";
	}
	
	
	@RequestMapping(value="/uploadPhoto", method=RequestMethod.POST)
	public String doUploadFile(HttpServletRequest request, @RequestParam("photo") MultipartFile file, ModelMap model) throws IOException{
		
		if(!file.isEmpty()){
			// add timestamp before the image
			String photo = System.currentTimeMillis() + file.getOriginalFilename();
			//get the path in server
			String imgpath = request.getSession().getServletContext().getRealPath("/resources/userPhotos");
						
			User userSession = (User)request.getSession().getAttribute("userSession");
			User user = new User();
			user.setId(userSession.getId());
			user.setPhoto(photo);
			
			//store the photo name into database
			boolean updated = userService.changePhoto(user);
			if(updated) {
				//upload the photo to server
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imgpath, photo));
				//delete the old photo
				if(!userSession.getPhoto().equals("defaultphoto.png")) {
					String oldphoto = imgpath + "/" + userSession.getPhoto();
					File old = new File(oldphoto);
					if (old.exists()) {
			            System.out.println("yes");
			            old.delete();
			        }
				}
				
				//update the photo in session
				userSession.setPhoto(photo);
				model.put("userSession", userSession);
				return "profile";
			}
			else {
				return "photo";
			}
		}
		else {
			return "photo";
		}
	}
	
	
	@RequestMapping(value="/userProfile", method = RequestMethod.GET)
	public String userProfile(HttpServletRequest request, ModelMap model) {
		
		Integer userid = Integer.valueOf(request.getParameter("id"));
		User userSession = (User)request.getSession().getAttribute("userSession");
		
		if(userid == userSession.getId()) {
			return "profile";
		}
		else {
			User user = userService.findUserByID(userid).get(0);
			
			user.setFriendstatus(userService.friendStatus(userSession.getId(), userid));
			
			model.put("user", user);
			
			return "userProfile";
		}	
	}
	
	@RequestMapping(value="/addFriend", method = RequestMethod.GET)
	public String addFriend(HttpServletRequest request, ModelMap model) {
		
		User userSession = (User)request.getSession().getAttribute("userSession");
		Integer myid = userSession.getId();
		Integer userid = Integer.valueOf(request.getParameter("id"));
		
		userService.addFriend(myid, userid);
		
		String address = "389203074@qq.com";
		
		Email mail = new Email();
		try {
			mail.sendEmail(address,"Friend Request","User " + userSession.getUsername() + " sends you a friend request!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:userProfile?id="+userid;
	}
	
	@RequestMapping(value="/deleteFriend", method = RequestMethod.GET)
	public String deleteFriend(HttpServletRequest request, ModelMap model) {
		
		User userSession = (User)request.getSession().getAttribute("userSession");
		Integer myid = userSession.getId();
		Integer userid = Integer.valueOf(request.getParameter("id"));
		
		userService.deleteFriend(myid, userid);
		
		return "redirect:userProfile?id="+userid;
	}
	
	@RequestMapping(value="/confirmFriend", method = RequestMethod.GET)
	public String confirmFriend(HttpServletRequest request, ModelMap model) {
		
		User userSession = (User)request.getSession().getAttribute("userSession");
		Integer myid = userSession.getId();
		Integer userid = Integer.valueOf(request.getParameter("id"));
		
		userService.confirmFriend(myid, userid);
		
		return "redirect:notice";
	}
	
	@RequestMapping(value="/basicSearch", method = RequestMethod.POST)
	public String basicSearch(HttpServletRequest request, ModelMap model) {
		
		String keywords = request.getParameter("keywords");
		
		ArrayList<User> users =  userService.findFriendsByUsername(keywords);
		
		model.put("users", users);
		
		return "results";
	}
	
	
	@RequestMapping(value="/advSearch", method = RequestMethod.POST)
	public String advSearch(HttpServletRequest request, ModelMap model) {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		
		ArrayList<User> users =  userService.findUsersByAdvSearch(name, email, gender, dob);
		
		model.put("users", users);
		
		return "results";
	}
	
	@RequestMapping(value="/notice")
	public String notice(HttpServletRequest request, ModelMap model) {
		
		User userSession = (User)request.getSession().getAttribute("userSession");
		Integer myid = userSession.getId();
		
		ArrayList<User> messageNotices = userService.findMessageNoticeById(myid);
		ArrayList<User> friendNotices = userService.findFriendNoticeById(myid);
		
		model.put("messageNotices", messageNotices);
		model.put("friendNotices", friendNotices);
		
		return "notice";
	}
	
	@RequestMapping(value="/like", method = RequestMethod.GET)
	public String like(HttpServletRequest request, ModelMap model) {
		
		User userSession = (User)request.getSession().getAttribute("userSession");
		Integer myid = userSession.getId();
		Integer messageid = Integer.valueOf(request.getParameter("id"));
		
		userService.like(myid, messageid);
		
		return "redirect:index";
	}
	
	@RequestMapping(value="/dislike", method = RequestMethod.GET)
	public String dislike(HttpServletRequest request, ModelMap model) {
		
		User userSession = (User)request.getSession().getAttribute("userSession");
		Integer myid = userSession.getId();
		Integer messageid = Integer.valueOf(request.getParameter("id"));
		
		userService.dislike(myid, messageid);
		
		return "redirect:index";
	}
	
}
