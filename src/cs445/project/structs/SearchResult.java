package cs445.project.structs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cs445.project.base.Address;
import cs445.project.base.Bed;
import cs445.project.base.BedState;

public class SearchResult {
	Integer       searchId;
	Integer       hostelId;
	String        hostelName;
	Address       hostelAddress;
	List<Bed>     beds;
	Date          startDate;
	Date          endDate;
	Integer       totalPrice;
	
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public Address getHostelAddress() {
		return hostelAddress;
	}
	public void setHostelAddress(Address hostelAddress) {
		this.hostelAddress = hostelAddress;
	}
	public Integer getHostelId() {
		return hostelId;
	}
	public void setHostelId(Integer hostelId) {
		this.hostelId = hostelId;
	}
	public List<Bed> getBeds() {
		return beds;
	}
	public void setBeds(List<Bed> beds) {
		if(beds != null){
			this.beds = new ArrayList<Bed>(beds);
		}
		else {
			this.beds = null;
		}
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
	public void updateBedStatus(BedState state){
		for(Bed bed:this.beds){
			bed.setState(state);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beds == null) ? 0 : beds.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		SearchResult other = (SearchResult) obj;
		if (beds == null) {
			if (other.beds != null)
				return false;
		} else if (!beds.equals(other.beds))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}

	
	
}
