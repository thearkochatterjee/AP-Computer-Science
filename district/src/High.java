import java.util.ArrayList;
import java.util.Random;

public class High extends Student{
    private int act, sat;

    public High(String fname, String lname, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework, int act, int sat){
        super(fname, lname, arrtest, arrproject, arrhomework);
    }

    @Override
    public int creategrade() {
        Random r = new Random();
        grade = r.nextInt(4)+9;
        return grade;
    }

    @Override
    public double percentage() {
        double percent = 0.0;
        double total = 0.0;
        for(double s: arrhomework){
            total += s;
        }
        percent = total * 0.2;
        total = 0.0;
        for(double s: arrproject){
            total+=s;
        }
        percent += total * 0.4;
        total = 0.0;
        for(double s: arrtest){
            total+=s;
        }
        percent += total * 0.4;
        return percent;
    }

    @Override
    public String toString() {
        return super.toString() + " " + act + " " + sat;
    }
}
