import javax.swing.*;
import java.awt.*;

public class InputPane extends Container{
    private JLabel imgbook = new JLabel();
    private RatingGui rating = new RatingGui();
    private JList lstbooks = new JList();
    private DefaultListModel dlm = new DefaultListModel();

    public InputPane(){
        setLayout(new GridLayout(1,3));
        add(rating);
        add(lstbooks);
        add(imgbook);
    }

    public void setcovers(String path){
        imgbook.setIcon(new ImageIcon(path));
    }
}
