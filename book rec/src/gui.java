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
    private static ArrayList<Book> arrallbooks = new ArrayList<Book>();
    private static ArrayList<Reader> arrallreaders = new ArrayList<Reader>();
    private static DefaultListModel dlm = new DefaultListModel();
    private static JList lstallreaders = new JList();

    public void main(String args[]){
        gui.setTitle("Book Rec");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().add(pane);
        mnubar.add(mnufile);
        mnufile.add(mnuaddreader);
        mnufile.add(mnuaddbook);
        gui.setJMenuBar(mnubar);
        gui.setVisible(true);
        mnuaddbook.addActionListener(new addbook());
        mnuaddreader.addActionListener(new addreader());
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

            arrallbooks.add(temp);
        }
    }
}
