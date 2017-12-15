import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InputPane extends Container{
    private JLabel imgbook = new JLabel();
    private RatingGui rating = new RatingGui();

    public InputPane(){
        setLayout(new GridLayout(1,2));
        add(rating);
        add(imgbook);
    }

    public void setcovers(String path){
        imgbook.setIcon(new ImageIcon(path));
    }
}
