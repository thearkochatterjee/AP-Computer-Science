public class PTEmp extends Emp{
    private int season;

    public PTEmp(int id, double hrs, double wage, int season){
        super(id, hrs, wage);
        this.season = season;
    }

    @Override
    public double findgp() {
        return wage * hrs;
    }

    public String toString() {
        ValueRounding vgp = new ValueRounding();
        vgp.setValue(findgp());
        return id + " " + hrs + " " + wage + " " + vgp.roundtodecnum(2) + " " + season;
    }
}
