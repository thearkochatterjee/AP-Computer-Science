import javax.swing.*;
import java.awt.*;

public class OutputPane extends Container{
    private JLabel lblnumwords = new JLabel();
    private JLabel lblnumsentences = new JLabel();
    private JLabel lblnumsyllibles = new JLabel();
    private JLabel lblnumbervowels = new JLabel();
    private JLabel lblnumberconsonents = new JLabel();
    private JLabel lblout = new JLabel();

    public OutputPane(){
        setLayout(new GridLayout(5,1));
        add(lblout);
        add(lblnumsentences);
        add(lblnumwords);
        add(lblnumsyllibles);
        add(lblnumberconsonents);
        add(lblnumbervowels);
        lblout.setText("Information");
        lblnumsentences.setText("Number of Sentences");

    }

    public void setOutput(TextAnalyzer textAnalyzer){
        lblnumwords.setText("Number of Words: "+textAnalyzer.numberofwords());

    }
}
