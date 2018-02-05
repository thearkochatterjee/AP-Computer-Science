import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Gui extends JFrame {
    private Pane pane = new Pane();
    private JMenuBar mnubar = new JMenuBar();
    private JMenu mnuadd = new JMenu();
    private JMenuItem mnuaddstu = new JMenuItem();
    private ArrayList<Student> arrstu = new ArrayList<Student>();
    private ArrayList<String> arrfname = new ArrayList<String>();
    private ArrayList<String> arrlname = new ArrayList<String>();

    public Gui(){
        setTitle("District");
        setSize(900,500);
        getContentPane().add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(mnubar);
        mnubar.add(mnuadd);
        mnuadd.add(mnuaddstu);
        mnuadd.setText("Add");
        mnuaddstu.setText("Add Student");
        setVisible(true);
        mnuaddstu.addActionListener(new addstu());
    }

    class addstu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Random r = new Random();
            int numstu = 0;
            String fname = "";
            String lname = "";
            double testavg, projavg, hwavg;
            int school = 0;
            int act = 0;
            numstu = Integer.valueOf(JOptionPane.showInputDialog("How many students would you like to enter?"));
            for(int i = 0;i<numstu;i++){
                fname = arrfname.get(r.nextInt(arrfname.size()));
                lname = arrlname.get(r.nextInt(arrlname.size()));
                testavg = r.nextDouble()*100 +1;
                projavg = r.nextDouble()*100+1;
                hwavg = r.nextDouble()*100+1;
                school = r.nextInt(3)+1;
                if(school==1){
                    arrstu.add(new Elementary(fname, lname, testavg, projavg, hwavg));
                }
                else if(school == 2){
                    act = r.nextInt(250)+1;
                    arrstu.add(new Middle(fname, lname, testavg, projavg, hwavg, act));
                }
                else{
                    act = r.nextInt(36)+1;
                    arrstu.add(new High(fname, lname, testavg, projavg, hwavg, act));
                }
            }
            pane.input(arrstu);
        }
    }
}
