package cs445.project.facilitator;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cs445.project.base.BedState;
import cs445.project.base.Booking;
import cs445.project.base.BookingState;
import cs445.project.base.Hostel;
import cs445.project.base.User;
import cs445.project.structs.SearchResult;

public class BookFacilitator {
	
	DBSaveRestore dbSaveRestore;
	
	public BookFacilitator() {
		dbSaveRestore = new DBSaveRestore();
	}
	
	public Booking book(Integer searchId, Integer userId){
		Booking booking = null;
		//Get searchResult using searchId
		SearchResult searchResult = dbSaveRestore.getSearchedDataById(searchId);
		User user = dbSaveRestore.getUserById(userId);
		
		if(searchResult != null && user != null){
			booking = new Booking();
			
			//Update the status of the bed
			searchResult.updateBedStatus(BedState.BOOKED);
			booking.setBeds(searchResult.getBeds());
			booking.setEndDate(searchResult.getEndDate());
			booking.setStartDate(searchResult.getStartDate());
			booking.setHostelId(searchResult.getHostelId());
			booking.setHostelName(searchResult.getHostelName());
			booking.setTotalPrice(searchResult.getTotalPrice());
			booking.setUserId(userId);
			booking.setState(BookingState.BOOKED);
			
			//Book the bed i.e update the bed status in the Bed DB
			dbSaveRestore.updateBedStatus(booking.getBeds());
			
			//Save the booking status in the Booking DB
			booking.setBookingId(dbSaveRestore.addBooking(booking));
			
			//Delete the search Id from the DB
			dbSaveRestore.deleteSearchIdData(searchId);
		}
		else {
			System.out.println("Search Id or user Id doesn't exist!! Please try with valid searchId/userId");
		}
		
		return booking;
	}
	
	public Booking getBookingDetailsById(Integer bookingId) {
		
		return dbSaveRestore.getBookingById(bookingId);
	}
	
	public List<Booking> getAllBookings(){
		return dbSaveRestore.getAllBookings();
	}
	
	public void cancelBooking(Booking booking) {
		booking.updateBedStatus(BedState.AVAILABLE);
		dbSaveRestore.updateBedStatus(booking.getBeds());
		
		Hostel hostel = dbSaveRestore.getHostelById(booking.getHostelId());
		Date cancellationDeadLine = addHours(booking.getStartDate(),-(hostel.getPolicy().getCancellationDeadline()));
		Date currentDate = new Date();
		Integer cancellationCharges =0;
		System.out.println("DeadLine " + cancellationDeadLine+" StartDate: "+ booking.getStartDate() +" current Date "+ currentDate);
		if(currentDate.after(cancellationDeadLine)) {
			cancellationCharges = (booking.getTotalPrice()*hostel.getPolicy().getCancellationPenalty() )/100; 
		}
		
		booking.setTotalPrice(cancellationCharges);
		booking.setState(BookingState.CANCELLED);
		
		dbSaveRestore.updateBooking(booking);
		dbSaveRestore.deleteBooking(booking.getBookingId());
	}
	
    private Date addHours(Date date, int hours){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours); //minus number would decrement the days
        return cal.getTime();
    }

}
