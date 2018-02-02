import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLHigh extends JPanel{
    private JList lsthigh = new JList();
    private DefaultListModel dlmhigh = new DefaultListModel();
    private JLabel lblhigh = new JLabel();
    private ScrollPane scrstu = new ScrollPane();

    public PNLHigh(){
        setLayout(new BorderLayout());
        add(scrstu);
        add(lblhigh, BorderLayout.NORTH);
        scrstu.add(lsthigh);
        lblhigh.setText("High School");
        lsthigh.setModel(dlmhigh);
    }

    public void input(ArrayList<Student> arrstu){
        for(Student stu: arrstu){
            if (stu instanceof High){
                dlmhigh.addElement(stu.toString());
            }
        }
    }
}
