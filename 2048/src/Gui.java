import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    public Gui(){
        Container pane = new Container();
        TopPane top = new TopPane();
        GamePlatform game = new GamePlatform();
        getContentPane().add(pane);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("2048");
        pane.setLayout(new BorderLayout());
        pane.add(game);
        pane.add(top, BorderLayout.NORTH);
        setVisible(true);
    }
}
