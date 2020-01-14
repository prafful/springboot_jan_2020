package com.example.demo.restapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Friend;

@RestController
@RequestMapping("api")
public class HelloRestController {
	
	
	List<Friend> friends = new ArrayList<Friend>();
	
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
		
		//instantiate 3 friends
		Friend f1 = new Friend(1, "Ola", "Chennai");
		Friend f2 = new Friend(2, "Nid", "Japan");
		Friend f3 = new Friend(3, "Pig", "Begaluru");
		
		//add f1, f2 and f3 to friends collection
		friends.add(f1);
		friends.add(f2);
		friends.add(f3);
		
		return friends;
	}
	
	/**
	 * Get the friend with specific id
	 */
	@GetMapping("/friends/{friendid}")
	public Friend getFriendById(@PathVariable("friendid") int id) {
		System.out.println(id);	
		for(int i = 0; i<friends.size();i++) {
			Friend f = friends.get(i);
			if(f.getId() == id) {
				return f;
			}
		
		}
		
		return null;
	}
	
	//@RequestMapping(value = "/friends/{friendid}", method = RequestMethod.DELETE)
	@DeleteMapping("/friends/{friendid}")
	public List<Friend> deleteFriendById(@PathVariable("friendid") int id) {
		System.out.println(id);	
		for(int i = 0; i<friends.size();i++) {
			Friend f = friends.get(i);
			if(f.getId() == id) {
				friends.remove(i);
			}
		
		}
		
		return friends;
	}

}
