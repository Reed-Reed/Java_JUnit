// Reed Murray
// The contact class can be used to create contact objects with unique IDs

public class Contact {
	// Attributes
	String firstName;
	String lastName;
	String phoneNum;
	String address;
	final String id;

	// Constructor
	public Contact(String userId) {
		if (userId == null || userId.length() > 10) {
			throw new IllegalArgumentException("invalid user id");
		}
		id = userId;
	}
	
	/*
	 * Accessors and mutators. SetId() is not created because ID cannot be updated per requirement
	 */
	public String getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String newName) {
		if (newName == null || newName.length() > 10) {
			throw new IllegalArgumentException("invalid name");
		}
		this.firstName = newName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String newName) {
		if (newName == null || newName.length() > 10) {
			throw new IllegalArgumentException("invalid last name");
		}
		this.lastName = newName;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String newNum) {
		if (newNum == null || newNum.length() != 10) {
			throw new IllegalArgumentException("invalid phone number");
		}
		this.phoneNum = newNum;
	}
	
	public String getAddress( ) {
		return address;
	}
	public void setAddress(String newAddress) {
		if (newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("invalid address");
		}
		this.address = newAddress;
	}	
}
