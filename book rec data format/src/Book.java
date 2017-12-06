public class Book {
    private String title, author;

    public Book(){
        title = "";
        author = "";
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
        out = author + "," + title
        return out;
    }
}
