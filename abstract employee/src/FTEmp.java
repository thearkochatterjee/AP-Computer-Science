public class FTEmp extends Emp{
    private double uniondues;

    public FTEmp(int id, double hr, double wage, double union){
        super(id, hr, wage);
        this.uniondues = union;
        totalempls++;
    }

    public double getUniondues() {
        return uniondues;
    }

    @Override
    public double findgp() {
        double gp = 0.0;
        if(hrs<=40){
            gp =  hrs * wage - uniondues;
        }
        else{
            gp =  40 * wage + 1.5 * (hrs-40) * wage - uniondues;
        }
        return gp;
    }

    @Override
    public String toString() {
        ValueRounding vgp = new ValueRounding();
        vgp.setValue(findgp());
        return "id: "+id + " hours: " + hrs + " wage: " + wage + " grosspay: " + vgp.roundtodecnum(2) + " union dues" + uniondues;
    }
}
