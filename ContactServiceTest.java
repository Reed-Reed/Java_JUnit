import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	/**
	 * Adding contacts and ensuring ID is unique
	 */
	@Test
	void testAddContact() {
		Contact[] contacts = new Contact[0];
		contacts = ContactService.addContact("user123", "reed", "murray", "1234567890", "123 reed st" , contacts.length, contacts);
		
		// Checks that the array is being re-sized properly
		assertTrue(contacts.length == 1);
		// Ensures the user id is correctly assigned
		assertTrue(contacts[0].getId().compareTo("user123") == 0);
	}
	
	@Test
	void testUserIdNotUnique() {
		// user cannot create a contact with an existing ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact[] contacts = new Contact[0];
			contacts = ContactService.addContact("user123", "reed", "murray", "1234567890", "123 reed st" , contacts.length, contacts);
			// Attempts to add contact with same id as previous contact
			contacts = ContactService.addContact("user123", "reed", "murray", "1234567890", "123 reed st" , contacts.length, contacts);
		});
	}
	
	/*
	 *  Deleting a contact, making sure the array is empty after deleted to verify the method works properly
	 */
	@Test
	void testDeleteContact() {
		// Create new contact array so we have something to delete
		Contact[] contacts = new Contact[0];
		contacts = ContactService.addContact("user123", "reed", "murray", "1234567890", "123 reed st" , contacts.length, contacts);
		contacts = ContactService.deleteContact("user123", contacts.length, contacts);
		assertTrue(contacts.length == 0);
		
	}
	
	/*
	 * Verifies updates to a contact: ContactService deletes the contact then calls updateContact
	 */
	@Test
	void testUpdateContact() {
		Contact[] contacts = new Contact[0];
		contacts = ContactService.addContact("user123", "reed", "murray", "1234567890", "123 reed st" , contacts.length, contacts);
		contacts = ContactService.deleteContact("user123", contacts.length, contacts);
		contacts = ContactService.updateContact("user123", "bob", "burray", "1234567891", "123 bob st" , contacts.length, contacts);
		
		assertTrue(contacts[0].getFirstName().compareTo("bob") == 0);
		assertTrue(contacts[0].getLastName().compareTo("burray") == 0);
		assertTrue(contacts[0].getPhoneNum().compareTo("1234567891") == 0);
		assertTrue(contacts[0].getAddress().compareTo("123 bob st") == 0);
	}
}
