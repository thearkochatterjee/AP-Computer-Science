import java.util.ArrayList;

public class TextAnalyzer {
    private String text = "";
    private ArrayList<Word> arrword = new ArrayList<Word>();

    public TextAnalyzer(String text){
        this.text = text;
        inputtowords();
    }

    public ArrayList<Word> getArrword() {
        return arrword;
    }

    public String getText() {
        return text;
    }

    public void setArrword(ArrayList<Word> arrword) {
        this.arrword = arrword;
    }

    public void setText(String text) {
        this.text = text;
        inputtowords();
    }

    public int numberofsenctences(){
        int nums = 0;

        return nums;
    }

    public int numberofwords(){
        return arrword.size();
    }

    public int totalsyllibles(){
        int numsym = 0;
        for(int i = 0;i<arrword.size();i++){
            numsym+=arrword.get(i).number_of_syllibles();
        }
        return numsym;
    }

    public int totalconssoants(){
        int numc = 0;
        for (Word w: arrword) {
            numc+=w.number_of_consonents();
        }
        return numc;
    }

    public int totalvowels(){
        int numv = 0;
        for (Word w: arrword) {
            numv += w.number_of_vowels();
        }
        return numv;
    }

    private void inputtowords(){
        String words[] = text.split(" ");
        for(int i = 0;i<words.length;i++){
            arrword.add(new Word(words[i]));
        }
    }
}
