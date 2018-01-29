import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Gui extends JFrame{
    private Pane pane = new Pane();
    private JMenuBar mnubar = new JMenuBar();
    private JMenu mnuemp = new JMenu();
    private JMenuItem mnuadd = new JMenuItem();

    public Gui(){
        setTitle("Employee");
        setSize(900,500);
        getContentPane().add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(mnubar);
        mnubar.add(mnuemp);
        mnuemp.add(mnuadd);
        mnuemp.setText("Employee");
        mnuadd.setText("Add Employees");
        setVisible(true);
        mnuadd.addActionListener(new add());
    }

    class add implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int numemps = Integer.valueOf(JOptionPane.showInputDialog("How many employees?"));
            Random r = new Random();
            ValueRounding vhr = new ValueRounding();
            ValueRounding vwage = new ValueRounding();
            ValueRounding vunion = new ValueRounding();
            ArrayList<Emp> arremps = new ArrayList<Emp>();
            for(int i = 0;i<numemps;i++){
                vhr.setValue(r.nextDouble()*1000+1);
                vwage.setValue(r.nextDouble()*1000+1);
                vunion.setValue(vwage.getValue()*0.05);
                boolean fulltime = false;
                fulltime = r.nextBoolean();
                if(fulltime){
                    arremps.add(new FTEmp(i+1, vhr.roundtodecnum(2), vwage.roundtodecnum(2), vunion.roundtodecnum(2)));
                }
                else{
                    arremps.add(new PTEmp(i+1, vhr.roundtodecnum(2), vwage.roundtodecnum(2), r.nextInt(4)+1));
                }
            }
            pane.inputemps(arremps);
        }
    }
}
