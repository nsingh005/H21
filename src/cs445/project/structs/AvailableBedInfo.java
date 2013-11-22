package cs445.project.structs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AvailableBedInfo {
	Date    startDate;
	Date    endDate;
	Integer bedsAvailable;
	Integer maxPrice;
	Integer minPrice;
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
	public Integer getBedsAvailable() {
		return bedsAvailable;
	}
	public void setBedsAvailable(Integer bedsAvailable) {
		this.bedsAvailable = bedsAvailable;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return "AvailableBedInfo [startDate=" + sdf.format(startDate) + ", endDate="
				+ sdf.format(endDate) + ", bedsAvailable=" + bedsAvailable + ", maxPrice="
				+ maxPrice + ", minPrice=" + minPrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bedsAvailable == null) ? 0 : bedsAvailable.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((maxPrice == null) ? 0 : maxPrice.hashCode());
		result = prime * result
				+ ((minPrice == null) ? 0 : minPrice.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		AvailableBedInfo other = (AvailableBedInfo) obj;
		if (bedsAvailable == null) {
			if (other.bedsAvailable != null)
				return false;
		} else if (!bedsAvailable.equals(other.bedsAvailable))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (maxPrice == null) {
			if (other.maxPrice != null)
				return false;
		} else if (!maxPrice.equals(other.maxPrice))
			return false;
		if (minPrice == null) {
			if (other.minPrice != null)
				return false;
		} else if (!minPrice.equals(other.minPrice))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
}
