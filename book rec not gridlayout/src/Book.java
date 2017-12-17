public class Book {
    private String title, author, imagepath, genre;
    private double score = 0.0;

    public Book(){
        title = "";
        author = "";
        imagepath = "null";
        genre = "";
        score = 0.0;
    }

    public Book(String line){

    }

    public String getImagepath() {
        return imagepath;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void copy(Book copy){
        this.title = copy.getTitle();
        this.author = copy.getAuthor();
        this.score = copy.getScore();
        this.imagepath = copy.getImagepath();
    }

    public String toString() {
        String out = "";

        return out;
    }
}
