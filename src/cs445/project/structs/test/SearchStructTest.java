package cs445.project.structs.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

import cs445.project.structs.SearchStruct;

public class SearchStructTest {

	@Test
	public void testGetCity_1()
		throws Exception {
		SearchStruct fixture = new SearchStruct();
		fixture.setNumberOfBeds(new Integer(1));
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setCity("");

		String result = fixture.getCity();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetEndDate_1()
		throws Exception {
		Date date = new Date();
		SearchStruct fixture = new SearchStruct();
		fixture.setNumberOfBeds(new Integer(1));
		fixture.setEndDate(date);
		fixture.setStartDate(date);
		fixture.setCity("");

		Date result = fixture.getEndDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetNumberOfBeds_1()
		throws Exception {
		SearchStruct fixture = new SearchStruct();
		fixture.setNumberOfBeds(new Integer(1));
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setCity("");

		Integer result = fixture.getNumberOfBeds();

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
		SearchStruct fixture = new SearchStruct();
		fixture.setNumberOfBeds(new Integer(1));
		fixture.setEndDate(new Date());
		fixture.setStartDate(date);
		fixture.setCity("");

		Date result = fixture.getStartDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testSetCity_1()
		throws Exception {
		SearchStruct fixture = new SearchStruct();
		fixture.setNumberOfBeds(new Integer(1));
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setCity("");
		String city = "";

		fixture.setCity(city);

		// add additional test code here
	}

	@Test
	public void testSetEndDate_1()
		throws Exception {
		SearchStruct fixture = new SearchStruct();
		fixture.setNumberOfBeds(new Integer(1));
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setCity("");
		Date endDate = new Date();

		fixture.setEndDate(endDate);

		// add additional test code here
	}

	@Test
	public void testSetNumberOfBeds_1()
		throws Exception {
		SearchStruct fixture = new SearchStruct();
		fixture.setNumberOfBeds(new Integer(1));
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setCity("");
		Integer numberOfBeds = new Integer(1);

		fixture.setNumberOfBeds(numberOfBeds);

		// add additional test code here
	}

	@Test
	public void testSetStartDate_1()
		throws Exception {
		SearchStruct fixture = new SearchStruct();
		fixture.setNumberOfBeds(new Integer(1));
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setCity("");
		Date startDate = new Date();

		fixture.setStartDate(startDate);

		// add additional test code here
	}

}
