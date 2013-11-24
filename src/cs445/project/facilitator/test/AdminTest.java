package cs445.project.facilitator.test;

import static org.junit.Assert.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cs445.project.base.Address;
import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.base.Booking;
import cs445.project.base.Contact;
import cs445.project.base.Hostel;
import cs445.project.base.Policy;
import cs445.project.facilitator.AdminFacilitator;
import cs445.project.structs.Occupancy;

public class AdminTest {
	AdminFacilitator adminFacilitator;
	
	@Before
	public void beforeTest() {
		adminFacilitator = new AdminFacilitator();
	}
	
	@Test
	public void testLoadValidXML() {
		File xmlFile = new File("sampleHostel.xml");
		List<Hostel> readHostels = adminFacilitator.loadXML(xmlFile);
		List<Hostel> expectedHostels = createHostelList(false);
		assertEquals(readHostels.get(0), expectedHostels.get(0));		
	}
	
	@Test
	public void testLoadValidXML1() {
		File xmlFile = new File("sampleHostel1.xml");
		List<Hostel> readHostels = adminFacilitator.loadXML(xmlFile);
		List<Hostel> expectedHostels = createHostelList(true);
		assertEquals(readHostels.get(0), expectedHostels.get(0));		
	}
	
	@Test
	public void testLoadValidXML2() {
		File xmlFile = new File("sampleHostel2.xml");
		List<Hostel> readHostels = adminFacilitator.loadXML(xmlFile);
		List<Hostel> expectedHostels = createHostelList(false);
		assertEquals(readHostels.get(0), expectedHostels.get(0));		
	}
	
	@Test
	public void testLoadInvalidXML() {
		File xmlFile = new File("invalid.xml");
		List<Hostel> readHostels = adminFacilitator.loadXML(xmlFile);
		
		assertEquals(readHostels, null);		
	}
	
	@Test
	public void testAllHostelOccupancy() {
		List<Hostel> hostels = createHostelListWithBookings(BedState.BOOKED);
		List<Occupancy> actualOccupancy = adminFacilitator.getOccupancyForAllHostels(hostels);
		
		assertEquals((double)50,actualOccupancy.get(0).getOccupancyRate(),0);
		assertEquals((double)100,actualOccupancy.get(1).getOccupancyRate(),0);
	}
	
	@Test
	public void testSingleHostelOccupancy() {
		List<Hostel> hostels = createHostelListWithBookings(BedState.BOOKED);
		Occupancy actualOccupancy = adminFacilitator.getOccupancyByHostel(hostels.get(0));
		
		assertEquals((double)50,actualOccupancy.getOccupancyRate(),0);		
	}
	
	@Test
	public void testCalculateRevenue(){
		List<Booking> bookings = createBookingList();
		Integer revenue = adminFacilitator.calculateRevenue(bookings);
		
		assertEquals((Integer)55, revenue);
	}
	
	
	private List<Booking> createBookingList(){
		List<Booking> bookings = new ArrayList<Booking>();
		
		Booking booking1 = new Booking();
		booking1.setTotalPrice(25);
		Booking booking2 = new Booking();
		booking2.setTotalPrice(30);
		
		bookings.add(booking1);
		bookings.add(booking2);
		
		return bookings;
	}
	
	private List<Hostel>  createHostelListWithBookings(BedState state){
		List<Hostel> hostels = new ArrayList<Hostel>();
		
		Address address = new Address(1, "123 Main Street", "Anytown", "Anystate", "10456-7890", "USA");
		Contact contact = new Contact(1, "+1-555-555-5555", "romantic@hostel21.com", "hostel21-romantic", "romantic.hostel21.com");
		Policy policy = new Policy(1, "14:00", "11:00", false, false, 48, 75);
		List<Bed> beds = new ArrayList<Bed>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null,b2 = null;
		try {
			 b1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, BedState.AVAILABLE);
			 b2 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, state);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beds.add(b1);
		beds.add(b2);
		
		Hostel hostel = new Hostel(1, "Hostel 21 - Romantic", address, contact, policy, beds);
		hostels.add(hostel);
		
		Address address1 = new Address(1, "125 Main Street", "Anytown", "Anystate", "10456-7890", "USA");
		Contact contact1 = new Contact(1, "+1-555-555-5555", "romantic@hostel21.com", "hostel21-romantic", "romantic.hostel21.com");
		Policy policy1 = new Policy(1, "14:00", "11:00", false, false, 48, 75);
		List<Bed> beds1 = new ArrayList<Bed>();
		
		Bed bd1 = null,bd2 = null;
		try {
			 bd1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, state);
			 bd2 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, state);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beds1.add(bd1);
		beds1.add(bd2);
		
		Hostel hostel1 = new Hostel(1, "Hostel 21 - Happy", address1, contact1, policy1, beds1);
		hostels.add(hostel1);
		
		return hostels;	
	}
	
	private List<Hostel> createHostelList(boolean flag){
		List<Hostel> hostels = new ArrayList<Hostel>();
		
		Address address = new Address(null, "123 Main Street", "Anytown", "Anystate", "10456-7890", "USA");
		Contact contact = new Contact(null, "+1-555-555-5555", "romantic@hostel21.com", "hostel21-romantic", "romantic.hostel21.com");
		Policy policy = new Policy(null, "14:00", "11:00", flag, flag, 48, 75);
		List<Bed> beds = new ArrayList<Bed>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null,b2 = null;
		try {
			 b1 = new Bed(null, sdf.parse("20140701"), 1, 1, 15, BedState.AVAILABLE);
			 b2 = new Bed(null, sdf.parse("20140701"), 1, 2, 14, BedState.AVAILABLE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beds.add(b1);
		beds.add(b2);
		
		Hostel hostel = new Hostel(null, "Hostel 21 - Romantic", address, contact, policy, beds);
		hostels.add(hostel);
		
		return hostels;
				
	}

}
