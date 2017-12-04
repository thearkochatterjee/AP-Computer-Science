import java.util.ArrayList;

public class Reader {
    private int ratings[] = new int[100];
    private String name = "";
    private int rnum = 0;

    public Reader(){
        rnum = 0;
        for(int i = 0;i<100;i++){
            ratings[i] = 0;
        }
        name = "";
    }

    public Reader(int ratings[], String name, int rnum){
        this.ratings = ratings;
        this.name = name;
        this.rnum = rnum;
    }

    public Reader(String line){
        String parts[] = line.split(",");

    }

    public String getName() {
        return name;
    }

    public int getRnum() {
        return rnum;
    }

    public int[] getRatings() {
        return ratings;
    }

    public void setRatings(int[] ratings) {
        this.ratings = ratings;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String out = "";
        out = name + ",";
        return out;
    }
}
