import java.util.List;
import java.util.ArrayList;

public class ToDoList {

    private List<Task> toDoList;

    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    public void addTask(String str) {
        System.out.println("added: " + str + "\n");
        Task task = new Task(str);
        toDoList.add(task);
    }

    public void checkOffTask(int taskNo) {
        Task task = toDoList.get(taskNo - 1);
        task.checkOff();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    public void listTasks() {
        int counter = 1;
        System.out.println("Here are the tasks in your list:");
        for (Task task : toDoList) {
            System.out.println(counter + ". " + task);
            counter++;
        }
    }
}
