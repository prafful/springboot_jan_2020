package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Friend;
import com.example.demo.repository.FriendRepository;

@Repository("friendDao")
public class FriendDao {
	
	@Autowired
	private FriendRepository friendRepository;

	public List<Friend> addFriend(Friend f) {
		// TODO Auto-generated method stub
		friendRepository.save(f);
		return friendRepository.findAll();
	}

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friendRepository.findAll();
	}

	public Friend getFriendById(int id) {
		// TODO Auto-generated method stub
		Friend f = friendRepository.findById(id).orElse(new Friend());
		return f;
	}

	public List<Friend> updateFriend(int id, Friend f) {
		// TODO Auto-generated method stub
		Friend f1 = friendRepository.findById(id).orElse(new Friend());
		System.out.println(f1.getName());
		if(f1.getName() != null) {
			f1.setName(f.getName());
			f1.setLocation(f.getLocation());
			f1.setId(id);
		}
		friendRepository.save(f1);
		return friendRepository.findAll();
	}

	public List<Friend> deleteFriend(int id) {
		// TODO Auto-generated method stub
		//Friend f = friendRepository.findById(id).orElse(new Friend());
		//if(f.getName() != null) {
		friendRepository.deleteById(id);
		//}
		//friendRepository.delete(entity);
		return friendRepository.findAll();
	}

}
