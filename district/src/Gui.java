import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Gui extends JFrame{
    private Pane pane = new Pane();
    private JMenuBar mnubar = new JMenuBar();
    private JMenu mnuadd = new JMenu();
    private JMenuItem mnuaddstudent = new JMenuItem();
    private ArrayList<Student> arrstu = new ArrayList<Student>();
    private ArrayList<String> arrfname = new ArrayList<String>();
    private ArrayList<String> arrlname = new ArrayList<String>();

    public Gui(){
        setTitle("District");
        setSize(500,500);
        getContentPane().add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        mnuaddstudent.addActionListener(new student());
    }

    class student implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int numstu = 0;
            int numtest = 0;
            int numproj = 0;
            int numhw = 0;
            int school = 0;
            Random r = new Random();
            ArrayList<Double> arrtest = new ArrayList<Double>();
            ArrayList<Double> arrhw = new ArrayList<Double>();
            ArrayList<Double> arrproj = new ArrayList<Double>();
            numstu = Integer.valueOf(JOptionPane.showInputDialog("How many students would you add?"));
            numtest = Integer.valueOf(JOptionPane.showInputDialog("How many tests do you want each student to have?"));
            numproj = Integer.valueOf(JOptionPane.showInputDialog("How many projects do you want each student to have?"));
            numhw = Integer.valueOf(JOptionPane.showInputDialog("How many homework assignments do you want each student to have?"));
            for(int i = 0;i<numstu;i++){
                school = r.nextInt(4)+1;
                for(int x = 0;i<numtest;i++){
                    arrtest.add(r.nextDouble()*100+1);
                }
                for(int x = 0;i<numhw;i++){
                    arrhw.add(r.nextDouble()*100+1);
                }
                for(int x = 0;i<numproj;i++){
                    arrproj.add(r.nextDouble()*100+1);
                }
                switch (school){
                    case 1:
                        arrstu.add(new Elementary(arrfname.get(r.nextInt(arrfname.size())),arrlname.get(r.nextInt(arrlname.size())), arrtest, arrproj, arrhw));
                        break;
                    case 2:
                        arrstu.add(new Intermediate(arrfname.get(r.nextInt(arrfname.size())),arrlname.get(r.nextInt(arrlname.size())), arrtest, arrproj, arrhw));
                        break;
                    case 3:
                        arrstu.add(new Middle(arrfname.get(r.nextInt(arrfname.size())),arrlname.get(r.nextInt(arrlname.size())), arrtest, arrproj, arrhw));
                        break;
                    case 4:
                        int act = r.nextInt(36)+1;
                        int sat = r.nextInt(800)+800;
                        arrstu.add(new High(arrfname.get(r.nextInt(arrfname.size())),arrlname.get(r.nextInt(arrlname.size())), arrtest, arrproj, arrhw, act, sat));
                        break;
                }
            }
        }
    }
}
