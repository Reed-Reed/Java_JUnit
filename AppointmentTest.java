import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class AppointmentTest {
	/*
	 *  Appt object must have attributes for id, summary, and date
	 */
	@Test
	void testApptClass() {
		LocalDate appt_date = LocalDate.of(2025, 8, 9);
		Appointment apptTest = new Appointment("ReedID", "this is the summary", appt_date);
		// Tests object creation by confirming attribute assignments
		assertTrue(apptTest.GetApptId() == "ReedID");
		assertTrue(apptTest.GetApptSummary() == "this is the summary");
		assertTrue(apptTest.GetApptDate().equals(appt_date));
	}
	
	/*
	 * The appt ID must not be null or exceed 10 characters
	 */
	@Test
	void testApptIdTooLong() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		LocalDate appt_date = LocalDate.of(2025, 8, 9);
		Appointment apptTest = new Appointment("ReedIDiswaytoolong", "this is the summary", appt_date);	
		});
	}
	@Test
	void testApptIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			LocalDate appt_date = LocalDate.of(2025, 8, 9);
			Appointment appTest = new Appointment(null, "This is the summary", appt_date);
		});
	}
	
	/*
	 * The appointment summary must not be null or exceed 50 characters
	 */
	@Test
	void testApptSummaryTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			LocalDate appt_date = LocalDate.of(2025, 8, 9);
			Appointment appTest = new Appointment("ReedID", "This is the summary but it is more than fifty characters,"
					+ "which makes it too long to be valid", appt_date);
		});
	}
	@Test
	void testApptSummaryIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			LocalDate appt_date = LocalDate.of(2025, 8, 9);
			Appointment appTest = new Appointment("ReedID", null, appt_date);
		});
	}
	
	/*
	 *  The date must be on or after today's date. (Appointments cannot be made for the past)
	 */
	@Test
	void testApptIsBeforeToday() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			LocalDate appt_date = LocalDate.of(2015, 8, 9);
			Appointment appTest = new Appointment("ReedID", "summary", appt_date);
		});
	}
	@Test
	void testApptDateIsNull() {
		Assertions.assertThrows(Exception.class, () -> {
			Appointment appTest = new Appointment("ReedID", "summary", null);
		});
	}
	
	
}
