import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private static final Map<Integer, Appointment> appointments = new HashMap<>();

    public static int addAppointment(String description) {
        int appointmentId = Appointment.generateUniqueID();
        Appointment appointment = new Appointment(appointmentId, new Date(), description);
        appointments.put(appointmentId, appointment);

        return appointmentId;
    }

    public static Map<Integer, Appointment> getAppointments() {

        return appointments;
    }

    public static Appointment getAppointment(int appointmentId) {
        return appointments.get(appointmentId);
    }

    public static boolean deleteAppointment(int appointmentId) {
        if (appointments.containsKey(appointmentId)) {
            appointments.remove(appointmentId);

            return true;
        }

        return false;
    }
}
