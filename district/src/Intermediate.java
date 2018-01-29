import java.util.ArrayList;

public class Intermediate extends Student{

    public Intermediate(String name, int grade, ArrayList<Double> arrtest, ArrayList<Double> arrproject, ArrayList<Double> arrhomework){
        super(name, grade, arrtest, arrproject, arrhomework);
    }

    @Override
    public double percentage() {
        return testavg() * 20 + projectavg() * 40 + hwavg() * 40;
    }

    private double testavg(){
        double avg = 0.0;
        for(Double g: arrtest){
            avg+=g;
        }
        avg = avg/arrtest.size();
        return avg;
    }

    private double projectavg(){
        double avg = 0.0;
        for(Double g: arrproject){
            avg+= g;
        }
        avg = avg / arrproject.size();
        return avg;
    }

    private double hwavg(){
        double avg = 0.0;
        for(Double g: arrhomework){
            avg+=g;
        }
        avg = avg / arrhomework.size();
        return avg;
    }
}
