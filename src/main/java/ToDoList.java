import java.util.List;
import java.util.ArrayList;

public class ToDoList {

    private List<String> toDoList;

    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    public void addItem(String str) {
        toDoList.add(str);
        System.out.println("added: " + str + "\n");
    }

    public void listItems() {
        int counter = 1;
        for (String str : toDoList) {
            System.out.println(counter + ". " + str);
            counter++;
        }
    }
}
