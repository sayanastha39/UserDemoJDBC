package com.vastika.user_demo_jdbc;

import java.util.List;
import java.util.Scanner;

import com.vastika.user_demo_jdbc.model.User;
import com.vastika.user_demo_jdbc.service.UserService;
import com.vastika.user_demo_jdbc.service.UserServiceImpl;

public class UserController {
	
	 public static User getUserData(String type, Scanner reader) {
		 User user= new User();
		 if(type.contentEquals("update")) {
			 System.out.println("Enter id:  ");
			 int id = reader.nextInt();
			 user.setId(id);
		 }
	   	 System.out.println("Enter username: ");
	   	 String username= reader.next();
	   	 System.out.println("Enter password: ");
	   	 String password= reader.next();
	   	 System.out.println("Enter address: ");
	   	 String address= reader.next();
	   	 System.out.println("Enter mobileNo: ");
	   	 Long mobileno= reader.nextLong ();
	   	 
	   	 user.setUsername(username);
	   	 user.setPassword(password);
	   	 user.setAddress(address);
	   	 user.setMobileno(mobileno);
	   	 return user;
		}
	
	
    public static void main( String[] args ){
    	
    	UserService userService = new UserServiceImpl();
    	String decision = "";
    	 Scanner reader  =  new Scanner(System.in);
    	 
    	 do {
    		 System.out.println("Enter your choice for operation from save/update/delete/get/list: ");
        	 String choice = reader.next();
        	 
        	 switch(choice) {
        	 case "save":
        		 User saveUser = getUserData(choice, reader);
            	 int saved =userService.saveUserInfo(saveUser);
            	 if (saved>=1) {
            		 System.out.println("User info is saved sucessfully!");
            	 }
            	 else {
            		 System.out.println("User info save failed!!");
            	 }
        		 break;
        		 
        	 case "update":
        		 User updateUser = getUserData(choice, reader);
            	 int updated =userService.updateUserInfo(updateUser);
            	 if (updated>=1) {
            		 System.out.println("User info is updated sucessfully!");
            	 }
            	 else {
            		 System.out.println("User info update  failed!!");
            	 }
        		 break;
        		 
        	 case "delete":
        		 System.out.println("Enter id to delete: ");
        		 int deleteId = reader.nextInt();
        		 userService.deleteUserInfo(deleteId);
        		 System.out.println("User info is deleted sucessfully!");
        		 break;
        		 
        	 case "get":
        		 System.out.println("Enter id you want to get info of: ");
        		 int getId = reader.nextInt();
        		 User user = userService.getUserById(getId);
        		 System.out.println("User id is: " + user.getId());
        		 System.out.println("Username is: " + user.getUsername());
        		 System.out.println("Password is: " + user.getPassword());
        		 System.out.println("Address is: " + user.getAddress());
        		 System.out.println("Mobileno is: " + user.getMobileno());
        		 break;
        		 
        	 case "list":
        		 
        		 List <User> userList = userService.getAllUserInfo();
        		 
        		 for(User u: userList) {
        			 System.out.println("User id is: " + u.getId());
            		 System.out.println("Username is: " + u.getUsername());
            		 System.out.println("Password is: " + u.getPassword());
            		 System.out.println("Address is: " + u.getAddress());
            		 System.out.println("Mobileno is: " + u.getMobileno());
        		 }
        		 break;
        		 
        	default:
        		System.out.println("Wrong input for choice!");
        		break;
        	 }
        	 System.out.println("Do you want to perform next? y or n");
        	 decision = reader.next();
    	 }
    	 while(decision.equalsIgnoreCase("y"));
    }
}
