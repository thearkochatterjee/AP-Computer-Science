import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;

public class Gui {
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenuItem mnuaddhomework = new JMenuItem();
    private static JMenuItem mnudelete = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static JMenuItem mnuopen = new JMenuItem();
    private static ArrayList<Assignment> arrassignments = new ArrayList<Assignment>();
    private static JList lsthw = new JList();
    private static DefaultListModel dlm = new DefaultListModel();
    private static JTextField txtname = new JTextField();
    private static JTextField txtsubject = new JTextField();
    private static JTextField txtduedate = new JTextField();
    private static JTextField txtcategory = new JTextField();
    private static JTextField txtearned = new JTextField();
    private static JTextField txttotal = new JTextField();
    private static JLabel lblname = new JLabel();
    private static JLabel lblsubject = new JLabel();
    private static JLabel lblduedate = new JLabel();
    private static JLabel lblcategory = new JLabel();
    private static JLabel lblearned = new JLabel();
    private static JLabel lbltotal = new JLabel();

    public static void main(String args[]){
        gui.setTitle("Basic Homework Log");
        gui.setSize(500,600);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().add(pane);
        openfile();
        mnubar.add(mnufile);
        mnufile.add(mnuaddhomework);
        mnufile.add(mnudelete);
        mnufile.add(mnusave);
        mnufile.add(mnuopen);
        gui.setJMenuBar(mnubar);
        mnufile.setText("File");
        mnusave.setText("Save");
        mnuopen.setText("Open");
        mnuaddhomework.setText("Add Assignment");
        mnudelete.setText("Delete Assignment");
        lsthw.setModel(dlm);
        lblduedate.setText("Due Date");
        lblname.setText("Name of Assignment");
        lblsubject.setText("Subject");
        pane.add(lsthw);
        pane.add(txtduedate);
        pane.add(txtname);
        pane.add(txtsubject);
        pane.add(txtcategory);
        pane.add(txtearned);
        pane.add(txttotal);
        pane.add(lblduedate);
        pane.add(lblname);
        pane.add(lblsubject);
        pane.add(lblcategory);
        pane.add(lblearned);
        pane.add(lbltotal);
        pane.add(lsthw);
        gui.addKeyListener(new key());
        lblname.setBounds(20,20,100,30);
        lblsubject.setBounds(20,70,100,30);
        lblduedate.setBounds(20,130,100,30);
        txtname.setBounds(140,20,200,30);
        txtsubject.setBounds(140,70,200,30);
        txtduedate.setBounds(140,130,200,30);
        lsthw.setBounds(20,180,400,400);
        gui.setVisible(true);
        mnuaddhomework.addActionListener(new addassignment());
        mnudelete.addActionListener(new deleteassignment());
        mnusave.addActionListener(new save());
        mnuopen.addActionListener(new open());
        lsthw.addListSelectionListener(new index());
    }

    static class key implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                arrassignments.get(lsthw.getSelectedIndex()).setName(txtname.getText());
                arrassignments.get(lsthw.getSelectedIndex()).setDate(new Duedate(txtduedate.getText()));
                arrassignments.get(lsthw.getSelectedIndex()).setSubject(txtsubject.getText());
                arrassignments.get(lsthw.getSelectedIndex()).setEarn(Double.valueOf(txtearned.getText()));
                arrassignments.get(lsthw.getSelectedIndex()).setTotal(Double.valueOf(txttotal.getText()));
                arrassignments.get(lsthw.getSelectedIndex()).setCategory(txtcategory.getText());
            }
            if(e.getKeyCode()==KeyEvent.VK_C){
                arrassignments.get(lsthw.getSelectedIndex()).setComplete(true);
                dlm.remove(lsthw.getSelectedIndex());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    static class index implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {
            txtname.setText(arrassignments.get(lsthw.getSelectedIndex()).getName());
            txtduedate.setText(arrassignments.get(lsthw.getSelectedIndex()).getDate().toString());
            txtsubject.setText(arrassignments.get(lsthw.getSelectedIndex()).getSubject());
            txtcategory.setText(arrassignments.get(lsthw.getSelectedIndex()).getCategory());
            txtearned.setText(String.valueOf(arrassignments.get(lsthw.getSelectedIndex()).getEarn()));
            txttotal.setText(String.valueOf(arrassignments.get(lsthw.getSelectedIndex()).getTotal()));
        }
    }

    static class addassignment implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Assignment temp = new Assignment();
            temp.setName(JOptionPane.showInputDialog("What is the name of the assignment?"));
            temp.setSubject(JOptionPane.showInputDialog("What subject is this for?"));
            temp.setDate(new Duedate(JOptionPane.showInputDialog("What is the due date?")));
            temp.setComplete(false);
            arrassignments.add(temp);
            dlm.addElement(temp.getName());
        }
    }

    static class deleteassignment implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try(PrintWriter out = new PrintWriter("C:\\Users\\Arko\\Documents\\homework start up log\\homework.txt")){
                for(int i = 0;i<arrassignments.size();i++){
                    out.println(arrassignments.get(i).toString());
                }
                out.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            openfile();
        }
    }

    public static void openfile(){
        ArrayList<String> arrin = new ArrayList<String>();
        dlm.clear();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Arko\\Documents\\homework start up log\\homework.txt"))){
            String line;
            while((line = br.readLine())!= null){
                arrin.add(line);
            }
            br.close();
        } catch (FileNotFoundException e1){
            e1.printStackTrace();
        } catch (IOException e1){
            e1.printStackTrace();
        }
        for(int i = 0;i<arrin.size();i++){
            arrassignments.add(new Assignment(arrin.get(i)));
            dlm.addElement(arrassignments.get(i).getName());
        }
    }
}
