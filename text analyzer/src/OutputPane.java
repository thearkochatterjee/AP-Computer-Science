import javax.swing.*;
import java.awt.*;

public class OutputPane extends Container{
    private JLabel lblout = new JLabel();
    private JList lstout = new JList();
    private DefaultListModel dlm = new DefaultListModel();

    public OutputPane(){
        setLayout(new BorderLayout());
        lstout.setModel(dlm);
        dlm.clear();
        add(lblout,BorderLayout.NORTH);
        add(lstout);
        lblout.setText("Information");
    }

    public void setOutput(TextAnalyzer textAnalyzer){
        dlm.clear();
        dlm.addElement("Number of Words:");
        dlm.addElement(textAnalyzer.numberofwords());
        dlm.addElement("Number of Vowels:");
        dlm.addElement(textAnalyzer.totalvowels());
        dlm.addElement("Number of Consonants:");
        dlm.addElement(textAnalyzer.totalconssoants());
        dlm.addElement("Number of Syllables:");
        dlm.addElement(textAnalyzer.totalsyllibles());
        dlm.addElement("Number of Sentences:");
        dlm.addElement(textAnalyzer.numberofsenctences());
        dlm.addElement("Coleman Index:");
        dlm.addElement(textAnalyzer.coleman_index());
        dlm.addElement("Readability Score:");
        dlm.addElement(textAnalyzer.readability_score());
    }
}
