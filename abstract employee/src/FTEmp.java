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
        if(hrs<=40){
            return hrs * wage - uniondues;
        }
        else{
            return 40 * wage + 1.5 * (hrs-40) * wage - uniondues;
        }
    }

    @Override
    public String toString() {
        ValueRounding vgp = new ValueRounding();
        vgp.setValue(findgp());
        return id + " " + hrs + " " + wage + " " + vgp.roundtodecnum(2) + " " + uniondues;
    }
}
