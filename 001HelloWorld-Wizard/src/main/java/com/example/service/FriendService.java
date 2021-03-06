package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FriendDao;
import com.example.pojo.Friend;

@Service("friendService")
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}

	public Friend getFriendById(int id) {
		// TODO Auto-generated method stub
		return friendDao.getFriendById(id);
	}

	public List<Friend> deleteFriendById(int id) {
		// TODO Auto-generated method stub
		return friendDao.deleteFriendById(id);
	}

	public List<Friend> addFriend(Friend f) {
		// TODO Auto-generated method stub
		return friendDao.addFriend(f);
	}

	
}
