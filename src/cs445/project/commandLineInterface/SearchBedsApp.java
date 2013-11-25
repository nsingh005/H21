package cs445.project.commandLineInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.Hostel;
import cs445.project.facilitator.DBSaveRestore;
import cs445.project.facilitator.SearchFacilitator;
import cs445.project.structs.AvailableBedInfo;
import cs445.project.structs.SearchGeneric;
import cs445.project.structs.SearchResult;
import cs445.project.structs.SearchStruct;

public class SearchBedsApp {
	public static void searchApp(String args[]) {
		
		String command = args[0];
		SearchStruct searchStruct = new SearchStruct();
		SearchFacilitator searchFacilitator = new SearchFacilitator();
		DBSaveRestore dbSaveRestore = new DBSaveRestore();
		
		if(args.length == 1){
			List<Hostel> hostels = dbSaveRestore.getHostelList();
			printHostelDetails(hostels);
			return;			
		}
		
		if(command.compareTo("search") == 0) {			
			if(args.length == 7){
				if(args[1].compareTo("--city") == 0 &&
						args[3].compareTo("--start_date") == 0 &&
						args[5].compareTo("--end_date") == 0){
					searchStruct.setCity(args[2]);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					searchStruct.setCity(args[2]);
					try {
						searchStruct.setStartDate(sdf.parse(args[4]));
						searchStruct.setEndDate(sdf.parse(args[6]));					
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					List<Hostel> hostels = dbSaveRestore.getAvailableBedsInAllHostels(searchStruct.getStartDate(),searchStruct.getEndDate());
					
					if(hostels != null){
						if(hostels.size() != 0){
							List<SearchGeneric> searchGenericList = searchFacilitator.searchGeneric(searchStruct,hostels);
							printGenericSearchResult(searchGenericList);
						}
						else {
							System.out.println("No hostel Data present!!");
						}
					}
					else {
						System.out.println("Invalid dates entered!!");
					}
					return;
				}
				else {
					System.out.println("Invalid argument!!");
					printHelp();
					return;
				}
			}
			
			if(args.length == 9) {
				if(args[1].compareTo("--city") == 0 && 
						args[3].compareTo("--start_date") == 0 &&
						args[5].compareTo("--end_date") == 0 &&
						args[7].compareTo("--beds") ==0 ) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					searchStruct.setCity(args[2]);
					try {
						searchStruct.setStartDate(sdf.parse(args[4]));
						searchStruct.setEndDate(sdf.parse(args[6]));					
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					searchStruct.setNumberOfBeds(Integer.parseInt(args[8]));
					
					List<Hostel> hostels = 
							dbSaveRestore.getAvailableBedsInAllHostels(searchStruct.getStartDate(),searchStruct.getEndDate());
					if(hostels != null){
						if(hostels.size() != 0){
							
							List<SearchResult> searchResultSet  = searchFacilitator.search(searchStruct,hostels);
							if(searchResultSet != null){
								dbSaveRestore.deleteSearchData();
								dbSaveRestore.addSearchData(searchResultSet);
								printResultSet(searchResultSet);
							}
							else{
								System.out.println("No search results found!!");
							}
								
						}
						else {
							System.out.println("No hostel Data present!!");
						}
					}
					else {
						System.out.println("Invalid dates entered!!");
					}
					return;
				}
				else {
					System.out.println("Invalid argument!!");
					printHelp();
					return;
				}
			}
			else {
				System.out.println("Insufficient number of arguments passed!!");
				printHelp();
				return;
			}
		}
	}
	
	static void printResultSet(List<SearchResult> searchResultSet) {
		String hostelName = new String("");
		
		if(searchResultSet != null) {
			if(searchResultSet.size() != 0) {
				for(SearchResult searchResult :searchResultSet) {
					if(hostelName.compareTo(searchResult.getHostelName()) != 0) {
						System.out.println(searchResult.getHostelName());
						hostelName = searchResult.getHostelName();
					}
					
					String printRoomStr  = "";					
					List<String> addedRoomStr = new ArrayList<String>();
					for(Bed bed: searchResult.getBeds()) {
						String roomString = "room#" + bed.getRoomNumber() + "/bed#" + bed.getBedNumber();
						
						if(addedRoomStr.contains(roomString) == false) {
							printRoomStr += " "+roomString;
							addedRoomStr.add(roomString);
						}
				    }
					
					System.out.println("Search Id: "+ searchResult.getSearchId() + ", Price " + searchResult.getTotalPrice() 
							+ ", " + printRoomStr);
				}
			}
			else {
				System.out.println("No beds found!!");
			}
		}
		else {
			System.out.println("No beds found!!");
		}	
	}
	
	static void printGenericSearchResult(List<SearchGeneric> searchGenericList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		for(SearchGeneric s: searchGenericList){
			System.out.println("Hostel : "+ s.getHostelName()+" Hostel Id: "+ s.getHostelId());
			for(AvailableBedInfo b: s.getAvailableBedInfo()){
				System.out.println(sdf.format(b.getStartDate()) + " to " + sdf.format(b.getEndDate()) + ": " +
			b.getBedsAvailable() + " beds available between " + b.getMinPrice() + " and " + b.getMaxPrice());
			}
		}
		
	}
	static void printHostelDetails(List<Hostel> hostels){
		
		for(Hostel h : hostels){
			System.out.println("Hostel  : " + h.getName());
			System.out.println("Address : " + h.getAddress());
			System.out.println("Contact : " + h.getContact());
			System.out.println("Policy  : " + h.getPolicy());
			
			for(Bed b: h.getBeds()){
				System.out.println(b);
			}
			System.out.println();
		}
	}
	
	static void printHelp() {
		System.out.println("Hostel Bed Search Usage:");
		System.out.println("  search --city <city> --start_date <Start Date> --end_date <End Date> --beds <Number of beds to be booked per day> :  "
				+ "Search the bed in all the Hostels in a city from start date to end date");
	}
}
