package user.mgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import user.mgt.domain.User;
import user.mgt.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/signin")
	public ModelAndView signin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignIn");
		return mv;
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignUp");
		return mv;
	}
	
	@PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user) {
		userService.saveUser(user);
        return "redirect/";
    }
}
