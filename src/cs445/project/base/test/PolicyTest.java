package cs445.project.base.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs445.project.base.Policy;

public class PolicyTest {

	@Test
	public void testPolicy_1()
		throws Exception {

		Policy result = new Policy();

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

		assertEquals(true, result);
		assertEquals(true, fixture.equals(fixture));
	}

	@Test
	public void testEquals_2()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Object obj = null;

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_3()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), null, "", true, true, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "12:00", "", true, true, new Integer(1), new Integer(1));
		Object obj1 = new Policy(new Integer(1), "14:00", "", true, true, new Integer(1), new Integer(1));
		
		boolean result = fixture.equals(obj);

		assertEquals(false, result);
		assertEquals(false,obj.equals(obj1));
	}

	@Test
	public void testEquals_5()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", null, true, true, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "", "12:00", true, true, new Integer(1), new Integer(1));
		Object obj1 = new Policy(new Integer(1), "", "14:00", true, true, new Integer(1), new Integer(1));
		
		boolean result = fixture.equals(obj);

		assertEquals(false, result);
		assertEquals(false, obj.equals(obj1));
	}

	@Test
	public void testEquals_6()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", false, true, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_7()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, false, new Integer(1), new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_8()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, null, new Integer(1));
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Object obj1 = new Policy(new Integer(1), "", "", true, true, new Integer(2), new Integer(1));
		
		boolean result = fixture.equals(obj);

		assertEquals(false, result);
		assertEquals(false, obj.equals(obj1));
	}

	@Test
	public void testEquals_9()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), null);
		Object obj = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Object obj1 = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(2));
		
		boolean result = fixture.equals(obj);

		assertEquals(false, result);
		assertEquals(false, obj.equals(obj1));
	}

	@Test
	public void testGetCancellationDeadline_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		Integer result = fixture.getCancellationDeadline();

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

		assertEquals("", result);
	}

	@Test
	public void testGetCheckOutTime_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		String result = fixture.getCheckOutTime();

		assertEquals("", result);
	}

	@Test
	public void testGetPolicyId_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		Integer result = fixture.getPolicyId();

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

		assertEquals(1744037440, result);
	}

	@Test
	public void testHashCode_2()
		throws Exception {
		Policy fixture = new Policy((Integer) null, "", (String) null, true, true, new Integer(1), new Integer(1));

		int result = fixture.hashCode();

		assertEquals(-1634802977, result);
	}

	@Test
	public void testIsAlcohol_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.isAlcohol();

		assertEquals(true, result);
	}

	@Test
	public void testIsAlcohol_2()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, false, new Integer(1), new Integer(1));

		boolean result = fixture.isAlcohol();

		assertEquals(false, result);
	}

	@Test
	public void testIsSmoking_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		boolean result = fixture.isSmoking();

		assertEquals(true, result);
	}

	@Test
	public void testIsSmoking_2()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", false, true, new Integer(1), new Integer(1));

		boolean result = fixture.isSmoking();

		assertEquals(false, result);
	}

	@Test
	public void testSetAlcohol_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		boolean isAlcohol = true;

		fixture.setAlcohol(isAlcohol);

	}

	@Test
	public void testSetCancellationDeadline_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Integer cancellationDeadline = new Integer(1);

		fixture.setCancellationDeadline(cancellationDeadline);

	}

	@Test
	public void testSetCancellationPenalty_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Integer cancellationPenalty = new Integer(1);

		fixture.setCancellationPenalty(cancellationPenalty);

	}

	@Test
	public void testSetCheckInTime_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		String checkInTime = "";

		fixture.setCheckInTime(checkInTime);

	}

	@Test
	public void testSetCheckOutTime_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		String checkOutTime = "";

		fixture.setCheckOutTime(checkOutTime);

	}

	@Test
	public void testSetPolicyId_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		Integer policyId = new Integer(1);

		fixture.setPolicyId(policyId);

	}

	@Test
	public void testSetSmoking_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));
		boolean isSmoking = true;

		fixture.setSmoking(isSmoking);

	}

	@Test
	public void testToString_1()
		throws Exception {
		Policy fixture = new Policy(new Integer(1), "", "", true, true, new Integer(1), new Integer(1));

		String result = fixture.toString();

		assertEquals("Policy [policyId=1, checkInTime=, checkOutTime=, isSmoking=true, isAlcohol=true, cancellationDeadline=1, cancellationPenalty=1]", result);
	}

}
