public class Player {
    private String name;
    private double score;
    private Baker baker;

    public Player(){

    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public Baker getBaker() {
        return baker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setBaker(Baker baker) {
        this.baker = baker;
    }
}
