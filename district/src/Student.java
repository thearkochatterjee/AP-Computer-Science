import java.util.ArrayList;

abstract public class Student {
    protected String fname, lname;
    protected int grade;
    protected ArrayList<Double> arrtest = new ArrayList<Double>();
    protected ArrayList<Double> arrproject = new ArrayList<Double>();
    protected ArrayList<Double> arrhomework = new ArrayList<Double>();

    public Student(String fname, String lname, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework){
        this.fname = fname;
        this.lname = lname;
        this.arrhomework = arrhomework;
        this.arrproject = arrproject;
        this.arrtest = arrtest;
    }

    public ArrayList<Double> getArrhomework() {
        return arrhomework;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public ArrayList<Double> getArrproject() {
        return arrproject;
    }

    public ArrayList<Double> getArrtest() {
        return arrtest;
    }

    public int getGrade() {
        return grade;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setArrtest(ArrayList<Double> arrtest) {
        this.arrtest = arrtest;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double testavg(){
        return avg(arrtest);
    }

    public double projavg(){
        return avg(arrproject);
    }

    public double hwavg(){
        return avg(arrhomework);
    }

    private double avg(ArrayList<Double> data){
        double avg = 0.0;
        for(double x: data){
            avg+=x;
        }
        avg = avg / data.size();
        return avg;
    }

    public void setArrhomework(ArrayList<Double> arrhomework) {
        this.arrhomework = arrhomework;
    }

    public void setArrproject(ArrayList<Double> arrproject) {
        this.arrproject = arrproject;
    }

    abstract public double percentage();

    abstract public int creategrade();

    public String toString(){
//        return String.format("%", fname, lname, testavg(), projavg(), hwavg());
        return fname + " " + lname + " " + testavg() + " " + projavg() + " " + hwavg();
    }
}
