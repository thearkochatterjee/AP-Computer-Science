import java.util.ArrayList;

public class Subject {
    private ArrayList<Category> arrcategory = new ArrayList<Category>();
    private String name;

    public Subject(){
        arrcategory = new ArrayList<Category>();
        name = "";
    }

    public String getName() {
        return name;
    }

    public ArrayList<Category> getArrcategory() {
        return arrcategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArrcategory(ArrayList<Category> arrcategory) {
        this.arrcategory = arrcategory;
    }

    public double grade(){
        double ans = 0.0;
        for(int i = 0;i<arrcategory.size();i++){
            ans += arrcategory.get(i).percentoverall();
        }
        return ans;
    }
}
