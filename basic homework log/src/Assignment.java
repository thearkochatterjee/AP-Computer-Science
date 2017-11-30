public class Assignment {
    private String name, subject, category;
    private Duedate date = new Duedate();
    private boolean complete = false;
    private double earn, total;

    public Assignment(){
        name = "";
        subject = "";
        date = new Duedate();
        complete = false;
        earn = 0.0;
        total = 0.0;
        category = "";
    }

    public Assignment(String name, String subject, Duedate date, boolean complete, double earn, double total, String category){
        this.name = name;
        this.subject = subject;
        this.date = date;
        this.complete = complete;
        this.earn = earn;
        this.total = total;
        this.category = category;
    }

    public Assignment(String line){
        String parts[] = line.split(",");
        name = parts[0];
        subject = parts[1];
        date = new Duedate(parts[2]);
        complete = parts[3].equals("1");
        earn = Double.valueOf(parts[4]);
        total = Double.valueOf(parts[5]);
        category = parts[6];
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

    public double getEarn() {
        return earn;
    }

    public double getTotal() {
        return total;
    }

    public String getCategory() {
        return category;
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

    public void setEarn(double earn) {
        this.earn = earn;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        String out = "";
        if(complete){
            out = name + "," + subject + "," + date.toString() + ",1,"+earn+","+total+","+category;
        }
        else{
            out = name + "," + subject + "," + date.toString() + ",0,"+earn+","+total+","+category;
        }
        return out;
    }
}
