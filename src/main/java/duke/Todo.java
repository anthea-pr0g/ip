package duke;
public class Todo extends Task {
    protected int length;

    public Todo(String description, int length) throws DukeException {

        super(description);
        this.length=length;

        if(length<2) {
            throw new DukeException();
        }
    }
    @Override
    public String toString() {
        return "[T]"+ super.toString();
    }
}

