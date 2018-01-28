import java.util.ArrayList;

abstract public class Student {
    protected String name;
    protected int grade;
    protected ArrayList<Double> arrtest = new ArrayList<Double>();
    protected ArrayList<Double> arrproject = new ArrayList<Double>();
    protected ArrayList<Double> arrhomework = new ArrayList<Double>();

    public Student(String name, int grade, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework){
        this.grade = grade;
        this.name = name;
        this.arrhomework = arrhomework;
        this.arrproject = arrproject;
        this.arrtest = arrtest;
    }

    public ArrayList<Double> getArrhomework() {
        return arrhomework;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setArrtest(ArrayList<Double> arrtest) {
        this.arrtest = arrtest;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setArrhomework(ArrayList<Double> arrhomework) {
        this.arrhomework = arrhomework;
    }

    public void setArrproject(ArrayList<Double> arrproject) {
        this.arrproject = arrproject;
    }

    abstract public double percentage();
}
