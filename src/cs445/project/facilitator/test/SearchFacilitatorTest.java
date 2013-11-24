package cs445.project.facilitator.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cs445.project.base.Address;
import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.base.Contact;
import cs445.project.base.Hostel;
import cs445.project.base.Policy;
import cs445.project.facilitator.SearchFacilitator;
import cs445.project.structs.AvailableBedInfo;
import cs445.project.structs.SearchGeneric;
import cs445.project.structs.SearchResult;
import cs445.project.structs.SearchStruct;

public class SearchFacilitatorTest {
	SearchFacilitator searchFacilitator;
	
	@Before
	public void beforeTest() {
		searchFacilitator = new SearchFacilitator();
	}

	@Test
	public void testSearchRequestNull(){
		assertEquals(null,searchFacilitator.search(null, new ArrayList<Hostel>()));
		assertEquals(null,searchFacilitator.search(new SearchStruct(), null));
		assertEquals(null,searchFacilitator.searchGeneric(null, new ArrayList<Hostel>()));
		assertEquals(null,searchFacilitator.searchGeneric(new SearchStruct(), null));
	}
	
	@Test
	public void testSearchZeroHostelSize(){
		List<Hostel> hostel = new ArrayList<Hostel>();
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20140701"));
			searchStruct.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(null,searchFacilitator.search(searchStruct, hostel));
		assertEquals(null,searchFacilitator.searchGeneric(searchStruct, hostel));
	}
	
	@Test
	public void testSearchStartDateBeforeCurrentDate(){
		List<Hostel> hostels = new ArrayList<Hostel>();
		Hostel hostel = new Hostel();
		hostels.add(hostel);
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20130701"));
			searchStruct.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(null,searchFacilitator.search(searchStruct, hostels));
		assertEquals(null,searchFacilitator.searchGeneric(searchStruct, hostels));
	}
	
	@Test
	public void testSearchStartDateAfterEndDate(){
		List<Hostel> hostels = new ArrayList<Hostel>();
		Hostel hostel = new Hostel();
		hostels.add(hostel);
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20140703"));
			searchStruct.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(null,searchFacilitator.search(searchStruct, hostels));
		assertEquals(null,searchFacilitator.searchGeneric(searchStruct, hostels));
	}
	
	@Test
	public void testSearchOneBedForOneDay() {
		List<Hostel> hostels = getHostelListForOneDay();
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20140701"));
			searchStruct.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchStruct.setNumberOfBeds(1);
		
		List<SearchResult> actualSearchResultSet = searchFacilitator.search(searchStruct, hostels);
		List<SearchResult> expectedSearchResultSet = getExpectedSearchResultSetForOneBed();
		
		assertEquals(expectedSearchResultSet, actualSearchResultSet);		
	}
	
	@Test
	public void testSearchTwoBedsForOneDay(){
		List<Hostel> hostels = getHostelListForOneDay();
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20140701"));
			searchStruct.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchStruct.setNumberOfBeds(2);
		
		List<SearchResult> actualSearchResultSet = searchFacilitator.search(searchStruct, hostels);
		List<SearchResult> expectedSearchResultSet = getExpectedSearchResultSetForTwoBedsForOneDay();
		
		assertEquals(expectedSearchResultSet, actualSearchResultSet);		
	}

