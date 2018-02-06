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
        setLayout(new GridLayout(5,2));
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
        lbltotalstu.setText("Total Students");
        lblavggrade.setText("Average Grade");
        lblpricount.setText("Number of Students on Principal's List");
        lblavgfee.setText("Average Fee");
        lblpercentplist.setText("Percent Principal's List");
        lbltotalstu.setHorizontalAlignment(JLabel.CENTER);
        lblavgfee.setHorizontalAlignment(JLabel.CENTER);
        lblpercentplist.setHorizontalAlignment(JLabel.CENTER);
        lblavggrade.setHorizontalAlignment(JLabel.CENTER);
        lblpricount.setHorizontalAlignment(JLabel.CENTER);
    }

    public void input(ArrayList<Student> arrstu){
        ArrayList<Integer> arrdata = new ArrayList<Integer>();
        int plistcount = 0;
        double avgfee = 0.0;
        lbltotalstu.setText(String.valueOf(arrstu.size()));
        for(Student stu: arrstu){
            arrdata.add(stu.grade);
            if (stu.principallist().equals("Made")){
                plistcount++;
            }
            avgfee+=stu.getFee();
        }
        avgfee = avgfee / arrstu.size();
        lblavggradeout.setText(String.valueOf(average(arrdata)));
        lblpricountout.setText(String.valueOf(plistcount));
        lblavgfee.setText(String.valueOf(avgfee));
    }

    private double average(ArrayList<Integer> data){
        double avg = 0;
        for(int p: data){
            avg+=p;
        }
        avg = avg / data.size();
        return avg;
    }
}
