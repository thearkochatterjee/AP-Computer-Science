abstract public class Student {
    protected String fname, lname;
    protected double testavg, projavg, hwavg, fee;
    protected int grade, id;

    public Student(String fname, String lname, double testavg, double projavg, double hwavg, int id){
        this.fname = fname;
        this.lname = lname;
        this.testavg = testavg;
        this.projavg = projavg;
        this.hwavg = hwavg;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getFee() {
        return fee;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    abstract public double percentage();

    abstract public void creategrade();

    abstract public String lettergrade();

    abstract public String principallist();

    abstract public double studentfee();

    @Override
    public String toString() {
        return "ID " + id + " First Name " + fname + " Last Name " + lname + " Grade " + grade +" Fee " + fee + " Test Avg " + testavg + " Project Avg " + projavg + " HW Avg "+ hwavg;
    }
}
