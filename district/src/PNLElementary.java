import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLElementary extends JPanel{
    private JList lstelementary = new JList();
    private JLabel lblelementary = new JLabel();
    private DefaultListModel dlmelementary = new DefaultListModel();
    private ScrollPane scrstu = new ScrollPane();

    public PNLElementary(){
        setLayout(new BorderLayout());
        add(scrstu);
        add(lblelementary, BorderLayout.NORTH);
        scrstu.add(lstelementary);
        lblelementary.setText("Elementary School");
        lstelementary.setModel(dlmelementary);
    }

    public void input(ArrayList<Student> arrstu){
        for(Student s: arrstu){
            if(s instanceof Elementary){
                dlmelementary.addElement(s.toString());
            }
        }
    }
}
