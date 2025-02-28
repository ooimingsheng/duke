package seedu.duke.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TaskList {

    private List<Task> taskList;
    private HashSet<String> taskDescriptionDictionary = new HashSet<>();
    private static final String INDENT = "  ";

    /**
     * Public constructor that returns a task list system with a list of tasks.
     * @param taskList the list of tasks the task list system is initialized with.
     */
    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
        for (Task task : taskList) {
            taskDescriptionDictionary.add(task.getDescription());
        }
    }

    /**
     * Public constructor that returns a task list system with an empty list of tasks.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Returns the list of tasks from the task list system.
     * @return the list of tasks from the task list system.
     */
    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     * Returns the size of the list of tasks from the task list system.
     * @return the size of the list of tasks from the task list system.
     */
    public int getTaskListSize() {
        return taskList.size();
    }

    /**
     * Adds a task of stipulated type to the task list system and returns it.
     * @param description the description of the task to be added to the task system.
     * @param taskType the task type of the task to be added to the task system.
     * @return the "To Do" task that was added to the task list system.
     */
    public Task addTask(String description, String taskType) throws DukeException {
        if (taskDescriptionDictionary.contains(description)) {
            throw new DukeException(description + " is a duplicate task and already inside the task list.");
        }
        taskDescriptionDictionary.add(description);
        Task task = Task.taskFactory(description, taskType);
        taskList.add(task);
        return task;
    }

    /**
     * Removes a task at the one-based position of taskNo from the list of tasks.
     * @param taskNo the one-based index of the task to be removed from the task list.
     * @return the task that was removed from the task list.
     */
    public Task removeTask(int taskNo) {
        return taskList.remove(taskNo - 1);
    }

    /**
     * Marks a task as completed at the one-based position of taskNo from the list of tasks.
     * @param taskNo the one-based index of the task to be removed from the task list.
     * @return the task that was marked as completed from the task list.
     */
    public Task checkOffTask(int taskNo) {
        Task task = taskList.get(taskNo - 1);
        task.checkOff();
        return task;
    }

    /**
     * Returns a list of tasks from the tasks list whose description contains the stipulated substring.
     * @param subStr the substring to be found in the task descriptions.
     * @return a list of tasks from the tasks list whose description contains the stipulated substring.
     */
    public List<Task> findTasks(String subStr) {
        List<Task> tasksWithSubstr = new ArrayList<>();
        for (Task task : taskList) {
            if (task.descriptionContainsSubstr(subStr)) {
                tasksWithSubstr.add(task);
            }
        }
        return tasksWithSubstr;
    }
}