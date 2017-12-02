public class Assignments {
    private String name, category, subject;
    private double total, earn;
    private DueDate due = new DueDate();

    public Assignments(){
        name = "";
        category = "";
        subject = "";
        total = 0.0;
        earn = 0.0;
        due = new DueDate();
    }

    public Assignments(String name, String category, String subject, double total, double earn, DueDate due){
        this.name = name;
        this.category = category;
        this.subject = subject;
        this.total = total;
        this.earn = earn;
        this.due = due;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSubject() {
        return subject;
    }

    public double getTotal() {
        return total;
    }

    public double getEarn() {
        return earn;
    }

    public DueDate getDue() {
        return due;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setEarn(double earn) {
        this.earn = earn;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDue(DueDate due) {
        this.due = due;
    }

    public String toString() {
        String out = "";

        return out;
    }
}
