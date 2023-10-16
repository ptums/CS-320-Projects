import java.util.Random;

public class Contact {
    private int contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(int contactID, String firstName, String lastName, String phone, String address) {
        setContactID(contactID);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public static int generateUniqueID() {
        int charLen = 9;
        String characters = "0123456789";

        StringBuilder strBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < charLen; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            strBuilder.append(randomChar);
        }

        String randomStr = strBuilder.toString();

        int randomId = Integer.parseInt(randomStr);

        return randomId;
    }

    public int getContactID() { return this.contactID; }

    public void setContactID(int contactID) {
        String contactIDToString = Integer.toString(contactID);

        if (contactIDToString == null || contactID > 10) {
            this.contactID = -1;
            System.err.println("Contact ID must not be null and cannot exceed 10 characters.");
        } else {
            this.contactID = contactID;
        }
    }


    public String getFirstName() {
        return this.firstName;
    }


    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            this.firstName = null;
            System.err.println("First name must not be null and cannot exceed 10 characters.");
        } else {
            this.firstName = firstName;
        }
    }


    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            this.lastName = null;
            System.err.println("Last name must not be null and cannot exceed 10 characters.");
        } else {
            this.lastName = lastName;
        }
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            this.phone = null;
            System.err.println("Phone number must not be null and must be exactly 10 digits.");
        } else {
            this.phone = phone;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            this.address = null;
            System.err.println("Address must not be null and cannot exceed 30 characters.");
        } else {
            this.address = address;
        }
    }
}