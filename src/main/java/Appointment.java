import java.util.Date;
import java.util.Random;

public class Appointment {
    private Integer appointmentID;
    private Date appointmentDate;
    private String description;

    public Appointment(Integer appointmentID, Date appointmentDate, String description) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
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

    public Integer getAppointmentID() {
        return this.appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        String appointmentIDToString = Integer.toString(appointmentID);
        if (appointmentIDToString == null || appointmentID > 10) {
            this.appointmentID = -1;
            System.err.println("Task ID must not be null and cannot exceed 10 characters.");
        }
        this.appointmentID = appointmentID;
    }

    public Date getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            this.appointmentDate = null;
            System.err.println("Appointment Date cannot not be null or a date in the past.");
        } else {
            this.appointmentDate = appointmentDate;

        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            this.description = null;
            System.err.println("Description cannot not be null or greater than 50 characters");
        } else {
            this.description = description;
        }
    }
}
