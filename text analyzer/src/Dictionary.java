import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> arrwords = new ArrayList<Word>();

    public Dictionary(){
        arrwords = new ArrayList<Word>();
        opendictionary();
    }

    public void setArrwords(ArrayList<Word> arrwords) {
        this.arrwords = arrwords;
    }

    public ArrayList<Word> getArrwords() {
        return arrwords;
    }

    public void opendictionary(){
        for(char l: letters()){
            open("src/assets/dictionary/"+l+".txt");
        }
    }

    private char[] letters(){
        char alphabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        return alphabet;
    }

    private void open(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrwords.add(new Word(line));
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
