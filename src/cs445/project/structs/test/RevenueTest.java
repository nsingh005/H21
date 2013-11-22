package cs445.project.structs.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

import cs445.project.base.Hostel;
import cs445.project.structs.Revenue;

public class RevenueTest {

	@Test
	public void testRevenue_1()
		throws Exception {
		Hostel hostel = new Hostel();
		Date startDate = new Date();
		Date endDate = new Date();
		Integer revenue = new Integer(1);

		Revenue result = new Revenue(hostel, startDate, endDate, revenue);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Revenue [startDate=2013/11/22, endDate=2013/11/22, revenue=1]", result.toString());
		assertEquals(new Integer(1), result.getRevenue());
	}

	@Test
	public void testGetEndDate_1()
		throws Exception {
		Date date = new Date();
		Revenue fixture = new Revenue(new Hostel(), new Date(), date, new Integer(1));

		Date result = fixture.getEndDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetHostel_1()
		throws Exception {
		Revenue fixture = new Revenue(new Hostel(), new Date(), new Date(), new Integer(1));

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
	public void testGetRevenue_1()
		throws Exception {
		Revenue fixture = new Revenue(new Hostel(), new Date(), new Date(), new Integer(1));

		Integer result = fixture.getRevenue();

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
	public void testGetStartDate_1()
		throws Exception {
		Date date = new Date();
		Revenue fixture = new Revenue(new Hostel(), date, new Date(), new Integer(1));

		Date result = fixture.getStartDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testSetEndDate_1()
		throws Exception {
		Revenue fixture = new Revenue(new Hostel(), new Date(), new Date(), new Integer(1));
		Date endDate = new Date();

		fixture.setEndDate(endDate);

		// add additional test code here
	}

	@Test
	public void testSetHostel_1()
		throws Exception {
		Revenue fixture = new Revenue(new Hostel(), new Date(), new Date(), new Integer(1));
		Hostel hostel = new Hostel();

		fixture.setHostel(hostel);

		// add additional test code here
	}

	@Test
	public void testSetRevenue_1()
		throws Exception {
		Revenue fixture = new Revenue(new Hostel(), new Date(), new Date(), new Integer(1));
		Integer revenue = new Integer(1);

		fixture.setRevenue(revenue);

		// add additional test code here
	}

	@Test
	public void testSetStartDate_1()
		throws Exception {
		Revenue fixture = new Revenue(new Hostel(), new Date(), new Date(), new Integer(1));
		Date startDate = new Date();

		fixture.setStartDate(startDate);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		Revenue fixture = new Revenue(new Hostel(), new Date(), new Date(), new Integer(1));

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Revenue [startDate=2013/11/22, endDate=2013/11/22, revenue=1]", result);
	}

}
