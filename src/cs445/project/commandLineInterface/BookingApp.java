package cs445.project.commandLineInterface;

import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.Booking;
import cs445.project.facilitator.BookFacilitator;
import cs445.project.facilitator.DBSaveRestore;

public class BookingApp {
	public static void bookApp(String args[]) {
		if(args.length < 2) {
			System.out.println("Insufficient number of arguments");
			printHelp();
			return;
		}
		
		String command = args[0];
		String subCommand = args[1];
		
		if(command.compareTo("book") == 0 &&
				subCommand.compareTo("add")==0) {
			if(args.length == 6) {
				if(args[2].compareTo("--search_id") ==0 &&
						args[4].compareTo("--user_id") == 0) {
					BookFacilitator bookFacilitator = new BookFacilitator();
					
					Integer searchId = Integer.parseInt(args[3]);
					Integer userId   = Integer.parseInt(args[5]);
					
					Booking booking = bookFacilitator.book(searchId,userId);
					if(booking != null) {
						System.out.println("Congratulations!! Requested Bed has been booked Successfully!!");
						System.out.println(booking);
						System.out.println("User details: " + new DBSaveRestore().getUserById(userId));
						return;
					}
					
				}
				else{
					System.out.println("Invalid arguments passed!!");
					printHelp();
					return;
				}
			}
			else {
				System.out.println("Insufficient number of arguments");
				printHelp();
				return;
			}
		} 
		else if(command.compareTo("book") == 0 &&
				subCommand.compareTo("view")==0) {
			if(args.length ==2){
				BookFacilitator bookFacilitator = new BookFacilitator();
				
				List<Booking> bookingList = bookFacilitator.getAllBookings();
				if(bookingList != null) {
					for(Booking b : bookingList){
						printBooking(b);
						System.out.println("User details: " + new DBSaveRestore().getUserById(b.getUserId()));
						System.out.println("");
					}
				}
				else{
					System.out.println("No bookings available!!");
				}
					
			}
			else if(args.length == 4) {
				if(args[2].compareTo("--booking_id") ==0 ) {
					BookFacilitator bookFacilitator = new BookFacilitator();
					
					Integer bookingId = Integer.parseInt(args[3]);
					
					Booking booking = bookFacilitator.getBookingDetailsById(bookingId);
					if(booking != null) {
						System.out.println("Below are the booking details:");
						printBooking(booking);
						System.out.println("User details: " + new DBSaveRestore().getUserById(booking.getUserId()));
						return;
					}
					else {
						System.out.println("Invalid Booking Id passed!!");
						printHelp();
						return;
					}
					
				}
				else{
					System.out.println("Invalid arguments passed!!");
					printHelp();
					return;
				}
			}
			else {
				System.out.println("Insufficient number of arguments");
				printHelp();
				return;
			}
		}
		else if (command.compareTo("book") == 0 &&
				subCommand.compareTo("cancel")==0) {
			if(args.length == 4) {
				if(args[2].compareTo("--booking_id") ==0 ) {
					BookFacilitator bookFacilitator = new BookFacilitator();
					
					Integer bookingId = Integer.parseInt(args[3]);
					
					Booking booking = bookFacilitator.getBookingDetailsById(bookingId);
					if(booking != null) {
						bookFacilitator.cancelBooking(booking);
						System.out.println("Below booking has been cancelled:");
						System.out.println(booking);
						System.out.println("User details: " + new DBSaveRestore().getUserById(booking.getUserId()));
						return;
					}
					else {
						System.out.println("Invalid Booking Id passed!!");
						printHelp();
						return;
					}					
				}
				else{
					System.out.println("Invalid arguments passed!!");
					printHelp();
					return;
				}
			}
		}
		else{
			System.out.println("Invalid arguments passed!!");
			printHelp();
			return;
		}
	}
	
	private static void printBooking(Booking b){
		System.out.println("Booking Id:" + b.getBookingId() +" User Id: "+ b.getUserId() + " Hostel Id: "+ b.getHostelId());
		System.out.println("Hostel Name: "+ b.getHostelName());
		for(Bed bed: b.getBeds()){
			System.out.println(bed);
		}
	}
	public static void printHelp() {
		System.out.println("Hostel Booking Usage:");
		System.out.println("  book add --search_id <Search Id> --user_id <User Id> : Books the bed as per the "
				+ "previous search for a particular user");
		System.out.println("  book cancel --booking_id <booking_id> : Cancels the booking");
		System.out.println("  book view --booking_id <booking Id> : Displays a particular booking");
	}
}
