import java.util.ArrayList;

public class Word {
    private String word = "";
    private int syllable = 0;
    private String type = "";

    public Word(){
        word = "";
        syllable = 0;
        type = "";
    }

    public Word(String line){
        String parts[] = line.split(",");
        word = parts[0];
        syllable = Integer.valueOf(parts[1]);
        type = parts[2];
    }

    public String getWord() {
        return word;
    }

    public String getType() {
        return type;
    }

    public int getSyllable() {
        return syllable;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSyllable(int syllable) {
        this.syllable = syllable;
    }
}
