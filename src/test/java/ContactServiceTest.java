import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService testContactService;

    @BeforeEach
    public void setUp() {
        testContactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        int contactId = testContactService.addContact("Peter", "T", "1234578911", "123 Sesame St.");
        assertAll(
                () -> assertNotNull(contactId)
        );
    }

    @Test
    public void testDeleteContact() {
        int contactId = testContactService.addContact("Peter", "T", "1234578911", "123 Sesame St.");
        assertAll(
                () -> assertTrue(ContactService.deleteContact(contactId))
        );
        assertFalse(ContactService.deleteContact(999999999));
    }

    @Test
    public void testUpdateFirstName() {
        int contactId = testContactService.addContact("Peter", "T", "1234578911", "123 Sesame St.");
        boolean updatedContact = testContactService.updateFirstName(contactId, "Jim");
        assertTrue(updatedContact);
        Contact currentContact = ContactService.getContact(contactId);
        assertAll(
                () -> assertNotEquals(currentContact.getFirstName(), "Jan"),
                () -> assertEquals(currentContact.getFirstName(), "Jim"),
                () -> assertNotNull(currentContact.getFirstName())
        );
        boolean falseUpdatedTask = testContactService.updateFirstName(999999999, "Jake");
        assertFalse(falseUpdatedTask);
    }

    @Test
    public void testUpdateLastName() {
        int contactId = testContactService.addContact("Peter", "T", "1234578911", "123 Sesame St.");
        boolean updatedLastName = testContactService.updateLastName(contactId, "B");
        Contact testContact = ContactService.getContact(contactId);

        assertAll(" test updated last name", () -> assertTrue(updatedLastName), () -> assertEquals("B", testContact.getLastName()));

        boolean falseUpdatedTask = testContactService.updateLastName(999999999, "Tully");
        assertFalse(falseUpdatedTask);
    }

    @Test
    public void testUpdatePhone() {
        int contactId = testContactService.addContact("Peter", "T", "1234578911", "123 Sesame St.");
        boolean updatedPhone = testContactService.updatePhone(contactId, "2222222255");
        Contact testContact = ContactService.getContact(contactId);

        assertAll(" test updated phone", () -> assertTrue(updatedPhone), () -> assertEquals("2222222255", testContact.getPhone()));

        boolean falseUpdatedTask = testContactService.updatePhone(999999999, "2222222255");
        assertFalse(falseUpdatedTask);
    }

    @Test
    public void testUpdateAddress() {
        int contactId = testContactService.addContact("Peter", "T", "1234578911", "123 Sesame St.");
        boolean updatedAddress = testContactService.updateAddress(contactId, "234 Sesame St.");
        Contact testContact = ContactService.getContact(contactId);

        assertAll(" test updated address", () -> assertTrue(updatedAddress), () -> assertEquals("234 Sesame St.", testContact.getAddress()));

        boolean falseUpdatedTask = testContactService.updateAddress(999999999, "234 Sesame St.");
        assertFalse(falseUpdatedTask);
    }
}
