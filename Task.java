/*
 * Used to create objects to store tasks in the task-service class
 */
public class Task {
	// Attributes
	final String taskId;
	String taskName;
	String taskSummary;
	
	public Task(String task_id) {
		if (task_id == null || task_id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		taskId = task_id;
	}
	/*
	 * Accessors and mutators. taskId is non-updateable
	 */
	public String GetTaskId() {
		return taskId;
	}
	
	public String GetTaskName() {
		return taskName;
	}
	public void SetTaskName(String task_name) {
		if (task_name == null || task_name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.taskName = task_name;
	}
	
	public String GetTaskSummary() {
		return taskSummary;
	}
	public void SetTaskSummary(String task_summary) {
		if (task_summary == null || task_summary.length() > 50) {
			throw new IllegalArgumentException("Invalid Summary: too long");
		}
		taskSummary = task_summary;
	}
	
}
