import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLIntermediate extends JPanel{
    private JList lststu = new JList();
    private JLabel lblinter = new JLabel();
    private DefaultListModel dlmstu = new DefaultListModel();
    private ScrollPane scrstu = new ScrollPane();

    public PNLIntermediate(){
        setLayout(new BorderLayout());
        add(scrstu);
        add(lblinter, BorderLayout.NORTH);
        scrstu.add(lststu);
        lblinter.setText("Intermediate School");
        lststu.setModel(dlmstu);
    }

    public void input(ArrayList<Student> arrstu){

    }
}
