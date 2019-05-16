package database.admin.DBPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import database.admin.DBPractice.model.*;
import database.admin.DBPractice.dao.*;

@Controller
public class MainController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		
		return mav;
		
	}
	
	@RequestMapping("/user-reg")
	public ModelAndView userReg() {
		ModelAndView mav = new ModelAndView("user-reg");
		
		return mav;
		
	}
	@RequestMapping("/user-conf")
	public ModelAndView userSub(@RequestParam("username") String username,
								@RequestParam("fullName") String fullName,
								@RequestParam("email") String email,
								@RequestParam("password") String password, 
								@RequestParam("passwordConf") String passwordConf) {
		User user = new User();
		user.setEmail(email);
		user.setFullName(fullName);
		user.setUsername(username);
		user.setPassword(passwordConf);
		User userCheck = userDao.findByUsername(user.getUsername());
		if(userCheck!=null) {
			return new ModelAndView("user-reg", "message","A user with that username already exists.");
		}
		if(!passwordConf.equals(user.getPassword())) {
			return new ModelAndView("user-reg","message", "Passwords do not match.");
		}
		
		userDao.create(user);
		ModelAndView mav = new ModelAndView("user-conf");
		return mav;
	}
	
}
