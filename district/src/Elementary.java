import java.util.ArrayList;

public class Elementary extends Student{

    public Elementary(String name, int grade, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework){
        super(name, grade, arrtest, arrproject, arrhomework);
    }

    @Override
    public double percentage() {
        double percent = 0.0;

        return percent;
    }
}
