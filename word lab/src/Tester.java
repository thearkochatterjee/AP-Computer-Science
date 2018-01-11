import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {
    private static WordAnalyzer analyzer = new WordAnalyzer();
    private static ArrayList<WordAnalyzer> arranalyzer = new ArrayList<WordAnalyzer>();

    public static void main(String args[]){
        String again = "";
        String more = "";
        ArrayList<String> arrwords = new ArrayList<String>();
        do {
            arranalyzer.clear();
            do{
                arrwords.add(JOptionPane.showInputDialog("What is the word you want to check?(0 to exit)"));
            }while(!arrwords.get(arrwords.size()-1).equals("0"));
            arrwords.remove(arrwords.indexOf("0"));
            for (String w: arrwords) {
                JOptionPane.showMessageDialog(null,w);
            }
            for (String w: arrwords) {
                arranalyzer.add(new WordAnalyzer(w));
            }
            for (WordAnalyzer a: arranalyzer) {
                JOptionPane.showMessageDialog(null,"The number of syllables in "+a.getWord()+" is "+a.number_of_syllibles());
                System.out.println("The number of syllables in "+a.getWord()+" is "+a.number_of_syllibles());
            }
            again = JOptionPane.showInputDialog("Do you want to run again?");
        }while (again.equals("yes"));
    }
}
