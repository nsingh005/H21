package cs445.project.base.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs445.project.base.Policy;

public class PolicyTest {

	@Test
	public void testPolicy_1()
		throws Exception {

		Policy result = new Policy();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Policy [policyId=null, checkInTime=null, checkOutTime=null, isSmoking=false, isAlcohol=false, cancellationDeadline=null, cancellationPenalty=null]", result.toString());
		assertEquals(null, result.getCheckOutTime());
		assertEquals(null, result.getCancellationDeadline());
		assertEquals(null, result.getCancellationPenalty());
		assertEquals(null, result.getCheckInTime());
		assertEquals(false, result.isAlcohol());
		assertEquals(false, result.isSmoking());
		assertEquals(null, result.getPolicyId());
	}

	@Test
	public void testPolicy_2()
		throws Exception {
		Integer policyId = new Integer(1);
		String checkInTime = "";
		String checkOutTime = "";
		boolean isSmoking = true;
		boolean isAlcohol = true;
		Integer cancellationDeadline = new Integer(1);
		Integer cancellationPenalty = new Integer(1);

		Policy result = new Policy(policyId, checkInTime, checkOutTime, isSmoking, isAlcohol, cancellationDeadline, cancellationPenalty);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Policy [policyId=1, checkInTime=, checkOutTime=, isSmoking=true, isAlcohol=true, cancellationDeadline=1, cancellationPenalty=1]", result.toString());
		assertEquals("", result.getCheckOutTime());
		assertEquals(new Integer(1), result.getCancellationDeadline());
		assertEquals(new Integer(1), result.getCancellationPenalty());
		assertEquals("", result.getCheckInTime());
		assertEquals(true, result.isAlcohol());
		assertEquals(true, result.isSmoking());
		assertEquals(new Integer(1), result.getPolicyId());
	}

	@Test
	public void testEquals_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	@Test
	public void testEquals_2()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_3()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), null, "", true, true, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_5()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", null, true, true, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_6()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", false, true, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_7()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, false, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_8()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, null, new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testEquals_9()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), null);
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testGetCancellationDeadline_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		Integer result = fixture.getCancellationDeadline();

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
	public void testGetCancellationPenalty_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		Integer result = fixture.getCancellationPenalty();

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
	public void testGetCheckInTime_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		String result = fixture.getCheckInTime();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetCheckOutTime_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		String result = fixture.getCheckOutTime();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetPolicyId_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		Integer result = fixture.getPolicyId();

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
	public void testHashCode_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), (String) null, "", false, false, (Integer) null, (Integer) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1744037440, result);
	}

	@Test
	public void testHashCode_2()
		throws Exception {
		Policy fixture = new Policy((Integer) null, "", (String) null, true, true, new Integer(1), new Integer(1));

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-1634802977, result);
	}

	@Test
	public void testIsAlcohol_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.isAlcohol();

		// add additional test code here
		assertEquals(true, result);
	}

	@Test
	public void testIsAlcohol_2()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, false, new Integer(1), new Integer(1));

		boolean result = fixture.isAlcohol();

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testIsSmoking_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.isSmoking();

		// add additional test code here
		assertEquals(true, result);
	}

	@Test
	public void testIsSmoking_2()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", false, true, new Integer(1), new Integer(1));

		boolean result = fixture.isSmoking();

		// add additional test code here
		assertEquals(false, result);
	}

	@Test
	public void testSetAlcohol_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		boolean isAlcohol = true;

		fixture.setAlcohol(isAlcohol);

		// add additional test code here
	}

	@Test
	public void testSetCancellationDeadline_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Integer cancellationDeadline = new Integer(1);

		fixture.setCancellationDeadline(cancellationDeadline);

		// add additional test code here
	}

	@Test
	public void testSetCancellationPenalty_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Integer cancellationPenalty = new Integer(1);

		fixture.setCancellationPenalty(cancellationPenalty);

		// add additional test code here
	}

	@Test
	public void testSetCheckInTime_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		String checkInTime = "";

		fixture.setCheckInTime(checkInTime);

		// add additional test code here
	}

	@Test
	public void testSetCheckOutTime_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		String checkOutTime = "";

		fixture.setCheckOutTime(checkOutTime);

		// add additional test code here
	}

	@Test
	public void testSetPolicyId_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Integer policyId = new Integer(1);

		fixture.setPolicyId(policyId);

		// add additional test code here
	}

	@Test
	public void testSetSmoking_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		boolean isSmoking = true;

		fixture.setSmoking(isSmoking);

		// add additional test code here
	}

	@Test
	public void testToString_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Policy [policyId=1, checkInTime=, checkOutTime=, isSmoking=true, isAlcohol=true, cancellationDeadline=1, cancellationPenalty=1]", result);
	}

}
