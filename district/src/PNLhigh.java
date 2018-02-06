import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLhigh extends JPanel{
    private JList lststu = new JList();
    private ScrollPane scrstu = new ScrollPane();
    private JLabel lblhigh = new JLabel();
    private DefaultListModel dlmhigh = new DefaultListModel();

    public PNLhigh(){
        setLayout(new BorderLayout());
        add(scrstu);
        add(lblhigh, BorderLayout.NORTH);
        scrstu.add(lststu);
        lststu.setModel(dlmhigh);
        lststu.setFont(new Font("MONOSPACED", Font.PLAIN,18));
        lblhigh.setText("High School");
    }

    public void input(ArrayList<Student> arrstu){
        dlmhigh.clear();
        for(Student stu: arrstu){
            if(stu instanceof High){
                dlmhigh.addElement(stu.toString());
            }
        }
    }
}
