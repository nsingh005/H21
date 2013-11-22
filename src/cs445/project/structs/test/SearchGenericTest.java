package cs445.project.structs.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import cs445.project.structs.AvailableBedInfo;
import cs445.project.structs.SearchGeneric;

public class SearchGenericTest {

		@Test
		public void testEquals_1()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			SearchGeneric obj = new SearchGeneric();
			obj.setHostelId(new Integer(1));
			obj.setHostelName("");
			obj.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			boolean result = fixture.equals(obj);

			// add additional test code here
			assertEquals(true, result);
		}

		@Test
		public void testEquals_2()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			Object obj = null;

			boolean result = fixture.equals(obj);

			// add additional test code here
			assertEquals(false, result);
		}

		@Test
		public void testEquals_3()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			Object obj = new Object();

			boolean result = fixture.equals(obj);

			// add additional test code here
			assertEquals(false, result);
		}

		@Test
		public void testEquals_4()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			SearchGeneric obj = new SearchGeneric();
			obj.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			boolean result = fixture.equals(obj);

			// add additional test code here
			assertEquals(false, result);
		}

		@Test
		public void testEquals_5()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			SearchGeneric obj = new SearchGeneric();
			obj.setHostelId(new Integer(1));
			obj.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			boolean result = fixture.equals(obj);

			// add additional test code here
			assertEquals(false, result);
		}


		@Test
		public void testEquals_6()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			SearchGeneric obj = new SearchGeneric();
			obj.setHostelId(new Integer(2));
			obj.setHostelName("");
			obj.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			boolean result = fixture.equals(obj);

			// add additional test code here
			assertEquals(false, result);
		}

		@Test
		public void testEquals_7()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName(null);
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			SearchGeneric obj = new SearchGeneric();
			obj.setHostelId(new Integer(1));
			obj.setHostelName("");
			obj.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			boolean result = fixture.equals(obj);

			// add additional test code here
			assertEquals(false, result);
		}

		@Test
		public void testEquals_8()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(null);
			SearchGeneric obj = new SearchGeneric();
			obj.setHostelId(new Integer(1));
			obj.setHostelName("");
			obj.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			boolean result = fixture.equals(obj);

			// add additional test code here
			assertEquals(false, result);
		}

		@Test
		public void testGetAvailableBedInfo_1()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			List<AvailableBedInfo> result = fixture.getAvailableBedInfo();

			// add additional test code here
			assertNotNull(result);
			assertEquals(0, result.size());
		}

		@Test
		public void testGetHostelId_1()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

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
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			String result = fixture.getHostelName();

			// add additional test code here
			assertEquals("", result);
		}

		@Test
		public void testSetAvailableBedInfo_1()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			List<AvailableBedInfo> availableBedInfo = new LinkedList<AvailableBedInfo>();

			fixture.setAvailableBedInfo(availableBedInfo);

			// add additional test code here
		}

		@Test
		public void testSetHostelId_1()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			Integer hostelId = new Integer(1);

			fixture.setHostelId(hostelId);

			// add additional test code here
		}

		@Test
		public void testSetHostelName_1()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());
			String hostelName = "";

			fixture.setHostelName(hostelName);

			// add additional test code here
		}

		@Test
		public void testToString_1()
			throws Exception {
			SearchGeneric fixture = new SearchGeneric();
			fixture.setHostelId(new Integer(1));
			fixture.setHostelName("");
			fixture.setAvailableBedInfo(new LinkedList<AvailableBedInfo>());

			String result = fixture.toString();

			// add additional test code here
			assertEquals("SearchGeneric [hostelId=1, hostelName=, availableBedInfoList=[]]", result);
		}
}
