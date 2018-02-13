import javax.swing.*;
import java.awt.*;

public class MainPane extends Container{
    private JTextArea txtin = new JTextArea();
    private JTextArea lblout = new JTextArea();

    public MainPane(){
        Font f = new Font("MONOSPACED", Font.PLAIN,18);
        setLayout(new GridLayout(2,1));
        add(txtin);
        add(lblout);
        txtin.setFont(f);
        lblout.setFont(f);
        lblout.setEditable(false);
    }

    public JTextArea getTxtin() {
        return txtin;
    }

    public JTextArea getLblout() {
        return lblout;
    }

    public void output(int c1, int c2){
        lblout.setText("Iterative:\n"+c1+"\nRecursive:\n"+c2);
    }

    public void output(boolean c1, boolean c2){
        String out1 = "";
        String out2 = "";
        if(c1){
            out1 = "yes";
        }
        else{
            out1 = "no";
        }
        if(c2){
            out2 = "yes";
        }
        else{
            out2 = "no";
        }
        lblout.setText("Iterative:\n"+out1+"\nRecursive:\n"+out2);
    }
}
