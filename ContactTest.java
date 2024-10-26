import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	// Ensures the object is being constructed correctly
	void testContactClassConstructor() {
		Contact contact = new Contact("userID123");
		assertTrue(contact.getId().equals("userID123"));
	}
	
	/* *
	 * User ID tests 
	 * */
	@Test
	void testUserIdTooLong( ) {
		// User id can be up to 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("userID1234567890");
		});
	}
	@Test
	void testUserIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(null);
		});
	}
	@Test
	void testGetUserId() {
		Contact contact = new Contact("userID123");
		assertTrue(contact.getId().compareTo("userID123") == 0);
	}
	
	/* *
	 * First Name tests 
	 * */
	@Test
	void testFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("userID123");
			contact.setFirstName(null);
		});
	}
	@Test
	void testFirstNameTooLong( ) {
		// Confirms exceptions are thrown if the length of the name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("userID123");
			contact.setFirstName("reedoaps4534oal");
		});
	}
	@Test
	void testGetFirstName() {
		Contact contact = new Contact("userID123");
		contact.setFirstName("Reed");
		assertTrue(contact.getFirstName().compareTo("Reed") == 0);
	}
	
	/* *
	 * Last Name tests 
	 * */
	@Test
	void testLastNameIsNull() {
		// exception thrown if last name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("user123");
			contact.setLastName(null);
		});
	}
	@Test
	void testLastNameTooLong() {
		// exception thrown if last name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("user123");
			contact.setLastName("Morethan10characters");
		});
	}
	@Test
	void testGetLastName() {
		Contact contact = new Contact("username");
		contact.setLastName("Murray");
		assertTrue(contact.getLastName().compareTo("Murray") == 0);
	}
	
	/* *
	 * Phone Number tests 
	 * */
	@Test
	void testPhoneNumTooShort() {
		// Phone numbers should be exactly 10 digits
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("user123");
			contact.setPhoneNum("12345");
		});
	}
	@Test
	void testPhoneIsNull() {
		// Phone numbers should be exactly 10 digits
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("user123");
			contact.setPhoneNum(null);
		});
	}
	@Test
	void testPhoneNumTooLong() {
		// Phone number too long for character limit
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("user123");
			contact.setPhoneNum("123456789011");
		});
	}
	@Test
	void testGetPhoneNum() {
		Contact contact = new Contact("user");
		contact.setPhoneNum("8592322323");
		assertTrue(contact.getPhoneNum().compareTo("8592322323") == 0);
	}
	
	/* *
	 * Address tests 
	 * */
	@Test
	void testAddressIsNull() {
		// Addresses can be up to 30 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("user123");
			contact.setAddress(null);
		});
	}
	
	@Test
	void testAddressTooLong() {
		// Addresses can be up to 30 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("user123");
			contact.setAddress("12345 This address is too long Street, apartment 15, Long Island new york");
		});
	}
	@Test
	void testGetAddress() {
		Contact contact = new Contact("user");
		contact.setAddress("123 street lane");
		assertTrue(contact.getAddress().compareTo("123 street lane") == 0);
	}
}

