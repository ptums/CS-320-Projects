import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private static final Map<Integer, Contact> contacts = new HashMap<>();

    // Delete contact
    public static boolean deleteContact(int contactId) {
        if (contacts.containsKey(contactId)) {
            contacts.remove(contactId);

            return true;
        }

        return false;
    }

    public static Contact getContact(int contactId) {
        return contacts.get(contactId);
    }

    // Add a new contact
    public int addContact(String firstName, String lastName, String phone, String address) {
        int contactId = Contact.generateUniqueID();
        Contact contact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, contact);

        return contactId;
    }

    // Update firstname
    public boolean updateFirstName(int contactId, String newFirstName) {
        if (contacts.containsKey(contactId)) {
            Contact currentContact = contacts.get(contactId);
            currentContact.setFirstName(newFirstName);

            return true;
        }

        return false;
    }

    // update last name
    public boolean updateLastName(int contactId, String newLastName) {
        if (contacts.containsKey(contactId)) {
            Contact currentContact = contacts.get(contactId);
            currentContact.setLastName(newLastName);

            return true;
        }

        return false;

    }

    // update phone
    public boolean updatePhone(int contactId, String newPhone) {
        if (contacts.containsKey(contactId)) {
            Contact currentContact = contacts.get(contactId);
            currentContact.setPhone(newPhone);

            return true;
        }

        return false;

    }

    // update address
    public boolean updateAddress(int contactId, String newAddress) {
        if (contacts.containsKey(contactId)) {
            Contact currentContact = contacts.get(contactId);
            currentContact.setAddress(newAddress);

            return true;
        }

        return false;
    }

}
