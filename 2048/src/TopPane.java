import javax.swing.*;
import java.awt.*;

public class TopPane extends Container{
    private JLabel lblscore = new JLabel();
    private JLabel lblname = new JLabel();

    public TopPane(){
        setLayout(new GridLayout(1,2));
        add(lblname);
        add(lblscore);
        lblname.setText("Name:");
        lblscore.setText("Score:");
    }

    public JLabel getLblname() {
        return lblname;
    }

    public JLabel getLblscore() {
        return lblscore;
    }
}
