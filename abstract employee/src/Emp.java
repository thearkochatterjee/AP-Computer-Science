abstract public class Emp {
    protected int id;
    protected double hrs, wage;

    public Emp(int id, double hrs, double wage){
        this.id = id;
        this.hrs = hrs;
        this.wage = wage;
    }

    public double getHrs() {
        return hrs;
    }

    public int getId() {
        return id;
    }

    public double getWage() {
        return wage;
    }

    abstract public double findgp();

    abstract public String toString();

    static public int totalempls = 0;
}
