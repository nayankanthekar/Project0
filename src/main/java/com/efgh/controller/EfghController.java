package com.efgh.controller;

import java.util.List;
import java.util.Scanner;

import com.efgh.entity.EfghUser;
import com.efgh.service.EfghServiceInterface;
import com.efgh.utility.ServiceFactory;
import com.efgh.entity.EfghUser;
import com.efgh.service.EfghServiceInterface;
import com.efgh.entity.EfghUser;
import com.efgh.entity.TimeLineEntity;
import com.efgh.service.EfghServiceInterface;

public class EfghController implements EfghControllerInterface {

	@Override
	public int createProfileController() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter name");
		String name=sc.next();
		
		System.out.println("Enter email");
		String email=sc.next();
		
		System.out.println("Enter address");
		String address=sc.next();
		
		System.out.println("Enter password");
		String password=sc.next();
		
		EfghUser eu=new EfghUser();
		eu.setName(name);
		eu.setAddress(address);
		eu.setEmail(email);
		eu.setPassword(password);
		
		EfghServiceInterface es= ServiceFactory.createObject();
		
		return es.createProfileService(eu);
	}

	@Override
	public int viewProfileController() {
		int i=0; 
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email:");
		String email=sc.next();
		
		EfghUser eu= new EfghUser();
		eu.setEmail(email);
		
		EfghServiceInterface es=ServiceFactory.createObject();
		EfghUser eu1=es.viewProfileService(eu);
		
		if(eu1!=null) {
			System.out.println("Name is:"+eu1.getName());
			System.out.println("Email is:"+eu1.getEmail());
			System.out.println("Address is:"+eu1.getAddress());
			System.out.println("Password is:"+eu1.getPassword());
			i=1;
		}else {
			System.out.println("Profile not found");
		}
		
		return i;
	}

	@Override
	public int deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email");
		String email=sc.next();
		
		EfghUser eu=new EfghUser();
		eu.setEmail(email);
		
		EfghServiceInterface es=ServiceFactory.createObject();
		int eu1=es.deleteProfileService(eu);
		return eu1;
	}

	@Override
	public int loginProfileController() {
		Scanner sc=new Scanner(System.in);
		
		
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		
		EfghUser eu=new EfghUser();
	
		eu.setPassword(password);
		eu.setEmail(email);
		
		
		EfghServiceInterface es=ServiceFactory.createObject();
		EfghUser ee=es.loginProfileService(eu);
		if(ee!=null) {
			System.out.println("Welcome "+ee.getName());
			
			System.out.println("press 1 to view timeline");
			System.out.println("press 2 to upload photo");
			
			System.out.println("enter your choice");
			int cc=sc.nextInt();
			
			switch(cc) {
			case 1 : List<TimeLineEntity> tresult=es.timelineService(eu);
						for(TimeLineEntity ti:tresult) {
							System.out.println("Sender of Message is :" + ti.getSender());
							System.out.print("	Time of Message is :" + ti.getTimeofmessage());
							System.out.print("		Message :" + ti.getMessage());
							System.out.println();
							System.out.println("	Reciever of Message is :" + ti.getReceiver());
							System.out.println();
						}
			break;
			}
		}
		
		return 0;
	}

	@Override
	public int viewAllProfileController() {
		
		EfghServiceInterface es=ServiceFactory.createObject();
		List<EfghUser> eu1=es.viewAllProfileService();
		
		for(EfghUser eu2:eu1) {
			System.out.println("*****************************");
			System.out.println("Name is "+eu2.getName());
			System.out.println("Password is "+eu2.getPassword());
			System.out.println("Email is "+eu2.getEmail());
			System.out.println("Address is "+eu2.getAddress());
			
		}
		
		return eu1.size();
	}

}
