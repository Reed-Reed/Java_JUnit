/*
 *  The task service allows users to add, delete, and update tasks per unique ID
 */
public class TaskService {
	
	/*
	 * This method adds a task by creating a new array with the old tasks and adding the new task 
	 * to the end of the new array. 
	 */
	public static Task[] AddTask(String task_id, String task_name, String task_summary, Task[] old_tasks, int arr_size) {
		for (Task task : old_tasks) {
			if (task.GetTaskId().compareTo(task_id) == 0) {
				throw new IllegalArgumentException("Task ID is taken");
			}
		}
		Task newTask = new Task(task_id);
		newTask.SetTaskName(task_name);
		newTask.SetTaskSummary(task_summary);
		
		Task[] newTasks = new Task[arr_size + 1];
		
		for (int i = 0; i < arr_size; i++) {
			newTasks[i] = old_tasks[i];
		}
		newTasks[arr_size] = newTask;
		
		return newTasks;
	}
	/*
	 *  Delete tasks by assigning every other task to a new 
	 */
	public static Task[] DeleteTask(String task_id, Task[] old_tasks, int arr_size) {
		
		Task[] newTasks = new Task[arr_size - 1];
		
		for (int i = 0; i < arr_size; i++) {
			if (old_tasks[i].GetTaskId().compareTo(task_id) != 0) {
				newTasks[i] = old_tasks[i];
			}
		}
		return newTasks;
	}
	/*
	 *  Updates the name of a task without needing the input of a new unique task id
	 */
	public static Task[] UpdateTask(String task_id, String new_name, String new_summary, Task[] old_tasks) {
		Task[] updatedTasks = new Task[0];
		
		// Main function deletes old task and we can add new one here
		updatedTasks = TaskService.AddTask(task_id, new_name, new_summary, old_tasks, old_tasks.length); 
		
		return updatedTasks;
	}
}
