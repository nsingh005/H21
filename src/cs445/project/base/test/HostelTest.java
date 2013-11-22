package cs445.project.base.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import cs445.project.base.Address;
import cs445.project.base.Bed;
import cs445.project.base.Contact;
import cs445.project.base.Hostel;
import cs445.project.base.Policy;

public class HostelTest {

	@Test
	public void testHostel_1()
		throws Exception {

		Hostel result = new Hostel();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Hostel [name=null, hostelId=null, address=null, contact=null, policy=null]", result.toString());
		assertEquals(null, result.getAddress());
		assertEquals(null, result.getName());
		assertEquals(null, result.getPolicy());
		assertEquals(null, result.getHostelId());
		assertEquals(null, result.getBeds());
		assertEquals(null, result.getContact());
	}

	@Test
	public void testHostel_2()
		throws Exception {
		String name = "";
		Address address = new Address();
		Contact contact = new Contact();
		Policy policy = new Policy();
		List<Bed> beds = new LinkedList<Bed>();

		Hostel result = new Hostel(name, address, contact, policy, beds);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Hostel [name=, hostelId=null, address=Address [street=null, city=null, state=null, postalCode=null, country=null], contact=Contact [phoneNumber=null, emailId=null, facebookId=null, webURL=null], policy=Policy [policyId=null, checkInTime=null, checkOutTime=null, isSmoking=false, isAlcohol=false, cancellationDeadline=null, cancellationPenalty=null]]", result.toString());
		assertEquals("", result.getName());
		assertEquals(null, result.getHostelId());
	}

	@Test
	public void testHostel_3()
		throws Exception {
		Integer hostelId = new Integer(1);
		String name = "";
		Address address = new Address();
		Contact contact = new Contact();
		Policy policy = new Policy();
		List<Bed> beds = new LinkedList<Bed>();

		Hostel result = new Hostel(hostelId, name, address, contact, policy, beds);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Hostel [name=, hostelId=1, address=Address [street=null, city=null, state=null, postalCode=null, country=null], contact=Contact [phoneNumber=null, emailId=null, facebookId=null, webURL=null], policy=Policy [policyId=null, checkInTime=null, checkOutTime=null, isSmoking=false, isAlcohol=false, cancellationDeadline=null, cancellationPenalty=null]]", result.toString());
		assertEquals("", result.getName());
		assertEquals(new Integer(1), result.getHostelId());
	}

