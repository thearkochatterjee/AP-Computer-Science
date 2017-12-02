public class Duedate {
    private int month, day, year;

    public Duedate(){
        month = 0;
        day = 0;
        year = 0;
    }

    public Duedate(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Duedate(String date){
        String parts[] = date.split("/");
        month = Integer.valueOf(parts[0]);
        day = Integer.valueOf(parts[1]);
        year = Integer.valueOf(parts[2]);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean before(Duedate compare){
        boolean ans = false;
        if(compare.getYear()>year){
            ans = true;
        }
        else if(compare.getMonth()>month){
            ans = true;
        }
        else if(compare.getDay()>day){
            ans = true;
        }
        return ans;
    }

    public String toString() {
        String out = "";
        out = month + "/" + day + "/" + year;
        return out;
    }
}
