package cs445.project.structs;

import cs445.project.base.Bed;
import cs445.project.base.BedState;
import cs445.project.base.Hostel;

public class Occupancy {
	Hostel hostel;
	Integer bedsBooked;
	Integer bedsAvailable;
	double occupancyRate;
	
	public Occupancy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Occupancy(Hostel hostel, Integer bedsBooked, Integer bedsAvailable,
			double occupancyRate) {
		super();
		this.hostel = hostel;
		this.bedsBooked = bedsBooked;
		this.bedsAvailable = bedsAvailable;
		this.occupancyRate = occupancyRate;
	}
	
	public Hostel getHostel() {
		return hostel;
	}
	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}
	public Integer getBedsBooked() {
		return bedsBooked;
	}
	public void setBedsBooked(Integer bedsBooked) {
		this.bedsBooked = bedsBooked;
	}
	public Integer getBedsAvailable() {
		return bedsAvailable;
	}
	public void setBedsAvailable(Integer bedsAvailable) {
		this.bedsAvailable = bedsAvailable;
	}
	public double getOccupancyRate() {		
		return occupancyRate;
	}
	public void setOccupancyRate(double occupancyRate) {
		this.occupancyRate = occupancyRate;
	}
	public void calculateOccupancy(){
		Integer totalBeds =0;
		Integer bedsOccupied=0;
		
		totalBeds = hostel.getBeds().size();
		for(Bed bed:hostel.getBeds()){
			if(bed.getState().compareTo(BedState.BOOKED) == 0){
				bedsOccupied++;
			}
		}
		this.bedsAvailable = totalBeds;
		this.bedsBooked=bedsOccupied;
		
		this.occupancyRate = ((double) bedsBooked/(double) totalBeds)*100;
	}
	@Override
	public String toString() {
		return "Occupancy ["+"bedsBooked=" + bedsBooked
				+ ", bedsAvailable=" + bedsAvailable + ", occupancyRate="
				+ occupancyRate + "%]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bedsAvailable == null) ? 0 : bedsAvailable.hashCode());
		result = prime * result
				+ ((bedsBooked == null) ? 0 : bedsBooked.hashCode());
		result = prime * result + ((hostel == null) ? 0 : hostel.hashCode());
		long temp;
		temp = Double.doubleToLongBits(occupancyRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Occupancy other = (Occupancy) obj;
		if (bedsAvailable == null) {
			if (other.bedsAvailable != null)
				return false;
		} else if (!bedsAvailable.equals(other.bedsAvailable))
			return false;
		if (bedsBooked == null) {
			if (other.bedsBooked != null)
				return false;
		} else if (!bedsBooked.equals(other.bedsBooked))
			return false;
		if (hostel == null) {
			if (other.hostel != null)
				return false;
		} else if (!hostel.equals(other.hostel))
			return false;
		if (Double.doubleToLongBits(occupancyRate) != Double
				.doubleToLongBits(other.occupancyRate))
			return false;
		return true;
	}
	
}
