package duke.task;

import duke.exception.DukeException;

import java.util.ArrayList;

public class TaskList {
    //I will use ArrayList because the maximum size is only 100
    //In the future, it would be easier to implement DELETE
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public Task findTask(int index) throws DukeException {
        try {
            return taskList.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! The task number is out of bound ☹"
                    + "\nThere are only " + taskList.size() + " task(s) in your list");
        }
    }

    public int getSize() {
        return taskList.size();
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public void markDone(int index) throws DukeException {
        findTask(index).setDone(true);
    }

    public void unmarkDone(int index) throws DukeException {
        findTask(index).setDone(false);
    }

    public String formatTaskListToStringToStore() throws DukeException {
        StringBuilder formattedString = new StringBuilder();
        for (int i = 0; i < getSize() - 1; i++) {
            formattedString.append(findTask(i).formatTaskToStringToStore());
        }
        return formattedString.toString();
    }
    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder((taskList.size() == 0 ? "There is nothing in your list right now" : "Here are " + taskList.size() + " tasks in your list:"));
        int index = 1;
        for (Task task : taskList) {
            listString.append('\n').append("   ").append(index++).append(". ").append(task);
        }
        return String.valueOf(listString);
    }
}
