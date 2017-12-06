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

    public Book mostread(){
        Book rec = new Book();
        int high = 0;
        int pos = 0;
        int temp = 0;
        for(int b = 0;b<arrbook.size();b++){
            for(int r = 0;r<arrreader.size();r++){
                if(arrreader.get(r).getRatings()[b]!=0){
                    temp++;
                }
            }
            if(temp>high){
                high = temp;
                pos = b;
            }
        }
        rec = arrbook.get(pos);
        return rec;
    }

    public Book basedongenre(){
        Book rec = new Book();

        return rec;
    }

    public Book methoda(int pos){
        double avg[] = new double[arrreader.size()];
        double high = 0.0;
        int p = 0;
        for (int b = 0;b<arrbook.size();b++){
            for(int r = 0;r<arrreader.size();r++){
                if(r != pos){
                    avg[b] += arrreader.get(r).getRatings()[b];
                }
            }
            avg[b] /= arrreader.size()-1;
        }
        for(int i = 0;i<avg.length;i++){
            if(avg[i]>high && arrreader.get(pos).getRatings()[i]==0){
                high = avg[i];
                p = i;
            }
        }
        return arrbook.get(p);
    }

    public Book methodb(int pos){
        double high = -1000.0;
        double score = 0.0;
        int p = 0;
        for(int i = 0;i<arrreader.size();i++){
            score = 0.0;
            if(i!=pos){
                for(int c = 0;c<arrbook.size();c++){
                    score += arrreader.get(pos).getRatings()[c] * arrreader.get(i).getRatings()[c];
                }
            }
            if(score > high){
                high = score;
                p = i;
            }
        }
        return arrbook.get(p);
    }

    public Book methodc(){
        Book rec = new Book();

        return rec;
    }

    private  double[] sort(double sort[]){
        double ans[] = new double[sort.length];
        double temp = 0.0;
        for(int f = 0;f<sort.length-1;f++){
            for(int b = f+1;b<sort.length;b++){
                if(sort[f]>sort[b]){
                    temp = sort[f];
                    sort[f] = sort[b];
                    sort[b] = temp;
                }
            }
        }
        return ans;
    }
}
