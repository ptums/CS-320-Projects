import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    private Appointment appointment;

    @Test
    void testAppointmentGenerateUniqueID() {
        Appointment testAppointment = new Appointment(0, new Date(), "Test Appointment 5");
        int testAppointmentId = Appointment.generateUniqueID();
        String testAppointmentIDToString = Integer.toString(testAppointmentId);
        testAppointment.setAppointmentID(testAppointmentId);

        assertAll(
                () -> assertNotNull(testAppointmentId),
                () -> assertTrue(testAppointmentIDToString.length() < 10)
        );

    }

    @Test
    void testGetAppointmentID() {
        Appointment testAppointment = new Appointment(002, new Date(), "Test Appointment 2");
        int getAppointmentId = testAppointment.getAppointmentID();
        assertAll(
                () -> assertNotNull(getAppointmentId),
                () -> assertNotEquals(getAppointmentId, 00333),
                () -> assertEquals(getAppointmentId, 002),
                () -> assertTrue(getAppointmentId < 10)
        );
    }

    @Test
    void testSetAppointmentID() {
        Appointment testAppointment = new Appointment(002, new Date(), "Test Appointment 2");
        testAppointment.setAppointmentID(003);
        assertAll(
                () -> assertNotNull(testAppointment.getAppointmentID()),
                () -> assertNotEquals(testAppointment.getAppointmentID(), 004),
                () -> assertEquals(testAppointment.getAppointmentID(), 003));
        testAppointment.setAppointmentID(9999999);
        assertNotEquals(testAppointment.getAppointmentID(), -1);
    }

    @Test
    void testGetAppointmentDate() {
        Appointment testAppointment = new Appointment(002, new Date(), "Test Appointment 2");
        Date testDate = new Date(3023 - 1900, 0, 01);
        assertAll(() -> assertNotNull(testAppointment.getAppointmentDate()), () -> assertNotEquals(testAppointment.getAppointmentDate(), testDate), () -> assertEquals(testAppointment.getAppointmentDate().toString(), new Date().toString()));

    }

    @Test
    void testSetAppointmentDate() {
        Appointment testAppointment = new Appointment(002, new Date(), "Test Appointment 2");
        Date testDate = new Date(2024, Calendar.SEPTEMBER, 1);
        testAppointment.setAppointmentDate(testDate);
        assertAll(
                () -> assertNotNull(testAppointment.getAppointmentDate()),
                () -> assertEquals(testAppointment.getAppointmentDate(), testDate),
                () -> assertNotEquals(testAppointment.getAppointmentDate(), new Date())
        );
        Date testDateTwo = new Date(2020 - 1900, 0, 01);

        testAppointment.setAppointmentDate(testDateTwo);
        assertNull(testAppointment.getAppointmentDate());

        Date testDateThree = new Date();
        testAppointment.setAppointmentDate(testDateThree);
        assertNotNull(testAppointment.getAppointmentDate());
    }

    @Test
    void testGetDescription() {
        Appointment testAppointment = new Appointment(002, new Date(), "Test Appointment 2");
        assertAll(() -> assertNotNull(testAppointment.getDescription()), () -> assertEquals(testAppointment.getDescription(), "Test Appointment 2"), () -> assertNotEquals(testAppointment.getDescription(), "Test Appointment 3"));
    }

    @Test
    void testSetDescription() {
        Appointment testAppointment = new Appointment(002, new Date(), "Test Appointment 2");
        testAppointment.setDescription("Test Appointment 3");
        assertAll(
                () -> assertNotNull(testAppointment.getDescription()),
                () -> assertNotEquals(testAppointment.getDescription(), "Test Appointment 2"),
                () -> assertEquals(testAppointment.getDescription(), "Test Appointment 3")
        );
        testAppointment.setDescription(null);
        assertNull(testAppointment.getDescription());
    }
}