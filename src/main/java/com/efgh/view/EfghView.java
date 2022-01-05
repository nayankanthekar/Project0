package com.efgh.view;

import java.util.Scanner;

import com.efgh.controller.EfghControllerInterface;
import com.efgh.utility.ControllerFactory;

public class EfghView {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String s="y";
		while(s.contentEquals("y")) {
			
			System.out.println("1.Press 1 to create profile");
			System.out.println("2.Press 2 to view profile");
			System.out.println("press 3 to view all profile");
			System.out.println("press 4 to delete profile");
			System.out.println("press 5 to login profile");
			
			int ch=sc.nextInt();
			
			EfghControllerInterface ec=ControllerFactory.createobject();
			
			
			switch(ch) {
			case 1:int i=ec.createProfileController();
					if(i>0) {
						System.out.println("Registration successfull");
					}else {
						System.out.println("profile not created");
					}
				break;
				
				
				
			case 2:int i1=ec.viewProfileController();
			if(i1>0) {
				System.out.println("Profile found");
			}else {
				System.out.println("profile not found");
			}
		        break;
			case 3 : int i2=ec.viewAllProfileController();
			  if(i2>0) {
				  System.out.println(i2+ " record found");
			  }
			  else {
				  System.out.println("could not find profile");
			  }
		break;
		
			case 4 : int i3=ec.deleteProfileController();
			  if(i3>0) {
				  System.out.println( " record deleted");
			  }
			  else {
				  System.out.println("could not delete profile");
			  }
		break;
			case 5 : int i4=ec.loginProfileController();
			  if(i4>0) {
				  System.out.println( " profile logedin");
			  }
			  else {
				  System.out.println("could not delete profile");
			  }
		break;
			  default:
			    	System.out.println("wrong choice");
			}
			
			System.out.println("Do you want to continue ?");
			s=sc.next();
			
			
		}
	}

}
