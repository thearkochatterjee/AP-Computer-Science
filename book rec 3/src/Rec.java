import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Rec {
    private ArrayList<Reader> arrreader = new ArrayList<Reader>();
    private ArrayList<Book> arrbook = new ArrayList<Book>();
    private Reader mostsimilar = new Reader();

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

    public Reader getMostsimilar() {
        return mostsimilar;
    }

    public ArrayList<Book> methoda(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();
        double avg = 0.0;
        for(int i = 0;i<arrbook.size();i++){
            avg = 0.0;
            for(int x = 0;x<arrreader.size();x++){
                if(arrreader.get(x).getRating()[i]!=0.0){
                    avg+=arrreader.get(x).getRating()[i];
                }
            }
            arrbook.get(i).setScore(avg);
        }
        Book temp[] = new Book[arrbook.size()];
        Book stemp = new Book();
        for(int i = 0;i<arrbook.size();i++){
            temp[i] = new Book();
        }
        for(int i = 0;i<arrbook.size();i++){
            temp[i] = arrbook.get(i);
        }
        for(int f = 0;f<arrbook.size()-1;f++){
            for(int b = f+1;b<arrbook.size();b++){
                if(temp[f].getScore()<temp[b].getScore()){
                    stemp = temp[f];
                    temp[f] = temp[b];
                    temp[b] = stemp;
                }
            }
        }
        for(int i = 0;i<temp.length;i++){
            rec.add(temp[i]);
        }
        return rec;
    }

    public int similarity(Reader r, Reader compare){
        int similar = 0;
        for(int i = 0;i<arrbook.size();i++){
            similar+=r.getRating()[i]*compare.getRating()[i];
        }
        return similar;
    }

    public Reader mostsimilar(Reader r){
        Reader mostsimiar = new Reader();
        int scores[] = new int[arrreader.size()];
        int highest = -100;
        int pos = 0;
        for(int i = 0;i<arrreader.size();i++){
            scores[i] = 0;
        }
        for(int i = 0;i<arrreader.size();i++){
            if(!arrreader.get(i).equals(r)){
                scores[i] = similarity(r,arrreader.get(i));
            }
        }
        for(int i = 0;i<arrreader.size();i++){
            if(scores[i]>highest){
                highest = scores[i];
                pos = i;
            }
        }
        mostsimiar = arrreader.get(pos);
        return mostsimiar;
    }

    public ArrayList<Book> methodb(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();
        mostsimilar = mostsimilar(r);
        for(int i = 5; i>0;i--){
            for(int j = 0;j<arrbook.size();j++){
                if((mostsimilar(r).getRating()[j]==i)&&(r.getRating()[j]==0)){
                    rec.add(arrbook.get(j));
                }
            }
        }
        return rec;
    }

    public ArrayList<Book> oldmethodb(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();
        double score = 0.0;
        double arrcomp[][] = new double[arrreader.size()][arrreader.size()];
        for(int i = 0;i<arrreader.size();i++){
            for(int x = 0;x<arrreader.size();x++){
                arrcomp[i][x] = 0.0;
            }
        }
        for(int i = 0;i<arrbook.size();i++){
            score = 0.0;
            for(int x = 0;x<arrreader.size();x++){
                if(arrreader.get(x).equals(r)==false){
                    score+=arrreader.get(x).getRating()[i] * r.getRating()[i];
                }
            }
            arrbook.get(i).setScore(score);
        }
        Book temp[] = new Book[arrbook.size()];
        Book stemp = new Book();
        for(int i = 0;i<arrbook.size();i++){
            temp[i] = new Book();
        }
        for(int i = 0;i<arrbook.size();i++){
            temp[i] = arrbook.get(i);
        }
        for(int f = 0;f<arrbook.size()-1;f++){
            for(int b = f+1;b<arrbook.size();b++){
                if(temp[f].getScore()<temp[b].getScore()){
                    stemp = temp[f];
                    temp[f] = temp[b];
                    temp[b] = stemp;
                }
            }
        }
        for(int i = 0;i<temp.length;i++){
            rec.add(temp[i]);
        }
        return rec;
    }

    public int booktotalscore(Reader r, int b){
        int scores[] = new int[arrreader.size()];
        for(int i = 0;i<arrreader.size();i++){
            scores[i] = similarity(r,arrreader.get(i)) * arrreader.get(i).getRating()[b];
        }
        return sum(scores);
    }

    public int sum(int total[]){
        int sum = 0;
        for(int i = 0;i<total.length;i++){
            sum+=total[i];
        }
        return sum;
    }

    public ArrayList<Book> methodc(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();
        for(int i = 0;i<arrbook.size();i++){
            arrbook.get(i).setScore(booktotalscore(r,i));
        }
        Book temp[] = new Book[arrbook.size()];
        Book stemp = new Book();
        for(int i = 0;i<arrbook.size();i++){
            temp[i] = new Book();
        }
        for(int i = 0;i<arrbook.size();i++){
            temp[i] = arrbook.get(i);
        }
        for(int f = 0;f<arrbook.size()-1;f++){
            for(int b = f+1;b<arrbook.size();b++){
                if(temp[f].getScore()<temp[b].getScore()){
                    stemp = temp[f];
                    temp[f] = temp[b];
                    temp[b] = stemp;
                }
            }
        }
        for(int i = 0;i<temp.length;i++){
            rec.add(temp[i]);
        }
        return rec;
    }

    public ArrayList<Book> oldmethodc(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();
        double scores[] = new double[arrreader.size()];
        double scores2[] = new double[arrbook.size()];
        for(int i = 0;i<arrreader.size();i++){
            scores[i] = 0.0;
        }
        for(int i = 0;i<arrbook.size();i++){
            scores2[i] = 0.0;
        }
        for(int re = 0;re<arrreader.size();re++){
            for(int b = 0;b<arrbook.size();b++){
                scores[re]+=r.getRating()[b]*arrreader.get(re).getRating()[b];
            }
        }
        for(int b = 0;b<arrbook.size();b++){
            for(int re = 0;re<arrreader.size();re++){
                scores2[b]+=arrreader.get(re).getRating()[b] * scores[re];
            }
        }
        for(int i = 0;i<arrbook.size();i++){
            arrbook.get(i).setScore(scores2[i]);
        }
        Book temp[] = new Book[arrbook.size()];
        Book stemp = new Book();
        for(int i = 0;i<arrbook.size();i++){
            temp[i] = new Book();
        }
        for(int i = 0;i<arrbook.size();i++){
            temp[i] = arrbook.get(i);
        }
        for(int f = 0;f<arrbook.size()-1;f++){
            for(int b = f+1;b<arrbook.size();b++){
                if(temp[f].getScore()<temp[b].getScore()){
                    stemp = temp[f];
                    temp[f] = temp[b];
                    temp[b] = stemp;
                }
            }
        }
        for(int i = 0;i<temp.length;i++){
            rec.add(temp[i]);
        }
        return rec;
    }

    public ArrayList<Book> methodd(Reader r){
        ArrayList<Book> rec = new ArrayList<Book>();
        String genres[] = new String[arrbook.size()];
        int go[] = new int[arrbook.size()];
        boolean found = false;
        int c = 0;
        for(int i = 0;i<arrbook.size();i++){
            genres[i] = "";
        }
        for(int i = 0;i<arrbook.size();i++){
            found = false;
            for(int x = 0;i<c;x++){
                if(genres[x].equals(arrbook.get(i).getGenre())){
                    found = true;
                    break;
                }
            }
            if(found ==false){
                genres[c] = arrbook.get(i).getGenre();
                c++;
            }
        }
        for(int i = 0;i<genres.length;i++){
            for(int x = 0;x<arrbook.size();x++){
                if(genres[i].equals(arrbook.get(x).getGenre())){
                    go[i]++;
                }
            }
        }
        String temp = "";
        int ntemp = 0;
        for(int f = 0;f<genres.length-1;f++){
            for(int b = f +1;b<genres.length;b++){
                if(go[f]<go[b]){
                    temp = genres[f];
                    genres[f] = genres[b];
                    genres[b] = temp;
                    ntemp = go[f];
                    go[f] = go[b];
                    go[b] = ntemp;
                }
            }
        }
        for(int x = 0;x<genres.length;x++){
            for(int i = 0;i<arrbook.size();i++){
                if(arrbook.get(i).getGenre()==genres[x]){
                    arrbook.get(i).setScore(go[x]);
                    rec.add(arrbook.get(i));
                }
            }
        }
        return rec;
    }

//    public vb(){
//        fsc = 0
//        ssc = 0
//        For Me.i = 1 To numr
//        ssc = 0
//        If i <> lstreaders.SelectedIndex + 1 Then
//        For Me.x = 1 To numb
//        ssc = ssc + person(i).ratings(x) * person(lstreaders.SelectedIndex + 1).ratings(x)
//        Next
//        If ssc > fsc Then
//        fsc = ssc
//        msp.name = person(i).name
//        msp.ratings = person(i).ratings
//        End If
//        End If
//        m3m(i) = ssc
//        Next
//        MsgBox("The most similar reader is: " + msp.name + vbCrLf + "With a score oE: " + fsc.ToString)
//        For Me.i = 1 To numb
//        If person(lstreaders.SelectedIndex + 1).ratings(i) = 0 And msp.ratings(i) <> 0 Then
//        sug(x).title = arrbook(i).title
//        sug(x).author = arrbook(i).author
//        sug(x).score = msp.ratings(i)
//        x = x + 1
//        End If
//        Next
//                x = x - 1
//        For Me.f = 1 To x - 1
//        For Me.b = f + 1 To x
//        If sug(f).score < sug(b).score Then
//                temp = sug(f)
//        sug(f) = sug(b)
//        sug(b) = temp
//        End If
//        Next
//                Next
//        For Me.i = 1 To x
//        If sug(i).title <> "" Then
//        lstm2.Items.Add(sug(i).title + " / " + sug(i).author + " / " + sug(i).score.ToString)
//        End If
//        Next
//        For Me.i = 1 To numb
//        m3r(i) = arrbook(i)
//        Next
//        For Me.i = 1 To numr
//        m3r(i).score = 0
//        Next
//        For Me.i = 1 To numr
//        For Me.x = 1 To numb
//        If person(lstreaders.SelectedIndex + 1).ratings(x) = 0 Then
//        m3r(x).score = m3r(x).score + m3m(i) * person(i).ratings(x)
//        End If
//        Next
//                Next
//        For Me.f = 1 To numr - 1
//        For Me.b = f + 1 To numr
//        If m3r(f).score < m3r(b).score Then
//                temp = m3r(f)
//        m3r(f) = m3r(b)
//        m3r(b) = temp
//        End If
//        Next
//                Next
//        For Me.i = 1 To numr
//        If m3r(i).title <> "" Then
//        lstm3.Items.Add(m3r(i).title + " / " + m3r(i).author + " / " + m3r(i).score.ToString)
//        End If
//        Next
//        For Me.i = 1 To numb
//        popb(i).title = arrbook(i).title
//        popb(i).author = arrbook(i).author
//        Next
//        For Me.i = 1 To numb
//        For Me.x = 1 To numr
//        If person(x).ratings(i) > 0 And person(lstreaders.SelectedIndex + 1).ratings(i) = 0 Then
//        popb(i).score = popb(i).score + 1
//        End If
//        Next
//                Next
//    }

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
//        for(int i = 0;i<sort.length;i++){
//            JOptionPane.showMessageDialog(null,sorted.get(i).getScore());
//        }
        return sorted;
    }
}
