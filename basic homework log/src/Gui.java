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

    public static void main(String args[]){

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
