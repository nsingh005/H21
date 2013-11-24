package cs445.project.structs;

import java.util.Date;

public class SearchStruct {
	String     city;
	Date       startDate;
	Date       endDate;
	Integer    numberOfBeds;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public Integer getNumberOfBeds() {
		return numberOfBeds;
	}
	public void setNumberOfBeds(Integer numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}	
}
