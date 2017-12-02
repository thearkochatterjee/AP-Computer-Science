import javax.swing.*;

public class DueDate {
    private int month, day, year;

    public DueDate(){
        month = 0;
        day = 0;
        year = 0;
    }

    public DueDate(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public DueDate(String line){
        String parts[] = line.split("/");
        try{
            month = Integer.valueOf(parts[0]);
            day = Integer.valueOf(parts[1]);
            year = Integer.valueOf(parts[2]);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Input Error");
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        String out = "";
        out = month + "/" + day + "/" + year;
        return out;
    }
}
