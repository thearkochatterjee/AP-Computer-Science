import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    public Gui(){
        Container pane = new Container();
        TopPane top = new TopPane();
        GamePlatform game = new GamePlatform();
        pane.setLayout(new BorderLayout());
        pane.add(game);
        pane.add(top, BorderLayout.NORTH);
    }
}
