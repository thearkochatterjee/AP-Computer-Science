import java.util.ArrayList;
import java.util.Random;

public class Middle extends Student{
    int explore;

    public Middle(String fname, String lname, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework){
        super(fname, lname, arrtest, arrproject, arrhomework);
    }

    @Override
    public double percentage() {
        double percent = 0.0;

        return percent;
    }

    @Override
    public int creategrade() {
        Random r = new Random();
        grade = r.nextInt(2)+7;
        return grade;
    }

    @Override
    public String toString() {
        return super.toString() + " " + explore;
    }
}
