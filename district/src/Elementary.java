import java.util.Random;

public class Elementary extends Student{
    private String participate = "";

    public Elementary(String fname, String lname, double testavg, double projavg, double hwavg, int id, String participate){
        super(fname, lname, testavg, projavg, hwavg, id);
        this.participate = participate;
    }

    @Override
    public void creategrade() {
        Random r = new Random();
        grade = r.nextInt(6)+1;
    }

    @Override
    public double percentage() {
        return (testavg / 100) * 20 + (projavg / 100) * 40 + (hwavg / 100) * 40;
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
        if(percentage()>=80){
            return "Made";
        }
        else{
            return "Didn't Make";
        }
    }

    @Override
    public void studentfee() {
        Random r = new Random();
        fee = Math.round((r.nextDouble()*20+20)*100)/100;
    }

    @Override
    public String toString() {
        return "Percentage " + percentage() + " Letter Grade " + lettergrade() + " PList " + principallist() + " Participate " + participate + " " + super.toString();
    }
}
