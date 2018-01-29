import javax.swing.*;
import java.util.ArrayList;

public class PNLElementary extends JPanel{
    private JList lstelementary = new JList();
    private JLabel lblelementary = new JLabel();
    private DefaultListModel dlmelementary = new DefaultListModel();

    public PNLElementary(){

    }

    public void input(ArrayList<Student> arrstu){
        for(Student s: arrstu){
            if(s instanceof Elementary){
                dlmelementary.addElement(s.toString());
            }
        }
    }
}
