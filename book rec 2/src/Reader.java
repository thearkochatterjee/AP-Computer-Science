public class Reader {
    private String name;
    private int rating[] = new int[100];

    public Reader(){
        name = "";
        for(int i = 0;i<100;i++){
            rating[i] = 0;
        }
    }

    public Reader(String line){
        String parts[] = line.split(",");
        String rpart[] = parts[1].split(" ");
        name = parts[0];
        rating = new int[rpart.length];
        for(int i = 0;i<rating.length;i++){
            rating[i] = 0;
        }
        for(int i = 0;i<rating.length;i++){
            rating[i] = Integer.valueOf(rpart[i]);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int[] rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int[] getRating() {
        return rating;
    }

    public String toString() {
        String out = "";
        out = name + ",";
        for(int i = 0;i<rating.length;i++){
            out += String.valueOf(rating[i]) + " ";
        }
        out = out.trim();
        return out;
    }
}
