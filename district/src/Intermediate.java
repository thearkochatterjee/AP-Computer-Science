import java.util.ArrayList;
import java.util.Random;

public class Intermediate extends Student{
    int oaa;

    public Intermediate(String fname, String lname, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework){
        super(fname, lname, arrtest, arrproject, arrhomework);
    }

    @Override
    public double percentage() {
        return testavg() * 20 + projavg() * 40 + hwavg() * 40;
    }

    @Override
    public int creategrade() {
        Random r = new Random();
        grade = r.nextInt(3)+4;
        return grade;
    }

    @Override
    public String toString() {
        return super.toString() + " " + oaa;
    }
}
