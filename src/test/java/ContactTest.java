import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    @Test
    void getTestContactFirstName() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        assertAll(
                () -> assertEquals("Peter", testContact.getFirstName()),
                () -> assertNotNull(testContact.getFirstName()),
                () -> assertTrue(testContact.getFirstName().length() < 10)
        );
    }

    @Test
    void setTestContactFirstName() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        testContact.setFirstName("Bill");
        assertAll(
                () -> assertEquals("Bill", testContact.getFirstName()),
                () -> assertNotNull(testContact.getFirstName()),
                () -> assertTrue(testContact.getFirstName().length() < 10)
        );
        testContact.setFirstName("This is a very long name to trigger the error");
        assertNull(testContact.getFirstName());
    }

    @Test
    void getTestContactLastName() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        assertAll(
                () -> assertEquals("T", testContact.getLastName()),
                () -> assertNotNull(testContact.getLastName()),
                () -> assertTrue(testContact.getLastName().length() < 10)
        );
    }

    @Test
    void setTestContactLastName() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        testContact.setLastName("B");
        assertAll(
                () -> assertEquals("B", testContact.getLastName()),
                () -> assertNotNull(testContact.getLastName()),
                () -> assertTrue(testContact.getLastName().length() < 10)
        );

        testContact.setLastName("This is a very long name to trigger the error");
        assertNull(testContact.getLastName());
    }

    @Test
    void getTestContactPhone() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        assertAll(
                () -> assertEquals("1234789653", testContact.getPhone()),
                () -> assertNotNull(testContact.getPhone()),
                () -> assertEquals(10, testContact.getPhone().length())
        );
    }

    @Test
    void setTestContactPhone() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        testContact.setPhone("1111111111");
        assertAll(
                () -> assertEquals("1111111111", testContact.getPhone()),
                () -> assertNotNull(testContact.getPhone()),
                () -> assertEquals(10, testContact.getPhone().length())
        );

        testContact.setPhone("1111111111111111");
        assertNull(testContact.getPhone());
    }

    @Test
    void getTestContactAddress() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        assertAll(
                () -> assertEquals("123 Address St.", testContact.getAddress()),
                () -> assertNotNull(testContact.getAddress()),
                () -> assertTrue(testContact.getAddress().length() < 30)
        );
    }

    @Test
    void setTestContactAddress() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        testContact.setAddress("456 Address St.");
        assertAll(
                () -> assertEquals("456 Address St.", testContact.getAddress()),
                () -> assertNotNull(testContact.getAddress()),
                () -> assertTrue(testContact.getAddress().length() < 30)
        );

        testContact.setAddress("44444455555666666 Addressssss St., New York, NY");
        assertNull(testContact.getAddress());
    }

    @Test
    void getTestContactId() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        assertAll(
                () -> assertNotNull(testContact.getContactID()),
                () -> assertNotEquals(testContact.getContactID(), 0002),
                () -> assertEquals(testContact.getContactID(), 0),
                () -> assertTrue(testContact.getContactID() < 10)
        );
    }

    @Test
    void setTestContactId() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        testContact.setContactID(003);
        assertAll(
                () -> assertNotNull(testContact.getContactID()),
                () -> assertNotEquals(testContact.getContactID(), 004),
                () -> assertEquals(testContact.getContactID(), 003)
        );
        testContact.setContactID(329537670);
        assertEquals(testContact.getContactID(), -1);
    }

    @Test
    void generateUniqueID() {
        Contact testContact = new Contact(0, "Peter", "T", "1234789653", "123 Address St.");
        int testContactId = Contact.generateUniqueID();
        String testContactIDToString = Integer.toString(testContactId);
        testContact.setContactID(testContactId);
        assertAll(
                () -> assertNotNull(testContactId),
                () -> assertTrue(testContactIDToString.length() < 10)
        );
    }
}