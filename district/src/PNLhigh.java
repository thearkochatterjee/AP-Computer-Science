import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLhigh extends JPanel{
    private JList lststu = new JList();
    private ScrollPane scrstu = new ScrollPane();
    private JLabel lblhigh = new JLabel();
    private DefaultListModel dlmhigh = new DefaultListModel();

    public PNLhigh(){

    }

    public void input(ArrayList<Student> arrstu){
        for(Student stu: arrstu){
            if(stu instanceof High){
                dlmhigh.addElement(stu.toString());
            }
        }
    }
}
