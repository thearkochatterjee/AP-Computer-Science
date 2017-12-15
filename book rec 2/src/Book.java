public class Book {
    private String title, author, imagepath;

    public Book(){
        title = "";
        author = "";
        imagepath = "null";
    }

    public Book(String title, String author, String imagepath){
        this.author = author;
        this.title = title;
        this.imagepath = imagepath;
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

        return out;
    }
}
