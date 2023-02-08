import duke.Task;
import duke.Deadline;
import duke.Todo;
import duke.Event;
import duke.DukeException;
import java.util.ArrayList;

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
        ArrayList<Task> tasks = new ArrayList<>();


        int index_for_mark = 1;
        int i = 0;

        while (true) {

            String line = in.nextLine();
            //if bye
            if (line.equalsIgnoreCase("bye")) {
                break;
            }

            //getting index for mark and delete
            String[] find_index = line.split(" ");

            if (line.toLowerCase().contains("unmark")) {
                index_for_mark = Integer.parseInt(find_index[1]);
                tasks.get(index_for_mark - 1).markAsUnDone();

                System.out.println("____________________________________________________________\n"
                        + "OK, I've marked this task as not done yet:\n"
                        + tasks.get(index_for_mark - 1) + "\n"
                        + "____________________________________________________________\n");

            } else if (line.toLowerCase().contains("mark")) {
                index_for_mark = Integer.parseInt(find_index[1]);
                tasks.get(index_for_mark - 1).markAsDone();
                System.out.println("____________________________________________________________\n"
                        + "Nice! I've marked this task as done:\n"
                        + tasks.get(index_for_mark - 1) + "\n"
                        + "____________________________________________________________\n");

            } else if(line.toLowerCase().contains("delete")) {
                int index_for_delete=Integer.parseInt(find_index[1]);
                System.out.println("____________________________________________________________\n"
                        +" Noted. I've removed this task:\n" +
                        "  " + tasks.get(index_for_delete-1) + "\n" +
                        "Now you have " + (i-1) + " tasks in the list.\n"
                        +"____________________________________________________________\n");
                i -= 1;
                tasks.remove(tasks.get(index_for_delete-1));

            }




            else if (line.toLowerCase().contains("todo") || line.toLowerCase().contains("deadline") || line.toLowerCase().contains("event")) {
                boolean empty;
                empty=false;

                if (line.toLowerCase().contains("todo")) {

                    String[] ToSplitTodo=line.split(" ");

                    try {

                      String TodoTask = line.toLowerCase().replaceAll("todo","");
                      tasks.add(new Todo(TodoTask,ToSplitTodo.length));

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
                    tasks.add(new Deadline(DeadlineTask, ToSplitDeadline[1].substring(3, ToSplitDeadline[1].length())));

                    //sample:event project meeting /from Mon 2pm /to 4pm
                } else if (line.toLowerCase().contains("event")) {
                    String[] ToSplitEvent = line.split("/");
                    String EventTask = ToSplitEvent[0].toLowerCase().substring(6, ToSplitEvent[0].length());
                    tasks.add(new Event(EventTask, ToSplitEvent[1].substring(5, ToSplitEvent[1].length()), ToSplitEvent[2].substring(3, ToSplitEvent[2].length())));

                }


                if(!empty) {
                    System.out.println("____________________________________________________________\n"
                    +"Got it. I've added this task:\n" +
                            "  " + tasks.get(i) + "\n" +
                            "Now you have " + (i + 1) + " tasks in the list.\n"
                    +"____________________________________________________________\n");
                    i += 1;

                }

            } else if (line.equalsIgnoreCase("list")) {

                System.out.println("____________________________________________________________\n" +
                        "Here are the tasks in your list:");

                for (int m = 0; m < i; m += 1) {
                    int index = m + 1;
                    System.out.println(index + "." + tasks.get(m));

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
