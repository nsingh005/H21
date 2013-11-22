package cs445.project.base;

public class Policy {
	Integer policyId;
	String checkInTime;
	String checkOutTime;
	boolean isSmoking;
	boolean isAlcohol;
	Integer cancellationDeadline;
	Integer cancellationPenalty;
	
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(Integer policyId, String checkInTime, String checkOutTime,
			boolean isSmoking, boolean isAlcohol, Integer cancellationDeadline,
			Integer cancellationPenalty) {
		super();
		this.policyId = policyId;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.isSmoking = isSmoking;
		this.isAlcohol = isAlcohol;
		this.cancellationDeadline = cancellationDeadline;
		this.cancellationPenalty = cancellationPenalty;
	}
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public boolean isSmoking() {
		return isSmoking;
	}
	public void setSmoking(boolean isSmoking) {
		this.isSmoking = isSmoking;
	}
	public boolean isAlcohol() {
		return isAlcohol;
	}
	public void setAlcohol(boolean isAlcohol) {
		this.isAlcohol = isAlcohol;
	}
	public Integer getCancellationDeadline() {
		return cancellationDeadline;
	}
	public void setCancellationDeadline(Integer cancellationDeadline) {
		this.cancellationDeadline = cancellationDeadline;
	}
	public Integer getCancellationPenalty() {
		return cancellationPenalty;
	}
	public void setCancellationPenalty(Integer cancellationPenalty) {
		this.cancellationPenalty = cancellationPenalty;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", checkInTime=" + checkInTime
				+ ", checkOutTime=" + checkOutTime + ", isSmoking=" + isSmoking
				+ ", isAlcohol=" + isAlcohol + ", cancellationDeadline="
				+ cancellationDeadline + ", cancellationPenalty="
				+ cancellationPenalty + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((cancellationDeadline == null) ? 0 : cancellationDeadline
						.hashCode());
		result = prime
				* result
				+ ((cancellationPenalty == null) ? 0 : cancellationPenalty
						.hashCode());
		result = prime * result
				+ ((checkInTime == null) ? 0 : checkInTime.hashCode());
		result = prime * result
				+ ((checkOutTime == null) ? 0 : checkOutTime.hashCode());
		result = prime * result + (isAlcohol ? 1231 : 1237);
		result = prime * result + (isSmoking ? 1231 : 1237);
		result = prime * result
				+ ((policyId == null) ? 0 : policyId.hashCode());
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
		Policy other = (Policy) obj;
		if (cancellationDeadline == null) {
			if (other.cancellationDeadline != null)
				return false;
		} else if (!cancellationDeadline.equals(other.cancellationDeadline))
			return false;
		if (cancellationPenalty == null) {
			if (other.cancellationPenalty != null)
				return false;
		} else if (!cancellationPenalty.equals(other.cancellationPenalty))
			return false;
		if (checkInTime == null) {
			if (other.checkInTime != null)
				return false;
		} else if (!checkInTime.equals(other.checkInTime))
			return false;
		if (checkOutTime == null) {
			if (other.checkOutTime != null)
				return false;
		} else if (!checkOutTime.equals(other.checkOutTime))
			return false;
		if (isAlcohol != other.isAlcohol)
			return false;
		if (isSmoking != other.isSmoking)
			return false;
		if (policyId == null) {
			if (other.policyId != null)
				return false;
		} else if (!policyId.equals(other.policyId))
			return false;
		return true;
	}
}
