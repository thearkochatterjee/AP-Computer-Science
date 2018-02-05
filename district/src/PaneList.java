import java.awt.*;
import java.util.ArrayList;

public class PaneList extends Container{
    private PNLelementary pnlelementary = new PNLelementary();
    private PNLmiddle pnlmiddle = new PNLmiddle();
    private PNLhigh pnlhigh = new PNLhigh();

    public PaneList(){
        setLayout(new GridLayout(1,3));
        add(pnlelementary);
        add(pnlmiddle);
        add(pnlhigh);
    }

    public void input(ArrayList<Student> arrstu){
        pnlelementary.input(arrstu);
        pnlmiddle.input(arrstu);
        pnlhigh.input(arrstu);
    }
}
