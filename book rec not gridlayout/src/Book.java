public class Book {
    private String title, author, imagepath, genre;

    public Book(){
        title = "";
        author = "";
        imagepath = "null";
        genre = "";
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

    public String toString() {
        String out = "";

        return out;
    }
}
