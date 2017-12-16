import javax.swing.*;
import java.awt.*;

public class OutputPane2 extends Container{
    private JList lstmethod1 = new JList();
    private JList lstmethod2 = new JList();
    private JList lstmethod3 = new JList();
    private JList lstmethod4 = new JList();
    private static DefaultListModel dlm1 = new DefaultListModel();
    private static DefaultListModel dlm2 = new DefaultListModel();
    private static DefaultListModel dlm3 = new DefaultListModel();
    private static DefaultListModel dlm4 = new DefaultListModel();

    public OutputPane2(){
        setLayout(new GridLayout(4,1));
        lstmethod1.setModel(dlm1);
        lstmethod2.setModel(dlm2);
        lstmethod3.setModel(dlm3);
        lstmethod4.setModel(dlm4);
        add(lstmethod1);
        add(lstmethod2);
        add(lstmethod3);
        add(lstmethod4);
    }

    public static DefaultListModel getDlm1() {
        return dlm1;
    }

    public static DefaultListModel getDlm2() {
        return dlm2;
    }

    public static DefaultListModel getDlm3() {
        return dlm3;
    }

    public static DefaultListModel getDlm4() {
        return dlm4;
    }

    public JList getLstmethod1() {
        return lstmethod1;
    }

    public JList getLstmethod2() {
        return lstmethod2;
    }

    public JList getLstmethod3() {
        return lstmethod3;
    }

    public JList getLstmethod4() {
        return lstmethod4;
    }

    public static void setDlm1(DefaultListModel dlm1) {
        OutputPane2.dlm1 = dlm1;
    }

    public static void setDlm2(DefaultListModel dlm2) {
        OutputPane2.dlm2 = dlm2;
    }

    public static void setDlm3(DefaultListModel dlm3) {
        OutputPane2.dlm3 = dlm3;
    }

    public static void setDlm4(DefaultListModel dlm4) {
        OutputPane2.dlm4 = dlm4;
    }
}
