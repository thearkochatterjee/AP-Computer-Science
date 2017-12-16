public class Book {
    private String title, author, imagepath, genre;

    public Book(){
        title = "";
        author = "";
        imagepath = "null";
        genre = "";
    }

    public Book(String title, String author, String imagepath, String genre){
        this.author = author;
        this.title = title;
        this.imagepath = imagepath;
        this.genre = genre;
    }

    public Book(String line){
        String parts[] = line.split(",");
        author = parts[0];
        title = parts[1];
        imagepath = parts[2];
        genre = parts[3];
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImagepath() {
        return imagepath;
    }

    public String toString() {
        String out = "";
        out = author + "," + title + "," + imagepath + "," + genre;
        return out;
    }
}
