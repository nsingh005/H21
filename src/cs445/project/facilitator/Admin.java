package cs445.project.facilitator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cs445.project.base.Address;
import cs445.project.base.Bed;
import cs445.project.base.Booking;
import cs445.project.base.Contact;
import cs445.project.base.Hostel;
import cs445.project.base.Policy;
import cs445.project.structs.Occupancy;

public class Admin {

	public  List<Hostel> loadXML(File hostel21_xml) {
		List<Hostel> hostels = new ArrayList<Hostel>();
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(hostel21_xml);
			
			//doc.getDocumentElement().normalize();
			
			NodeList hostelList = doc.getElementsByTagName("hostel");
			if(hostelList.getLength() != 0){
				for (int temp = 0; temp < hostelList.getLength(); temp++) {
					Node nNode = hostelList.item(temp);
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) nNode;
						String name;
						Address address = new Address();
						Contact contact = new Contact();
						Policy policy   = new Policy();
						
						name = eElement.getElementsByTagName("name").item(0).getTextContent();
								
						address.setStreet(eElement.getElementsByTagName("street").item(0).getTextContent());
						address.setCity  (eElement.getElementsByTagName("city").item(0).getTextContent());
						address.setCountry(eElement.getElementsByTagName("country").item(0).getTextContent());
						address.setState(eElement.getElementsByTagName("state").item(0).getTextContent());
						address.setPostalCode(eElement.getElementsByTagName("postal_code").item(0).getTextContent());
						contact.setPhoneNumber(eElement.getElementsByTagName("phone").item(0).getTextContent());
						contact.setEmailId(eElement.getElementsByTagName("email").item(0).getTextContent());
						contact.setFacebookId(eElement.getElementsByTagName("facebook").item(0).getTextContent());
						contact.setWebURL(eElement.getElementsByTagName("web").item(0).getTextContent());
															
						policy.setCheckInTime(eElement.getElementsByTagName("check_in_time").item(0).getTextContent());
						policy.setCheckOutTime(eElement.getElementsByTagName("check_out_time").item(0).getTextContent());
						if(eElement.getElementsByTagName("smoking").item(0).getTextContent().compareTo("N") == 0) {
							policy.setSmoking(false);
						}
						else if(eElement.getElementsByTagName("smoking").item(0).getTextContent().compareTo("Y") == 0) {
							policy.setSmoking(true);
						}
						else {
							policy.setSmoking(false);
						}
						
						if(eElement.getElementsByTagName("alcohol").item(0).getTextContent().compareTo("N") == 0) {
							policy.setAlcohol(false);
						}
						else if(eElement.getElementsByTagName("alcohol").item(0).getTextContent().compareTo("Y") == 0) {
							policy.setAlcohol(true);
						}
						else {
							policy.setAlcohol(false);
						}
						policy.setCancellationDeadline(Integer.parseInt(eElement.getElementsByTagName("cancellation_deadline").item(0).getTextContent()));
						String penalty = eElement.getElementsByTagName("cancellation_penalty").item(0).getTextContent();
						policy.setCancellationPenalty(Integer.parseInt(penalty.replaceAll("%", "")));
											
						NodeList nList = eElement.getElementsByTagName("availability");
						List<Bed> beds = new ArrayList<Bed>();
						for (int temp1 = 0; temp1 < nList.getLength(); temp1++) {
							 
							Node nNode1 = nList.item(temp1);
					 
							if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
					 
								Element eElement1 = (Element) nNode1;
								
								String dateString = eElement1.getElementsByTagName("date").item(0).getTextContent();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
								Date date = sdf.parse(dateString);
								Integer roomNumber = Integer.parseInt(eElement1.getElementsByTagName("room").item(0).getTextContent());
								Integer bedNumber = Integer.parseInt(eElement1.getElementsByTagName("bed").item(0).getTextContent());
								Integer price = Integer.parseInt(eElement1.getElementsByTagName("price").item(0).getTextContent());							
								
								beds.add(new Bed(date,roomNumber,bedNumber,price));
					 
							}
						}
	
						hostels.add(new Hostel(name,address,contact,policy,beds));
					}
				}
			}
			else {
				hostels = null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return hostels;
	}
	
	public List<Occupancy> getOccupancyForAllHostels(List<Hostel> hostels) {

		
		List<Occupancy> hostelOccupancyList = new ArrayList<Occupancy>();
		
		for(Hostel h: hostels) {
			Occupancy hostelOccupancy = new Occupancy();
			hostelOccupancy.setHostel(h);
			hostelOccupancy.calculateOccupancy();
			hostelOccupancyList.add(hostelOccupancy);
		}
		
		return hostelOccupancyList;
		
	}
	
	public Occupancy getOccupancyByHostel(Hostel hostel) {
		
		Occupancy hostelOccupancy = new Occupancy();
		hostelOccupancy.setHostel(hostel);
		hostelOccupancy.calculateOccupancy();
				
		return hostelOccupancy;
	}
	
	public Integer calculateRevenue(List<Booking> bookings){
		Integer revenue=0;
		
		for(Booking b:bookings){
			revenue += b.getTotalPrice();
		}
		
		return revenue;
	}
	
	public List<Booking> getHostelBookings(Integer hostelId,Date startDate,Date endDate){
		DBSaveRestore dbSaveRestore = new DBSaveRestore();
		List<Booking> bookings = dbSaveRestore.getHostelBookings(hostelId,startDate,endDate);
		
		return bookings;
	}
	
	public List<Hostel> getHostelList() {
		List<Hostel> hostels = null;
		DBSaveRestore dbSaveRestore = new DBSaveRestore();
		hostels = dbSaveRestore.getHostelList();
		
		return hostels;
	}	
	
	public Hostel getHostelById(Integer hostelId) {
		Hostel hostel = null;
		
		DBSaveRestore dbSaveRestore = new DBSaveRestore();
		hostel = dbSaveRestore.getHostelById(hostelId);
		
		return hostel;
	}
	
	public void saveHostelList(List<Hostel> hostels){
	    DBSaveRestore dbSaveRestore = new DBSaveRestore();
	    dbSaveRestore.loadUpdateHostelList(hostels);
	}
}
