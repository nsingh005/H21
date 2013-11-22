package cs445.project.commandLineInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import cs445.project.base.User;
import cs445.project.facilitator.UserFacilitator;

public class UserApp {
	public static void userApp(String args[]) {
		if(args.length < 2) {
			System.out.println("Insufficient number of arguments");
			printHelp();
			return;
		}
		
		UserFacilitator userFacilitator = new UserFacilitator();
		
		if(args[0] != null && args[1] != null){
			String command = args[0];
			String subCommand = args[1];
			
			if(command.compareTo("user") == 0 && subCommand.compareTo("add") == 0) {
				if(args[2].compareTo("--first_name") == 0 && 
						args[4].compareTo("--last_name") == 0 &&
						args[6].compareTo("--email") == 0 ) {
					User user = new User();
					user.setFirstName(args[3]);
					user.setLastName(args[5]);
					user.setEmail(args[7]);

					if(args[8].compareTo("--cc_number") == 0) {
						user.setCcNumber(args[9]);
					}						
					
					if(args[10].compareTo("--expiration_date") == 0) {
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
							user.setCcExpiryDate(sdf.parse(args[11]));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if(args[12].compareTo("--security_code") == 0) {
						user.setSecurityCode(Integer.parseInt(args[13]));
					}
					
					if(args[14].compareTo("--phone") == 0) {
						user.setPhone(args[15]);
					}
										
					
					if(userFacilitator.isUserPresent(user) == false) {
						user.setUserId(userFacilitator.addUser(user));
						System.out.println("User Added Successfully!!");
						System.out.println("User Id: "+ user.getUserId());
						return;
					}
					else{
						System.out.println("User Already exist!!!");
						User u = userFacilitator.getUserByEmail(user.getEmail());
						System.out.println(u);						
					}
				}				
			}
			else if(command.compareTo("user") == 0 && subCommand.compareTo("view") == 0) {
				if(args.length == 3) {
					if(args[2].compareTo("all")==0) {
						List<User> users = userFacilitator.getAllUsers();
						for(User u: users) {
							System.out.println(u);
						}
					}
					else {
						Integer userId = Integer.parseInt(args[2]);
						User user = userFacilitator.getUserById(userId);
						if(user != null ) {
							System.out.println(user);
							return;
						}
						else {
							System.out.println("User does not exist!!");
							printHelp();
						}
					}
				}
				else {
					System.out.println("Insufficient Arguments!!!");
					printHelp();
					return;
				}
			}
			else if(command.compareTo("user") == 0 && subCommand.compareTo("change") == 0) {
				if(args.length == 18) {
					if(args[2].compareTo("--user_id")==0 &&
							args[4].compareTo("--first_name")==0 &&
							args[6].compareTo("--last_name")==0 && 
							args[8].compareTo("--email")==0 &&
							args[10].compareTo("--cc_number")==0 &&
							args[12].compareTo("--expiration_date")==0 &&
							args[14].compareTo("--security_code")==0 &&
							args[16].compareTo("--phone")==0) {
						User updateUser = new User();
						updateUser.setUserId(Integer.parseInt(args[3]));
						updateUser.setFirstName(args[5]);
						updateUser.setLastName(args[7]);
						updateUser.setEmail(args[9]);
						updateUser.setCcNumber(args[11]);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
						try {
							updateUser.setCcExpiryDate(sdf.parse(args[13]));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						updateUser.setSecurityCode(Integer.parseInt(args[15]));
						updateUser.setPhone(args[17]);
						
						User existingUser = userFacilitator.getUserById(updateUser.getUserId());
						if(existingUser != null) {
							userFacilitator.changeUserDetails(updateUser);
							System.out.println("User Updated Successfully!!");
							System.out.println(userFacilitator.getUserById(updateUser.getUserId()));
							return;
						}
						else {
							System.out.println("User "+ updateUser + " does not exist!!");
							printHelp();
							return;
						}
						
					}
					else{
						System.out.println("Invaild Arguments!!!");
						printHelp();
						return;
					}
						
				}
				else {
					System.out.println("Insufficient Arguments!!!");
					printHelp();
					return;
				}
			}
		}
	}
	
	public static void printHelp() {
		System.out.println("Hostel User Usage:");
		System.out.println("  user add --first_name <User's First Name> --last_name <User's Last Name> --email <Email Id>"
				+ "\n  --cc_number <Credit Card Number> --expiration_date <Credit Card Exiry Date>"
				+ "\n  --security_code <Credit Card Security Code> --phone_number <Phone Number>"
				+ "\n : Adds the user details");
		System.out.println("  user change --user_id <User Id> --first_name <User's First Name> --last_name <User's Last Name> --email <Email Id>"
				+ "\n  --cc_number <Credit Card Number> --expiration_date <Credit Card Exiry Date>"
				+ "\n  --security_code <Credit Card Security Code> --phone_number <Phone Number>"
				+ "\n  :Update user details");
		System.out.println("  user view --user_id <User Id> : Displays a particular User Information");
	}
}
