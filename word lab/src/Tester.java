import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {
    private static ArrayList<Word> arrwords = new ArrayList<Word>();
    private static WordAnalyzer analyzer = new WordAnalyzer();

    public static void main(String args[]){
        String again = "";
        do {
            analyzer.setWord(JOptionPane.showInputDialog("What is the word?"));
            open("src/assets/dictionary/"+analyzer.getWord().toLowerCase().toCharArray()[0]+".txt");
            analyzer.setArrwords(arrwords);
            JOptionPane.showMessageDialog(null,"The number of syllables is "+analyzer.number_of_syllibles());
            again = JOptionPane.showInputDialog("Do you want to run again?");
        }while (again.equals("yes"));
    }

    public static void open(String path){
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
        analyzer.setArrwords(arrwords);
    }
}
