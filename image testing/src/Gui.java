import javax.swing.*;
import java.awt.*;

public class Gui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static JLabel imgtest = new JLabel();

    public static void main(String args[]){
        gui.setTitle("Image test");
        gui.setSize(500,500);
        gui.getContentPane().add(pane);
        pane.setLayout(new GridLayout(2,2,20,20));
        imgtest.setIcon(new ImageIcon("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science Projects\\bookrecdata\\Bone Series.jpg"));
        pane.add(new JLabel());
        pane.add(imgtest);
        pane.add(new JLabel());
        gui.setVisible(true);
    }
}
