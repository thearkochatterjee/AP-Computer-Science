import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Paneover extends Container{
    private JLabel lbltotalstu = new JLabel();
    private JLabel lbltotalstuout = new JLabel();
    private JLabel lblavggrade = new JLabel();
    private JLabel lblavggradeout = new JLabel();
    private JLabel lblpricount = new JLabel();
    private JLabel lblpricountout = new JLabel();
    private JLabel lblfeetotal = new JLabel();
    private JLabel lblfeetotalout = new JLabel();
    private JLabel lblavgfee = new JLabel();
    private JLabel lblavgfeeout = new JLabel();
    private JLabel lblpercentplist = new JLabel();
    private JLabel lblpercentplistout = new JLabel();

    public Paneover(){
        Font f = new Font("MONOSPACED", Font.PLAIN,20);
        setLayout(new GridLayout(6,2));
        add(lbltotalstu);
        add(lbltotalstuout);
        add(lblavggrade);
        add(lblavggradeout);
        add(lblpricount);
        add(lblpricountout);
        add(lblavgfee);
        add(lblavgfeeout);
        add(lblpercentplist);
        add(lblpercentplistout);
        add(lblfeetotal);
        add(lblfeetotalout);
        lbltotalstu.setText("Total Students");
        lblavggrade.setText("Average Grade");
        lblpricount.setText("Number of Students on Principal's List");
        lblavgfee.setText("Average Fee");
        lblpercentplist.setText("Percent Principal's List");
        lblfeetotal.setText("Total Fees");
        lblfeetotal.setHorizontalAlignment(JLabel.CENTER);
        lbltotalstu.setHorizontalAlignment(JLabel.CENTER);
        lblavgfee.setHorizontalAlignment(JLabel.CENTER);
        lblpercentplist.setHorizontalAlignment(JLabel.CENTER);
        lblavggrade.setHorizontalAlignment(JLabel.CENTER);
        lblpricount.setHorizontalAlignment(JLabel.CENTER);
        lblavgfeeout.setFont(f);
        lblfeetotal.setFont(f);
        lblfeetotalout.setFont(f);
        lblavgfee.setFont(f);
        lblpercentplistout.setFont(f);
        lblpercentplist.setFont(f);
        lblpricountout.setFont(f);
        lblpricount.setFont(f);
        lblavggrade.setFont(f);
        lbltotalstu.setFont(f);
        lblavggradeout.setFont(f);
        lbltotalstuout.setFont(f);
    }

    public void input(ArrayList<Student> arrstu){
        double avggrade = 0.0;
        int plistcount = 0;
        double avgfee = 0.0;
        double percent = 0.0;
        lbltotalstuout.setText(String.valueOf(arrstu.size()));
        for(Student stu: arrstu){
            avggrade += stu.percentage();
            if (stu.principallist().equals("Made")){
                plistcount++;
            }
            avgfee+=stu.getFee();
        }
        avggrade = avggrade / arrstu.size();
        lblfeetotalout.setText(String.valueOf(avgfee));
        avgfee = avgfee / arrstu.size();
        percent = Double.valueOf(plistcount)/arrstu.size() * 100;
        lblavggradeout.setText(String.valueOf(avggrade));
        lblpricountout.setText(String.valueOf(plistcount));
        lblavgfeeout.setText(String.valueOf(avgfee));
        lblpercentplistout.setText(percent+"%");
    }
}
