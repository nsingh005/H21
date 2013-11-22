package cs445.project.base.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.base.Booking;
import cs445.project.base.BookingState;

public class BookingTest {

	@Test
	public void testBooking_1()
		throws Exception {

		Booking result = new Booking();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getState());
		assertEquals(null, result.getTotalPrice());
		assertEquals(null, result.getHostelName());
		assertEquals(null, result.getEndDate());
		assertEquals(null, result.getStartDate());
		assertEquals(null, result.getHostelId());
		assertEquals(null, result.getBeds());
		assertEquals(null, result.getBookingId());
		assertEquals(null, result.getUserId());
	}

	@Test
	public void testBooking_2()
		throws Exception {
		Integer bookingId = new Integer(1);
		Integer userId = new Integer(1);
		Integer hostelId = new Integer(1);
		String hostelName = "";
		List<Bed> beds = new LinkedList<Bed>();
		Date startDate = new Date();
		Date endDate = new Date();
		Integer totalPrice = new Integer(1);
		BookingState state = BookingState.BOOKED;

		Booking result = new Booking(bookingId, userId, hostelId, hostelName, beds, startDate, endDate, totalPrice, state);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Booking [bookingId=1, userId=1, hostelId=1, hostelName=, beds=[], startDate=2013/11/22, endDate=2013/11/22, totalPrice=1, state=BOOKED]", result.toString());
		assertEquals(new Integer(1), result.getTotalPrice());
		assertEquals("", result.getHostelName());
		assertEquals(new Integer(1), result.getHostelId());
		assertEquals(new Integer(1), result.getBookingId());
		assertEquals(new Integer(1), result.getUserId());
	}

	@Test
	public void testGetBeds_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		List<Bed> result = fixture.getBeds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}


	@Test
	public void testGetBookingId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		Integer result = fixture.getBookingId();

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
	public void testGetEndDate_1()
		throws Exception {
		Date date = new Date();
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), date, date, new Integer(1), BookingState.BOOKED);

		Date result = fixture.getEndDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetHostelId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		Integer result = fixture.getHostelId();

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
	public void testGetHostelName_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		String result = fixture.getHostelName();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetStartDate_1()
		throws Exception {
		Date date = new Date();;
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), date, new Date(), new Integer(1), BookingState.BOOKED);

		Date result = fixture.getStartDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetState_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		BookingState result = fixture.getState();

		// add additional test code here
		assertNotNull(result);
		assertEquals("BOOKED", result.name());
		assertEquals("BOOKED", result.toString());
		assertEquals(0, result.ordinal());
	}

	@Test
	public void testGetTotalPrice_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		Integer result = fixture.getTotalPrice();

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
	public void testGetUserId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		Integer result = fixture.getUserId();

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
	public void testSetBeds_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		List<Bed> beds = new LinkedList<Bed>();

		fixture.setBeds(beds);

		// add additional test code here
	}

	@Test
	public void testSetBookingId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Integer bookingId = new Integer(1);

		fixture.setBookingId(bookingId);

		// add additional test code here
	}

	@Test
	public void testSetEndDate_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Date endDate = new Date();

		fixture.setEndDate(endDate);

		// add additional test code here
	}

	@Test
	public void testSetHostelId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Integer hostelId = new Integer(1);

		fixture.setHostelId(hostelId);

		// add additional test code here
	}

	@Test
	public void testSetHostelName_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		String hostelName = "";

		fixture.setHostelName(hostelName);

		// add additional test code here
	}

	@Test
	public void testSetStartDate_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Date startDate = new Date();

		fixture.setStartDate(startDate);

		// add additional test code here
	}

	@Test
	public void testSetState_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		BookingState state = BookingState.BOOKED;

		fixture.setState(state);

		// add additional test code here
	}

	@Test
	public void testSetTotalPrice_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Integer totalPrice = new Integer(1);

		fixture.setTotalPrice(totalPrice);

		// add additional test code here
	}

	@Test
	public void testSetUserId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Integer userId = new Integer(1);

		fixture.setUserId(userId);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Booking [bookingId=1, userId=1, hostelId=1, hostelName=, beds=[], startDate=2013/11/22, endDate=2013/11/22, totalPrice=1, state=BOOKED]", result);
	}

	@Test
	public void testUpdateBedStatus_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		BedState state = BedState.AVAILABLE;

		fixture.updateBedStatus(state);

		// add additional test code here
	}

	@Test
	public void testUpdateBedStatus_2()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		BedState state = BedState.AVAILABLE;

		fixture.updateBedStatus(state);

		// add additional test code here
	}

}
