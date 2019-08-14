import java.util.List;
import java.util.ArrayList;

public class ToDoList {
    private List<Task> toDoList;
    private static final String indent = "  ";

    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    public void addTask(String description) {
        addTask(description, "todo");
    }

    public void addTask(String description, String taskType) {
        Task task = Task.taskFactory(description, taskType);
        toDoList.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(indent + task);
        System.out.println("Now you have " + toDoList.size() + " tasks in the list.");
    }

    public void checkOffTask(int taskNo) {
        Task task = toDoList.get(taskNo - 1);
        task.checkOff();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(indent + task);
    }

    public void removeTask(int taskNo) {
        Task task = toDoList.remove(taskNo - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println(indent + task);
        System.out.println("Now you have " + toDoList.size() + " tasks in the list.");
    }

    public void listTasks() {
        int counter = 1;
        System.out.println("Here are the tasks in your list:");
        for (Task task : toDoList) {
            System.out.println(counter + "." + task);
            counter++;
        }
    }
}
