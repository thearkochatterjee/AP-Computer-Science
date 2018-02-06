import java.util.Random;

public class High extends Student{
    int actscore = 0;

    public High(String fname, String lname, double testavg, double projavg, double hwavg, int actscore, int id){
        super(fname, lname, testavg, projavg, hwavg, id);
        this.actscore = actscore;
    }

    @Override
    public void creategrade() {
        Random r = new Random();
        grade = r.nextInt(4)+9;
    }

    @Override
    public double percentage() {
        return (testavg / 100) * 50 + (projavg / 100) * 30 + (hwavg / 100) * 20;
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
    public double studentfee() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Percentage " + percentage() + " Letter Grade " + lettergrade() + " Fees " + studentfee() + " PList " + principallist();
    }
}