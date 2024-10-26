import java.util.Scanner;

public class ContactService {
	
	public static Contact[] addContact(String id, String firstName, String lastName, String phoneNum, String userAddress, int arrSize, Contact[] contacts) {
		
		// Ensure user id is unique
		for (Contact contact : contacts) {
			if (contact.getId().compareTo(id) == 0) {
				throw new IllegalArgumentException("user id is taken");
			}
		}
		
		// initialize Contact and attributes
		Contact userContact = new Contact(id);
		userContact.setFirstName(firstName);
		userContact.setLastName(lastName);
		userContact.setPhoneNum(phoneNum);
		userContact.setAddress(userAddress);
		
		// Create a new array and initialize each element to it's previous index, with the new contact at the end of the new array
		Contact[] newContacts = new Contact[arrSize + 1];
		
		for (int i = 0; i < arrSize; i++)
			newContacts[i] = contacts[i];
		
		newContacts[arrSize] = userContact;
		
		System.out.println("Contact added.");
		
		return newContacts;
	}
	
	
	public static Contact[] deleteContact(String userId, int arrSize, Contact[] contacts) {
		// Delete a user per user ID
		Contact[] newContacts = new Contact[arrSize - 1];
		System.out.println(userId);
		for (int i = 0; i < arrSize; i++) {
			if (contacts[i].getId().compareTo(userId) != 0) {
				newContacts[i] = contacts[i];
			}	
		}
		System.out.println("Contact deleted");
		
		return newContacts;
	}
	
	/*
	 * Update Contacts by deleting the requested user id's contact and re-adding it with updated information
	 */
	public static Contact[] updateContact(String id, String firstName, String lastName, String phoneNum,
			String userAddress, int arrSize, Contact[] contacts) 
	{
		Contact[] updatedContacts = new Contact[0];
		updatedContacts = ContactService.addContact(id, firstName, lastName, phoneNum, userAddress, arrSize, contacts);
		
		return updatedContacts;
	}
}
