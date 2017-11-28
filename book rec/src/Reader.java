import java.util.ArrayList;

public class Reader {
    private ArrayList<Book> arrbook = new ArrayList<Book>();
    private String name = "";

    public Reader(){

    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getArrbook() {
        return arrbook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArrbook(ArrayList<Book> arrbook) {
        this.arrbook = arrbook;
    }

    @Override
    public String toString() {
        String out = "";

        return out;
    }
}
