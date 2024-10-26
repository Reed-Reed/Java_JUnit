import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	@Test
	// The task ID must be unique
	void testUniqueId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task[] newTasks = new Task[0];
			newTasks = TaskService.AddTask("Reed", "bob", "This is the summary", newTasks, newTasks.length);
			// Attempts to add a task with the same task ID as existing task
			newTasks = TaskService.AddTask("Reed", "bob", "This is the summary", newTasks, newTasks.length);
		});
	}
	
	@Test
	// The Task Service must be able to add tasks to the local array
	void testAddTask() {
		Task[] newTasks = new Task[0]; // Create an array for Tasks
		
		newTasks = TaskService.AddTask("Reed", "bob", "This is the summary", newTasks, newTasks.length);
		// Verify add method
		assertTrue(newTasks.length == 1);
		assertTrue(newTasks[0].GetTaskId() == "Reed");
		assertTrue(newTasks[0].GetTaskName() == "bob");
		assertTrue(newTasks[0].GetTaskSummary() == "This is the summary");
		// Verify that another task can be added
		newTasks = TaskService.AddTask("Reed123", "bob", "This is the summary", newTasks, newTasks.length);
		assertTrue(newTasks.length == 2);
	}
	
	@Test
	// The Task Service must be able to delete tasks
	void testDeleteTasks() {
		Task[] newTasks = new Task[0];
		newTasks = TaskService.AddTask("Reed", "bob", "This is the summary", newTasks, newTasks.length);
		// Verify the task was added
		assertTrue(newTasks.length == 1);
		newTasks = TaskService.DeleteTask("Reed", newTasks, newTasks.length);
		// Verify the task was deleted
		assertTrue(newTasks.length == 0);
	}
	
	@Test
	// TaskService must be able to update the name of a task
	void testUpdateTaskName() {
		Task[] newTasks = new Task[0];
		newTasks = TaskService.AddTask("Reed", "bob", "This is the summary", newTasks, newTasks.length);
		// Main method will delete task and update by adding a new one with new content
		newTasks = TaskService.DeleteTask("Reed", newTasks, newTasks.length);
		newTasks = TaskService.UpdateTask("Reed", "bill", "new summary here", newTasks);
		// Verify the name updated
		assertTrue(newTasks[0].GetTaskName().compareTo("bill") == 0);
	}

}
