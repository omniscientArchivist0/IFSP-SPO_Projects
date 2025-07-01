package object;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BaseTaskTest {

    private BaseTask genericTask(ZonedDateTime date) {
        return new BaseTask("Test task.", false, date);
    }

    @Test
    void isTaskUpdating() {
        var currentDate = ZonedDateTime.now();
        var sampleTask = genericTask(currentDate);
        assertEquals(currentDate, sampleTask.getDate());
        sampleTask.changeTaskStatus();
        assertNotEquals(currentDate, sampleTask.getDate());
    }
}
