import javax.swing.*;
import java.util.ArrayList;

public class TextAnalyzer {
    private String text = "";
    private ArrayList<WordAnalyzer> arrword = new ArrayList<WordAnalyzer>();

    public TextAnalyzer(){
        text = "";
        arrword = new ArrayList<WordAnalyzer>();
    }

    public TextAnalyzer(String text){
        this.text = text;
        inputtowords();
    }

    public ArrayList<WordAnalyzer> getArrword() {
        return arrword;
    }

    public String getText() {
        return text;
    }

    public void setArrword(ArrayList<WordAnalyzer> arrword) {
        this.arrword = arrword;
    }

    public void setText(String text) {
        this.text = text;
        inputtowords();
    }

    private int total_characters(){
        int total = 0;
        for(WordAnalyzer w: arrword){
            total += w.getWord().length();
        }
        return total;
    }

    public double readability_score(){
        double score = 0;
        score = 206.835 - 84.6 * avgw() - 1.015 * avgs()-2;
        score = roundvalue(score, 3);
        return score;
    }

    private double avgs(){
        return numberofwords()/numberofsenctences();
    }

    private double avgw(){
        return totalsyllibles()/numberofwords();
    }

    public double coleman_index(){
        double score = 0;
        score = 5.89 * (total_characters()/numberofwords()) - 0.3 * (numberofsenctences() / numberofwords()) - 15.8;
        score = roundvalue(score, 3);
        return score;
    }

    public double numberofsenctences(){
        return text.split("[.!?]").length;
    }

    public double numberofwords(){
        return arrword.size();
    }

    public double totalsyllibles(){
        int numsym = 0;
        for(WordAnalyzer w: arrword){
            numsym += w.number_of_syllibles();
        }
        return numsym;
    }

    public double totalconssoants(){
        int numc = 0;
        for (WordAnalyzer w: arrword) {
            numc+=w.number_of_consonents();
        }
        return numc;
    }

    public double totalvowels(){
        int numv = 0;
        for (WordAnalyzer w: arrword) {
            numv += w.number_of_vowels();
        }
        return numv;
    }

    public String readability_grade(){
        if(readability_score()>=91){
            return "5th grade";
        }
        else if(readability_score()>=81){
            return "6th grade";
        }
        else if(readability_score()>=71){
            return "7th grade";
        }
        else if(readability_score()>=61){
            return "8th and 9th grade";
        }
        else if(readability_score()>=51){
            return "10th to 12th grade";
        }
        else if(readability_score()>=31){
            return "College student";
        }
        else {
            return "College Graduate";
        }
    }

    private void inputtowords(){
        String words[] = text.split(" ");
        arrword.clear();
        for(int i = 0;i<words.length;i++){
            if(!words[i].equals("")){
                arrword.add(new WordAnalyzer(words[i].toLowerCase()));
            }
        }
    }

    private double roundvalue(double value, int numdec){
        double v = value * Math.pow(10,numdec);
        v = Math.round(v);
        v = v / Math.pow(10,numdec);
        return v;
    }
}
