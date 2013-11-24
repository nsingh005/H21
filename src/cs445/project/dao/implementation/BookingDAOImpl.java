package cs445.project.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.base.Booking;
import cs445.project.base.BookingState;
import cs445.project.dao.connection.DBConnectionFactory;
import cs445.project.dao.connection.ServiceLocatorException;

public class BookingDAOImpl {
	private DBConnectionFactory services = null;
	
	public BookingDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	public Integer insert(Booking booking) throws SQLException {
		Connection con = null;
		Integer bookingId=0;
		try{
			con = services.createConnection();
			PreparedStatement stmt;
			bookingId = getMaxBookingId() + 1;
			
			stmt = con.prepareStatement("insert into bookings (bookingId,hostelId,hostelName,startDate,endDate,totalPrice,userId,state) "
					+ " values (?,?,?,?,?,?,?,?);");
			stmt.setInt(1, bookingId);
			stmt.setInt(2, booking.getHostelId());
			stmt.setString(3,booking.getHostelName());
			stmt.setDate(4,new java.sql.Date(booking.getStartDate().getTime()));
			stmt.setDate(5,new java.sql.Date(booking.getEndDate().getTime()));
			stmt.setInt(6,booking.getTotalPrice());
			stmt.setInt(7, booking.getUserId());
			stmt.setString(8, booking.getState().name());
			
			stmt.execute();
			stmt.close();
			
			for(Bed bed: booking.getBeds()) {
				stmt = con.prepareStatement("insert into booked_beds (bookingId,room,bed,price,state,hostelId,date) " +
						" values (?,?,?,?,?,?,?);");
				stmt.setInt(1, bookingId);
				stmt.setInt(2, bed.getRoomNumber());
				stmt.setInt(3, bed.getBedNumber());
				stmt.setInt(4, bed.getPrice());
				stmt.setString(5, bed.getState().name());
				stmt.setInt(6, bed.getHostelId());
				stmt.setDate(7, new java.sql.Date(bed.getDate().getTime()));
				
				stmt.execute();
				stmt.close();	
			}
		
		}catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			 if(con != null){
				 con.close();
			 }
		}
		
		return bookingId;
	}
	
	public void updateBookingState(Booking booking) throws SQLException {
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt;
			
			stmt = con.prepareStatement("update  bookings set state=?,totalPrice=? where bookingId=?;");
			stmt.setString(1, booking.getState().name());
			stmt.setInt(2, booking.getTotalPrice());
			stmt.setInt(2, booking.getBookingId());
			stmt.executeUpdate();
			stmt.close();
	
		}catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			 if(con != null){
				 con.close();
			 }
		}		
	}
	
	public void delete(Integer bookingId) throws SQLException {
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt;
			
			stmt = con.prepareStatement("delete from  booked_beds where bookingId=?;");
			stmt.setInt(1, bookingId);
			stmt.execute();
			stmt.close();		
		
		}catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			 if(con != null){
				 con.close();
			 }
		}		
	}
	
	public List<Booking> getAllBookings() throws SQLException {
		Connection con = null;
		List<Booking> bookings =  new ArrayList<Booking>();
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from bookings; ");
			
			ResultSet rs = stmt.executeQuery();
			Booking booking;
			while(rs.next()){
				booking = createBookingInstance(rs);
				bookings.add(booking);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}
		
		return bookings;
	}
	
	public Booking getBookingById(Integer bookingId) throws SQLException {
		Connection con = null;
		Booking booking = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from bookings where bookingId=?; ");
			stmt.setInt(1, bookingId);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				booking = createBookingInstance(rs);				
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}
		
		return booking;
	}
	
	public List<Bed> getBookedBedByBookingId(Integer bookingId) throws SQLException {
		Connection con = null;
		List<Bed> beds = new ArrayList<Bed>();
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from booked_beds where bookingId = ?; ");
			stmt.setInt(1, bookingId);
			
			ResultSet rs = stmt.executeQuery();
			Bed bed;
			while(rs.next()){
				bed = createBookedBedInstance(rs);
				beds.add(bed);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}
		return beds;		
	}
	public List<Booking> getHostelBookings(Integer hostelId,Date startDate,Date endDate) throws SQLException {
		Connection con = null;
		List<Booking> bookings = new ArrayList<Booking> ();
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from bookings where hostelId = ? and "
					+ " startDate>=? and endDate<=?; ");
			stmt.setInt(1, hostelId);
			stmt.setDate(2, new java.sql.Date(startDate.getTime()));
			stmt.setDate(3, new java.sql.Date(endDate.getTime()));
						
			ResultSet rs = stmt.executeQuery();
						
			while(rs.next()){
				Booking b = createBookingInstance(rs);
				bookings.add(b);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}
		
		return bookings;		
	}
	
	public List<Bed> getBookedBedByHostelId(Integer hostelId) throws SQLException {
		Connection con = null;
		List<Bed> beds = new ArrayList<Bed>();
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from booked_beds where hostelId = ?; ");
			stmt.setInt(1, hostelId);
			
			ResultSet rs = stmt.executeQuery();
			Bed bed;
			while(rs.next()){
				bed = createBookedBedInstance(rs);
				beds.add(bed);
			}
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}
		return beds;		
	}
	
	private Integer getMaxBookingId() throws SQLException {
		Connection con = null;
		Integer maxBookingId = 0;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select max(bookingId) from bookings;");
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				maxBookingId = rs.getInt(1);
			}
			
			rs.close();
			stmt.close();
		}catch (ServiceLocatorException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				con.close();
			}
		}
		
		return maxBookingId;
	}
	
	Bed createBookedBedInstance(ResultSet rs) throws SQLException {
		Bed bed = new Bed();
		
		bed.setBedNumber(rs.getInt("bed"));
		bed.setRoomNumber(rs.getInt("room"));
		bed.setDate(rs.getDate("date"));
		bed.setPrice(rs.getInt("price"));
		bed.setHostelId(rs.getInt("hostelId"));
		bed.setState(BedState.valueOf(rs.getString("state")));	
		
		return bed;
	}
	
	Booking createBookingInstance(ResultSet rs) throws SQLException {
		Booking booking = new Booking();
		
		booking.setBookingId(rs.getInt("bookingId"));
		booking.setHostelId(rs.getInt("hostelId"));
		booking.setEndDate(rs.getDate("endDate"));
		booking.setStartDate(rs.getDate("startDate"));
		booking.setHostelName(rs.getString("hostelName"));
		booking.setTotalPrice(rs.getInt("totalPrice"));		
		booking.setBeds(getBookedBedByBookingId(booking.getBookingId()));
		booking.setUserId(rs.getInt("userId"));
		booking.setState(BookingState.valueOf(rs.getString("state")));
		
		return booking;
	}
	
	Booking createBookingInstancePerHostel(ResultSet rs) throws SQLException {
		Booking booking = new Booking();
		
		booking.setBookingId(rs.getInt("bookingId"));
		booking.setHostelId(rs.getInt("hostelId"));
		booking.setEndDate(rs.getDate("endDate"));
		booking.setStartDate(rs.getDate("startDate"));
		booking.setHostelName(rs.getString("hostelName"));
		booking.setTotalPrice(rs.getInt("totalPrice"));		
		booking.setBeds(getBookedBedByHostelId(booking.getHostelId()));
		booking.setUserId(rs.getInt("userId"));
		
		return booking;
	}
}
