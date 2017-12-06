import java.util.ArrayList;

public class Book {
    private String title, author, imagepath;
    private ArrayList<String> arrgenre = new ArrayList<String>();

    public Book(){
        title = "";
        author = "";
        imagepath = "";
        arrgenre = new ArrayList<String>();
    }

    public Book(String line){
        String parts[] = line.split(",");
        title = parts[0];
        author = parts[1];
        imagepath = parts[2];

    }

    public Book(String title, String author, String imagepath, ArrayList<String> arrgenre){
        this.title = title;
        this.author = author;
        this.imagepath = imagepath;
        this.arrgenre = arrgenre;
    }

    public ArrayList<String> getGenre() {
        return arrgenre;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        String out = "";
        out = title + "," + author + "," + imagepath + "," + genre;
        return out;
    }
}
