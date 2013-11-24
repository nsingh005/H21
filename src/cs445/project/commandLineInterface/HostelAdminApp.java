package cs445.project.commandLineInterface;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cs445.project.base.Booking;
import cs445.project.base.Hostel;
import cs445.project.facilitator.AdminFacilitator;
import cs445.project.facilitator.DBSaveRestore;
import cs445.project.structs.Occupancy;
import cs445.project.structs.Revenue;


public class HostelAdminApp {
	public static void adminApp(String args[]){
		
		if(args.length < 2) {
			System.out.println("Insufficient arguments!!");
			printHelp();
			return;
		}
		
		String command = args[0];
		String subCommand = args[1];
		String xmlFile = null;
		
		if(command.compareTo("admin") == 0 && subCommand.compareTo("load") ==0) {
			if(args.length == 4) {
				if(args[2].compareTo("--file") == 0) {
					xmlFile = args[3];
					
				    List<Hostel> hostels = null;
				    AdminFacilitator adminFacilitator = new AdminFacilitator();
				    DBSaveRestore dbSaveRestore = new DBSaveRestore();
				    hostels = adminFacilitator.loadXML(new File(xmlFile));
				    if(hostels.size() != 0) {
				    	dbSaveRestore.loadUpdateHostelList(hostels);
					    System.out.println("Data loaded successfully!!");
					    return;
				    }
				    else{
				    	System.out.println("Failed to load the XML file!!");
				    	return;
				    }
				}
				else {
					System.out.println("Invalid argument!!");
					printHelp();
					return;
				}
			}
			else{
				System.out.println("Insufficient number of arguments");
				printHelp();
				return;
			}				
		}
		else if (command.compareTo("admin") == 0 && subCommand.compareTo("revenue") ==0) {
			AdminFacilitator adminFacilitator = new AdminFacilitator();
			DBSaveRestore dbSaveRestore = new DBSaveRestore();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			if(args.length >= 7) {
				if(args[2].compareTo("all")==0 &&
						args[3].compareTo("--start_date") == 0 &&
						args[5].compareTo("--end_date") == 0) {
					Date startDate = null;
					Date endDate = null;
					try {
						startDate = sdf.parse(args[4]);
						endDate = sdf.parse(args[6]);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					List<Hostel> hostels = dbSaveRestore.getHostelList();
					if(hostels.size() !=0){
						for(Hostel hostel : hostels){
							List<Booking> bookings = dbSaveRestore.getHostelBookings(hostel.getHostelId(),startDate,endDate);
							if(bookings.size() != 0){
								Revenue revenue = new Revenue(hostel, startDate, endDate, adminFacilitator.calculateRevenue(bookings));
							
								System.out.println("Hostel: "+ revenue.getHostel());
								System.out.println(revenue);			
							}
							else {
								System.out.println("No Bookings found for the "+ hostel.getName() +". So revenue is ZERO");
							}
						}
						return;
					}
					else {
						System.out.println("No Hostel Data present!!");
						return;
					}
				}
				else if (args[2].compareTo("--hostel_id") == 0) {
					if(args.length == 8){
						if(args[4].compareTo("--start_date")==0 &&
								args[6].compareTo("--end_date")==0) {
							
							Date startDate = null;
							Date endDate = null;
							Integer hostelId = Integer.parseInt(args[3]);
							try {
								startDate = sdf.parse(args[5]);
								endDate = sdf.parse(args[7]);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}			
							
							Hostel hostel = dbSaveRestore.getHostelById(hostelId);
							if(hostel != null){
								List<Booking> bookings = dbSaveRestore.getHostelBookings(hostelId,startDate,endDate);
								if(bookings.size() !=0){
									Revenue revenue = new Revenue(hostel, startDate, endDate, adminFacilitator.calculateRevenue(bookings));
									
									System.out.println("Hostel: "+ revenue.getHostel());
									System.out.println(revenue);
									return;
								}
								else {
									System.out.println("No Bookings found for the specied period!! So revenue is ZERO");
									return;
								}
							}
							else {
								System.out.println("Hostel Id: "+ hostelId +" doesn't exist!!");
								System.out.println("Please enter a valid hostelId.");
								return;
							}
								
						}
						else{
							System.out.println("Invalid argument!!");
							printHelp();
							return;
						}
							
					}
					else{
						System.out.println("Insufficient number of arguments");
						printHelp();
						return;
					}					
				}
				else {
					System.out.println("Invalid argument!!");
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
		else if (command.compareTo("admin") == 0 && subCommand.compareTo("occupancy") ==0) {
			AdminFacilitator adminFacilitator = new AdminFacilitator();
			DBSaveRestore dbSaveRestore = new DBSaveRestore();
			if(args.length >= 3) {
				if(args[2].compareTo("all")==0) {
					List<Hostel> hostels = dbSaveRestore.getHostelList();
					if(hostels.size() != 0) {
						//Get the occupancy for all the hostels
						List<Occupancy> occupancy = adminFacilitator.getOccupancyForAllHostels(hostels);
						if(occupancy.size() != 0){
							for(Occupancy o: occupancy){
								System.out.println("Hostel: "+ o.getHostel());
								System.out.println(o);
							}
						}
						else {
							System.out.println("ZERO Occupancy Rate!!");
						}
						return;
					}
					else{
						System.out.println("No Hostel data present!!");
						return;
					}
				}
				else if (args[2].compareTo("--hostel_id") == 0) {
					//Get the occupancy of a particular hostel
					if(args.length == 4) {
						Integer hostelId = Integer.parseInt(args[3]);
						Hostel hostel = dbSaveRestore.getHostelById(hostelId);
						if(hostel != null) {
							Occupancy occupancy = adminFacilitator.getOccupancyByHostel(hostel);
							if(occupancy != null){
								System.out.println("Hostel: "+ occupancy.getHostel());
								System.out.println(occupancy);
								return;	
							}
							else {
								System.out.println("ZERO Occupancy Rate!!");
								return;
							}					
						}
						else{
							System.out.println("Hostel Id: "+ hostelId +" doesn't exist!!");
							System.out.println("Please enter a valid hostelId.");
							return;
						}							
					}
					else {
						System.out.println("Insufficient Arguments Passed!!");
						printHelp();
						return;
					}
				}
				else {
					System.out.println("Invalid argument!!");
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
		else if (command.compareTo("admin") == 0 && subCommand.compareTo("view") ==0){
			DBSaveRestore dbSaveRestore = new DBSaveRestore();
			if(args.length >= 3) {
				if(args[2].compareTo("all")==0) {
					//Get the list of all the hostels
					List<Hostel> hostels = dbSaveRestore.getHostelList();
					if(hostels.size() != 0) {
						for(Hostel h : hostels) {
							System.out.println("Hostel: "+ h);
							System.out.println(h.getBeds());
						}
					}
					else {
						System.out.println("No Hostels present!!");
					}
					return;
				}
				else if (args[2].compareTo("--hostel_id") == 0) {
					//Get the details of a particular hostel
					if(args.length == 4) {
						Integer hostelId = Integer.parseInt(args[3]);
						Hostel hostel = dbSaveRestore.getHostelById(hostelId);
						if(hostel != null) {
							System.out.println("Hostel: "+ hostel);
							System.out.println(hostel.getBeds());
							return;
						}
						else{
							System.out.println("Invalid Hostel Id passed!!");
							return;
						}
					}
					else {
						System.out.println("Insufficient Arguments Passed!!");
						printHelp();
						return;
					}
				}
				else {
					System.out.println("Invalid argument!!");
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
	}
	
	public static void printHelp(){
		System.out.println("Hostel Admin Usage:");
		System.out.println("  admin load --file <XML file name> : Loads/Updates the hostel inventory");
		System.out.println("  admin revenue all --start_date <revenue_start_date> --end_date <revenue_end_date> "
				+ ": Displays the revnue for all the hostels for the specefied date range");
		System.out.println("  admin revenue --hostel_id <hostel ID> --start_date <revenue_start_date> --end_date <revenue_end_date> "
				+ ": Displays the revnue for the specific hostel for the specefied date range");
		System.out.println("  admin occupancy all : Displays occupancy for all the hostels.");
		System.out.println("  admin occupancy --hostel_id : Displays occupancy for the specific hostel.");
		System.out.println("  admin view all : Displays details of all the hostels.");
		System.out.println("  admin view --hostel_id <hostel id> : Displays the details of a particular hostel");		
	}

}
