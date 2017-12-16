import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static InputPane panein = new InputPane();
    private static OutputPane1 paneout1 = new OutputPane1();
    private static OutputPane2 paneout2 = new OutputPane2();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenuItem mnuaddbook = new JMenuItem();
    private static JMenuItem mnudeletebook = new JMenuItem();
    private static JMenuItem mnuaddreader = new JMenuItem();
    private static JMenuItem mnudeletereader = new JMenuItem();
    private static JMenuItem mnuopen = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static ArrayList<Reader> arrreader = new ArrayList<Reader>();
    private static ArrayList<Book> arrbook = new ArrayList<Book>();

    public static void main(String args[]){
        gui.setTitle("Book Rec");
        gui.setSize(500,500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mnubar.add(mnufile);
        mnufile.add(mnuaddbook);
        mnufile.add(mnudeletebook);
        mnufile.add(mnuaddreader);
        mnufile.add(mnudeletereader);
        mnufile.add(mnuopen);
        mnufile.add(mnusave);
        pane.setLayout(new GridLayout(3,1));
        gui.setJMenuBar(mnubar);
        gui.getContentPane().add(pane);
        pane.add(panein);
        pane.add(paneout1);
        pane.add(paneout2);
        gui.setVisible(true);
        mnuaddbook.addActionListener(new addbook());
        mnudeletebook.addActionListener(new deletebook());
        mnudeletereader.addActionListener(new deletereader());
        mnuaddreader.addActionListener(new addreader());
        mnuopen.addActionListener(new open());
        mnusave.addActionListener(new save());
    }

    static class addbook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Book temp = new Book();
            temp.setTitle(JOptionPane.showInputDialog("What is the title of the book?"));
            temp.setAuthor(JOptionPane.showInputDialog("Who is the author?"));
            temp.setGenre(JOptionPane.showInputDialog("What genre is the book?"));
            temp.setImagepath(JOptionPane.showInputDialog("What is the path for the cover of the book? (use 'null' if there is none)"));
            arrbook.add(temp);
        }
    }

    static class deletebook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class addreader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class deletereader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
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

    private static void open(String path){

    }

    private static void save(String path){

    }
}
