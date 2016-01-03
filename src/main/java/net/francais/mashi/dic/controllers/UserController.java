package net.francais.mashi.dic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users",userService.findAll());
		return "users";
	}
	
	@RequestMapping("/users/${id}")
	public String detail(Model model, @PathVariable long id){
		model.addAttribute("user",userService.find(id));
		return "user-details";
	}
	
}
