abstract public class Student {
    protected String fname, lname;
    protected double testavg, projavg, hwavg;
    protected int grade;

    public Student(String fname, String lname, double testavg, double projavg, double hwavg){
        this.fname = fname;
        this.lname = lname;
        this.testavg = testavg;
        this.projavg = projavg;
        this.hwavg = hwavg;
    }

    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public double getHwavg() {
        return hwavg;
    }

    public int getGrade() {
        return grade;
    }

    public double getProjavg() {
        return projavg;
    }

    public double getTestavg() {
        return testavg;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setHwavg(double hwavg) {
        this.hwavg = hwavg;
    }

    public void setProjavg(double projavg) {
        this.projavg = projavg;
    }

    public void setTestavg(double testavg) {
        this.testavg = testavg;
    }

    abstract public double percentage();

    abstract public void creategrade();

    abstract public String lettergrade();

    abstract public String principallist();

    @Override
    public String toString() {
        return String.format("%1s %15s %15.2f %5.2f %5.2f%n", fname, lname, testavg, projavg, hwavg);
    }
}
