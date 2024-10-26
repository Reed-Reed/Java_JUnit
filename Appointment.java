/*
 *  This class is used to create appointment objects for tracking within the appointmentService class
 */

import java.time.LocalDate;

public class Appointment {
	/*
	 * Attributes
	 */
	final String apptId;
	String apptSummary;
	LocalDate apptDate;
	/*
	 *  Construct appointment object and validate input
	 */
	public Appointment(String appt_id, String appt_summary, LocalDate appt_date) {
		if (appt_id == null || appt_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.apptId = appt_id;
		
		if (appt_summary == null || appt_summary.length() > 50) {
			throw new IllegalArgumentException("Invalid summary");
		}
		this.apptSummary = appt_summary;
		
		if (appt_date.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("invalid date");
		}
		// Ensures the Date is not null
		try {
			this.apptDate = appt_date;
		} catch (Exception e) {
			System.out.println("invalid date");
		}
	}
	/*
	 * Accessors and mutators for attributes
	 */
	public String GetApptId() {
		return this.apptId;
	}
	public String GetApptSummary() {
		return this.apptSummary;
	}
	public LocalDate GetApptDate() {
		return this.apptDate;
	}
	public void SetApptDate(LocalDate appt_date) {
		if (appt_date.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("invalid date");
		}
		this.apptDate = appt_date;
	}
}
