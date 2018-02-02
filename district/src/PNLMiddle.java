import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLMiddle extends JPanel{
    private JList lstmiddle = new JList();
    private DefaultListModel dlmmiddle = new DefaultListModel();
    private JLabel lblmiddle = new JLabel();
    private ScrollPane scrstu = new ScrollPane();

    public PNLMiddle(){
        setLayout(new BorderLayout());
        add(scrstu);
        add(lblmiddle, BorderLayout.NORTH);
        scrstu.add(lstmiddle);
        lblmiddle.setText("Middle School");
        lstmiddle.setModel(dlmmiddle);
    }

    public void input(ArrayList<Student> arrstu){
        for(Student stu: arrstu){
            if(stu instanceof Middle){
                dlmmiddle.addElement(stu.toString());
            }
        }
    }
}
