import javax.swing.*;
import java.awt.*;

public class Pane extends Container{
    private PNLMiddle pnlmiddle = new PNLMiddle();
    private PNLElementary pnlelementary = new PNLElementary();
    private PNLHigh pnlhigh = new PNLHigh();

    public Pane(){
        setLayout(new GridLayout(1,3));
        add(pnlelementary);
        add(pnlmiddle);
        add(pnlhigh);
    }
}
