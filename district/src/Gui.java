import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{
    private Pane pane = new Pane();
    private JMenuBar mnubar = new JMenuBar();
    private JMenu mnuadd = new JMenu();
    private JMenuItem mnuaddstudent = new JMenuItem();

    public Gui(){
        setTitle("District");
        getContentPane().add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        mnuaddstudent.addActionListener(new student());
    }

    class student implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
