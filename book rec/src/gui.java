import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    private static JMenuItem mnudeletebook = new JMenuItem();
    private static JMenuItem mnudeletereader = new JMenuItem();
    private static JMenuItem mnuclear = new JMenuItem();
    private static JMenuItem mnuquit = new JMenuItem();
    private static ArrayList<Book> arrallbooks = new ArrayList<Book>();
    private static ArrayList<Reader> arrallreaders = new ArrayList<Reader>();
    private static DefaultListModel dlm = new DefaultListModel();
    private static JList lstallreaders = new JList();
    private static DefaultListModel dlm2 = new DefaultListModel();
    private static JList lstbooks = new JList();
    private static JCheckBox chxrate1 = new JCheckBox();
    private static JCheckBox chxrate2 = new JCheckBox();
    private static JCheckBox chxrate3 = new JCheckBox();
    private static JCheckBox chxrate4 = new JCheckBox();
    private static JCheckBox chxrate5 = new JCheckBox();
    private static JCheckBox chxnotread = new JCheckBox();

    public static void main(String args[]){
        gui.setTitle("Book Rec");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().add(pane);
        mnubar.add(mnufile);
        mnufile.add(mnuaddreader);
        mnufile.add(mnuaddbook);
        mnufile.add(mnudeletereader);
        mnufile.add(mnudeletebook);
        mnufile.add(mnusave);
        mnufile.add(mnuopen);
        mnufile.add(mnuclear);
        mnufile.add(mnuquit);
        gui.setJMenuBar(mnubar);
        mnufile.setText("File");
        mnuaddreader.setText("Add Reader");
        mnuaddbook.setText("Add Text");
        mnuquit.setText("Quit");
        mnuclear.setText("Clear");
        pane.add(lstallreaders);
        pane.add(lstbooks);
        pane.add(chxnotread);
        pane.add(chxrate1);
        pane.add(chxrate2);
        pane.add(chxrate3);
        pane.add(chxrate4);
        pane.add(chxrate5);
        pane.add(chxnotread);
        mnudeletebook.setText("Delete Book");
        mnudeletereader.setText("Delete Reader");
        openbooks("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\books.txt");
        openreader("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\reader.txt");
        gui.setVisible(true);
        mnuaddbook.addActionListener(new addbook());
        mnuaddreader.addActionListener(new addreader());
        mnuopen.addActionListener(new open());
        mnusave.addActionListener(new save());
        mnuclear.addActionListener(new clear());
        mnuquit.addActionListener(new quit());
        chxrate1.addItemListener(new rate1());
        chxrate2.addItemListener(new rate2());
        chxrate3.addItemListener(new rate3());
        chxrate4.addItemListener(new rate4());
        chxrate5.addItemListener(new rate5());
        chxnotread.addItemListener(new notread());
    }

    static class rate1 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class rate2 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class rate3 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class rate4 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class rate5 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class notread implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
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
            int tempr[] = new int[arrallbooks.size()];
            temp.setName(JOptionPane.showInputDialog("What is your name?"));
            for(int i = 0;i<arrallbooks.size();i++){
                if(JOptionPane.showConfirmDialog(null,"Have you read"+arrallbooks.get(i).toString()+"?")==JOptionPane.YES_OPTION){
                    tempr[i] = Integer.valueOf(JOptionPane.showInputDialog("What is your rating of "+arrallbooks.get(i).toString()));
                }
                else{
                    tempr[i] = 0;
                }
            }
            arrallreaders.add(temp);
        }
    }

    static class addbook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Book temp = new Book();
            temp.setTitle(JOptionPane.showInputDialog("What is the title?").trim());
            temp.setAuthor(JOptionPane.showInputDialog("Who is the author?").trim());
            if(JOptionPane.showConfirmDialog(null,"Do you know the path for the image?","Image Path",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                temp.setImagepath(JOptionPane.showInputDialog("What is the image path?").trim());
            }
            else{
                temp.setImagepath("null");
            }
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
