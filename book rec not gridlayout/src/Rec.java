import java.util.ArrayList;

public class Rec {
    private ArrayList<Reader> arrreader = new ArrayList<Reader>();
    private ArrayList<Book> arrbook = new ArrayList<Book>();

    public Rec(){
        arrbook = new ArrayList<Book>();
        arrreader = new ArrayList<Reader>();
    }

    public Rec(ArrayList<Book> arrbook, ArrayList<Reader> arrreader){
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

    public ArrayList<Book> methoda(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();
        double avg = 0.0;
        int numr = 0;
        for(int i = 0;i<arrbook.size();i++){
            avg = 0.0;
            numr = arrbook.size();
            for(int x = 0;x<arrreader.size();x++){
                if(arrreader.get(i).getRating()[x]!=0.0){
                    avg+=arrreader.get(x).getRating()[i];
                }
                else{
                    numr = numr - 1;
                }
            }
            arrbook.get(i).setScore(avg/numr);
        }
        rec = sort(arrbook);
        return rec;
    }

    public ArrayList<Book> methodb(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();

        return rec;
    }

    public ArrayList<Book> methodc(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();

        return rec;
    }

    public ArrayList<Book> methodd(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();

        return rec;
    }

    private ArrayList<Book> sort(ArrayList<Book> arrsort){
        Book temp = new Book();
        Book sort[] = new Book[arrsort.size()];
        ArrayList<Book> sorted = new ArrayList<Book>();
        for(int i = 0;i<arrsort.size();i++){
            sort[i] = arrsort.get(i);
        }
        for(int f = 0;f<arrsort.size()-1;f++){
            for(int b = f +1;b<arrsort.size();b++){
                if(arrsort.get(f).getScore()<arrsort.get(b).getScore()){
                    temp = sort[f];
                    sort[f] = sort[b];
                    sort[b] = temp;
                }
            }
        }
        for(int i = 0;i<sort.length;i++){
            sorted.add(sort[i]);
        }
        return sorted;
    }
}
