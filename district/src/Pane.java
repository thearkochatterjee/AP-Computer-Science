import java.awt.*;
import java.util.ArrayList;

public class Pane extends Container{
    private PaneList panelist = new PaneList();
    private Paneover paneover = new Paneover();

    public Pane(){

    }

    public void input(ArrayList<Student> arrstu){
        panelist.input(arrstu);
        paneover.input(arrstu);
    }
}
