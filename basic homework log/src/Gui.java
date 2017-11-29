import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenuItem mnuaddhomework = new JMenuItem();
    private static JMenuItem mnudelete = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static JMenuItem mnuopen = new JMenuItem();
    private static ArrayList<Assignment> arrassignments = new ArrayList<Assignment>();
    private static JList lsthw = new JList();
    private static DefaultListModel dlm = new DefaultListModel();

    public static void main(String args[]){
        gui.setTitle("Basic Homework Log");
        gui.setSize(500,500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().add(pane);
        mnubar.add(mnufile);
        mnufile.add(mnuaddhomework);
        mnufile.add(mnudelete);
        mnufile.add(mnusave);
        mnufile.add(mnuopen);
        gui.setJMenuBar(mnubar);
        mnufile.setText("File");
        mnusave.setText("Save");
        mnuopen.setText("Open");
        mnuaddhomework.setText("Add Assignment");
        mnudelete.setText("Delete Assignment");
        pane.add(lsthw);
        gui.setVisible(true);
        mnuaddhomework.addActionListener(new addassignment());
        mnudelete.addActionListener(new deleteassignment());
        mnusave.addActionListener(new save());
        mnuopen.addActionListener(new open());
    }

    static class addassignment implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Assignment temp = new Assignment();
            temp.setName(JOptionPane.showInputDialog("What is the name of the assignment?"));
            temp.setSubject(JOptionPane.showInputDialog("What subject is this for?"));
            temp.setDate(new Duedate(JOptionPane.showInputDialog("What is the due date?")));
            temp.setComplete(false);
            arrassignments.add(temp);
        }
    }

    static class deleteassignment implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
