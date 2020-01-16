package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Friend;

@Repository("friendDao")
public class FriendDao {
	
	List<Friend> friends = new ArrayList<Friend>();
	
    FriendDao() {
		//instantiate 3 friends
		Friend f1 = new Friend(1, "Ola", "Chennai");
		Friend f2 = new Friend(2, "Nid", "Japan");
		Friend f3 = new Friend(3, "Pig", "Begaluru");
				
		//add f1, f2 and f3 to friends collection
		friends.add(f1);
		friends.add(f2);
		friends.add(f3);
	}

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friends;
	}

	public Friend getFriendById(int id) {
		// TODO Auto-generated method stub
		for(int i=0; i<friends.size();i++) {
			Friend f = friends.get(i);
			if(f.getId() == id) {
				return f;
			}
		}
		return null;
	}

	public List<Friend> deleteFriendById(int id) {
		// TODO Auto-generated method stub
		for(int i=0; i<friends.size();i++) {
			Friend f = friends.get(i);
			if(f.getId() == id) {
				friends.remove(i);
			}
		}
		return friends;
	}

	public List<Friend> addFriend(Friend f) {
		// TODO Auto-generated method stub
		friends.add(f);
		return friends;
	}

}
