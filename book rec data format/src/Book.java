public class Book {
    private String title, author, imagepath, genre;

    public Book(){
        title = "";
        author = "";
        imagepath = "";
        genre = "";
    }

    public Book(String line){
        String parts[] = line.split(",");
        author = parts[0];
        title = parts[1];
        imagepath = parts[2];
        genre = parts[3];
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        String out = "";
        out = author + "," + title;
        return out;
    }
}
