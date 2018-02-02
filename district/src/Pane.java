import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pane extends Container{
    private PNLMiddle pnlmiddle = new PNLMiddle();
    private PNLElementary pnlelementary = new PNLElementary();
    private PNLHigh pnlhigh = new PNLHigh();
    private PNLIntermediate pnlintermediate = new PNLIntermediate();

    public Pane(){
        setLayout(new GridLayout(1,3));
        add(pnlelementary);
        add(pnlintermediate);
        add(pnlmiddle);
        add(pnlhigh);
    }

    public void input(ArrayList<Student> arrstu){
        pnlelementary.input(arrstu);
        pnlintermediate.input(arrstu);
    }
}
