import java.util.Random;

public class Middle extends Student{
    private int mapscore = 0;

    public Middle(String fname, String lname, double testavg, double projavg, double hwavg, int mapscor, int id){
        super(fname, lname, testavg, projavg, hwavg, id);
        this.mapscore = mapscore;
    }

    @Override
    public String principallist() {
        Random r = new Random();
        if(r.nextBoolean()){
            return "Made";
        }
        else{
            return "Didn't Make";
        }
    }

    @Override
    public String lettergrade() {
        if(percentage()>=90){
            return "A";
        }
        else if(percentage()>=80){
            return "B";
        }
        else if(percentage()>=70){
            return "C";
        }
        else if(percentage()>=60){
            return "D";
        }
        else{
            return "F";
        }
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

    @Override
    public double studentfee() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Percentage " + percentage() + " Letter Grade " + lettergrade() + " Fees " + studentfee() + " PList " + principallist();
    }
}
