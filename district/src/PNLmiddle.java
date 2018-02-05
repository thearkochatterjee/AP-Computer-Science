import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PNLmiddle extends JPanel{
    private DefaultListModel dlmmiddle = new DefaultListModel();
    private ScrollPane scrstu = new ScrollPane();

    public PNLmiddle(){

    }

    public void input(ArrayList<Student> arrstu){
        for(Student stu: arrstu){
            if(stu instanceof High){
                dlmmiddle.addElement(stu.toString());
            }
        }
    }
}
