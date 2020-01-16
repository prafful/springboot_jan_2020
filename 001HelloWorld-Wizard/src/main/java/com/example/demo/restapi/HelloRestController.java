package com.example.demo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Friend;
import com.example.demo.service.FriendService;

@RestController
@RequestMapping("api")
public class HelloRestController {
	
	@Autowired
	private FriendService friendService;
	
	
	/**
	 * GET Request
	 * http://localhost:8080/
	 * @return
	 */
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Spring Boot!";
	}
	
	/**
	 * GET Request
	 * http://localhost:8080/check
	 * @return
	 */
	@RequestMapping("/check")
	public String sendCheck() {
		return "Check from Spring Boot!";
	}
	
	//@RequestMapping(value = "/friends/all", method = RequestMethod.GET)
	@GetMapping("/friends/all")
	public List<Friend> getAllFriends() {
		return friendService.getAllFriends();
	
	}
	
	/**
	 * Get the friend with specific id
	 */
	@GetMapping("/friends/{friendid}")
	public Friend getFriendById(@PathVariable("friendid") int id) {
		System.out.println(id);
		return friendService.getFriendById(id);
		
	}
	
	//@RequestMapping(value = "/friends/{friendid}", method = RequestMethod.DELETE)
	@DeleteMapping("/friends/{friendid}")
	public List<Friend> deleteFriendById(@PathVariable("friendid") int id) {
		System.out.println(id);
		return friendService.deleteFriendById(id);
		
	}
	
	@PostMapping("/friends/add")
	public List<Friend> addFriend(@RequestBody Friend f){
		System.out.println("In add friend method");
		System.out.println("Name: " + f.getName());
		System.out.println("Location: " + f.getLocation());
		System.out.println("Id: " + f.getId());
		
		return friendService.addFriend(f);
	}

}
