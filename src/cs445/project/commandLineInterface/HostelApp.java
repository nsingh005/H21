package cs445.project.commandLineInterface;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.Hostel;
import cs445.project.facilitator.Admin;
import cs445.project.facilitator.DBSaveRestore;

public class HostelApp {
	public static void main(String args[]){
		
		  if(args.length < 1) {
			  System.out.println("Insufficient number of arguments");
			  return;
		  }
		  
		  List<Hostel> hostels= null;
		  Admin admin = new Admin();
		  hostels = admin.loadXML(new File(args[0]));
		  
		  DBSaveRestore dbSaveRestore = new DBSaveRestore();
		  
		  //dbSaveRestore.addHostelList(hostels);
		  
		  List<Hostel> savedHostelList = dbSaveRestore.getHostelList();
		  for(Hostel hostel1 : savedHostelList) {
			  for(Hostel hostel2 : hostels)
			  if(hostel1.equals(hostel2))
			  {
				  System.out.println("Same Hostel Data");
			  }
			  else {
				  if(hostel1.getName().compareTo(hostel2.getName()) == 0){
					  System.out.println("Hostel Data differs!! Updating hostel Data");
					  hostel2.setAllIds(hostel1);
					  dbSaveRestore.updateHostel(hostel2);
				  }
			  }				  
		  }
		  
		  savedHostelList = dbSaveRestore.getHostelList();
		  for(Hostel hostel : savedHostelList) {
			  System.out.println(hostel);
			  if(hostel.getAddress().getCity().compareTo("Anytown") == 0) {
				  for(Bed bed:hostel.getBeds()) {
					  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					  Date date = null;
					  try {
							date = sdf.parse("20140701");
					  } catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					  }
					  if(bed.getBedNumber()==1 && bed.getRoomNumber()==1 && bed.getDate().compareTo(date) ==0) {
						  //bed.setPrice(18);
					  }
				  }
			  }
		  }		  
		  
		  //dbSaveRestore.updateHostelList(savedHostelList);		  
	}
}
