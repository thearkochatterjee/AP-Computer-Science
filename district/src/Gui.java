import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Gui extends JFrame {
    private Pane pane = new Pane();
    private JMenuBar mnubar = new JMenuBar();
    private JMenu mnuadd = new JMenu();
    private JMenuItem mnuaddstu = new JMenuItem();
    private JMenuItem mnuremove = new JMenuItem();
    private JMenuItem mnuchange = new JMenuItem();
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
        mnuadd.add(mnuremove);
        mnuadd.add(mnuchange);
        mnuadd.setText("File");
        mnuaddstu.setText("Add Student");
        mnuremove.setText("Remove Student");
        mnuchange.setText("Change Student");
        openfname("src/assets/MaleNames.txt");
        openfname("src/assets/FemaleNames.txt");
        openlname("src/assets/LastNames.txt");
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
            String participate = "";
            numstu = Integer.valueOf(JOptionPane.showInputDialog("How many students would you like to enter?"));
            for(int i = 0;i<numstu;i++){
                fname = arrfname.get(r.nextInt(arrfname.size()));
                lname = arrlname.get(r.nextInt(arrlname.size()));
                testavg = r.nextDouble()*100 +1;
                projavg = r.nextDouble()*100+1;
                hwavg = r.nextDouble()*100+1;
                school = r.nextInt(3)+1;
                if(school==1){
                    if(r.nextBoolean()){
                        participate = "yes";
                    }
                    else{
                        participate = "no";
                    }
                    arrstu.add(new Elementary(fname, lname, testavg, projavg, hwavg, i, participate));
                }
                else if(school == 2){
                    act = r.nextInt(250)+1;
                    arrstu.add(new Middle(fname, lname, testavg, projavg, hwavg, act, i));
                }
                else{
                    act = r.nextInt(36)+1;
                    arrstu.add(new High(fname, lname, testavg, projavg, hwavg, act, i));
                }
                arrstu.get(arrstu.size()-1).creategrade();
            }
            pane.input(arrstu);
        }
    }

    public void openfname(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrfname.add(line.trim());
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openlname(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrlname.add(line.trim());
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
