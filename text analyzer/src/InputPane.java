import javax.swing.*;
import java.awt.*;

public class InputPane extends Container{
    private JTextArea txttext = new JTextArea();
    private JLabel lbltext = new JLabel();

    public InputPane() {
        setLayout(new BorderLayout());
        add(txttext);
        add(lbltext,BorderLayout.NORTH);
        lbltext.setText("Text");
    }
}
