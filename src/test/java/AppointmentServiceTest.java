import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class AppointmentServiceTest {
    @Test
    void testDeleteAppointment() {
        int appointmentId = AppointmentService.addAppointment("Appointment1 description");
        assertAll(() -> assertTrue(AppointmentService.deleteAppointment(appointmentId)));
        assertFalse(AppointmentService.deleteAppointment(999999999));
    }

    @Test
    void testGetAppointment() {
        int testAppointmentId = AppointmentService.addAppointment("Appointment1 description");
        Appointment testAppointment = AppointmentService.getAppointment(testAppointmentId);

        assertAll(() -> assertNotNull(testAppointment), () -> assertEquals(testAppointment.getAppointmentDate().toString(), new Date().toString()), () -> assertEquals(testAppointment.getDescription(), "Appointment1 description"));
    }

    @Test
    void testAddAppointment() {
        int testAppointmentId = AppointmentService.addAppointment("Appointment2 description");
        Appointment testAppointment = AppointmentService.getAppointment(testAppointmentId);
        assertAll(
                () -> assertNotNull(testAppointmentId),
                () -> assertNotNull(testAppointment),
                () -> assertEquals(testAppointment.getAppointmentDate().toString(), new Date().toString()),
                () -> assertEquals(testAppointment.getDescription(), "Appointment2 description")
        );
    }

    @Test
    void testGetAppointments () {
        Map<Integer, Appointment> testAppointments = AppointmentService.getAppointments();
        assertAll(
                () -> assertNotNull(testAppointments),
                () -> assertTrue(testAppointments.size() > 0)
        );
    }


}