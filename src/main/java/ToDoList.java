import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ToDoList {

    private String filePath;
    private List<Task> toDoList;
    private static final String indent = "  ";
    private static String divider = " XXXDIVIDERXXX ";

    public ToDoList(String filePath) {
        this.filePath = filePath;
        toDoList = new ArrayList<>();
        readTasksFromFile();
    }

    private void readTasksFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] taskParams = line.split(divider);
                Task task = Task.taskFactory(taskParams);
                toDoList.add(task);
            }
        } catch (IOException ioException) { }
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

    public void removeTask(int taskNo) {
        Task task = toDoList.remove(taskNo - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println(indent + task);
        System.out.println("Now you have " + toDoList.size() + " tasks in the list.");
    }

    public void checkOffTask(int taskNo) {
        Task task = toDoList.get(taskNo - 1);
        task.checkOff();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(indent + task);
    }

    public void listTasks() {
        int counter = 1;
        System.out.println("Here are the tasks in your list:");
        for (Task task : toDoList) {
            System.out.println(counter + "." + task);
            counter++;
        }
    }

    public void saveTasks() {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : toDoList) {
                if (task instanceof  ToDo) {
                    writer.write("T");
                } else if(task instanceof  Deadline){
                    writer.write("D");
                } else if(task instanceof  Event){
                    writer.write("E");
                }
                writer.write(divider + task.hasBeenDone() + divider + task.getDescription());
                if (task instanceof  Deadline) {
                    writer.write(divider + ((Deadline) task).getDeadline());
                } else if(task instanceof  Event) {
                    writer.write(divider + ((Event) task).getEventVenue());
                }
                writer.write("\n");
            }
        } catch (IOException ioException) { }
    }
}
