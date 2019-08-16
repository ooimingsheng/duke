package seedu.duke.task;

import java.util.ArrayList;
import java.util.List;

public class Task {

    protected String description;
    protected boolean isDone;

    public static Task taskFactory(String description, String taskType) {
        if (taskType.equals("todo")) {
            return new ToDo(description);
        } else if (taskType.equals("deadline")) {
            String[] str = description.split(" /by ", 2);
            String taskDescription = str[0];
            String by = str[1];
            return new Deadline(taskDescription, by);
        } else if (taskType.equals("event")) {
            String[] str = description.split(" /at ", 2);
            String taskDescription = str[0];
            String at = str[1];
            return new Event(taskDescription, at);
        } else {
            return null;
        }
    }

    public static Task taskFactory(String[] taskParams) {
        String taskType = taskParams[0];
        boolean isDone = taskParams[1].equals("true");
        String taskDescription = taskParams[2];
        if (taskType.equals("T")) {
            return new ToDo(taskDescription, isDone);
        } else if (taskType.equals("D")) {
            String by = taskParams[3];
            return new Deadline(taskDescription, isDone, by);
        } else if (taskType.equals("E")) {
            String at = taskParams[3];
            return new Event(taskDescription, isDone, at);
        } else {
            return null;
        }
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public Boolean hasBeenDone() {
        return isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void checkOff() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
