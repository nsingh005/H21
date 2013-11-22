package cs445.project.base.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs445.project.base.Contact;

public class ContactTest {
	@Test
	public void testContact_1()
		throws Exception {

		Contact result = new Contact();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Contact [phoneNumber=null, emailId=null, facebookId=null, webURL=null]", result.toString());
		assertEquals(null, result.getFacebookId());
		assertEquals(null, result.getPhoneNumber());
		assertEquals(null, result.getContactId());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getWebURL());
	}

	@Test
	public void testContact_2()
		throws Exception {
		Integer contactId = new Integer(1);
		String phoneNumber = "";
		String emailId = "";
		String facebookId = "";
		String webURL = "";

		Contact result = new Contact(contactId, phoneNumber, emailId, facebookId, webURL);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Contact [phoneNumber=, emailId=, facebookId=, webURL=]", result.toString());
		assertEquals("", result.getFacebookId());
		assertEquals("", result.getPhoneNumber());
		assertEquals(new Integer(1), result.getContactId());
		assertEquals("", result.getEmailId());
		assertEquals("", result.getWebURL());
	}

	@Test
	public void testEquals_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		Object obj = new Contact(new Integer(1), "", "", "", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	@Test
	public void testEquals_2()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_3()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		Object obj = new Contact(new Integer(1), "123", "", "", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_5()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		Object obj = new Contact(new Integer(1), "", "", "123@123.com", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_6()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "123.com");
		Object obj = new Contact(new Integer(1), "", "", "", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_7()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		Object obj = new Contact(new Integer(1), "", "abc", "", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_8()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", null, "");
		Object obj = new Contact(new Integer(1), "", "", "", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_9()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", (String) null);
		Object obj = new Contact(new Integer(1), "", "", "", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_10()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", null, "", "");
		Object obj = new Contact(new Integer(1), "", "", "", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}
	
	@Test
	public void testEquals_11()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), null, "", "", "");
		Object obj = new Contact(new Integer(1), "", "", "", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}
	
	@Test
	public void testGetContactId_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");

		Integer result = fixture.getContactId();

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
	public void testGetEmailId_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");

		String result = fixture.getEmailId();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetFacebookId_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");

		String result = fixture.getFacebookId();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetPhoneNumber_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");

		String result = fixture.getPhoneNumber();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetWebURL_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");

		String result = fixture.getWebURL();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testHashCode_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", (String) null, (String) null, "");

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(923521, result);
	}

	@Test
	public void testHashCode_2()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), (String) null, "", "", (String) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(923521, result);
	}

	@Test
	public void testSetContactId_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		Integer contactId = new Integer(1);

		fixture.setContactId(contactId);

		// add additional test code here
	}

	@Test
	public void testSetEmailId_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		String emailId = "";

		fixture.setEmailId(emailId);

		// add additional test code here
	}

	@Test
	public void testSetFacebookId_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		String facebookId = "";

		fixture.setFacebookId(facebookId);

		// add additional test code here
	}

	@Test
	public void testSetPhoneNumber_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		String phoneNumber = "";

		fixture.setPhoneNumber(phoneNumber);

		// add additional test code here
	}

	@Test
	public void testSetWebURL_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");
		String webURL = "";

		fixture.setWebURL(webURL);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		Contact fixture = new Contact(new Integer(1), "", "", "", "");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Contact [phoneNumber=, emailId=, facebookId=, webURL=]", result);
	}

}
