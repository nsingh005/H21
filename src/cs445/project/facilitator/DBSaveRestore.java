package cs445.project.facilitator;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.Booking;
import cs445.project.base.Hostel;
import cs445.project.base.User;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;
import cs445.project.dao.implementation.AddressDAOImpl;
import cs445.project.dao.implementation.BedDAOImpl;
import cs445.project.dao.implementation.BookingDAOImpl;
import cs445.project.dao.implementation.ContactDAOImpl;
import cs445.project.dao.implementation.HostelDAOImpl;
import cs445.project.dao.implementation.PolicyDAOImpl;
import cs445.project.dao.implementation.SearchDAOImpl;
import cs445.project.dao.implementation.UserDAOImpl;
import cs445.project.structs.SearchResult;

public class DBSaveRestore {
	private DBConnectionFactory services;
	private HostelDAOImpl hostelDAOImpl;
	private AddressDAOImpl addressDAO;
	private ContactDAOImpl contactDAO;
	private PolicyDAOImpl policyDAO;
	private BedDAOImpl bedDAO;
	private SearchDAOImpl searchDAO;
	private UserDAOImpl userDAO;
	private BookingDAOImpl bookingDAO;
	
	public DBSaveRestore()  {
		try {
			this.services = new DBConnectionFactory();
		} catch (ServiceLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.hostelDAOImpl = new HostelDAOImpl(services);
		this.bedDAO = new BedDAOImpl(services);
		this.contactDAO = new ContactDAOImpl(services);
		this.addressDAO = new AddressDAOImpl(services);
		this.policyDAO = new PolicyDAOImpl(services);
		this.searchDAO = new SearchDAOImpl(services);
		this.userDAO = new UserDAOImpl(services);
		this.bookingDAO = new BookingDAOImpl(services);
	}
	
	public void addHostelList(List<Hostel> hostels)  {
		for(Hostel hostel : hostels) {
			addHostel(hostel);			
		}
	}
	
	public void addHostel(Hostel hostel) {
		try {
			hostel.getPolicy().setPolicyId(policyDAO.insert(hostel.getPolicy()));
			hostel.getAddress().setAddressId(addressDAO.insert(hostel.getAddress()));
			hostel.getContact().setContactId(contactDAO.insert(hostel.getContact()));
			hostel.setHostelId(hostelDAOImpl.insert(hostel));
			hostel.setHostelIdInBeds(hostel.getHostelId());
			bedDAO.insertBedList(hostel.getBeds());
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Hostel> getHostelList() {
		List<Hostel> hostels = null;
		
		try {
			hostels = hostelDAOImpl.getAllHostel();
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hostels;
	}
	
	public Hostel getHostelById(Integer hostelId) {
		Hostel hostel = null;
		
		try {
			hostel = hostelDAOImpl.getHostelById(hostelId);
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hostel;
	}
	public List<Hostel> getAvailableBedsInAllHostels (Date startDate, Date endDate) {
		List<Hostel> hostels = null;
		
		try {
			hostels = hostelDAOImpl.getAvailableBedsInAllHostels(startDate, endDate);
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hostels;	
	}
	
	private boolean hasHostel(List<Hostel> hostels, Hostel hostel) {
		boolean result = false;
		
		for(Hostel h : hostels) {
			if(h.getName().compareTo(hostel.getName()) == 0) {
				result = true;
			}
		}
		
		return result;
	}
	
	private Hostel getHostelFromList(List<Hostel> hostels, Hostel hostel) {
		Hostel retHostel = null;
		
		for(Hostel h : hostels) {
			if(h.getName().compareTo(hostel.getName()) == 0) {
				retHostel = h;
				break;
			}
		}
		
		return retHostel;
	}
	
	public void loadUpdateHostelList(List<Hostel> hostels) {
		List<Hostel> savedHostelList = getHostelList();

		for(Hostel hostel : hostels) {
			if (hasHostel(savedHostelList,hostel) == false) {
				//hostel Not present in list so add it 
				addHostel(hostel);
			}
			else {
				//Hostel is present, just update the list
				Hostel h = getHostelFromList(savedHostelList, hostel);
				if(h != null){
					if(!hostel.equals(h)){
						hostel.setAllIds(h);
						updateHostel(hostel);
					}
				}
			}
		}
	}
	
	public void updateHostelList(List<Hostel> hostels) {

		  
		for(Hostel hostel:hostels) {
			try {
				addressDAO.update(hostel.getAddress());
				contactDAO.update(hostel.getContact());
				policyDAO.update(hostel.getPolicy());
				hostelDAOImpl.update(hostel);
				bedDAO.updateBedList(hostel.getBeds());
			} catch (SQLException | ServiceLocatorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateHostel(Hostel hostel) {
		try {
			addressDAO.update(hostel.getAddress());
			contactDAO.update(hostel.getContact());
			policyDAO.update(hostel.getPolicy());
			hostelDAOImpl.update(hostel);
			bedDAO.updateBedList(hostel.getBeds());
		} catch (SQLException | ServiceLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteSearchData() {
		try {
			searchDAO.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteSearchIdData(Integer searchId) {
		try {
			searchDAO.deleteById(searchId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addSearchData(List<SearchResult> searchResultSet) {
		try {
			searchDAO.insert(searchResultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<SearchResult> getSearchedData(){
		List<SearchResult> searchResultSet = null;
		
		try {
			searchResultSet = searchDAO.getSearchResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return searchResultSet;
	}
	
	public SearchResult getSearchedDataById(Integer searchId){
		SearchResult searchResult = null;
		
		try {
			searchResult = searchDAO.getSearchResultById(searchId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return searchResult;
	}
	
	public List<User> getAllUsers(){
		List<User> users = null;
		
		try {
			users = userDAO.getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public User getUserById(Integer userId){
		User user = null;
		
		try {
			user = userDAO.getUserById(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public void updateUser(User user){
		try {
			userDAO.update(user);
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Integer addUser(User user) {
		Integer userId=0;
		try {
			userId = userDAO.insert(user);
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userId;
	}
	
	public void updateBedStatus(List<Bed> beds){
		try {
			bedDAO.updateBedStatus(beds);
		} catch (SQLException | ServiceLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Integer addBooking(Booking booking) {
		Integer bookingId = 0;
		try {
			bookingId =  bookingDAO.insert(booking);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookingId;
	}
	
	public Booking getBookingById(Integer bookingId){
		Booking booking=null;
		try {
			booking= bookingDAO.getBookingById(bookingId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return booking;
	}
	
	public List<Bed> getBookingsByHostelId(Integer hostelId){
		List<Bed> beds=null;
		try {
			beds= bookingDAO.getBookedBedByHostelId(hostelId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return beds;
	}
	
	public List<Booking> getHostelBookings(Integer hostelId,Date startDate,Date endDate) {
		List<Booking> bookings=null;
		
		try {
			bookings =  bookingDAO.getHostelBookings(hostelId,startDate,endDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookings;
	}
	
	public void updateBooking(Booking booking) {
		try {
			bookingDAO.updateBookingState(booking);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteBooking(Integer bookingId) {		
		try {
			bookingDAO.delete(bookingId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
