public class Book {
    private String title, author, imagepath;
    private double rating;

    public Book(){
        title = "";
        author = "";
        rating = 0;
    }

    public Book(String title, String author, double rating, String imagepath){
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.imagepath = imagepath;
    }

    public String getAuthor() {
        return author;
    }

    public String getImagepath() {
        return imagepath;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
