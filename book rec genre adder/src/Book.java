public class Book {
    private String title, author, imagepath;

    public Book(){
        title = "";
        author = "";
        imagepath = "";
    }

    public Book(String line){
        String parts[] = line.split(",");
        author = parts[0];
        title = parts[1];
        imagepath = parts[3];
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getImagepath() {
        return imagepath;
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

    @Override
    public String toString() {
        String out = "";
        out = author + "," + title + "," + imagepath;
        return out;
    }
}
