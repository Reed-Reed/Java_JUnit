import java.time.LocalDate;
import java.util.Scanner;
/*
 *  The appointment service allows users to add and delete appointments
 */
public class AppointmentService {
	/*
	 *  This method can add appointments and verifies a unique ID
	 */
	public static Appointment[] AddAppointment(Appointment new_appt, Appointment[] apptList) {
		for (Appointment appt : apptList) {
			if (appt.GetApptId().compareTo(new_appt.GetApptId()) == 0) {
				throw new IllegalArgumentException("ID is taken");
			}
		}
		// Create a new array
		Appointment newAppt = new_appt;
		Appointment[] newApptList = new Appointment[apptList.length + 1];
		
		for (int i = 0; i < apptList.length; i++) {
			newApptList[i] = apptList[i]; 
		}
		newApptList[apptList.length] = newAppt;
		
		return newApptList;
	}
	
	/*
	 *  This method can delete appointments per ID
	 */
	public static Appointment[] DeleteAppointment(String id_to_del, Appointment[] apptList) {
		boolean canBeDeleted = false;
		
		for (Appointment appt : apptList) {
			if (appt.GetApptId().compareTo(id_to_del) == 0) {
				canBeDeleted = true;
			}
		}
		if (canBeDeleted) {
			Appointment[] newApptList = new Appointment[apptList.length - 1];
			
			for (int i = 0; i < apptList.length; i++) {
				if (apptList[i].GetApptId().compareTo(id_to_del) != 0) {
					newApptList[i] = apptList[i];
				}
			}
			return newApptList;
		} else {
			return apptList;
		}
	}
}
