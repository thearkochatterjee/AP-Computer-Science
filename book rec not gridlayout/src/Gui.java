import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Gui {
    private static ArrayList<Book> arrbook = new ArrayList<Book>();
    private static ArrayList<Reader> arrreader = new ArrayList<Reader>();
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static JList lstmethoda = new JList();
    private static JList lstmethodb = new JList();
    private static JList lstmethodc = new JList();
    private static JList lstmethodd = new JList();
    private static JList lstreader = new JList();
    private static JList lstbook = new JList();
    private static JList lstrating = new JList();
    private static DefaultListModel dlmbook = new DefaultListModel();
    private static DefaultListModel dlmrating = new DefaultListModel();
    private static DefaultListModel dlmreader = new DefaultListModel();
    private static DefaultListModel dlmmethoda = new DefaultListModel();
    private static DefaultListModel dlmmethodb = new DefaultListModel();
    private static DefaultListModel dlmmethodc = new DefaultListModel();
    private static DefaultListModel dlmmethodd = new DefaultListModel();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenuItem mnuaddbook = new JMenuItem();
    private static JMenuItem mnuaddreader = new JMenuItem();
    private static JMenuItem mnudeletebook = new JMenuItem();
    private static JMenuItem mnudeletereader = new JMenuItem();
    private static JMenuItem mnuopen = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static JMenuItem mnucalc = new JMenuItem();
    private static JMenuItem mnuchangebook = new JMenuItem();
    private static JMenuItem mnuchangereader = new JMenuItem();
    private static JLabel imgcover = new JLabel();
    private static Color myred = new Color(255,128,128);
    private static Rec rec = new Rec();

    public static void main(String args[]){
        gui.setTitle("Book Rec");
        gui.setSize(500,500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().add(pane);
        mnubar.add(mnufile);
        mnufile.add(mnuaddbook);
        mnufile.add(mnuaddreader);
        mnufile.add(mnudeletebook);
        mnufile.add(mnudeletereader);
        mnufile.add(mnuopen);
        mnufile.add(mnusave);
        mnufile.add(mnucalc);
        mnubar.add(mnufile);
        gui.setJMenuBar(mnubar);
        pane.add(lstmethoda);
        pane.add(lstmethodb);
        pane.add(lstmethodc);
        pane.add(lstmethodd);
        pane.add(lstbook);
        pane.add(lstrating);
        pane.add(lstreader);
        pane.add(imgcover);
        mnufile.setText("File");
        mnuaddbook.setText("Add Book");
        mnuaddreader.setText("Add Reader");
        mnudeletebook.setText("Delete Book");
        mnudeletereader.setText("Delete Reader");
        mnusave.setText("Save");
        mnuopen.setText("Open");
        mnucalc.setText("Find Recommendations");
        lstmethoda.setBounds(20,20,100,100);
        lstmethoda.setBackground(myred);
        lstmethodb.setBackground(myred);
        lstmethodc.setBackground(myred);
        lstmethodd.setBackground(myred);
        lstbook.setBackground(myred);
        lstrating.setBackground(myred);
        lstreader.setBackground(myred);
        gui.setVisible(true);
        gui.getContentPane().setBackground(Color.BLACK);
        mnuaddbook.addActionListener(new addbook());
        mnuaddreader.addActionListener(new addreader());
        mnudeletereader.addActionListener(new deletereader());
        mnudeletebook.addActionListener(new deletebook());
        mnuopen.addActionListener(new open());
        mnusave.addActionListener(new save());
        lstbook.addListSelectionListener(new cover());
        lstreader.addListSelectionListener(new recommend());
    }

    static class recommend implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {
            rec.setArrbook(arrbook);
            rec.setArrreader(arrreader);
            ArrayList<Book> arrrec = new ArrayList<Book>();
            dlmmethoda.clear();
            dlmmethodb.clear();
            dlmmethodc.clear();
            dlmmethodd.clear();
            arrrec = rec.methoda(arrreader.get(lstreader.getSelectedIndex()));
            for(int i = 0;i<rec.methoda(arrreader.get(lstreader.getSelectedIndex())).size();i++){
                dlmmethoda.addElement(arrrec.get(i).getTitle() + " " + arrrec.get(i).getAuthor() + " " + arrrec.get(i).getScore());
            }
            arrrec = rec.methodb(arrreader.get(lstreader.getSelectedIndex()));
            for(int i = 0;i<rec.methodb(arrreader.get(lstreader.getSelectedIndex())).size();i++){
                dlmmethodb.addElement(arrrec.get(i).getTitle() + " " + arrrec.get(i).getAuthor() + " " + arrrec.get(i).getScore());
            }
            arrrec = rec.methodc(arrreader.get(lstreader.getSelectedIndex()));
            for(int i = 0;i<rec.methodc(arrreader.get(lstreader.getSelectedIndex())).size();i++){
                dlmmethodc.addElement(arrrec.get(i).getTitle() + " " + arrrec.get(i).getAuthor() + " " + arrrec.get(i).getScore());
            }
            arrrec = rec.methodd(arrreader.get(lstreader.getSelectedIndex()));
            for(int i = 0;i<rec.methodd(arrreader.get(lstreader.getSelectedIndex())).size();i++){
                dlmmethodd.addElement(arrrec.get(i).getTitle() + " " + arrrec.get(i).getAuthor() + " " + arrrec.get(i).getScore());
            }
        }
    }

    static class cover implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {
            imgcover.setIcon(new ImageIcon(arrbook.get(lstbook.getSelectedIndex()).getImagepath()));
        }
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            openbook("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science\\bookrecdata\\books.txt");
            openrating("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science\\bookrecdata\\ratings.txt");
        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            savebook("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science\\bookrecdata\\books.txt");
            saverating("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science\\bookrecdata\\ratings.txt");
        }
    }

    static class addbook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Book temp = new Book();
            temp.setTitle(JOptionPane.showInputDialog("What is the title of the book?"));
            temp.setAuthor(JOptionPane.showInputDialog("Who is the author of this book?"));
            temp.setGenre(JOptionPane.showInputDialog("What is the genre of this book?"));
            temp.setImagepath(JOptionPane.showInputDialog("What is the path for the cover of the book?"));
            if(arrbook.contains(temp)) {
                JOptionPane.showMessageDialog(null,"Book already exists.");
            }
            else{
                arrbook.add(temp);
                dlmbook.addElement(temp.getTitle());
                rec.setArrbook(arrbook);
            }

        }
    }

    static class addreader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Reader temp = new Reader();
            int rating[] = new int[100];
            String choice = "";
            Random r = new Random();
            for(int i = 0;i<100;i++){
                rating[i] = 0;
            }
            temp.setName(JOptionPane.showInputDialog("What is your name?"));
            choice = JOptionPane.showInputDialog("Do you want to randomly generate the ratings?");
            if(choice.equals("yes")){
                for(int i = 0;i<arrbook.size();i++){
                    rating[i] = r.nextInt(6)+1;
                    switch (rating[i]){
                        case 1:
                            rating[i] = 0;
                            break;
                        case 2:
                            rating[i] = -5;
                            break;
                        case 3:
                            rating[i] = -3;
                            break;
                        case 4:
                            rating[i] = 1;
                            break;
                        case 5:
                            rating[i] = 3;
                            break;
                        case 6:
                            rating[i] = 5;
                            break;
                    }
                }
            }
            else{
                for(int i = 0;i<arrbook.size();i++){
                    rating[i] = Integer.valueOf(JOptionPane.showInputDialog("What is the rating of "+arrbook.get(i).getTitle()+" (-5 hate it, -3 dislike it, 0 haven't read it, 1 ok, 3 liked it, 5 loved it"));
                }
            }
        }
    }

    static class deletebook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showInputDialog("Are you sure you want to delete "+arrbook.get(lstbook.getSelectedIndex()).getTitle() + " by " + arrbook.get(lstbook.getSelectedIndex()).getAuthor()).equals("yes")){
                arrbook.remove(lstbook.getSelectedIndex());
                dlmbook.remove(lstbook.getSelectedIndex());
            }
            rec.setArrbook(arrbook);
        }
    }

    static class deletereader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showInputDialog("Are you sure you want to delete "+arrreader.get(lstreader.getSelectedIndex()).getName()).equals("yes")){
                arrreader.remove(lstreader.getSelectedIndex());
                dlmreader.remove(lstreader.getSelectedIndex());
            }
            rec.setArrreader(arrreader);
        }
    }

    static class changebook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Book temp = new Book();
            String change = "";
            temp = arrbook.get(lstbook.getSelectedIndex());
            change = JOptionPane.showInputDialog("What do you want to change about the book?(title, author, imagepath, genre");
            if(change.equals("title")){
                temp.setTitle(JOptionPane.showInputDialog("What is the new title?"));
            }
            else if(change.equals("author")){
                temp.setAuthor(JOptionPane.showInputDialog("Who is the new author?"));
            }
            else if(change.equals("imagepath")){
                temp.setImagepath(JOptionPane.showInputDialog("What is the new imagepath?"));
            }
            else if(change.equals("genre")){
                temp.setGenre(JOptionPane.showInputDialog("What is the new genre?"));
            }
            else{
                JOptionPane.showMessageDialog(null,"Input Error");
            }
            arrbook.get(lstbook.getSelectedIndex()).copy(temp);
            dlmbook.clear();
            for(int i = 0;i<arrbook.size();i++){
                dlmbook.addElement(arrbook.get(i).getTitle()+" "+arrbook.get(i).getAuthor());
            }
        }
    }

    static class changereader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String change = "";
            change = JOptionPane.showInputDialog("What do you want to change?(rating,name)");
            if(change.equals("rating")){

            }
            else if(change.equals("name")){

            }
            else{
                JOptionPane.showMessageDialog(null,"Input Error");
            }
        }
    }

    private static void openbook(String path){
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
        for(int i = 0;i<arrbook.size();i++){
            dlmbook.addElement(arrbook.get(i).getTitle()+" "+arrbook.get(i).getAuthor());
        }
    }

    private static void openrating(String path){
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

    private static void savebook(String path){
        try(PrintWriter out = new PrintWriter(path)  ){
            for(int i = 0;i<arrbook.size();i++){
                out.println(arrbook.get(i).toString());
            }
            out.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    private static void saverating(String path){
        try(PrintWriter out = new PrintWriter(path)  ){
            for(int i = 0;i<arrreader.size();i++){
                out.println(arrreader.get(i).toString());
            }
            out.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
