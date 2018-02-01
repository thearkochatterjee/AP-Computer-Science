import javax.swing.*;
import java.awt.*;

public class PNLHigh extends JPanel{
    private JList lsthigh = new JList();
    private DefaultListModel dlmhigh = new DefaultListModel();
    private JLabel lblhigh = new JLabel();

    public PNLHigh(){
        setLayout(new BorderLayout());
        add(lsthigh);
        add(lblhigh, BorderLayout.NORTH);
    }
}
