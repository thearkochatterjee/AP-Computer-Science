import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pane extends Container{
    private FTPanel ftpanel = new FTPanel();
    private PTPanel ptpanel = new PTPanel();


    public Pane(){
        setLayout(new GridLayout(1,2));
        add(ftpanel);
        add(ptpanel);
    }

    public void inputemps(ArrayList<Emp> arremps){
        ftpanel.input(arremps);
        ptpanel.input(arremps);
    }
}
