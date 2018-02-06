import java.util.Random;

public class Middle extends Student{
    private int mapscore = 0;

    public Middle(String fname, String lname, double testavg, double projavg, double hwavg, int mapscore, int id){
        super(fname, lname, testavg, projavg, hwavg, id);
        this.mapscore = mapscore;
    }

    @Override
    public String principallist() {
        if(percentage()>=85){
            return  "Made";
        }
        else{
            return  "Didn't Make";
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
        return (testavg / 100) * 35 + (projavg / 100) * 35 + (hwavg / 100) * 30;
    }

    @Override
    public void creategrade() {
        Random r = new Random();
        grade = r.nextInt(2)+7;
    }

    @Override
    public void studentfee() {
        Random r = new Random();
        fee = Math.round((r.nextDouble()*20+1)*100)/100;
    }

    @Override
    public String toString() {
        return "Percentage " + percentage() + " Letter Grade " + lettergrade() + " PList " + principallist() + " MAP Score " + mapscore + " " + super.toString();
    }
}
