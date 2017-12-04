import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenuItem mnuaddbook = new JMenuItem();
    private static JMenuItem mnuaddreader = new JMenuItem();
    private static JMenuItem mnuopen = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static JMenuItem mnuclear = new JMenuItem();
    private static JMenuItem mnuquit = new JMenuItem();
    private static ArrayList<Book> arrallbooks = new ArrayList<Book>();
    private static ArrayList<Reader> arrallreaders = new ArrayList<Reader>();
    private static DefaultListModel dlm = new DefaultListModel();
    private static JList lstallreaders = new JList();
    private static DefaultListModel dlm2 = new DefaultListModel();
    private static JList lstbooks = new JList();

    public void main(String args[]){
        gui.setTitle("Book Rec");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().add(pane);
        mnubar.add(mnufile);
        mnufile.add(mnuaddreader);
        mnufile.add(mnuaddbook);
        mnufile.add(mnusave);
        mnufile.add(mnuopen);
        mnufile.add(mnuclear);
        mnufile.add(mnuquit);
        gui.setJMenuBar(mnubar);
        openbooks("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\books.txt");
        openreader("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\reader.txt");
        gui.setVisible(true);
        mnuaddbook.addActionListener(new addbook());
        mnuaddreader.addActionListener(new addreader());
        mnuopen.addActionListener(new open());
        mnusave.addActionListener(new save());
        mnuclear.addActionListener(new clear());
        mnuquit.addActionListener(new quit());
    }

    static class clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dlm.clear();
            dlm2.clear();
        }
    }

    static class quit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            savebooks("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\books.txt");
            savereader("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\reader.txt");
            gui.dispose();
        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            savereader("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\reader.txt");
            savebooks("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\books.txt");
        }
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            openbooks("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\books.txt");
            openreader("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\reader.txt");
        }
    }

    static class addreader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Reader temp = new Reader();
            temp.setName(JOptionPane.showInputDialog("What is your name?"));
            arrallreaders.add(temp);
        }
    }

    static class addbook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Book temp = new Book();
            temp.setTitle(JOptionPane.showInputDialog("What is the title?").trim());
            temp.setAuthor(JOptionPane.showInputDialog("Who is the author?").trim());
            arrallbooks.add(temp);
        }
    }

    public static void openreader(String path){

    }

    public static void openbooks(String path){

    }

    public static void savereader(String path){

    }

    public static void savebooks(String path){

    }
}
