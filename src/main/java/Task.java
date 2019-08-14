public class Task {
    protected String description;
    protected boolean isDone;

    public static Task taskFactory(String description, String taskType){
        if (taskType.equals("todo")) {
            return new ToDo(description);
        } else if (taskType.equals("deadline")){
            String[] str = description.split(" /by ", 2);
            String taskDescription = str[0];
            String by = str[1];
            return new Deadline(taskDescription, by);
        } else if (taskType.equals("event")) {
            String[] str = description.split(" /at ", 2);
            String taskDescription = str[0];
            String at = str[1];
            return new Event(taskDescription, at);
        } else {
            return null;
        }
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void checkOff() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
