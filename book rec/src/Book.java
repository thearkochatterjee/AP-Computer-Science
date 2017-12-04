public class Book {
    private String title, author, imagepath;

    public Book(){
        title = "";
        author = "";
        imagepath = "";
    }

    public Book(String line){
        String parts[] = line.split(",");
        title = parts[0];
        author = parts[1];
        imagepath = parts[2];
    }

    public Book(String title, String author, double rating, String imagepath){
        this.title = title;
        this.author = author;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String toString() {
        String out = "";
        out = title + "," + author + "," + imagepath;
        return out;
    }
}
