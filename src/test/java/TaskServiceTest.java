import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @BeforeEach
    public void setUp() {
        TaskService.addTask("Car wheel", "Get a new car wheel for car.");
        TaskService.addTask("Get candy", "Get a kitkat for a snack");
        TaskService.addTask("New shoes", "Get new shoes.");
    }

    @Test
    void testDeleteTask() {
        int taskId = TaskService.addTask("Task1", "Task1 description");
        assertAll(() -> assertTrue(TaskService.deleteTask(taskId)), () -> assertNull(TaskService.getTask(taskId)), () -> assertNotEquals(TaskService.getAllTasks().size(), 10));
        assertFalse(TaskService.deleteTask(999999999));
    }


    @Test
    public void testAddTask() {
        int taskId = TaskService.addTask("Task2", "Task2 description");
        assertAll(() -> assertNotNull(TaskService.getTask(taskId)), () -> assertEquals(TaskService.getAllTasks().size(), 4), () -> assertNotEquals(TaskService.getAllTasks().size(), 5));
    }

    @Test
    public void testUpdateName() {
        int taskId = TaskService.addTask("Task3", "Task3 description");
        boolean updatedTask = TaskService.updateName(taskId, "Task3 Junior");
        Task currentTask = TaskService.getTask(taskId);

        assertAll(
                () -> assertNotEquals(currentTask.getName(), "Task3"),
                () -> assertEquals(currentTask.getName(), "Task3 Junior"),
                () -> assertNotNull(currentTask.getName()),
                () -> assertTrue(updatedTask)
        );

        boolean falseUpdatedTask = TaskService.updateName(999999999, "Task1000 Junior");
        assertFalse(falseUpdatedTask);
    }

    @Test
    public void testUpdateDescription() {
        int taskId = TaskService.addTask("Task4", "Task4 description");
        boolean updatedTask = TaskService.updateDescription(taskId, "Task4 description junior");
        assertTrue(updatedTask);
        Task currentTask = TaskService.getTask(taskId);
        assertAll(() -> assertNotEquals(currentTask.getDescription(), "Task4 description"), () -> assertEquals(currentTask.getDescription(), "Task4 description junior"), () -> assertNotNull(currentTask.getDescription()));
        boolean falseUpdatedTask = TaskService.updateDescription(999999999, "Task1000 description junior");
        assertFalse(falseUpdatedTask);
    }

    @Test
    public void testGetTask() {
        int taskId = TaskService.addTask("Task5", "Task5 description");

        Task currentTask = TaskService.getTask(taskId);
        assertAll(
                () -> assertNotNull(currentTask),
                () -> assertEquals(currentTask.getDescription(), "Task5 description"),
                () -> assertEquals(currentTask.getName(), "Task5")
        );

    }
}