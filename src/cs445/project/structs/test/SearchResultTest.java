package cs445.project.structs.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import cs445.project.base.Address;
import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.structs.SearchResult;

public class SearchResultTest {

	@Test
	public void testEquals_1()
		throws Exception {
		Date date = new Date();
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(date);
		fixture.setStartDate(date);
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		SearchResult obj = new SearchResult();
		obj.setEndDate(date);
		obj.setStartDate(date);
		obj.setHostelId(new Integer(1));
		obj.setHostelName("");
		obj.setTotalPrice(new Integer(1));
		obj.setHostelAddress(new Address());
		obj.setSearchId(new Integer(1));
		obj.setBeds(new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
		assertEquals(true, fixture.equals(fixture));
		assertEquals(fixture.hashCode(),obj.hashCode());
		assertEquals(new SearchResult().hashCode(),new SearchResult().hashCode());
	}

	@Test
	public void testEquals_2()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_3()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(null);
		SearchResult obj = new SearchResult();
		

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
		
		obj.setBeds(new LinkedList<Bed>());
		assertEquals(false, fixture.equals(obj));
		
		List<Bed> beds = new LinkedList<Bed>();
		beds.add(new Bed());
		fixture.setBeds(beds);
		assertEquals(false, fixture.equals(obj));
	}

	@Test
	public void testEquals_5()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(null);
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		SearchResult obj = new SearchResult();
		obj.setEndDate(null);
		obj.setBeds(new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
		
		obj.setEndDate(new Date());
		assertEquals(false,fixture.equals(obj));
	}

	@Test
	public void testEquals_6()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(null);
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		SearchResult obj = new SearchResult();
		obj.setEndDate(new Date());
		obj.setStartDate(null);
		obj.setBeds(new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
		
		obj.setStartDate(new Date());
		assertEquals(false,fixture.equals(obj));
	}

	@Test
	public void testEquals_7()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(null);
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		SearchResult obj = new SearchResult();
		obj.setEndDate(new Date());
		obj.setTotalPrice(null);
		obj.setStartDate(new Date());
		obj.setBeds(new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
		
		obj.setTotalPrice(new Integer(1));
		assertEquals(false,fixture.equals(obj));
	}

	@Test
	public void testEquals_8()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(null);
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		SearchResult obj = new SearchResult();
		obj.setEndDate(new Date());
		obj.setTotalPrice(new Integer(1));
		obj.setStartDate(new Date());
		obj.setBeds(new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_9()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice((Integer) null);
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		SearchResult obj = new SearchResult();
		obj.setEndDate(new Date());
		obj.setTotalPrice(new Integer(1));
		obj.setStartDate(new Date());
		obj.setBeds(new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testGetBeds_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());

		List<Bed> result = fixture.getBeds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetEndDate_1()
		throws Exception {
		Date date = new Date();
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(date);
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());

		Date result = fixture.getEndDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetHostelAddress_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());

		Address result = fixture.getHostelAddress();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Address [street=null, city=null, state=null, postalCode=null, country=null]", result.toString());
		assertEquals(null, result.getState());
		assertEquals(null, result.getCountry());
		assertEquals(null, result.getAddressId());
		assertEquals(null, result.getStreet());
		assertEquals(null, result.getCity());
		assertEquals(null, result.getPostalCode());
	}

	@Test
	public void testGetHostelId_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());

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
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());

		String result = fixture.getHostelName();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetSearchId_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());

		Integer result = fixture.getSearchId();

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
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(date);
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());

		Date result = fixture.getStartDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetTotalPrice_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());

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
	public void testSetBeds_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		List<Bed> beds = new LinkedList<Bed>();

		fixture.setBeds(beds);

		// add additional test code here
	}

	@Test
	public void testSetEndDate_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		Date endDate = new Date();

		fixture.setEndDate(endDate);

		// add additional test code here
	}

	@Test
	public void testSetHostelAddress_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		Address hostelAddress = new Address();

		fixture.setHostelAddress(hostelAddress);

		// add additional test code here
	}

	@Test
	public void testSetHostelId_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		Integer hostelId = new Integer(1);

		fixture.setHostelId(hostelId);

		// add additional test code here
	}

	@Test
	public void testSetHostelName_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		String hostelName = "";

		fixture.setHostelName(hostelName);

		// add additional test code here
	}

	@Test
	public void testSetSearchId_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		Integer searchId = new Integer(1);

		fixture.setSearchId(searchId);

		// add additional test code here
	}

	@Test
	public void testSetStartDate_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		Date startDate = new Date();

		fixture.setStartDate(startDate);

		// add additional test code here
	}

	@Test
	public void testSetTotalPrice_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		Integer totalPrice = new Integer(1);

		fixture.setTotalPrice(totalPrice);

		// add additional test code here
	}

	@Test
	public void testUpdateBedStatus_1()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		List<Bed> beds = new LinkedList<Bed>();
		beds.add(new Bed());
		fixture.setBeds(beds);
		BedState state = BedState.SEARCHED;

		fixture.updateBedStatus(state);

		// add additional test code here
	}

	@Test
	public void testUpdateBedStatus_2()
		throws Exception {
		SearchResult fixture = new SearchResult();
		fixture.setEndDate(new Date());
		fixture.setStartDate(new Date());
		fixture.setHostelId(new Integer(1));
		fixture.setHostelName("");
		fixture.setTotalPrice(new Integer(1));
		fixture.setHostelAddress(new Address());
		fixture.setSearchId(new Integer(1));
		fixture.setBeds(new LinkedList<Bed>());
		BedState state = BedState.AVAILABLE;

		fixture.updateBedStatus(state);

		// add additional test code here
	}
}
