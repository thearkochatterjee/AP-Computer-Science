import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Book> arrbook = new ArrayList<Book>();
    private static ArrayList<String> arraddgenre = new ArrayList<String>();

    public static void main(String args[]){
        String genre = "";
        String temp = "";
        open("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\bookrecdata\\books.txt");
        for(int i = 0;i<arrbook.size();i++){
            ArrayList<String> bookgenres = new ArrayList<String>();
            do{
                genre = JOptionPane.showInputDialog("What is the genre for "+arrbook.get(i).getTitle() + "press 0 for next book");
                if(genre.equals("0")==false){
                    bookgenres.add(genre);
                }
            }while(genre.equals("0")==false);
            temp = "";
            for(int x = 0;x<bookgenres.size()-1;x++){
                temp += bookgenres.get(x) + "-";
            }
            temp+=bookgenres.get(bookgenres.size()-1);
            JOptionPane.showMessageDialog(null, temp);
            arraddgenre.add(temp);
        }
        save("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\bookrecdata\\books.txt");
    }

    private static void open(String path){
        ArrayList<String> arrin = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrin.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int x = 0;x<arrin.size();x++)
        {
            arrbook.add(new Book(arrin.get(x)));
        }
    }

    private static void save(String path){
        try(PrintWriter out = new PrintWriter(path)  ){
            for(int i = 0;i<arrbook.size();i++){
                out.println(arrbook.get(i).toString()+","+arraddgenre.get(i));
            }
            out.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
