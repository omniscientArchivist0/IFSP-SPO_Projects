package controller;

import object.BaseTask;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseControllerTest {

    DatabaseController db = new DatabaseController();

    private BaseTask genericTask(ZonedDateTime date) {
        return new BaseTask("Test task.", false, date);
    }

    private void cleanup(int id) {
        db.removeTask(id);
    }

    @Test
    void isDatabaseKeepingData() {
        assertNull(db.getTask(1000000));
        db.storeTask(genericTask(ZonedDateTime.now()), 1000000);
        assertNotNull(db.getTask(1000000));
        cleanup(1000000);
    }

    @Test
    void isDatabaseUpdatingData() {
        db.storeTask(genericTask(ZonedDateTime.now()), 1000000);
        BaseTask firstAcquiredTask = db.getTask(1000000);
        firstAcquiredTask.setText("Test task 2.");
        db.updateTask(firstAcquiredTask, 1000000);
        BaseTask secondAcquiredTask = db.getTask(1000000);
        assertEquals("Test task 2.", secondAcquiredTask.getText());
    }
}
