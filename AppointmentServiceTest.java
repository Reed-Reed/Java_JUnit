import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class AppointmentServiceTest {
	/*
	 * The following tests ensure AddAppointment() meets requirements
	 */
	@Test
	void testAddAppointment() {
		Appointment[] apptList = new Appointment[0];
		Appointment newAppt = new Appointment("Reed", "description", LocalDate.of(2025, 12, 12));
		
		apptList = AppointmentService.AddAppointment(newAppt, apptList);
		// Assert that the appointment is added with the correct ID
		assertTrue(apptList.length == 1);
		assertTrue(apptList[0].GetApptId().compareTo("Reed") == 0);	
	}
	@Test
	 // Appointment ID must be unique
	void testIdIsTaken() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment[] apptList = new Appointment[0];
			Appointment newAppt = new Appointment("Reed", "description", LocalDate.of(2025, 12, 12));
			apptList = AppointmentService.AddAppointment(newAppt, apptList);
			apptList = AppointmentService.AddAppointment(newAppt, apptList);
		});
	}
	
	/*
	 * The service must be able to delete appointments per id
	 */
	@Test
	void testDeleteAppointment( ) {
		// First, add appointment
		Appointment[] apptList = new Appointment[0];
		Appointment newAppt = new Appointment("Reed", "description", LocalDate.of(2025, 12, 12));
		apptList = AppointmentService.AddAppointment(newAppt, apptList);
		// Verify it was added
		assertTrue(apptList.length == 1);
		// Then delete
		apptList = AppointmentService.DeleteAppointment("Reed", apptList);
		// Verify it was deleted
		assertTrue(apptList.length == 0);
	}
}
