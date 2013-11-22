package cs445.project.structs;

import java.text.SimpleDateFormat;
import java.util.Date;

import cs445.project.base.Hostel;

public class Revenue {
	Hostel hostel;
	Date startDate;
	Date endDate;
	Integer revenue;

	public Revenue(Hostel hostel, Date startDate, Date endDate, Integer revenue) {
		super();
		this.hostel = hostel;
		this.startDate = startDate;
		this.endDate = endDate;
		this.revenue = revenue;
	}
	public Hostel getHostel() {
		return hostel;
	}
	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
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
	public Integer getRevenue() {
		return revenue;
	}
	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return "Revenue [startDate=" + sdf.format(startDate) + ", endDate=" + sdf.format(endDate)
				+ ", revenue=" + revenue + "]";
	}
	
	
}
