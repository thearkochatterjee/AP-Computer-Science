import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Book> arrbook = new ArrayList<Book>();

    public static void main(String args[]){
        String basepath = "";
        ArrayList<String> arrpaths = new ArrayList<String>();
        basepath = JOptionPane.showInputDialog("Where is the folder?");
        open(basepath+"\\books.txt");
        save(basepath+"\\books.txt", basepath);
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

    private static void save(String path, String basepath){
        try(PrintWriter out = new PrintWriter(path)  ){
            for(int i = 0;i<arrbook.size();i++){
                out.println(arrbook.get(i).toString()+","+basepath+arrbook.get(i).getTitle()+".jpg");
            }
            out.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
