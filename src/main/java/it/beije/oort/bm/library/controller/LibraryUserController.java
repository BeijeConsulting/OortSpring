package it.beije.oort.bm.library.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.bm.library.entity.User;
import it.beije.oort.bm.library.service.UserService;

@RestController
@RequestMapping("/user")
public class LibraryUserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/all")
	public List<User> getAll(){
		log.debug("/user/all : get");
		return userService.getAll();
	}
	
	@GetMapping(value = "/get/{id}")
	public User get(@PathVariable int id){
		log.debug("/user/get/{if} : get : id := " + id);
		return userService.getUser(id);
	}
	
	@PostMapping( value = "/insert")
	public User insert(@RequestBody User user) {
		log.debug("/user/insert : post : Object := " + user);
		userService.addUser(user);
		return user;
	}
	
	@PutMapping( value = "/update/{id}")
	public User update(@RequestBody User user, @PathVariable int id){
		log.debug("/user/upgrade/{if} : get : id := " + id + " : Object := " + user);
		user.setId(id);
		return userService.updateUser(id, user);
	}
	@DeleteMapping( value = "/delete/{id}")
	public boolean delete(@PathVariable int id) {
		log.debug("/user/delete - post - id: " + id);
		return userService.deleteUser(id);
	}
	
}
