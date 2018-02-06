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
    private JMenuItem mnuviewgrading = new JMenuItem();
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
        mnuadd.add(mnuviewgrading);
        mnuadd.setText("File");
        mnuaddstu.setText("Add Student");
        mnuremove.setText("Remove Student");
        mnuchange.setText("Change Student");
        mnuviewgrading.setText("View Grading System");
        openfname("src/assets/MaleNames.txt");
        openfname("src/assets/FemaleNames.txt");
        openlname("src/assets/LastNames.txt");
        setVisible(true);
        mnuaddstu.addActionListener(new addstu());
        mnuremove.addActionListener(new remove());
        mnuviewgrading.addActionListener(new view());
        mnuchange.addActionListener(new change());
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
                    arrstu.add(new Elementary(fname, lname, testavg, projavg, hwavg, i+1, participate));
                }
                else if(school == 2){
                    act = r.nextInt(250)+1;
                    arrstu.add(new Middle(fname, lname, testavg, projavg, hwavg, act, i+1));
                }
                else{
                    act = r.nextInt(36)+1;
                    arrstu.add(new High(fname, lname, testavg, projavg, hwavg, act, i+1));
                }
                arrstu.get(arrstu.size()-1).creategrade();
            }
            pane.input(arrstu);
        }
    }

    class change implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            int pos = 0;
            String change = "";
            String confirm = "";
            pos = Integer.valueOf(JOptionPane.showInputDialog("What is the ID for the student info you want to change?"));
            for(int i = 0;i<arrstu.size();i++){
                if(arrstu.get(i).getId()==pos){
                    id = i;
                }
            }
            confirm = JOptionPane.showInputDialog("Is the name of the student " + arrstu.get(id).getFname() + " " + arrstu.get(id).getLname());
            if(confirm.equals("yes")){
                change = JOptionPane.showInputDialog("What would you like to change?\nFirst Name\nLastName\ntest avg\nproj avg\nhw avg\nparticipation\nmap score\nact score");
                if(change.equals("First Name")){
                    String nfname = "";
                    nfname = JOptionPane.showInputDialog("What is their new first name?");
                    arrstu.get(id).setFname(nfname);
                }
                else if(change.equals("Last Name")){
                    String nlname = "";
                    nlname = JOptionPane.showInputDialog("What is their new last name?");
                    arrstu.get(id).setLname(nlname);
                }
                else if(change.equals("test avg")){
                    arrstu.get(id).setTestavg(Double.valueOf(JOptionPane.showInputDialog("What is the new test average?")));
                }
                else if(change.equals("proj avg")){
                    arrstu.get(id).setProjavg(Double.valueOf(JOptionPane.showInputDialog("What is the new project average?")));
                }
                else if(change.equals("hw avg")){
                    arrstu.get(id).setHwavg(Double.valueOf(JOptionPane.showInputDialog("What is the new homework average?")));
                }
                else if(change.equals("grade")){
                    int ngrade = 0;
                    ngrade = Integer.valueOf(JOptionPane.showInputDialog("What is the new grade this student is in?"));
                    arrstu.get(id).setGrade(ngrade);
                }
                else{
                    if(arrstu.get(id) instanceof Elementary){
                        Student s = arrstu.get(id);
                        if(change.equals("participation")){
                            String p = JOptionPane.showInputDialog("Does the student participate?");
                            Elementary cstu = new Elementary(s.getFname(), s.getLname(), s.getTestavg(), s.getProjavg(), s.getHwavg(), s.getId(), p);
                            arrstu.set(id, cstu);
                        }
                    }
                    else if(arrstu.get(id) instanceof Middle){
                        if(change.equals("map score")){
                            Student s = arrstu.get(id);
                            int nmap = Integer.valueOf(JOptionPane.showInputDialog("What is the new map score?"));
                            Middle m = new Middle(s.getFname(), s.getLname(), s.getTestavg(), s.getProjavg(), s.getHwavg(), nmap, s.getId());
                            arrstu.set(id,m);
                        }
                    }
                    else{
                        if(change.equals("act")){
                            Student s = arrstu.get(id);
                            int nact = Integer.valueOf(JOptionPane.showInputDialog("What is the new act score?"));
                            High h = new High(s.getFname(), s.getLname(), s.getTestavg(), s.getProjavg(), s.getHwavg(), nact, s.getId());
                            arrstu.set(id,h);
                        }
                    }
                }
            }
        }
    }

    class remove implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.valueOf(JOptionPane.showInputDialog("What is the id of the student you want to remove?"));
            int pos = 0;
            for(int i = 0;i<arrstu.size();i++){
                if(arrstu.get(i).getId()==id){
                    pos = i;
                }
            }
            arrstu.remove(pos);
        }
    }

    class view implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Elementary School\nMiddle School\nHigh School\n");
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
