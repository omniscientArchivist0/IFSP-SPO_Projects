package object;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class BaseTask {
    private String text;
    private Boolean isCompleted;
    private ZonedDateTime taskChangeDate;

    public BaseTask() {
        text = "";
        isCompleted = false;
        taskChangeDate = ZonedDateTime.now();
    }
    public BaseTask(String text) {
        this.text = text;
        isCompleted = false;
        taskChangeDate = ZonedDateTime.now();
    }
    public BaseTask(String text, Boolean isCompleted, ZonedDateTime date) {
        this.text = text;
        this.isCompleted = isCompleted;
        this.taskChangeDate = date;
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

    public Boolean getCompleted() {
        return isCompleted;
    }

    public String getText() {
        return text;
    }

    private void updateTaskDate() {
        taskChangeDate = ZonedDateTime.now();
    }
}
