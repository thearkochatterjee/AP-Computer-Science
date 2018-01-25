import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FTPanel extends Panel{
    private JList lstfulltime = new JList();
    private DefaultListModel dlmfull = new DefaultListModel();
    private JLabel lblfull = new JLabel();
    private ScrollPane scrfull = new ScrollPane();

    public FTPanel(){
        setLayout(new BorderLayout());
        add(scrfull);
        add(lblfull,BorderLayout.NORTH);
        scrfull.add(lstfulltime);
        lstfulltime.setModel(dlmfull);
        lblfull.setText("Full Time Employee");
    }

    public void input(ArrayList<Emp> arremps){
        for(Emp e: arremps){
            if(e instanceof FTEmp){
                dlmfull.addElement(e.toString());
            }
        }
    }
}
