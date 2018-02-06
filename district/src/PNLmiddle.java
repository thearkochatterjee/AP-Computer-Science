import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLmiddle extends JPanel{
    private DefaultListModel dlmmiddle = new DefaultListModel();
    private ScrollPane scrstu = new ScrollPane();
    private JList lststu = new JList();
    private JLabel lblmiddle = new JLabel();

    public PNLmiddle(){
        setLayout(new BorderLayout());
        add(scrstu);
        add(lblmiddle, BorderLayout.NORTH);
        scrstu.add(lststu);
        lststu.setModel(dlmmiddle);
        lststu.setFont(new Font("MONOSPACED", Font.PLAIN,18));
        lblmiddle.setText("Middle School");
    }

    public void input(ArrayList<Student> arrstu){
        for(Student stu: arrstu){
            if(stu instanceof Middle){
                dlmmiddle.addElement(stu.toString());
            }
        }
    }
}
