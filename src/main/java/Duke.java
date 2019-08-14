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
            if(input.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                shouldContinue = false;
            } else if(input.equals("list")){
                toDoList.listTasks();
            } else if(input.substring(0, 4).equals("done")){
                String str[] = input.split(" ");
                int taskNo = Integer.parseInt(str[1]);
                toDoList.checkOffTask(taskNo);
            }  else {
                toDoList.addTask(input);
            }
        }
    }
}
