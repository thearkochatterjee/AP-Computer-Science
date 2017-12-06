import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        String basepath = "";
        ArrayList<String> arrpaths = new ArrayList<String>();
        open("C:\\Users\\Arko\\12th grade\\AP Computer Science Projects\\bookrecdata\\books.txt");
        basepath = JOptionPane.showInputDialog("Where is the folder?");

        save("C:\\Users\\Arko\\12th grade\\AP Computer Science Projects\\bookrecdata\\books.txt");
    }

    private static void open(String path){

    }

    private static void save(String path){

    }
}
