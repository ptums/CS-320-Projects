import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        task = new Task(001, "Test Task", "Description of a test task.");
    }


    @Test
    void testGetTaskID() {
        assertAll(
                () -> assertNotNull(task.getTaskID()),
                () -> assertNotEquals(task.getTaskID(), 0002),
                () -> assertEquals(task.getTaskID(), 001),
                () -> assertTrue(task.getTaskID() < 10)
        );
    }

    @Test
    void testSetTaskID() {
        task.setTaskID(003);
        assertAll(() -> assertNotNull(task.getTaskID()), () -> assertNotEquals(task.getTaskID(), 004), () -> assertEquals(task.getTaskID(), 003));
        task.setTaskID(999999);
        assertEquals(task.getTaskID(), -1);

    }

    @Test
    void testGetName() {
        assertAll(
                () -> assertNotNull(task.getName()),
                () -> assertNotEquals(task.getName(), "James Bond"),
                () -> assertEquals(task.getName(), "Test Task")
        );
    }

    @Test
    void testSetName() {
        task.setName("James Bond");
        assertAll(() -> assertNotNull(task.getName()), () -> assertNotEquals(task.getName(), "Test Task"), () -> assertEquals(task.getName(), "James Bond"), () -> assertTrue(task.getName().length() < 20));
        task.setName("James MacArthur Gordon Michael Bond the 8th, Duke of Winterfell");
        assertEquals(task.getName(), "unknown");
    }

    @Test
    void testGetDescription() {
        assertAll(() -> assertNotNull(task.getDescription()), () -> assertNotEquals(task.getDescription(), "James Bond is cool!"), () -> assertEquals(task.getDescription(), "Description of a test task."));
    }

    @Test
    void testSetDescription() {
        task.setDescription("James Bond is cool!");
        assertAll(() -> assertNotNull(task.getDescription()), () -> assertNotEquals(task.getDescription(), "Description of a test task."), () -> assertEquals(task.getDescription(), "James Bond is cool!"), () -> assertTrue(task.getDescription().length() < 50));
        task.setDescription("The James Bond series focuses on the titular character, a fictional British Secret Service agent created in 1953 by writer Ian Fleming, who featured him in twelve novels and two short-story collections. Since Fleming's death in 1964, eight other authors have written authorised Bond novels or novelisations: Kingsley Amis, Christopher Wood, John Gardner, Raymond Benson, Sebastian Faulks, Jeffery Deaver, William Boyd, and Anthony Horowitz. The latest novel is With a Mind to Kill by Anthony Horowitz, published in May 2022. Additionally Charlie Higson wrote a series on a young James Bond, and Kate Westbrook wrote three novels based on the diaries of a recurring series character, Moneypenny.");
        assertEquals(task.getDescription(), "unknown");
    }

    @Test
    void testTaskGenerateUniqueID() {
        int testTaskId = task.generateUniqueID();
        String testTaskIDToString = Integer.toString(testTaskId);
        task.setTaskID(testTaskId);

        assertAll(
                () -> assertNotNull(testTaskId),
                () -> assertTrue(testTaskIDToString.length() < 10)
        );
    }
}