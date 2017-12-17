public class Reader {
    private String name = "";
    private int rating[] = new int[100];

    public Reader(){
        name = "";
        for(int i = 0;i<rating.length;i++){
            rating[i] = 0;
        }
    }

    public Reader(String line){
        String parts[] = line.split(",");
        String rparts[] = parts[1].split(" ");
        name = parts[0];
        rating = new int[rparts.length];
        for(int i = 0;i<rparts.length;i++){
            rating[i] = Integer.valueOf(rparts[i]);
        }
    }

    public void setRating(int[] rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public void copy(Reader copy){
        this.rating = copy.getRating();
        this.name = copy.getName();
    }
}
