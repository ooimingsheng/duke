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
                + "What can I do for you?" + "\n"
        );

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        ToDoList toDoList = new ToDoList();

        while(shouldContinue) {
            String input = scanner.nextLine();
            String[] str = input.split(" ", 2);
            String action = str[0];
            if (action.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                shouldContinue = false;
            } else if(action.equals("list")) {
                toDoList.listTasks();
            } else if(action.equals("done")) {
                int taskNo = Integer.parseInt(str[1]);
                toDoList.checkOffTask(taskNo);
            } else if(action.equals("todo") || action.equals("deadline") || action.equals("event")) {
                String taskType = str[0];
                String taskDescription = str[1];
                toDoList.addTask(taskDescription, taskType);
            } else {
                toDoList.addTask(input);
            }
        }
    }
}
