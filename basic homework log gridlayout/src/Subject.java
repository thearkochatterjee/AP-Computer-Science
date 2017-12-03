import java.util.ArrayList;

public class Subject {
    private ArrayList<Category> arrcategory = new ArrayList<Category>();
    private String name;
    private ArrayList<String> arrcategoryname = new ArrayList<String>();

    public Subject(){
        arrcategory = new ArrayList<Category>();
        name = "";
    }

    public Subject(String line){
        String parts[] = line.split(",");
        name = parts[0];
        for(int i = 1;i<parts.length;i++){
            arrcategoryname.add(parts[i]);
        }
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
            if (arrcategory.get(i).getSubject()==name){
                ans += arrcategory.get(i).percentoverall();
            }
        }
        return ans;
    }
}
