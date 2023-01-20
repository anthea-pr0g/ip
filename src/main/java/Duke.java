import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);


        String greeting="____________________________________________________________\n"
                +" Hello! I'm Duke\n"
                +" What can I do for you?\n"
                + "____________________________________________________________\n";

        System.out.println(greeting);
        Scanner in=new Scanner(System.in);
        String[] list= new String[100];
        int i=0;
        while(true)
        {
            String line=in.nextLine();
            if(line.equalsIgnoreCase("bye"))
            {
                break;
            }
            list[i]=line;

            if(line.equalsIgnoreCase("list"))
            {
                System.out.println("____________________________________________________________");
                for(int m=0;m<i;m+=1)
                {
                    int index=m+1;
                    System.out.println(index + ". " + list[m] );
                }
                System.out.println( "____________________________________________________________");

            }
            else {
                i += 1;

                System.out.println("____________________________________________________________\n" + "added: " + line);
                System.out.println("____________________________________________________________\n");
            }

        }


            System.out.println("____________________________________________________________\n"
                    +" Bye. Hope to see you again soon!\n"
                    +"____________________________________________________________\n");


    }
}
