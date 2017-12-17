public class Reader {
    private String name = "";
    private int rating[] = new int[100];

    public Reader(){

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
}
