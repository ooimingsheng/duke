package seedu.duke.task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> taskList;
    private static final String INDENT = "  ";

    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int getTaskListSize() {
        return taskList.size();
    }

    public Task addTask(String description) {
        return addTask(description, "todo");
    }

    public Task addTask(String description, String taskType) {
        Task task = Task.taskFactory(description, taskType);
        taskList.add(task);
        return task;
    }

    public Task removeTask(int taskNo) {
        return taskList.remove(taskNo - 1);
    }

    public Task checkOffTask(int taskNo) {
        Task task = taskList.get(taskNo - 1);
        task.checkOff();
        return task;
    }

    /*
     * Returns a list of tasks from the tasks list whose description contains the stipulated substring.
     * @params subStr the substring to be found in the task descriptions.
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