package com.example.demo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Friend;
import com.example.demo.service.FriendService;

@RestController
@CrossOrigin(origins = "*")
public class FriendsRestController {
	
	@Autowired
	private FriendService friendService;
	
	@PostMapping("/add")
	public List<Friend> addFriend(@RequestBody Friend f) {
		return friendService.addFriend(f);
	}
	
	@GetMapping("/all")
	public List<Friend> getAllFriends() {
		return friendService.getAllFriends();
	}
	
	@GetMapping("/{id}")
	public Friend getFriendById(@PathVariable int id) {
		return friendService.getFriendById(id);
	}
	
	@PostMapping("/{id}")
	public List<Friend> updateFriend(@PathVariable int id, @RequestBody Friend f){
		return friendService.updateFriend(id, f);
	}
	
	@DeleteMapping("/{id}")
	public List<Friend> deleteFriend(@PathVariable int id){
		return friendService.deleteFriend(id);
	}

	
	
}
