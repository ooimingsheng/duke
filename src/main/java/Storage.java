import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Storage {

    private String filePath;
    public static String DIVIDER = " XXXDIVIDERXXX ";

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public List<Task> load() throws DukeException {
        List<Task> taskList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] taskParams = line.split(Storage.DIVIDER);
                Task task = Task.taskFactory(taskParams);
                taskList.add(task);
            }
        } catch (IOException ioException) {
            throw new DukeException();
        }
        return taskList;
    }

    public void saveTasks(List<Task> taskList) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : taskList) {
                if (task instanceof  ToDo) {
                    writer.write("T");
                } else if(task instanceof  Deadline){
                    writer.write("D");
                } else if(task instanceof  Event){
                    writer.write("E");
                }
                writer.write(DIVIDER + task.hasBeenDone() + DIVIDER + task.getDescription());
                if (task instanceof  Deadline) {
                    writer.write(DIVIDER + ((Deadline) task).getDeadline());
                } else if(task instanceof  Event) {
                    writer.write(DIVIDER + ((Event) task).getEventVenue());
                }
                writer.write("\n");
            }
        } catch (IOException ioException) { }
    }

}
