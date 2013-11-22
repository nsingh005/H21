package cs445.project.structs.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cs445.project.base.Address;
import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.base.Contact;
import cs445.project.base.Hostel;
import cs445.project.base.Policy;
import cs445.project.structs.Occupancy;

public class OccupancyTest {

	@Test
	public void testOccupancy_1()
		throws Exception {

		Occupancy result = new Occupancy();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Occupancy [bedsBooked=null, bedsAvailable=null, occupancyRate=0.0%]", result.toString());
		assertEquals(null, result.getHostel());
		assertEquals(0.0, result.getOccupancyRate(), 1.0);
		assertEquals(null, result.getBedsAvailable());
		assertEquals(null, result.getBedsBooked());
	}

	@Test
	public void testOccupancy_2()
		throws Exception {
		Hostel hostel = new Hostel();
		Integer bedsBooked = new Integer(1);
		Integer bedsAvailable = new Integer(1);
		double occupancyRate = 1.0;

		Occupancy result = new Occupancy(hostel, bedsBooked, bedsAvailable, occupancyRate);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Occupancy [bedsBooked=1, bedsAvailable=1, occupancyRate=1.0%]", result.toString());
		assertEquals(1.0, result.getOccupancyRate(), 1.0);
		assertEquals(new Integer(1), result.getBedsAvailable());
		assertEquals(new Integer(1), result.getBedsBooked());
	}

	@Test
	public void testCalculateOccupancy_1()
		throws Exception {
		Hostel hostel = createHostelListWithBookings(BedState.BOOKED);
		Occupancy fixture = new Occupancy(hostel, new Integer(1), new Integer(1), 1.0);
		
		fixture.calculateOccupancy();
		
		assertEquals(50.0, fixture.getOccupancyRate(),0.0);

	}

	@Test
	public void testCalculateOccupancy_2()
		throws Exception {
		Hostel hostel = createHostelListWithBookings(BedState.AVAILABLE);
		Occupancy fixture = new Occupancy(hostel, new Integer(1), new Integer(1), 1.0);

		fixture.calculateOccupancy();
		
		assertEquals(0.0, fixture.getOccupancyRate(),0.0);
	}

	private Hostel  createHostelListWithBookings(BedState state){
		
		Address address = new Address(1, "123 Main Street", "Anytown", "Anystate", "10456-7890", "USA");
		Contact contact = new Contact(1, "+1-555-555-5555", "romantic@hostel21.com", "hostel21-romantic", "romantic.hostel21.com");
		Policy policy = new Policy(1, "14:00", "11:00", false, false, 48, 75);
		List<Bed> beds = new ArrayList<Bed>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null,b2 = null,b3 = null,b4 = null;
		try {
			 b1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, BedState.AVAILABLE);
			 b2 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, state);
			 b3 = new Bed(1, sdf.parse("20140701"), 1, 3, 14, BedState.AVAILABLE);
			 b4 = new Bed(1, sdf.parse("20140701"), 1, 4, 14, state);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beds.add(b1);
		beds.add(b2);
		beds.add(b3);
		beds.add(b4);		
		Hostel hostel = new Hostel(1, "Hostel 21 - Romantic", address, contact, policy, beds);
		
		return hostel;	
	}
	
	
	@Test
	public void testEquals_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);
		Object obj = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	@Test
	public void testEquals_2()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_3()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);
		Object obj = new Occupancy(new Hostel(), new Integer(2), new Integer(1), 1.0);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_5()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(2), 1.0);
		Object obj = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_6()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.1);
		Object obj = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_7()
		throws Exception {
		Occupancy fixture = new Occupancy((Hostel) null, (Integer) null, (Integer) null, 1.0);
		Object obj = new Occupancy(new Hostel(), (Integer) null, (Integer) null, 1.0);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_8()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), null, new Integer(1), 1.0);
		Object obj = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testGetBedsAvailable_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		Integer result = fixture.getBedsAvailable();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetBedsBooked_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		Integer result = fixture.getBedsBooked();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetHostel_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		Hostel result = fixture.getHostel();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Hostel [name=null, hostelId=null, address=null, contact=null, policy=null]", result.toString());
		assertEquals(null, result.getAddress());
		assertEquals(null, result.getName());
		assertEquals(null, result.getPolicy());
		assertEquals(null, result.getContact());
		assertEquals(null, result.getHostelId());
		assertEquals(null, result.getBeds());
	}

	@Test
	public void testGetOccupancyRate_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		double result = fixture.getOccupancyRate();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	@Test
	public void testHashCode_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), (Integer) null, 1.0);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1961121411, result);
	}

	@Test
	public void testHashCode_2()
		throws Exception {
		Occupancy fixture = new Occupancy((Hostel) null, (Integer) null, new Integer(1), 1.0);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1073646560, result);
	}

	@Test
	public void testSetBedsAvailable_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);
		Integer bedsAvailable = new Integer(1);

		fixture.setBedsAvailable(bedsAvailable);

		// add additional test code here
	}

	@Test
	public void testSetBedsBooked_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);
		Integer bedsBooked = new Integer(1);

		fixture.setBedsBooked(bedsBooked);

		// add additional test code here
	}

	@Test
	public void testSetHostel_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);
		Hostel hostel = new Hostel();

		fixture.setHostel(hostel);

		// add additional test code here
	}

	@Test
	public void testSetOccupancyRate_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);
		double occupancyRate = 1.0;

		fixture.setOccupancyRate(occupancyRate);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		Occupancy fixture = new Occupancy(new Hostel(), new Integer(1), new Integer(1), 1.0);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Occupancy [bedsBooked=1, bedsAvailable=1, occupancyRate=1.0%]", result);
	}


}
