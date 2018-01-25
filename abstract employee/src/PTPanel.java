import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PTPanel extends Panel {
    private JLabel lblpart = new JLabel();
    private JList lstpart = new JList();
    private DefaultListModel dlmpart = new DefaultListModel();
    private ScrollPane scrpart = new ScrollPane();

    public PTPanel(){
        setLayout(new BorderLayout());
        add(scrpart);
        add(lblpart, BorderLayout.NORTH);
        scrpart.add(lstpart);
        lstpart.setModel(dlmpart);
        lblpart.setText("Part Time Employee");
    }

    public void input(ArrayList<Emp> arremps){
        for(Emp e: arremps){
            if(e instanceof PTEmp){
                dlmpart.addElement(e.toString());
            }
        }
    }
}
