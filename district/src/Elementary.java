import java.util.Random;

public class Elementary extends Student{
    public Elementary(String fname, String lname, double testavg, double projavg, double hwavg){
        super(fname, lname, testavg, projavg, hwavg);
    }

    @Override
    public void creategrade() {
        Random r = new Random();
        grade = r.nextInt(6)+1;
    }

    @Override
    public double percentage() {
        return 0;
    }

    @Override
    public String lettergrade() {
        return null;
    }

    @Override
    public String principallist() {
        return null;
    }
}
