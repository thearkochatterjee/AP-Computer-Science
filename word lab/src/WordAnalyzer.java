import javax.swing.*;
import java.util.ArrayList;

public class WordAnalyzer {
    private String word = "";
    private ArrayList<Word> arrwords = new ArrayList<Word>();

    public WordAnalyzer(){
        word = "";
        arrwords = new ArrayList<Word>();
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Word> getArrwords() {
        return arrwords;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setArrwords(ArrayList<Word> arrwords) {
        this.arrwords = arrwords;
    }

    public int number_of_syllibles(){
        char chword[] = word.toLowerCase().toCharArray();
        int nums = 0;
        ArrayList<String> arrsword = new ArrayList<String>();
        for (Word w: arrwords) {
            arrsword.add(w.getWord());
        }
        if(arrsword.contains(word)){
            nums = arrwords.get(arrsword.indexOf(word)).getSyllable();
        }
        else{
            for(int i = 0;i<chword.length;i++){
                if(!isvowel(chword[chword.length-1])){
                    if(isvowel(chword[i])&&!isvowel(chword[i+1])){
                        nums++;
                    }
                    else{
                        if(isvowel(chword[i])){
                            nums++;
                        }
                    }
                }
                else{
                    if(i!=0){
                        if(isvowel(chword[i])&&!isvowel(chword[i-1])){
                            nums++;
                        }
                    }
                    else{
                        if(isvowel(chword[i])){
                            nums++;
                        }
                    }
                }
            }
            if(hassilente()){
                nums--;
            }
        }
        if(nums==0){
            nums=1;
        }
        return nums;
    }

    private boolean isvowel(char test){
        char vowels[] = {'a','e','i','o','u'};
        boolean t = false;
        for(int i = 0;i<5;i++){
            if(test==vowels[i]){
                t=true;
            }
        }
        return t;
    }

    private boolean hassilente(){
        boolean silent = false;
        char letter[] = word.toLowerCase().toCharArray();
        for(int i = 0;i<word.length()-1;i++){
            if(!isvowel(letter[i])&&letter[i+1]=='e'){
                silent=true;
            }
        }
        return silent;
    }
}
