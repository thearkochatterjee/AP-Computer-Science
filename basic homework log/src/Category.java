import java.util.ArrayList;

public class Category {
    private String name = "";
    private double weight = 0.0;
    private ArrayList<Assignment> arrassignment = new ArrayList<Assignment>();

    public Category(){
        name = "";
        weight = 0.0;
        arrassignment = new ArrayList<Assignment>();
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public ArrayList<Assignment> getArrassignment() {
        return arrassignment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setArrassignment(ArrayList<Assignment> arrassignment) {
        this.arrassignment = arrassignment;
    }

    public double percentcategory(){
        double ans = 0.0;
        double e = 0.0;
        double t = 0.0;
        for(int i = 0;i<arrassignment.size();i++){
            e += arrassignment.get(i).getEarn();
            t += arrassignment.get(i).getTotal();
        }
        ans = e/t * 100;
        return ans;
    }

    public double percentofoverall(){
        double ans = 0.0;
        ans = (percentcategory()/100) * weight;
        return ans;
    }

    public String toString() {
        String out = "";

        return out;
    }
}
