package seedu.duke.task;

import java.util.ArrayList;
import java.util.List;

public class Task {

    protected String description;
    protected boolean isDone;

    /**
     * Factory that creates the appropriate task according to the function parameters.
     * @param description the description of the task.
     * @param taskType the type of task to be created.
     * @return an uncompleted task according to the taskType and description
     */
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

    /**
     * Factory that creates the appropriate task according to the function parameters.
     * @param taskParams an array of the parameters of the task to be created of the following format:
     *      [taskType, isDone, taskDescription, by/at ?].
     * @return an uncompleted task according to the task params.
     */
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

    /**
     * Public constructor of a task.
     * @param description description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Public constructor of a task.
     * @param description description of the task.
     * @param isDone whether the task has been completed.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns the description of the task.
     * @return the description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether the task has been completed.
     * @return whether the task has been completed.
     */
    public Boolean hasBeenDone() {
        return isDone;
    }

    /**
     * Returns a check icon if the task has been completed and a cross otherwise.
     * @return a check icon if the task has been completed and a cross otherwise.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Marks the task as completed.
     */
    public void checkOff() {
        this.isDone = true;
    }

    /*
     * Returns whether the task description contains the substring.
     * @return whether the task description contains the substring.
     */
    public boolean descriptionContainsSubstr(String substr) {
        return description.contains(substr);
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
