package cs445.project.base;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Bed {

	Integer hostelId;
	Date date;
	Integer roomNumber;
	Integer bedNumber;
	Integer price;
	BedState  state;

	public Bed(Integer hostelId, Date date, Integer roomNumber,
			Integer bedNumber, Integer price, BedState state) {
		super();
		this.hostelId = hostelId;
		this.date = date;
		this.roomNumber = roomNumber;
		this.bedNumber = bedNumber;
		this.price = price;
		this.state = state;
	}

	public Bed(Date date, Integer roomNumber, Integer bedNumber, Integer price) {
		super();
		this.date = date;
		this.roomNumber = roomNumber;
		this.bedNumber = bedNumber;
		this.price = price;
		this.state = BedState.AVAILABLE;
	}
	
	public Bed(Date date, Integer roomNumber, Integer bedNumber, Integer price,
			BedState state) {
		super();
		this.date = date;
		this.roomNumber = roomNumber;
		this.bedNumber = bedNumber;
		this.price = price;
		this.state = state;
	}

	public Bed() {
		// TODO Auto-generated constructor stub
	}

	public Integer getHostelId() {
		return hostelId;
	}

	public void setHostelId(Integer hostelId) {
		this.hostelId = hostelId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public BedState getState() {
		return state;
	}

	public void setState(BedState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return "Bed [date=" + sdf.format(date) + ", roomNumber=" + roomNumber
				+ ", bedNumber=" + bedNumber + ", price=" + price + ", state="
				+ state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bedNumber == null) ? 0 : bedNumber.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((roomNumber == null) ? 0 : roomNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bed other = (Bed) obj;
		if (bedNumber == null) {
			if (other.bedNumber != null)
				return false;
		} else if (!bedNumber.equals(other.bedNumber))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		return true;
	}
	
	
}
