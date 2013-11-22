package cs445.project.structs.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

import cs445.project.structs.AvailableBedInfo;

public class AvailableBedInfoTest {

	@Test
	public void testEquals_1()
		throws Exception {
		Date date = new Date();
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(date);
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(date);
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		AvailableBedInfo obj = new AvailableBedInfo();
		obj.setEndDate(date);
		obj.setMaxPrice(new Integer(1));
		obj.setStartDate(date);
		obj.setMinPrice(new Integer(1));
		obj.setBedsAvailable(new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	@Test
	public void testEquals_2()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_3()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		AvailableBedInfo obj = new AvailableBedInfo();
		obj.setBedsAvailable(new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_5()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		AvailableBedInfo obj = new AvailableBedInfo();
		obj.setEndDate(new Date());
		obj.setBedsAvailable(new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_6()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		AvailableBedInfo obj = new AvailableBedInfo();
		obj.setEndDate(new Date());
		obj.setMaxPrice(new Integer(1));
		obj.setBedsAvailable(new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_7()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		AvailableBedInfo obj = new AvailableBedInfo();
		obj.setEndDate(new Date());
		obj.setMaxPrice(new Integer(1));
		obj.setMinPrice(new Integer(1));
		obj.setBedsAvailable(new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_8()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		AvailableBedInfo obj = new AvailableBedInfo();
		obj.setEndDate(new Date());
		obj.setMaxPrice(new Integer(1));
		obj.setStartDate(new Date());
		obj.setMinPrice(new Integer(1));
		obj.setBedsAvailable(new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	@Test
	public void testGetBedsAvailable_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));

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
	public void testGetEndDate_1()
		throws Exception {
		Date date = new Date();
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(date);
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(date);
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));

		Date result = fixture.getEndDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetMaxPrice_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));

		Integer result = fixture.getMaxPrice();

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
	public void testGetMinPrice_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));

		Integer result = fixture.getMinPrice();

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
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(date);
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(date);
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));

		Date result = fixture.getStartDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testSetBedsAvailable_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		Integer bedsAvailable = new Integer(1);

		fixture.setBedsAvailable(bedsAvailable);

		// add additional test code here
	}

	@Test
	public void testSetEndDate_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		Date endDate = new Date();

		fixture.setEndDate(endDate);

		// add additional test code here
	}

	@Test
	public void testSetMaxPrice_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		Integer maxPrice = new Integer(1);

		fixture.setMaxPrice(maxPrice);

		// add additional test code here
	}

	@Test
	public void testSetMinPrice_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		Integer minPrice = new Integer(1);

		fixture.setMinPrice(minPrice);

		// add additional test code here
	}

	@Test
	public void testSetStartDate_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));
		Date startDate = new Date();

		fixture.setStartDate(startDate);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		AvailableBedInfo fixture = new AvailableBedInfo();
		fixture.setEndDate(new Date());
		fixture.setMaxPrice(new Integer(1));
		fixture.setStartDate(new Date());
		fixture.setMinPrice(new Integer(1));
		fixture.setBedsAvailable(new Integer(1));

		String result = fixture.toString();

		// add additional test code here
		assertEquals("AvailableBedInfo [startDate=2013/11/22, endDate=2013/11/22, bedsAvailable=1, maxPrice=1, minPrice=1]", result);
	}

}
