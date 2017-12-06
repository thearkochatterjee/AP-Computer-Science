import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Book> arrbook = new ArrayList<Book>();

    public static void main(String args[]){
        String basepath = "";
        ArrayList<String> arrpaths = new ArrayList<String>();
        basepath = JOptionPane.showInputDialog("Where is the folder?");
        open(basepath+"\\books.txt");
        save(basepath+"\\books.txt");
    }

    private static void open(String path){

    }

    private static void save(String path){

    }
}
