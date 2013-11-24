package cs445.project.base.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs445.project.base.Address;

public class AddressTest {

	@Test
	public void testAddress_1()
		throws Exception {

		Address result = new Address();

		assertNotNull(result);
		assertEquals("Address [street=null, city=null, state=null, postalCode=null, country=null]", result.toString());
		assertEquals(null, result.getState());
		assertEquals(null, result.getCountry());
		assertEquals(null, result.getPostalCode());
		assertEquals(null, result.getCity());
		assertEquals(null, result.getAddressId());
		assertEquals(null, result.getStreet());
	}
	
	public void testAddress_2()
			throws Exception {
			Integer addressId = new Integer(1);
			String street = "";
			String city = "";
			String state = "";
			String postalCode = "";
			String country = "";

			Address result = new Address(addressId, street, city, state, postalCode, country);

			assertNotNull(result);
			assertEquals("Address [street=, city=, state=, postalCode=, country=]", result.toString());
			assertEquals("", result.getState());
			assertEquals("", result.getCountry());
			assertEquals("", result.getPostalCode());
			assertEquals("", result.getCity());
			assertEquals(new Integer(1), result.getAddressId());
			assertEquals("", result.getStreet());
		}
	
	@Test
	public void testEquals_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(true, result);
		assertEquals(true,fixture.equals(fixture));
	}
	
	@Test
	public void testEquals_2()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		Object obj = null;

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_3()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_4()
		throws Exception {
		Address fixture = new Address(new Integer(1), "123", "", "", "", "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_5()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "xyz", "", "", "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_6()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "xyz", "", "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_7()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "xyz", "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_8()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "xyz");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_9()
		throws Exception {
		Address fixture = new Address(new Integer(1), null, "", "", "", "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_10()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", null, "", "", "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_11()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", null, "", "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_12()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", null, "");
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_13()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", null);
		Object obj = new Address(new Integer(1), "", "", "", "", "");

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}
	
	@Test
	public void testGetAddressId_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");

		Integer result = fixture.getAddressId();

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
	public void testGetCity_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "xyz", "", "", "");

		String result = fixture.getCity();

		assertEquals("xyz", result);
	}
	
	@Test
	public void testGetCountry_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "xyz");

		String result = fixture.getCountry();

		assertEquals("xyz", result);
	}
	
	@Test
	public void testGetPostalCode_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "1234", "");

		String result = fixture.getPostalCode();

		assertEquals("1234", result);
	}
	
	@Test
	public void testGetState_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "XYZ", "", "");

		String result = fixture.getState();

		assertEquals("XYZ", result);
	}
	
	@Test
	public void testGetStreet_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "abc", "", "", "", "");

		String result = fixture.getStreet();

		assertEquals("abc", result);
	}
	
	@Test
	public void testHashCode_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", (String) null, "", "", (String) null);

		int result = fixture.hashCode();

		assertEquals(28629151, result);
	}
	
	@Test
	public void testHashCode_2()
		throws Exception {
		Address fixture = new Address(new Integer(1), (String) null, "", (String) null, (String) null, "");

		int result = fixture.hashCode();

		assertEquals(28629151, result);
	}
	
	@Test
	public void testSetAddressId_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		Integer addressId = new Integer(1);

		fixture.setAddressId(addressId);
		
		assertEquals(addressId, fixture.getAddressId());
	}
	
	@Test
	public void testSetCity_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		String city = "";

		fixture.setCity(city);
		assertEquals("", fixture.getCity());
	}
	
	@Test
	public void testSetCountry_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		String country = "";

		fixture.setCountry(country);
		assertEquals("", fixture.getCountry());
	}
	
	@Test
	public void testSetPostalCode_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		String postalCode = "";

		fixture.setPostalCode(postalCode);
		assertEquals("", fixture.getPostalCode());
	}
	
	@Test
	public void testSetState_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		String state = "";

		fixture.setState(state);
		assertEquals("", fixture.getState());
	}
	
	@Test
	public void testSetStreet_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");
		String street = "";

		fixture.setStreet(street);
		assertEquals("", fixture.getStreet());
	}
	
	@Test
	public void testToString_1()
		throws Exception {
		Address fixture = new Address(new Integer(1), "", "", "", "", "");

		String result = fixture.toString();

		assertEquals("Address [street=, city=, state=, postalCode=, country=]", result);
	}	

}
