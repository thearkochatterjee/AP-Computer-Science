import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Book> arrbook = new ArrayList<Book>();
    private static ArrayList<String> arraddgenre = new ArrayList<String>();

    public static void main(String args[]){
        String genre = "";
        String temp = "";
        open("C:\\Users\\Arko\\12th grade\\AP Computer Science Projects\\bookrecdata\\books.txt");
        for(int i = 0;i<arrbook.size();i++){
            ArrayList<String> bookgenres = new ArrayList<String>();
            do{
                genre = JOptionPane.showInputDialog("What is the genre for "+arrbook.get(i).getTitle() + "press 0 for next book");
                if(genre.equals("0")==false){
                    bookgenres.add(genre);
                }
            }while(genre.equals("0")==false);
            for(int x = 0;x<bookgenres.size()-1;x++){
                temp += bookgenres.get(x) + ",";
            }
            temp+=bookgenres.get(bookgenres.size()-2);
            arraddgenre.add(temp);
        }
    }

    private static void open(String path){

    }

    private static void save(String path){

    }
}