	@Test
	public void testSearchOneBedForTwoDay(){
		List<Hostel> hostels = getHostelListForTwoDays();
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20140701"));
			searchStruct.setEndDate(sdf.parse("20140703"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchStruct.setNumberOfBeds(1);
		
		List<SearchResult> actualSearchResultSet = searchFacilitator.search(searchStruct, hostels);
		List<SearchResult> expectedSearchResultSet = getExpectedSearchResultSetForOneBedForTwoDay();
		
		assertEquals(expectedSearchResultSet, actualSearchResultSet);		
	}

	@Test
	public void testSearchTwoBedForTwoDay(){
		List<Hostel> hostels = getHostelListForTwoDays();
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20140701"));
			searchStruct.setEndDate(sdf.parse("20140703"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchStruct.setNumberOfBeds(2);
		
		List<SearchResult> actualSearchResultSet = searchFacilitator.search(searchStruct, hostels);
		List<SearchResult> expectedSearchResultSet = getExpectedSearchResultSetForTwoBedForTwoDay();
		
		assertEquals(expectedSearchResultSet, actualSearchResultSet);		
	}
	
	@Test
	public void testSearchGenericOneDay(){
		List<Hostel> hostels = getHostelListForOneDay();
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20140701"));
			searchStruct.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<SearchGeneric> actualSearchGenericSet = searchFacilitator.searchGeneric(searchStruct, hostels);
		List<SearchGeneric> expectedSearchGenericSet = getExpectedSearchGenericSetForOneDay();
		
		assertEquals(expectedSearchGenericSet, actualSearchGenericSet);		
	}
	
	@Test
	public void testSearchGenericTwoDays(){
		List<Hostel> hostels = getHostelListForTwoDays();
		SearchStruct searchStruct = new SearchStruct();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		searchStruct.setCity("Anytown");
		try {
			searchStruct.setStartDate(sdf.parse("20140701"));
			searchStruct.setEndDate(sdf.parse("20140703"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<SearchGeneric> actualSearchGenericSet = searchFacilitator.searchGeneric(searchStruct, hostels);
		List<SearchGeneric> expectedSearchGenericSet = getExpectedSearchGenericSetForTwoDays();
		
		assertEquals(expectedSearchGenericSet, actualSearchGenericSet);		
	}

	private List<SearchGeneric> getExpectedSearchGenericSetForTwoDays() {
		List<SearchGeneric> searchGenericSet = new ArrayList<SearchGeneric>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		SearchGeneric sg1 = new SearchGeneric();
		List<AvailableBedInfo> avlBdList1 = new ArrayList<AvailableBedInfo>();
		AvailableBedInfo ab1 = new AvailableBedInfo();
		ab1.setBedsAvailable(3);
		ab1.setMaxPrice(15);
		ab1.setMinPrice(11);
		try {
			ab1.setStartDate(sdf.parse("20140701"));
			ab1.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		avlBdList1.add(ab1);
		
		AvailableBedInfo ab12 = new AvailableBedInfo();
		ab12.setBedsAvailable(2);
		ab12.setMaxPrice(12);
		ab12.setMinPrice(10);
		try {
			ab12.setStartDate(sdf.parse("20140702"));
			ab12.setEndDate(sdf.parse("20140703"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		avlBdList1.add(ab12);
		
		sg1.setAvailableBedInfo(avlBdList1);
		sg1.setHostelId(1);
		sg1.setHostelName("Hostel 21 - Romantic");
		searchGenericSet.add(sg1);
		
		SearchGeneric sg2 = new SearchGeneric();
		List<AvailableBedInfo> avlBdList2 = new ArrayList<AvailableBedInfo>();
		AvailableBedInfo ab2 = new AvailableBedInfo();
		ab2.setBedsAvailable(2);
		ab2.setMaxPrice(14);
		ab2.setMinPrice(10);
		try {
			ab2.setStartDate(sdf.parse("20140701"));
			ab2.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		avlBdList2.add(ab2);
		sg2.setAvailableBedInfo(avlBdList2);
		sg2.setHostelId(2);
		sg2.setHostelName("Hostel 21 - Happy");
		searchGenericSet.add(sg2);
		
		return searchGenericSet;
	}
	
	private List<SearchGeneric> getExpectedSearchGenericSetForOneDay() {
		List<SearchGeneric> searchGenericSet = new ArrayList<SearchGeneric>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		SearchGeneric sg1 = new SearchGeneric();
		List<AvailableBedInfo> avlBdList1 = new ArrayList<AvailableBedInfo>();
		AvailableBedInfo ab1 = new AvailableBedInfo();
		ab1.setBedsAvailable(2);
		ab1.setMaxPrice(15);
		ab1.setMinPrice(14);
		try {
			ab1.setStartDate(sdf.parse("20140701"));
			ab1.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		avlBdList1.add(ab1);
		sg1.setAvailableBedInfo(avlBdList1);
		sg1.setHostelId(1);
		sg1.setHostelName("Hostel 21 - Romantic");
		searchGenericSet.add(sg1);
		
		SearchGeneric sg2 = new SearchGeneric();
		List<AvailableBedInfo> avlBdList2 = new ArrayList<AvailableBedInfo>();
		AvailableBedInfo ab2 = new AvailableBedInfo();
		ab2.setBedsAvailable(2);
		ab2.setMaxPrice(14);
		ab2.setMinPrice(10);
		try {
			ab2.setStartDate(sdf.parse("20140701"));
			ab2.setEndDate(sdf.parse("20140702"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		avlBdList2.add(ab2);
		sg2.setAvailableBedInfo(avlBdList2);
		sg2.setHostelId(2);
		sg2.setHostelName("Hostel 21 - Happy");
		searchGenericSet.add(sg2);
		
		return searchGenericSet;
	}
	
	private List<SearchResult> getExpectedSearchResultSetForTwoBedForTwoDay() {
		List<SearchResult> searchResultSet = new ArrayList<SearchResult>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null;
		Bed b2 = null;
		Bed b3 = null;
		Bed b4 = null;
		SearchResult sr1 = new SearchResult();
		try {
			sr1.setStartDate(sdf.parse("20140701"));
			sr1.setEndDate(sdf.parse("20140703"));
			b1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, BedState.SEARCHED);
			b2 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, BedState.SEARCHED);
			b3 = new Bed(1, sdf.parse("20140702"), 1, 1, 10, BedState.SEARCHED);
			b4 = new Bed(1, sdf.parse("20140702"), 1, 2, 12, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds = new ArrayList<Bed>();
		beds.add(b1);
		beds.add(b2);
		beds.add(b3);
		beds.add(b4);
		
		sr1.setTotalPrice(51);
		sr1.setBeds(beds);
		
		searchResultSet.add(sr1);
		
		return searchResultSet;
	}
	
	private List<SearchResult> getExpectedSearchResultSetForOneBedForTwoDay() {
		List<SearchResult> searchResultSet = new ArrayList<SearchResult>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null;
		Bed b2 = null;
		SearchResult sr1 = new SearchResult();
		try {
			sr1.setStartDate(sdf.parse("20140701"));
			sr1.setEndDate(sdf.parse("20140703"));
			b1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, BedState.SEARCHED);
			b2 = new Bed(1, sdf.parse("20140702"), 1, 1, 10, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds = new ArrayList<Bed>();
		beds.add(b1);
		beds.add(b2);
		
		sr1.setTotalPrice(25);
		sr1.setBeds(beds);
		
		searchResultSet.add(sr1);
		
		Bed b3 = null;
		Bed b4 = null;
		SearchResult sr2 = new SearchResult();
		try {
			sr2.setStartDate(sdf.parse("20140701"));
			sr2.setEndDate(sdf.parse("20140703"));
			b3 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, BedState.SEARCHED);
			b4 = new Bed(1, sdf.parse("20140702"), 1, 2, 12, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds2 = new ArrayList<Bed>();
		beds2.add(b3);
		beds2.add(b4);
		
		sr2.setTotalPrice(26);
		sr2.setBeds(beds2);
		searchResultSet.add(sr2);
		
		return searchResultSet;
	}
	
	private List<SearchResult> getExpectedSearchResultSetForTwoBedsForOneDay() {
		List<SearchResult> searchResultSet = new ArrayList<SearchResult>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null;
		Bed b2 = null;
		SearchResult sr1 = new SearchResult();
		try {
			sr1.setStartDate(sdf.parse("20140701"));
			sr1.setEndDate(sdf.parse("20140702"));
			b1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, BedState.SEARCHED);
			b2 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds = new ArrayList<Bed>();
		beds.add(b1);
		beds.add(b2);
		
		sr1.setTotalPrice(29);
		sr1.setBeds(beds);
		
		searchResultSet.add(sr1);
		
		Bed b3 = null;
		Bed b4 = null;
		SearchResult sr2 = new SearchResult();
		try {
			sr2.setStartDate(sdf.parse("20140701"));
			sr2.setEndDate(sdf.parse("20140702"));
			b3 = new Bed(2, sdf.parse("20140701"), 1, 1, 10, BedState.SEARCHED);
			b4 = new Bed(2, sdf.parse("20140701"), 1, 2, 14, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds2 = new ArrayList<Bed>();
		beds2.add(b3);
		beds2.add(b4);
		
		sr2.setTotalPrice(24);
		sr2.setBeds(beds2);
		searchResultSet.add(sr2);
		
		return searchResultSet;
	}
	
	private List<SearchResult> getExpectedSearchResultSetForOneBed() {
		List<SearchResult> searchResultSet = new ArrayList<SearchResult>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null;
		SearchResult sr1 = new SearchResult();
		try {
			sr1.setStartDate(sdf.parse("20140701"));
			sr1.setEndDate(sdf.parse("20140702"));
			b1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds = new ArrayList<Bed>();
		beds.add(b1);
		
		sr1.setTotalPrice(15);
		sr1.setBeds(beds);
		
		searchResultSet.add(sr1);
		
		Bed b2 = null;
		SearchResult sr2 = new SearchResult();
		try {
			sr2.setStartDate(sdf.parse("20140701"));
			sr2.setEndDate(sdf.parse("20140702"));
			b2 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds2 = new ArrayList<Bed>();
		beds2.add(b2);
		
		sr2.setTotalPrice(14);
		sr2.setBeds(beds2);
		
		searchResultSet.add(sr2);
		
		Bed b3_1 = null;
		SearchResult sr3 = new SearchResult();
		try {
			sr3.setStartDate(sdf.parse("20140701"));
			sr3.setEndDate(sdf.parse("20140702"));
			b3_1 = new Bed(2, sdf.parse("20140701"), 1, 1, 10, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds3 = new ArrayList<Bed>();
		beds3.add(b3_1);
		
		sr3.setTotalPrice(10);
		sr3.setBeds(beds3);
		searchResultSet.add(sr3);
		
		Bed b4_1 = null;
		SearchResult sr4 = new SearchResult();
		try {
			sr4.setStartDate(sdf.parse("20140701"));
			sr4.setEndDate(sdf.parse("20140702"));
			b4_1 = new Bed(2, sdf.parse("20140701"), 1, 2, 14, BedState.SEARCHED);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bed> beds4 = new ArrayList<Bed>();
		beds4.add(b4_1);
		
		sr4.setTotalPrice(14);
		sr4.setBeds(beds4);
		searchResultSet.add(sr4);
		
		return searchResultSet;
	}

	private List<Hostel>  getHostelListForOneDay(){
		List<Hostel> hostels = new ArrayList<Hostel>();
		
		Address address = new Address(1, "123 Main Street", "Anytown", "Anystate", "10456-7890", "USA");
		Contact contact = new Contact(1, "+1-555-555-5555", "romantic@hostel21.com", "hostel21-romantic", "romantic.hostel21.com");
		Policy policy = new Policy(1, "14:00", "11:00", false, false, 48, 75);
		List<Bed> beds = new ArrayList<Bed>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null,b2 = null;
		try {
			 b1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, BedState.AVAILABLE);
			 b2 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, BedState.AVAILABLE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beds.add(b1);
		beds.add(b2);
		
		Hostel hostel = new Hostel(1, "Hostel 21 - Romantic", address, contact, policy, beds);
		hostels.add(hostel);
		
		Address address1 = new Address(2, "125 Main Street", "Anytown", "Anystate", "10456-7890", "USA");
		Contact contact1 = new Contact(2, "+1-555-555-5555", "happy@hostel21.com", "hostel21-happy", "happy.hostel21.com");
		Policy policy1 = new Policy(2, "14:00", "11:00", false, false, 48, 75);
		List<Bed> beds1 = new ArrayList<Bed>();
		
		Bed bd1 = null,bd2 = null;
		try {
			 bd1 = new Bed(2, sdf.parse("20140701"), 1, 1, 10, BedState.AVAILABLE);
			 bd2 = new Bed(2, sdf.parse("20140701"), 1, 2, 14, BedState.AVAILABLE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beds1.add(bd1);
		beds1.add(bd2);
		
		Hostel hostel1 = new Hostel(2, "Hostel 21 - Happy", address1, contact1, policy1, beds1);
		hostels.add(hostel1);
		
		return hostels;	
	}
	
	private List<Hostel>  getHostelListForTwoDays(){
		List<Hostel> hostels = new ArrayList<Hostel>();
		
		Address address = new Address(1, "123 Main Street", "Anytown", "Anystate", "10456-7890", "USA");
		Contact contact = new Contact(1, "+1-555-555-5555", "romantic@hostel21.com", "hostel21-romantic", "romantic.hostel21.com");
		Policy policy = new Policy(1, "14:00", "11:00", false, false, 48, 75);
		List<Bed> beds = new ArrayList<Bed>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Bed b1 = null,b2 = null,b3=null;
		Bed b11 = null,b21 = null;
		try {
			 b1 = new Bed(1, sdf.parse("20140701"), 1, 1, 15, BedState.AVAILABLE);
			 b2 = new Bed(1, sdf.parse("20140701"), 1, 2, 14, BedState.AVAILABLE);
			 b3 = new Bed(1, sdf.parse("20140701"), 1, 3, 11, BedState.AVAILABLE);
			 b11 = new Bed(1, sdf.parse("20140702"), 1, 1, 10, BedState.AVAILABLE);
			 b21 = new Bed(1, sdf.parse("20140702"), 1, 2, 12, BedState.AVAILABLE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beds.add(b1);
		beds.add(b2);
		beds.add(b3);
		beds.add(b11);
		beds.add(b21);
		
		Hostel hostel = new Hostel(1, "Hostel 21 - Romantic", address, contact, policy, beds);
		hostels.add(hostel);
		
		Address address1 = new Address(2, "125 Main Street", "Anytown", "Anystate", "10456-7890", "USA");
		Contact contact1 = new Contact(2, "+1-555-555-5555", "happy@hostel21.com", "hostel21-happy", "happy.hostel21.com");
		Policy policy1 = new Policy(2, "14:00", "11:00", false, false, 48, 75);
		List<Bed> beds1 = new ArrayList<Bed>();
		
		Bed bd1 = null,bd2 = null;
		try {
			 bd1 = new Bed(2, sdf.parse("20140701"), 1, 1, 10, BedState.AVAILABLE);
			 bd2 = new Bed(2, sdf.parse("20140701"), 1, 2, 14, BedState.AVAILABLE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		beds1.add(bd1);
		beds1.add(bd2);
		
		Hostel hostel1 = new Hostel(2, "Hostel 21 - Happy", address1, contact1, policy1, beds1);
		hostels.add(hostel1);
		
		return hostels;	
	}
}
