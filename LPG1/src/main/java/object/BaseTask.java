package object;

import java.time.ZonedDateTime;
import java.util.UUID;

public class BaseTask {
    private String text;
    private Boolean isCompleted;
    private ZonedDateTime taskChangeDate;
    private int internalID;
    // private final UUID taskID;

    public BaseTask() {
        text = "";
        isCompleted = false;
        taskChangeDate = ZonedDateTime.now();
        // taskID = new UUID(32,32);
    }
    public BaseTask(String text) {
        this.text = text;
        isCompleted = false;
        taskChangeDate = ZonedDateTime.now();
        // taskID = new UUID(32,32);
    }
    public BaseTask(String text, Boolean isCompleted, ZonedDateTime date) {
        this.text = text;
        this.isCompleted = isCompleted;
        this.taskChangeDate = date;
        // taskID = new UUID(32,32);
    }

    public void setText(String text) {
        this.text = text;
        updateTaskDate();
    }

    public void changeTaskStatus() {
        isCompleted = !isCompleted;
        updateTaskDate();
    }

    public ZonedDateTime getDate() {
        return taskChangeDate;
    }

    public Boolean isCompleted() {
        return isCompleted;
    }

    public String getText() {
        return text;
    }

    /* public UUID getTaskID() {
        return taskID;
    } */

    public int getInternalID() {
        return internalID;
    }

    private void updateTaskDate() {
        taskChangeDate = ZonedDateTime.now();
    }
}
