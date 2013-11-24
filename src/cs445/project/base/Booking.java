package cs445.project.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Booking {
	

	private Integer   bookingId;
	private Integer   userId;
	private Integer   hostelId;
	private String    hostelName;
	private List<Bed> beds;
	private Date      startDate;
	private Date      endDate;
	private Integer   totalPrice;
	BookingState      state;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Booking(Integer bookingId, Integer userId, Integer hostelId,
			String hostelName, List<Bed> beds, Date startDate, Date endDate,
			Integer totalPrice, BookingState state) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.hostelId = hostelId;
		this.hostelName = hostelName;
		this.beds = beds;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.state = state;
	}

	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getHostelId() {
		return hostelId;
	}
	public void setHostelId(Integer hostelId) {
		this.hostelId = hostelId;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public List<Bed> getBeds() {
		return beds;
	}
	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public BookingState getState() {
		return state;
	}
	public void setState(BookingState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return "Booking [bookingId=" + bookingId + ", userId=" + userId
				+ ", hostelId=" + hostelId + ", hostelName=" + hostelName
				+ ", beds=" + beds + ", startDate=" + sdf.format(startDate) + ", endDate="
				+ sdf.format(endDate) + ", totalPrice=" + totalPrice + ", state=" + state
				+ "]";
	}
	public void updateBedStatus(BedState state){
		for(Bed bed:this.beds){
			bed.setState(state);
		}
	}
	
}
