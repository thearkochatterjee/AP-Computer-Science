import java.util.ArrayList;
import java.util.Random;

public class Elementary extends Student{

    public Elementary(String fname, String lname, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework){
        super(fname, lname, arrtest, arrproject, arrhomework);
    }

    @Override
    public double percentage() {
        return testavg() * 20 + projavg() * 40 + hwavg() * 40;
    }

    @Override
    public int creategrade() {
        Random r = new Random();
        grade = r.nextInt(3) +1;
        return grade;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
