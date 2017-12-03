import javax.swing.*;

public class Assignments {
    private String name, category, subject;
    private double total, earn;
    private DueDate due = new DueDate();
    private boolean complete = false;

    public Assignments(){
        name = "";
        category = "";
        subject = "";
        total = 0.0;
        earn = 0.0;
        due = new DueDate();
        complete = false;
    }

    public Assignments(String name, String category, String subject, double total, double earn, DueDate due, boolean complete){
        this.name = name;
        this.category = category;
        this.subject = subject;
        this.total = total;
        this.earn = earn;
        this.due = due;
        this.complete = complete;
    }

    public Assignments(String line){
        String parts[] = line.split(",");
        name = parts[0];
        subject = parts[1];
        category = parts[2];
        try{
            earn = Double.valueOf(parts[3]);
            total = Double.valueOf(parts[4]);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Data Corrupted");
        }
        due = new DueDate(parts[5]);
        complete = parts[6].equals("y");
    }

    public boolean isComplete() {
        return complete;
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

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String toString() {
        String out = "";
        out = name + "," + subject + "," + category + "," + earn + "," + total +"," + due.toString() +",";
        if(complete){
            out +="y";
        }
        else{
            out+="n";
        }
        return out;
    }
}
