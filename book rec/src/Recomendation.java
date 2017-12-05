import java.util.ArrayList;

public class Recomendation {
    private ArrayList<Book> arrbook = new ArrayList<Book>();
    private ArrayList<Reader> arrreader = new ArrayList<Reader>();

    public Recomendation(){
        arrbook = new ArrayList<Book>();
        arrreader = new ArrayList<Reader>();
    }

    public Recomendation(ArrayList<Book> arrbook, ArrayList<Reader> arrreader){
        this.arrreader = arrreader;
        this.arrbook = arrbook;
    }

    public ArrayList<Book> getArrbook() {
        return arrbook;
    }

    public ArrayList<Reader> getArrreader() {
        return arrreader;
    }

    public void setArrbook(ArrayList<Book> arrbook) {
        this.arrbook = arrbook;
    }

    public void setArrreader(ArrayList<Reader> arrreader) {
        this.arrreader = arrreader;
    }
}
