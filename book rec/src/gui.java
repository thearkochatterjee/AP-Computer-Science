import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class gui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static Container panein = new Container();
    private static Container paneout = new Container();
    private static Container paneout2 = new Container();
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
    private static JCheckBox chxrate[] = new JCheckBox[6];
    private static Recomendation rec = new Recomendation();
    private static JLabel imgbook = new JLabel();

    public static void main(String args[]){
        gui.setTitle("Book Rec");
        gui.setSize(500,500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().add(pane);
        pane.setLayout(new GridLayout(2,1));
        panein.setLayout(new GridLayout(1,6));
        paneout.setLayout(new GridLayout(2,2));
        pane.add(panein);
        pane.add(paneout);
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
        paneout.add(lstallreaders);
        paneout.add(lstbooks);
        for(int i = 0;i<6;i++){
            chxrate[i] = new JCheckBox();
            panein.add(chxrate[i]);
            chxrate[i].addItemListener(new rate());
        }
        chxrate[0].setText("Not Read");
        chxrate[1].setText("Hated it");
        chxrate[2].setText("Didn't like it");
        chxrate[3].setText("OK");
        chxrate[4].setText("Liked it");
        chxrate[5].setText("Loved it");
        mnudeletebook.setText("Delete Book");
        mnudeletereader.setText("Delete Reader");
        lstallreaders.setModel(dlm);
        lstbooks.setModel(dlm2);
        openbooks("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\books.txt");
        openreader("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\reader.txt");
        rec.setArrbook(arrallbooks);
        rec.setArrreader(arrallreaders);
        gui.setVisible(true);
        mnuaddbook.addActionListener(new addbook());
        mnuaddreader.addActionListener(new addreader());
        mnuopen.addActionListener(new open());
        mnusave.addActionListener(new save());
        mnuclear.addActionListener(new clear());
        mnuquit.addActionListener(new quit());
        lstbooks.addListSelectionListener(new books());
    }

    static class books implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {
            imgbook.setIcon(new ImageIcon(arrallbooks.get(lstbooks.getSelectedIndex()).getImagepath()));
        }
    }

    static class rate implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            int rate = 0;
            for(int i = 0;i<6;i++){
                if(chxrate[i].isSelected()){
                    for(int x = 0;x<6;x++){
                        if(x!=i){
                            chxrate[x].setSelected(false);
                        }
                    }
                    switch (i){
                        case 0:
                            rate = 0;
                            break;
                        case 1:
                            rate = -5;
                            break;
                        case 2:
                           rate = -3;
                            break;
                        case 3:
                            rate = 1;
                            break;
                        case 4:
                            rate = 3;
                            break;
                        case 5:
                            rate = 5;
                            break;
                    }
                    arrallreaders.get(lstallreaders.getSelectedIndex()).setRatings(rate, lstbooks.getSelectedIndex());
                    rec.setArrreader(arrallreaders);
                    break;
                }
            }
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
            rec.setArrreader(arrallreaders);
        }
    }

    static class addbook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Book temp = new Book();
            ArrayList<String> arrgenre = new ArrayList<String>();
            String tempg = "";
            temp.setTitle(JOptionPane.showInputDialog("What is the title?").trim());
            temp.setAuthor(JOptionPane.showInputDialog("Who is the author?").trim());
            do{
                tempg = JOptionPane.showInputDialog("What is the genre?").trim();
                if(tempg.equals("0")==false){
                    arrgenre.add(tempg);
                }
            }while(tempg.equals("0")==false);
            temp.setGenre(arrgenre);
            if(JOptionPane.showConfirmDialog(null,"Do you know the path for the image?","Image Path",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                temp.setImagepath(JOptionPane.showInputDialog("What is the image path?").trim());
            }
            else{
                temp.setImagepath("null");
            }
            arrallbooks.add(temp);
            rec.setArrbook(arrallbooks);
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
