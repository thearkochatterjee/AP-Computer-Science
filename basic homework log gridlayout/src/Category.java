import java.util.ArrayList;

public class Category {
    private String name;
    private double weight;
    private ArrayList<Assignments> arrassignment = new ArrayList<Assignments>();

    public Category(){
        name = "";
        weight = 0.0;
        arrassignment = new ArrayList<Assignments>();
    }

    public Category(String name, double weight, ArrayList<Assignments> arrassignment){
        this.name = name;
        this.weight = weight;
        this.arrassignment = arrassignment;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public ArrayList<Assignments> getArrassignment() {
        return arrassignment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArrassignment(ArrayList<Assignments> arrassignment) {
        this.arrassignment = arrassignment;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double percentcategory(){
        double ans = 0.0;
        double tp = 0.0;
        double ep = 0.0;
        for(int i = 0;i<arrassignment.size();i++){
            if(arrassignment.get(i).getCategory().equals(name)){
                tp += arrassignment.get(i).getTotal();
                ep += arrassignment.get(i).getEarn();
            }
        }
        ans = ep/tp*100;
        return ans;
    }

    public double percentoverall(){
        double ans = 0.0;
        ans = (percentcategory()/100) * weight;
        return ans;
    }

    public String toString() {
        String ans = "";

        return ans;
    }
}