	@Test
	public void testEquals_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Object obj = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	@Test
	public void testEquals_2()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_3()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "xyz", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Object obj = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_5()
		throws Exception {
		Address addr = new Address(1, null, null, null, null, null);
		Contact contact = new Contact();
		Policy policy = new Policy();
		List<Bed> beds = new LinkedList<Bed>();
		beds.add(new Bed());
		Hostel fixture = new Hostel(new Integer(1), "", addr,contact,policy, beds);
		Object obj = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_6()
		throws Exception {
		Address addr = new Address();
		Contact contact = new Contact(1, null, null, null, null);
		Policy policy = new Policy(1, null, null, false, false, null, null);
		List<Bed> beds = new LinkedList<Bed>();
		beds.add(new Bed());
		Hostel fixture = new Hostel(new Integer(1), "", addr,contact,policy, beds);
		Object obj = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_7()
		throws Exception {
		Address addr = new Address();
		Contact contact = new Contact();
		Policy policy = new Policy(1, null, null, false, false, null, null);
		List<Bed> beds = new LinkedList<Bed>();
		beds.add(new Bed());
		Hostel fixture = new Hostel(new Integer(1), "", addr,contact,policy, beds);
		Object obj = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_8()
		throws Exception {
		Address addr = new Address();
		Contact contact = new Contact();
		Policy policy = new Policy();
		List<Bed> beds = new LinkedList<Bed>();
		beds.add(new Bed());
		Hostel fixture = new Hostel(new Integer(1), "", addr,contact,policy, beds);
		Object obj = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_10()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), (Policy) null, new LinkedList<Bed>());
		Object obj = new Hostel(new Integer(1), null, new Address(), new Contact(), (Policy) null, new LinkedList<Bed>());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testGetAddress_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		Address result = fixture.getAddress();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Address [street=null, city=null, state=null, postalCode=null, country=null]", result.toString());
		assertEquals(null, result.getState());
		assertEquals(null, result.getCountry());
		assertEquals(null, result.getPostalCode());
		assertEquals(null, result.getStreet());
		assertEquals(null, result.getCity());
		assertEquals(null, result.getAddressId());
	}

	@Test
	public void testGetBeds_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		List<Bed> result = fixture.getBeds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetContact_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		Contact result = fixture.getContact();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Contact [phoneNumber=null, emailId=null, facebookId=null, webURL=null]", result.toString());
		assertEquals(null, result.getPhoneNumber());
		assertEquals(null, result.getFacebookId());
		assertEquals(null, result.getWebURL());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getContactId());
	}

	@Test
	public void testGetHostelId_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

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
	public void testGetName_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetPolicy_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		Policy result = fixture.getPolicy();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Policy [policyId=null, checkInTime=null, checkOutTime=null, isSmoking=false, isAlcohol=false, cancellationDeadline=null, cancellationPenalty=null]", result.toString());
		assertEquals(null, result.getCheckInTime());
		assertEquals(null, result.getCheckOutTime());
		assertEquals(null, result.getCancellationDeadline());
		assertEquals(null, result.getCancellationPenalty());
		assertEquals(false, result.isAlcohol());
		assertEquals(false, result.isSmoking());
		assertEquals(null, result.getPolicyId());
	}

	@Test
	public void testHashCode_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", (Address) null, new Contact(), new Policy(), (List<Bed>) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-1634797025, result);
	}

	@Test
	public void testHashCode_2()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), (String) null, new Address(), (Contact) null, (Policy) null, new LinkedList<Bed>());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-167854563, result);
	}

	@Test
	public void testSetAddress_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Address address = new Address();

		fixture.setAddress(address);

		// add additional test code here
	}

	@Test
	public void testSetAllIds_1()
		throws Exception {
		Address addr = new Address(1, null, null, null, null, null);
		Contact contact = new Contact(1, null, null, null, null);
		Policy policy = new Policy(1, null, null, false, false, null, null);
		List<Bed> beds = new LinkedList<Bed>();
		beds.add(new Bed());
		Hostel fixture = new Hostel(new Integer(1), "", addr,contact,policy, beds);
		Hostel hostel = new Hostel(new Integer(1), "", addr,contact,policy, beds);

		hostel.setAllIds(fixture);
	}

	@Test
	public void testSetBeds_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		List<Bed> beds = new LinkedList<Bed>();

		fixture.setBeds(beds);

		// add additional test code here
	}

	@Test
	public void testSetContact_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Contact contact = new Contact();

		fixture.setContact(contact);

		// add additional test code here
	}

	@Test
	public void testSetHostelId_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Integer hostelId = new Integer(1);

		fixture.setHostelId(hostelId);

		// add additional test code here
	}

	@Test
	public void testSetHostelIdInBeds_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Integer hostelId = new Integer(1);

		fixture.setHostelIdInBeds(hostelId);

		// add additional test code here
	}

	@Test
	public void testSetHostelIdInBeds_2()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Integer hostelId = new Integer(1);

		fixture.setHostelIdInBeds(hostelId);

		// add additional test code here
	}

	@Test
	public void testSetName_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	@Test
	public void testSetPolicy_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());
		Policy policy = new Policy();

		fixture.setPolicy(policy);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		Hostel fixture = new Hostel(new Integer(1), "", new Address(), new Contact(), new Policy(), new LinkedList<Bed>());

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Hostel [name=, hostelId=1, address=Address [street=null, city=null, state=null, postalCode=null, country=null], contact=Contact [phoneNumber=null, emailId=null, facebookId=null, webURL=null], policy=Policy [policyId=null, checkInTime=null, checkOutTime=null, isSmoking=false, isAlcohol=false, cancellationDeadline=null, cancellationPenalty=null]]", result);
	}

}
