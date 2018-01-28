import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FTPanel extends Panel{
    private JList lstfulltime = new JList();
    private DefaultListModel dlmfull = new DefaultListModel();
    private JLabel lblfull = new JLabel();
    private ScrollPane scrfull = new ScrollPane();
    private JLabel lbltotal = new JLabel();

    public FTPanel(){
        setLayout(new BorderLayout());
        add(scrfull);
        add(lblfull,BorderLayout.NORTH);
        add(lbltotal, BorderLayout.SOUTH);
        scrfull.add(lstfulltime);
        lstfulltime.setModel(dlmfull);
        lblfull.setText("Full Time Employee");
    }

    public void input(ArrayList<Emp> arremps){
        double total = 0.0;
        ValueRounding vtotal = new ValueRounding();
        for(Emp e: arremps){
            if(e instanceof FTEmp){
                dlmfull.addElement(e.toString());
            }
        }
        for(Emp e: arremps){
            total += e.findgp();
        }
        vtotal.setValue(total);
        total = vtotal.roundtodecnum(2);
        lbltotal.setText("Total gross pay of all Employees: "+total);
    }
}
