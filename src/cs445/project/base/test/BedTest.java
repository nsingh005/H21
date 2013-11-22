package cs445.project.base.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

import cs445.project.base.Bed;
import cs445.project.base.BedState;

public class BedTest {

	@Test
	public void testBed_1()
		throws Exception {

		Bed result = new Bed();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getState());
		assertEquals(null, result.getDate());
		assertEquals(null, result.getRoomNumber());
		assertEquals(null, result.getBedNumber());
		assertEquals(null, result.getPrice());
		assertEquals(null, result.getHostelId());
	}


	@Test
	public void testBed_2()
		throws Exception {
		Integer hostelId = new Integer(1);
		Date date = new Date();
		Integer roomNumber = new Integer(1);
		Integer bedNumber = new Integer(1);
		Integer price = new Integer(1);
		BedState state = BedState.AVAILABLE;

		Bed result = new Bed(hostelId, date, roomNumber, bedNumber, price, state);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Bed [date=2013/11/22, roomNumber=1, bedNumber=1, price=1, state=AVAILABLE]", result.toString());
		assertEquals(new Integer(1), result.getRoomNumber());
		assertEquals(new Integer(1), result.getBedNumber());
		assertEquals(new Integer(1), result.getPrice());
		assertEquals(new Integer(1), result.getHostelId());
	}


	@Test
	public void testEquals_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Object obj = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}


	@Test
	public void testEquals_2()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}


	@Test
	public void testEquals_3()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}


	@Test
	public void testEquals_4()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), null, new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Object obj = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}


	@Test
	public void testEquals_5()
		throws Exception {
		Date date = new Date();
		Bed fixture = new Bed(new Integer(1), date, new Integer(2), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Object obj = new Bed(new Integer(1), date, new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}


	@Test
	public void testEquals_6()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(2), new Integer(1), BedState.AVAILABLE);
		Object obj = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}


	@Test
	public void testEquals_7()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(2), BedState.AVAILABLE);
		Object obj = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_8()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), null, new Integer(1), new Integer(1), BedState.AVAILABLE);
		Object obj = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_9()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), null, new Integer(1), BedState.AVAILABLE);
		Object obj = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_10()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), null, BedState.AVAILABLE);
		Object obj = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}
	
	@Test
	public void testGetBedNumber_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		Integer result = fixture.getBedNumber();

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
	public void testGetDate_1()
		throws Exception {
		Date date = new Date();
		Bed fixture = new Bed(new Integer(1), date, new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		Date result = fixture.getDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}


	@Test
	public void testGetHostelId_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

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
	public void testGetPrice_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		Integer result = fixture.getPrice();

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
	public void testGetRoomNumber_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		Integer result = fixture.getRoomNumber();

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
	public void testGetState_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		BedState result = fixture.getState();

		// add additional test code here
		assertNotNull(result);
		assertEquals("AVAILABLE", result.name());
		assertEquals("AVAILABLE", result.toString());
		assertEquals(0, result.ordinal());
	}


	@Test
	public void testHashCode_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), (Date) null, new Integer(1), (Integer) null, new Integer(1), BedState.AVAILABLE);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(923553, result);
	}

	@Test
	public void testSetBedNumber_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Integer bedNumber = new Integer(1);

		fixture.setBedNumber(bedNumber);

		// add additional test code here
	}

	@Test
	public void testSetDate_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Date date = new Date();

		fixture.setDate(date);

		// add additional test code here
	}

	@Test
	public void testSetHostelId_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Integer hostelId = new Integer(1);

		fixture.setHostelId(hostelId);

		// add additional test code here
	}

	@Test
	public void testSetPrice_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Integer price = new Integer(1);

		fixture.setPrice(price);

		// add additional test code here
	}

	@Test
	public void testSetRoomNumber_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		Integer roomNumber = new Integer(1);

		fixture.setRoomNumber(roomNumber);

		// add additional test code here
	}

	@Test
	public void testSetState_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);
		BedState state = BedState.AVAILABLE;

		fixture.setState(state);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		Bed fixture = new Bed(new Integer(1), new Date(), new Integer(1), new Integer(1), new Integer(1), BedState.AVAILABLE);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Bed [date=2013/11/22, roomNumber=1, bedNumber=1, price=1, state=AVAILABLE]", result);
	}

}
