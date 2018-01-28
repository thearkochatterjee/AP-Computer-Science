import java.util.ArrayList;

public class High extends Student{

    public High(String name, int grade, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework){
        super(name, grade, arrtest, arrproject, arrhomework);
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
}
