package net.francais.mashi.dic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.francais.mashi.dic.entities.User;
import net.francais.mashi.dic.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> getById(@PathVariable Long userId){
		userService.find(userId);
		return new ResponseEntity<User>(userService.find(userId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/users/", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> addUser(User user){
		userService.createOrUpdate(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<User> updateUser(@PathVariable Long id, User user){
		user.setId(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
