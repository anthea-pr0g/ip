package duke;
public class Task {

        /**
         * Creates a task.
         * @param description is the task name
         * @param isDone defines if a task is done
         * @return getStatusIcon checks if the task is done or not
         * @return toString the format of how the task is shown
         */
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }

        public void markAsDone() {
            this.isDone=true;
        }
        public void markAsUnDone() {
            this.isDone=false;
        }

        public String toString() {
            return "["+ getStatusIcon() +"] " + description;
        }


}

