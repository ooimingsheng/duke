import java.util.List;
import java.util.ArrayList;

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
}
