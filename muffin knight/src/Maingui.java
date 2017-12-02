import javax.swing.*;
import java.awt.*;

public class Maingui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static JButton cmdsingle = new JButton();
    private static JButton cmdquit = new JButton();

    public Maingui(){
        gui.setTitle("Muffin Knight");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().add(pane);
    }

    public void show(){
        gui.setVisible(true);
    }

    public void hide(){
        gui.setVisible(false);
    }
}
