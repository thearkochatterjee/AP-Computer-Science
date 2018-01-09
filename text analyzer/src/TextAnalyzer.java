import java.util.ArrayList;

public class TextAnalyzer {
    private String text = "";
    private ArrayList<Word> arrword = new ArrayList<Word>();

    public TextAnalyzer(String text){
        this.text = text;
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
    }

    public int numberofsenctences(){
        int nums = 0;

        return nums;
    }

    public int numberofwords(){
        int numw = 0;

        return arrword.size();
    }
}
