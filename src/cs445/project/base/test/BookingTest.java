package cs445.project.base.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date startDate = sdf.parse("2013/11/22");
		Date endDate = sdf.parse("2013/11/23");
		Integer totalPrice = new Integer(1);
		BookingState state = BookingState.BOOKED;

		Booking result = new Booking(bookingId, userId, hostelId, hostelName, beds, startDate, endDate, totalPrice, state);

		assertNotNull(result);
		assertEquals("Booking [bookingId=1, userId=1, hostelId=1, hostelName=, beds=[], startDate=2013/11/22, endDate=2013/11/23, totalPrice=1, state=BOOKED]", result.toString());
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

		assertNotNull(result);
		assertEquals(0, result.size());
	}


	@Test
	public void testGetBookingId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		Integer result = fixture.getBookingId();

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


		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetHostelId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		Integer result = fixture.getHostelId();


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


		assertEquals("", result);
	}

	@Test
	public void testGetStartDate_1()
		throws Exception {
		Date date = new Date();;
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), date, new Date(), new Integer(1), BookingState.BOOKED);

		Date result = fixture.getStartDate();

		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetState_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);

		BookingState result = fixture.getState();

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

	}

	@Test
	public void testSetHostelId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Integer hostelId = new Integer(1);

		fixture.setHostelId(hostelId);

	}

	@Test
	public void testSetHostelName_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		String hostelName = "";

		fixture.setHostelName(hostelName);

	}

	@Test
	public void testSetStartDate_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Date startDate = new Date();

		fixture.setStartDate(startDate);

	}

	@Test
	public void testSetState_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		BookingState state = BookingState.BOOKED;

		fixture.setState(state);

	}

	@Test
	public void testSetTotalPrice_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Integer totalPrice = new Integer(1);

		fixture.setTotalPrice(totalPrice);

	}

	@Test
	public void testSetUserId_1()
		throws Exception {
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		Integer userId = new Integer(1);

		fixture.setUserId(userId);

	}

	@Test
	public void testToString_1()
		throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = sdf.parse("2013/11/22");
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", new LinkedList<Bed>(), date,date, new Integer(1), BookingState.BOOKED);

		String result = fixture.toString();


		assertEquals("Booking [bookingId=1, userId=1, hostelId=1, hostelName=, beds=[], startDate=2013/11/22, endDate=2013/11/22, totalPrice=1, state=BOOKED]", result);
	}

	@Test
	public void testUpdateBedStatus_1()
		throws Exception {
		List<Bed> beds = new LinkedList<Bed>();
		Bed b1 = new Bed();
		beds.add(b1);
		Booking fixture = new Booking(new Integer(1), new Integer(1), new Integer(1), "", beds, new Date(), new Date(), new Integer(1), BookingState.BOOKED);
		BedState state = BedState.BOOKED;

		fixture.updateBedStatus(state);
	}

}
