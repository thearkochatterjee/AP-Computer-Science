public class Assignment {
    private String name, subject;
    private Duedate date = new Duedate();
    private boolean complete = false;

    public Assignment(){
        name = "";
        subject = "";
        date = new Duedate();
        complete = false;
    }

    public Assignment(String name, String subject, Duedate date, boolean complete){
        this.name = name;
        this.subject = subject;
        this.date = date;
        this.complete = complete;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Duedate getDate() {
        return date;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDate(Duedate date) {
        this.date = date;
    }

    public String toString() {
        String out = "";

        return out;
    }
}
