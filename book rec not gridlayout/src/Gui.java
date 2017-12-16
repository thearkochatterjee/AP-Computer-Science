import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenuItem mnuaddbook = new JMenuItem();
    private static JMenuItem mnuaddreader = new JMenuItem();
    private static JMenuItem mnudeletebook = new JMenuItem();
    private static JMenuItem mnudeletereader = new JMenuItem();
    private static JMenuItem mnuopen = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static JMenuItem mnucalc = new JMenuItem();
    private static JLabel imgcover = new JLabel();
    private static Color myred = new Color(255,128,128);

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
        gui.setVisible(true);
        gui.getContentPane().setBackground(Color.BLACK);
        mnuaddbook.addActionListener(new addbook());
        mnuaddreader.addActionListener(new addreader());
        mnudeletereader.addActionListener(new deletereader());
        mnudeletebook.addActionListener(new deletebook());
        mnuopen.addActionListener(new open());
        mnusave.addActionListener(new save());
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class addbook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class addreader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class deletebook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class deletereader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private static void open(String path){

    }

    private static void save(String path){

    }
}
