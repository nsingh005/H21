package cs445.project.base.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

import cs445.project.base.User;

public class UserTest {

	@Test
	public void testGetCcExpiryDate_1()
		throws Exception {
		User fixture = new User();
		Date date = new Date();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());

		Date result = fixture.getCcExpiryDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
	}

	@Test
	public void testGetCcNumber_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());

		String result = fixture.getCcNumber();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetEmail_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());

		String result = fixture.getEmail();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetFirstName_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());

		String result = fixture.getFirstName();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetLastName_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());

		String result = fixture.getLastName();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetPhone_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());

		String result = fixture.getPhone();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetSecurityCode_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());

		Integer result = fixture.getSecurityCode();

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
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());

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
	public void testSetCcExpiryDate_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());
		Date ccExpiryDate = new Date();

		fixture.setCcExpiryDate(ccExpiryDate);

		// add additional test code here
	}

	@Test
	public void testSetCcNumber_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());
		String ccNumber = "";

		fixture.setCcNumber(ccNumber);

		// add additional test code here
	}

	@Test
	public void testSetEmail_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());
		String email = "";

		fixture.setEmail(email);

		// add additional test code here
	}

	@Test
	public void testSetFirstName_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());
		String firstName = "";

		fixture.setFirstName(firstName);

		// add additional test code here
	}

	@Test
	public void testSetLastName_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());
		String lastName = "";

		fixture.setLastName(lastName);

		// add additional test code here
	}

	@Test
	public void testSetPhone_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());
		String phone = "";

		fixture.setPhone(phone);

		// add additional test code here
	}

	@Test
	public void testSetSecurityCode_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());
		Integer securityCode = new Integer(1);

		fixture.setSecurityCode(securityCode);

		// add additional test code here
	}

	@Test
	public void testSetUserId_1()
		throws Exception {
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(new Date());
		Integer userId = new Integer(1);

		fixture.setUserId(userId);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		Date date = new Date();
		User fixture = new User();
		fixture.setEmail("");
		fixture.setPhone("");
		fixture.setCcNumber("");
		fixture.setFirstName("");
		fixture.setUserId(new Integer(1));
		fixture.setLastName("");
		fixture.setSecurityCode(new Integer(1));
		fixture.setCcExpiryDate(date);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("User [userId=1, firstName=, lastName=, email=, ccNumber=, ccExpiryDate="+date+", securityCode=1, phone=]", result);
	}

}
