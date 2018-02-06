import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLelementary extends JPanel{
    private JLabel lblelementary = new JLabel();
    private ScrollPane scrstu = new ScrollPane();
    private JList lststu = new JList();
    private DefaultListModel dlmstu = new DefaultListModel();

    public PNLelementary(){
        setLayout(new BorderLayout());
        add(scrstu);
        add(lblelementary,BorderLayout.NORTH);
        scrstu.add(lststu);
        lststu.setModel(dlmstu);
        lststu.setFont(new Font("MONOSPACED",Font.PLAIN,18));
        lblelementary.setText("Elementary School");
    }

    public void input(ArrayList<Student> arrstu){
        for(Student stu: arrstu){
            if(stu instanceof Elementary){
                dlmstu.addElement(stu.toString());
            }
        }
    }
}
