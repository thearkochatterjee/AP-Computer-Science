import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static Container panein = new Container();
    private static Container paneout = new Container();
    private static JCheckBox chxcomplete = new JCheckBox();
    private static JTextField txtname = new JTextField();
    private static JTextField txtsubject = new JTextField();
    private static JTextField txtduedate = new JTextField();
    private static JTextField txtcategory = new JTextField();
    private static JTextField txttotal = new JTextField();
    private static JTextField txtearn = new JTextField();
    private static JLabel lblname = new JLabel();
    private static JLabel lblsubject = new JLabel();
    private static JLabel lblduedate = new JLabel();
    private static JLabel lblcategory = new JLabel();
    private static JLabel lbltotal = new JLabel();
    private static JLabel lblearn = new JLabel();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenu mnusort = new JMenu();
    private static JMenuItem mnuadd = new JMenuItem();
    private static JMenuItem mnudelete = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static JMenuItem mnuopen = new JMenuItem();
    private static JMenuItem mnucompleted = new JMenuItem();
    private static JMenuItem mnunotcompleted = new JMenuItem();
    private static JList lsthw = new JList();
    private static DefaultListModel dlm = new DefaultListModel();
    private static ArrayList<Assignments> arrassignments = new ArrayList<Assignments>();
    private static ArrayList<Subject> arrsubject = new ArrayList<Subject>();
    private static ArrayList<Category> arrcategory = new ArrayList<Category>();

    public static void main(String args[]){
        gui.setTitle("Homework");
        gui.setSize(500,500);
        gui.setJMenuBar(mnubar);
        gui.getContentPane().add(pane);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mnubar.add(mnufile);
        mnubar.add(mnusort);
        mnusort.add(mnucompleted);
        mnusort.add(mnunotcompleted);
        mnufile.add(mnuadd);
        mnufile.add(mnudelete);
        mnufile.add(mnusave);
        mnufile.add(mnuopen);
        pane.setLayout(new GridLayout(2,1,20,20));
        pane.add(panein);
        pane.add(paneout);
        panein.setLayout(new GridLayout(7,2,20,10));
        panein.add(lblname);
        panein.add(txtname);
        panein.add(lblsubject);
        panein.add(txtsubject);
        panein.add(lblcategory);
        panein.add(txtcategory);
        panein.add(lblduedate);
        panein.add(txtduedate);
        panein.add(lblearn);
        panein.add(txtearn);
        panein.add(lbltotal);
        panein.add(txttotal);
        panein.add(new JLabel());
        panein.add(chxcomplete);
        paneout.add(lsthw);
        lsthw.setModel(dlm);
        lblname.setText("Name");
        lblsubject.setText("Subject");
        lblcategory.setText("Category");
        lblduedate.setText("Due Date");
        lblearn.setText("Points Earned");
        lbltotal.setText("Total Points");
        chxcomplete.setText("complete");
        lblname.setHorizontalAlignment(SwingConstants.CENTER);
        lblsubject.setHorizontalAlignment(SwingConstants.CENTER);
        lblcategory.setHorizontalAlignment(SwingConstants.CENTER);
        lblduedate.setHorizontalAlignment(SwingConstants.CENTER);
        lblearn.setHorizontalAlignment(SwingConstants.CENTER);
        lbltotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblname.setVerticalAlignment(SwingConstants.CENTER);
        lblsubject.setVerticalAlignment(SwingConstants.CENTER);
        lblcategory.setVerticalAlignment(SwingConstants.CENTER);
        lblduedate.setVerticalAlignment(SwingConstants.CENTER);
        lblearn.setVerticalAlignment(SwingConstants.CENTER);
        lbltotal.setVerticalAlignment(SwingConstants.CENTER);
        mnufile.setText("File");
        mnuadd.setText("Add Assignment");
        mnudelete.setText("Delete Assignment");
        mnusave.setText("Save");
        mnuopen.setText("Open");
        mnusort.setText("Organization");
        mnucompleted.setText("Show Completed");
        mnunotcompleted.setText("Show Not Completed");
        openhomework("C:\\Users\\Arko\\Documents\\homework start up log\\homework.txt");
        opensubject("C:\\Users\\Arko\\Documents\\homework start up log\\subject.txt");
        opencategory("C:\\Users\\Arko\\Documents\\homework start up log\\category.txt");
        gui.setVisible(true);
        gui.addKeyListener(new guiupdate());
        mnuadd.addActionListener(new add());
        mnudelete.addActionListener(new delete());
        mnusave.addActionListener(new save());
        mnuopen.addActionListener(new open());
        mnunotcompleted.addActionListener(new showincomplete());
        mnucompleted.addActionListener(new showcomplete());
    }

    static class guiupdate implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                update();
            }
        }
    }

    static class add implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Assignments temp = new Assignments();
            temp.setName(txtname.getText());
            temp.setSubject(txtsubject.getText());
            temp.setCategory(txtcategory.getText());
            temp.setComplete(false);
            try{
                temp.setEarn(Double.valueOf(txtearn.getText()));
                temp.setTotal(Double.valueOf(txttotal.getText()));
                temp.setDue(new DueDate(txtduedate.getText()));
            }
            catch (Exception e1){
                JOptionPane.showMessageDialog(null,"Input Error");
            }
            arrassignments.add(temp);
            dlm.addElement(temp.getName());
        }
    }

    static class delete implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dlm.remove(lsthw.getSelectedIndex());
            arrassignments.remove(lsthw.getSelectedIndex());
        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            savehomework("C:\\Users\\Arko\\Documents\\homework start up log\\homework.txt");
            savecategory("C:\\Users\\Arko\\Documents\\homework start up log\\category.txt");
            savesubject("C:\\Users\\Arko\\Documents\\homework start up log\\subject.txt");
        }
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            openhomework("C:\\Users\\Arko\\Documents\\homework start up log\\homework.txt");
            opensubject("C:\\Users\\Arko\\Documents\\homework start up log\\subject.txt");
            opencategory("C:\\Users\\Arko\\Documents\\homework start up log\\category.txt");
        }
    }

    static class complete implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            update();
        }
    }

    static class showcomplete implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dlm.clear();
            for(int i = 0;i<arrassignments.size();i++){
                if(arrassignments.get(i).isComplete()){
                    dlm.addElement(arrassignments.get(i).getName());
                }
            }
        }
    }

    static class showincomplete implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dlm.clear();
            for(int i = 0;i<arrassignments.size();i++){
                if(arrassignments.get(i).isComplete()==false){
                    dlm.addElement(arrassignments.get(i).getName());
                }
            }
        }
    }

    public static void openhomework(String path){

    }

    public static void opensubject(String path){

    }

    public static void opencategory(String path){

    }

    public static void savehomework(String path){

    }

    public static void savesubject(String path){

    }

    public static void savecategory(String path){

    }

    public static void update(){
        arrassignments.get(lsthw.getSelectedIndex()).setName(txtname.getText());
        arrassignments.get(lsthw.getSelectedIndex()).setSubject(txtsubject.getText());
        arrassignments.get(lsthw.getSelectedIndex()).setCategory(txtcategory.getText());
        try{
            arrassignments.get(lsthw.getSelectedIndex()).setEarn(Double.valueOf(txtearn.getText()));
            arrassignments.get(lsthw.getSelectedIndex()).setTotal(Double.valueOf(txttotal.getText()));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Input Error");
        }
        arrassignments.get(lsthw.getSelectedIndex()).setDue(new DueDate(txtduedate.getText()));
        arrassignments.get(lsthw.getSelectedIndex()).setComplete(chxcomplete.isSelected());
    }
}
