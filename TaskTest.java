import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Task thisTask = new Task("ThisIDistoolong");
	});
	}
	
	@Test
	void testTaskIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task thisTask = new Task(null);
		});
	}
	
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			Task thisTask = new Task("Reed");
			thisTask.SetTaskName("ThisTaskNameIsTooLong");
		});
	}
	
	@Test
	void testTaskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			Task thisTask = new Task("Reed");
			thisTask.SetTaskName(null);
		});
	}
	
	@Test
	void testTaskSummaryTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			Task thisTask = new Task("Reed");
			thisTask.SetTaskSummary("ThisTaskSummaryisTooLongBecauseItCanOnlyBe50CharactersPerRequirements");
		});
	}
	
	@Test
	void testTaskSummaryIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			Task thisTask = new Task("Reed");
			thisTask.SetTaskSummary(null);
		});
	}
}
