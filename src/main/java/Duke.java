import java.util.Scanner;
import java.lang.Integer;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(
                "Hello! I'm Duke" + "\n"
                + "What can I do for you?"
        );

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        String filePath = "C:\\Users\\Ooi Ming Sheng\\Desktop\\CS2103\\Individual project\\duke\\data\\duke.txt";
        ToDoList toDoList = new ToDoList(filePath);

        while(shouldContinue) {
            String input = scanner.nextLine();
            String[] str = input.split(" ", 2);
            String action = str[0];
            try {
                if (action.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    toDoList.saveTasks();
                    shouldContinue = false;
                } else if(action.equals("list")) {
                    toDoList.listTasks();
                } else if(action.equals("blah")) {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                } else if(action.equals("delete")) {
                    int taskNo = Integer.parseInt(str[1]);
                    toDoList.removeTask(taskNo);
                } else if(action.equals("done")) {
                    int taskNo = Integer.parseInt(str[1]);
                    toDoList.checkOffTask(taskNo);
                } else if(action.equals("todo") || action.equals("deadline") || action.equals("event")) {
                    String taskType = str[0];
                    if (str.length <= 1) {
                        throw new DukeException("☹ OOPS!!! The description of a " + taskType + " cannot be empty.");
                    }
                    String taskDescription = str[1];
                    toDoList.addTask(taskDescription, taskType);
                } else {
                    toDoList.addTask(input);
                }
            } catch (DukeException dukeException) {
                System.out.println(dukeException.getMessage());
            }
        }
    }
}
