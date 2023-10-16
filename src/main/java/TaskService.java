import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private static final Map<Integer, Task> tasks = new HashMap<>();

    // Delete contact
    public static boolean deleteTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);

            return true;
        }

        return false;
    }

    public static Task getTask(int taskId) {
        return tasks.get(taskId);
    }

    // Add a new task
    public static int addTask(String name, String description) {
        int taskId = Task.generateUniqueID();
        Task task = new Task(taskId, name, description);
        tasks.put(taskId, task);

        return taskId;
    }

    // Update Name
    public static boolean updateName(int taskId, String name) {
        if (tasks.containsKey(taskId)) {
            Task currentTask = tasks.get(taskId);
            currentTask.setName(name);

            return true;
        }

        return false;
    }

    // update Description
    public static boolean updateDescription(int taskId, String description) {
        if (tasks.containsKey(taskId)) {
            Task currentTask = tasks.get(taskId);
            currentTask.setDescription(description);

            return true;
        }

        return false;
    }

    public static Map<Integer, Task> getAllTasks() {
        return tasks;
    }
}
