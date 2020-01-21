package com.springcore.beginner.mainEntry;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.beginner.pojo.FriendPojo;
import com.springcore.beginner.pojo.Profile;

public class SpringCoreMain {

	
	public static void main(String args[]) {
		
		/*	
		 * non-spring way
		 * FriendPojo fp = new FriendPojo(); 
		 * fp.setLocation("Chennai");
		 * fp.setName("Prafful");
		 * System.out.println(fp.getName() + " at " + fp.getLocation());
		 */
		//spring way
		
		AbstractApplicationContext handleToSpringContainer =
			new ClassPathXmlApplicationContext("settings.xml");
		
		FriendPojo fp = (FriendPojo) handleToSpringContainer.getBean("friendBean");
		fp.setLocation("Chennai");
		fp.setName("Prafful");
		System.out.println(fp.getName() + " at " + fp.getLocation());
		
		
		FriendPojo fp1 = (FriendPojo) handleToSpringContainer.getBean("friendBean");
		System.out.println(fp1.getName() + " at " + fp1.getLocation());
		
		FriendPojo fp2 = (FriendPojo) handleToSpringContainer.getBean("friendBean");
		System.out.println(fp2.getName() + " at " + fp2.getLocation());
		
		Profile p1 = (Profile) handleToSpringContainer.getBean("profileBean");
		p1.setLikes(88);
		System.out.println(p1.getLikes());
		
	}
	
}
