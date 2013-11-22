package cs445.project.base;

import java.util.List;

public class Hostel {
	Integer hostelId;
	String name;
	Address address;
	Contact contact;
	Policy  policy;
	List<Bed> beds;
	
	
	public Hostel(String name, Address address, Contact contact, Policy policy,
			List<Bed> beds) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.policy = policy;
		this.beds = beds;
	}

	public Hostel(Integer hostelId, String name, Address address,
			Contact contact, Policy policy, List<Bed> beds) {
		super();
		this.hostelId = hostelId;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.policy = policy;
		this.beds = beds;
	}

	public Hostel() {
		// TODO Auto-generated constructor stub
	}

	public Integer getHostelId() {
		return hostelId;
	}

	public void setHostelId(Integer hostelId) {
		this.hostelId = hostelId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public List<Bed> getBeds() {
		return beds;
	}
	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}
	@Override
	public String toString() {
		return "Hostel [name=" + name + ", hostelId=" + hostelId + ", address=" + address + ", contact="
				+ contact + ", policy=" + policy+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((beds == null) ? 0 : beds.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((policy == null) ? 0 : policy.hashCode());
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
		Hostel other = (Hostel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (beds == null) {
			if (other.beds != null)
				return false;
		} else if (!beds.equals(other.beds))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (policy == null) {
			if (other.policy != null)
				return false;
		} else if (!policy.equals(other.policy))
			return false;
		return true;
	}

	public void setHostelIdInBeds(Integer hostelId) {
		for(Bed bed: beds) {
			bed.setHostelId(hostelId);
		}		
	}
	
	
	public void setAllIds(Hostel hostel){
		this.address.setAddressId(hostel.getAddress().getAddressId());
		this.contact.setContactId(hostel.getContact().getContactId());
		this.policy.setPolicyId(hostel.getPolicy().getPolicyId());
		this.hostelId = hostel.getHostelId();
		this.setHostelIdInBeds(hostelId);
	}
}
