package cs445.project.structs;

import java.util.List;


public class SearchGeneric {

	Integer hostelId;
	String hostelName;
	List<AvailableBedInfo> availableBedInfoList;
	
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
	public List<AvailableBedInfo> getAvailableBedInfo() {
		return availableBedInfoList;
	}
	public void setAvailableBedInfo(List<AvailableBedInfo> availableBedInfo) {
		this.availableBedInfoList = availableBedInfo;
	}
	@Override
	public String toString() {
		return "SearchGeneric [hostelId=" + hostelId + ", hostelName="
				+ hostelName + ", availableBedInfoList=" + availableBedInfoList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((availableBedInfoList == null) ? 0 : availableBedInfoList
						.hashCode());
		result = prime * result
				+ ((hostelId == null) ? 0 : hostelId.hashCode());
		result = prime * result
				+ ((hostelName == null) ? 0 : hostelName.hashCode());
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
		SearchGeneric other = (SearchGeneric) obj;
		if (availableBedInfoList == null) {
			if (other.availableBedInfoList != null)
				return false;
		} else if (!availableBedInfoList.equals(other.availableBedInfoList))
			return false;
		if (hostelId == null) {
			if (other.hostelId != null)
				return false;
		} else if (!hostelId.equals(other.hostelId))
			return false;
		if (hostelName == null) {
			if (other.hostelName != null)
				return false;
		} else if (!hostelName.equals(other.hostelName))
			return false;
		return true;
	}

}
