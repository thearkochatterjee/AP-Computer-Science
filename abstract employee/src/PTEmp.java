public class PTEmp extends Emp{
    private int season;

    public PTEmp(int id, double hrs, double wage, int season){
        super(id, hrs, wage);
        this.season = season;
    }

    @Override
    public double findgp() {
        double gp = 0.0;
        gp =  wage * hrs;
        return gp;
    }

    public String toString() {
        ValueRounding vgp = new ValueRounding();
        vgp.setValue(findgp());
        return "id: " + id + " hours: " + hrs + " wage: " + wage + " grosspay: " + vgp.roundtodecnum(2) + " season: " + season;
    }
}
