package cs445.project.base;

public class Contact {
	Integer contactId;
	String phoneNumber;
	String emailId;
	String facebookId;
	String webURL;
	
	public Contact() {

	}
	
	public Contact(Integer contactId, String phoneNumber, String emailId,
			String facebookId, String webURL) {
		super();
		this.contactId = contactId;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.facebookId = facebookId;
		this.webURL = webURL;
	}
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	public String getWebURL() {
		return webURL;
	}
	public void setWebURL(String webURL) {
		this.webURL = webURL;
	}
	@Override
	public String toString() {
		return "Contact [phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", facebookId=" + facebookId + ", webURL=" + webURL + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result
				+ ((facebookId == null) ? 0 : facebookId.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((webURL == null) ? 0 : webURL.hashCode());
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
		Contact other = (Contact) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (facebookId == null) {
			if (other.facebookId != null)
				return false;
		} else if (!facebookId.equals(other.facebookId))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (webURL == null) {
			if (other.webURL != null)
				return false;
		} else if (!webURL.equals(other.webURL))
			return false;
		return true;
	}
	
}
