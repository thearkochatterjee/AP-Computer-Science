public class High extends Student{
    int actscore = 0;

    public High(String fname, String lname, double testavg, double projavg, double hwavg, int actscore){
        super(fname, lname, testavg, projavg, hwavg);
        this.actscore = actscore;
    }

    @Override
    public void creategrade() {

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
