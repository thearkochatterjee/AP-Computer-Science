public class PTEmp extends Emp{
    private String season;

    public PTEmp(int id, double hrs, double wage, String season){
        super(id, hrs, wage);
        this.season = season;
    }

    @Override
    public double findgp() {
        return wage * hrs;
    }

    public String toString() {
        return id + " " + hrs + " " + wage + " " + findgp();
    }
}
