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
        String gpart[] = parts[3].split("-");
        title = parts[0];
        author = parts[1];
        imagepath = parts[2];
        for(int i = 0;i<gpart.length;i++){
            arrgenre.add(gpart[i]);
        }
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

    public void setGenre(ArrayList<String> arrgenre) {
        this.arrgenre = arrgenre;
    }

    public String toString() {
        String out = "";
        String gout = "";
        for(int i = 0;i<arrgenre.size()-1;i++){
            gout+=arrgenre.get(i)+"-";
        }
        gout+=arrgenre.get(arrgenre.size()-1);
        out = title + "," + author + "," + imagepath + "," + gout;
        return out;
    }
}
