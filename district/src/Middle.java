import java.util.Random;

public class Middle extends Student{
    private int mapscore = 0;

    public Middle(String fname, String lname, double testavg, double projavg, double hwavg, int mapscore){
        super(fname, lname, testavg, projavg, hwavg);
        this.mapscore = mapscore;
    }

    @Override
    public String principallist() {
        return null;
    }

    @Override
    public String lettergrade() {
        return null;
    }

    @Override
    public double percentage() {
        return 0;
    }

    @Override
    public void creategrade() {
        Random r = new Random();
        grade = r.nextInt(2)+7;
    }
}
