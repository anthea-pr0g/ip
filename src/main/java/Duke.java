import duke.Task;
import duke.Deadline;
import duke.Todo;
import duke.Event;
import duke.DukeException;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);


        String greeting = "____________________________________________________________\n"
                + " Hello! I'm Duke\n"
                + " What can I do for you?\n"
                + "____________________________________________________________\n";

        System.out.println(greeting);
        Scanner in = new Scanner(System.in);
        String[] list = new String[100];
        Task[] tasks = new Task[100];


        int index_for_mark = 1;
        int i = 0;

        while (true) {

            String line = in.nextLine();
            //if bye
            if (line.equalsIgnoreCase("bye")) {
                break;
            }

            //getting index and line
            list[i] = line;
            String[] find_index = line.split(" ");

            //Task description
            String desc;
            desc=line;
            Task t = new Task(desc);

            if (line.toLowerCase().contains("unmark")) {
                index_for_mark = Integer.parseInt(find_index[1]);
                tasks[index_for_mark - 1].markAsUnDone();

                System.out.println("____________________________________________________________\n"
                        + "OK, I've marked this task as not done yet:\n"
                        + "[" + tasks[index_for_mark - 1].getStatusIcon() + "] " + list[index_for_mark - 1] + "\n"
                        + "____________________________________________________________\n");

            } else if (line.toLowerCase().contains("mark")) {
                index_for_mark = Integer.parseInt(find_index[1]);
                tasks[index_for_mark - 1].markAsDone();
                System.out.println("____________________________________________________________\n"
                        + "Nice! I've marked this task as done:\n" +
                        "[" + tasks[index_for_mark - 1].getStatusIcon() + "] " + list[index_for_mark - 1] + "\n"
                        + "____________________________________________________________\n");

            } else if (line.toLowerCase().contains("todo") || line.toLowerCase().contains("deadline") || line.toLowerCase().contains("event")) {
                boolean empty;
                empty=false;

                if (line.toLowerCase().contains("todo")) {

                    String[] ToSplitTodo=line.split(" ");

                    try {
                      // description.toLowerCase().substring(5, description.length());
                      //list[i] = TodoTask;
                      String TodoTask = line.toLowerCase().replaceAll("todo","");
                      tasks[i] = new Todo(TodoTask,ToSplitTodo.length);

                    } catch (DukeException ex) {
                      empty=true;
                      System.out.println("____________________________________________________________\n"
                              +"OOPS!!! The description of a todo cannot be empty.\n"
                              + "____________________________________________________________\n");
                  }

                    //sample : deadline return book /by Sunday
                } else if (line.toLowerCase().contains("deadline")) {
                    String[] ToSplitDeadline = line.split("/");
                    String DeadlineTask = ToSplitDeadline[0].toLowerCase().substring(9, ToSplitDeadline[0].length() - 1);
                    list[i] = DeadlineTask;
                    tasks[i] = new Deadline(DeadlineTask, ToSplitDeadline[1].substring(3, ToSplitDeadline[1].length()));

                    //sample:event project meeting /from Mon 2pm /to 4pm
                } else if (line.toLowerCase().contains("event")) {
                    String[] ToSplitEvent = line.split("/");
                    String EventTask = ToSplitEvent[0].toLowerCase().substring(6, ToSplitEvent[0].length());
                    list[i] = EventTask;
                    tasks[i] = new Event(EventTask, ToSplitEvent[1].substring(5, ToSplitEvent[1].length()), ToSplitEvent[2].substring(3, ToSplitEvent[2].length()));

                }

                if(!empty) {
                    System.out.println("____________________________________________________________\n"
                    +"Got it. I've added this task:\n" +
                            "  " + tasks[i] + "\n" +
                            "Now you have " + (i + 1) + " tasks in the list.\n"
                    +"____________________________________________________________\n");
                    i += 1;

                }

            } else if (line.equalsIgnoreCase("list")) {

                System.out.println("____________________________________________________________\n" +
                        "Here are the tasks in your list:");

                for (int m = 0; m < i; m += 1) {
                    int index = m + 1;
                    if (tasks[m] == null) {
                        System.out.println(index + "." + "[" + t.getStatusIcon() + "] " + list[m]);
                    } else {
                        //the [X] or []
                        System.out.println(index + "." + tasks[m]);
                    }

                }
                System.out.println("____________________________________________________________");

            } else {
                System.out.println("____________________________________________________________\n"
                        +"OOPS!!! The description of a todo cannot be empty.\n"
                +"____________________________________________________________\n");
            }

            }




        System.out.println("____________________________________________________________\n"
                + " Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n");


    }
}
