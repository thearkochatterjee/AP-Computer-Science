import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static Container panein = new Container();
    private static Container paneout = new Container();
    private static JTextField txtname = new JTextField();
    private static JTextField txtsubject = new JTextField();
    private static JTextField txtduedate = new JTextField();
    private static JTextField txtcategory = new JTextField();
    private static JTextField txttotal = new JTextField();
    private static JTextField txtearn = new JTextField();
    private static JTextField txtcomplete = new JTextField();
    private static JLabel lblname = new JLabel();
    private static JLabel lblsubject = new JLabel();
    private static JLabel lblduedate = new JLabel();
    private static JLabel lblcategory = new JLabel();
    private static JLabel lbltotal = new JLabel();
    private static JLabel lblearn = new JLabel();
    private static JLabel lblcomplete = new JLabel();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenuItem mnuadd = new JMenuItem();
    private static JMenuItem mnudelete = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static JMenuItem mnuopen = new JMenuItem();
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
        panein.add(lblcomplete);
        panein.add(txtcomplete);
        paneout.add(lsthw);
        lsthw.setModel(dlm);
        lblname.setText("Name");
        lblsubject.setText("Subject");
        lblcategory.setText("Category");
        lblduedate.setText("Due Date");
        lblearn.setText("Points Earned");
        lbltotal.setText("Total Points");
        lblcomplete.setText("Complete");
        lblname.setHorizontalAlignment(SwingConstants.CENTER);
        lblsubject.setHorizontalAlignment(SwingConstants.CENTER);
        lblcategory.setHorizontalAlignment(SwingConstants.CENTER);
        lblduedate.setHorizontalAlignment(SwingConstants.CENTER);
        lblearn.setHorizontalAlignment(SwingConstants.CENTER);
        lbltotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblcomplete.setHorizontalAlignment(SwingConstants.CENTER);
        lblname.setVerticalAlignment(SwingConstants.CENTER);
        lblsubject.setVerticalAlignment(SwingConstants.CENTER);
        lblcategory.setVerticalAlignment(SwingConstants.CENTER);
        lblduedate.setVerticalAlignment(SwingConstants.CENTER);
        lblearn.setVerticalAlignment(SwingConstants.CENTER);
        lbltotal.setVerticalAlignment(SwingConstants.CENTER);
        lblcomplete.setVerticalAlignment(SwingConstants.CENTER);
        mnufile.setText("File");
        mnuadd.setText("Add Assignment");
        mnudelete.setText("Delete Assignment");
        mnusave.setText("Save");
        mnuopen.setText("Open");
        gui.setVisible(true);
        mnuadd.addActionListener(new add());
        mnudelete.addActionListener(new delete());
        mnusave.addActionListener(new save());
        mnuopen.addActionListener(new open());
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

        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void open(String path){

    }

    public void save(String path){

    }
}
