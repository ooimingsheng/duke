package seedu.duke.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Storage {

    private String filePath;
    public static String DIVIDER = " XXXDIVIDERXXX ";

    /**
     * Public constructor that returns a task storage system.
     * @param filePath the file path to save and load task data of the system.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the task data from the file at the file path if one exists.
     * @return a list of the tasks loaded from the file located at the file path if one exists.
     */
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
            throw new DukeException("File to be loaded could not be found.");
        }
        return taskList;
    }

    /**
     * Saves the task list to the file path or otherwise show a saving error.
     * @param taskList the list of tasks to be saved to the file.
     * @param ui the user interface to show the saving error if there is an error when saving.
     */
    public void saveTasks(List<Task> taskList, Ui ui) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : taskList) {
                if (task instanceof ToDo) {
                    writer.write("T");
                } else if (task instanceof Deadline) {
                    writer.write("D");
                } else if (task instanceof Event) {
                    writer.write("E");
                }
                writer.write(DIVIDER + task.hasBeenDone() + DIVIDER + task.getDescription());
                if (task instanceof Deadline) {
                    writer.write(DIVIDER + ((Deadline) task).getDeadline());
                } else if (task instanceof Event) {
                    writer.write(DIVIDER + ((Event) task).getEventVenue());
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {
            ui.showSavingError();
        }
    }

}
