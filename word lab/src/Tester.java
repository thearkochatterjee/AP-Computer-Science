import javax.swing.*;

public class Tester {

    public static void main(String args[]){
        Word word = new Word();
        String again = "";
        do {
            word.setWord(JOptionPane.showInputDialog("What is the word?"));
            JOptionPane.showMessageDialog(null,"The number of syllables is "+word.number_of_syllibles());
            again = JOptionPane.showInputDialog("Do you want to run again?");
        }while (again.equals("yes"));
    }
}
