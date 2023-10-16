import java.util.Random;

public class Task {
    private int taskID;
    private String name;
    private String description;

    public Task(int taskID, String name, String description) {
        setTaskID(taskID);
        setName(name);
        setDescription(description);
    }

    public static int generateUniqueID() {
        int charLen = 9;
        String characters = "0123456789";

        StringBuilder strBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < charLen; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            strBuilder.append(randomChar);
        }

        String randomStr = strBuilder.toString();

        int randomId = Integer.parseInt(randomStr);

        return randomId;
    }


    public int getTaskID() { return this.taskID; }

    public void setTaskID(int taskID) {
        String taskIDToString = Integer.toString(taskID);
        if (taskIDToString == null || taskID > 10) {
            this.taskID = -1;
            System.err.println("Task ID must not be null and cannot exceed 10 characters.");
        } else {
            this.taskID = taskID;
        }
    }

    public String getName() { return this.name; }

    public void  setName(String name) {
        if (name == null || name.length() > 20) {
            this.name = "unknown";
            System.err.println("Name must not be null and cannot exceed 20 characters.");
        } else {
            this.name = name;
        }
    }


    public String getDescription() { return this.description; }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            this.description = "unknown";
            System.err.println("Description must not be null and cannot exceed 50 characters.");
        } else {
            this.description = description;
        }
    }
}
