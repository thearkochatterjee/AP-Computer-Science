import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    private static JFrame gui = new JFrame();
    private static JLabel lblmat1 = new JLabel();
    private static JLabel lblmat2 = new JLabel();
    private static JTextArea txtm1 = new JTextArea();
    private static JTextArea txtm2 = new JTextArea();
    private static Container pane = new Container();
    private static JLabel lblans = new JLabel();
    private static JTextArea txtans = new JTextArea();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnufile = new JMenu();
    private static JMenuItem mnuopen = new JMenuItem();
    private static JMenuItem mnusave = new JMenuItem();
    private static JMenuItem mnurandom = new JMenuItem();
    private static JMenu mnucalc = new JMenu();
    private static JMenuItem mnuadd = new JMenuItem();
    private static JMenuItem mnusubtract = new JMenuItem();
    private static JMenuItem mnumultply = new JMenuItem();
    private static JMenuItem mnudivide = new JMenuItem();
    private static JMenuItem mnusqr = new JMenuItem();
    private static JMenuItem mnucube = new JMenuItem();
    private static JMenuItem mnuall = new JMenuItem();
    private static JMenu mnuformat = new JMenu();
    private static JMenuItem mnuclear = new JMenuItem();
    private static JMenuItem mnuquit = new JMenuItem();
    private static matrix m1, m2;

    public static void main(String args[]){
        gui.setTitle("Matrix");
        gui.setSize(500,500);
        gui.getContentPane().add(pane);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m1 = new matrix();
        m2 = new matrix();
        pane.add(lblmat1);
        pane.add(lblmat2);
        pane.add(txtm1);
        pane.add(txtm2);
        pane.add(lblans);
        pane.add(txtans);
        mnubar.add(mnufile);
        mnufile.add(mnuopen);
        mnufile.add(mnusave);
        mnufile.add(mnurandom);
        mnubar.add(mnucalc);
        mnucalc.add(mnuadd);
        mnucalc.add(mnusubtract);
        mnucalc.add(mnumultply);
        mnucalc.add(mnudivide);
        mnucalc.add(mnusqr);
        mnucalc.add(mnucube);
        mnucalc.add(mnuall);
        mnubar.add(mnuformat);
        mnuformat.add(mnuclear);
        mnuformat.add(mnuquit);
        mnufile.setText("File");
        mnuopen.setText("Open");
        mnusave.setText("Save");
        mnurandom.setText("Random");
        mnucalc.setText("Calculate");
        mnuadd.setText("Add");
        mnusubtract.setText("Subtract");
        mnumultply.setText("Multiply");
        mnudivide.setText("Divide");
        mnusqr.setText("Square");
        mnucube.setText("Cube");
        mnuall.setText("All");
        mnuformat.setText("Format");
        mnuclear.setText("Clear");
        mnuquit.setText("Quit");
        lblmat1.setText("Matrix 1");
        lblmat2.setText("Matrix 2");
        lblans.setText("Answers");
        gui.setJMenuBar(mnubar);
        lblmat1.setBounds(20,20,100,20);
        lblmat2.setBounds(150, 20, 100, 20);
        lblans.setBounds(270,20,100,20);
        txtm1.setBounds(20,50,100,100);
        txtm2.setBounds(150,50,100,100);
        txtans.setBounds(270,50,100,100);
        gui.setVisible(true);
        mnuadd.addActionListener(new add());
        mnusubtract.addActionListener(new subtract());
        mnumultply.addActionListener(new multiply());
        mnudivide.addActionListener(new divide());
        mnusqr.addActionListener(new sqr());
        mnucube.addActionListener(new cube());
        mnuopen.addActionListener(new open());
        mnusave.addActionListener(new save());
        mnurandom.addActionListener(new random());
        mnuall.addActionListener(new all());
        mnuclear.addActionListener(new clear());
        mnuquit.addActionListener(new quit());
    }

    static class add implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            txtans.setText(m1.add(m2).toString());
        }
    }

    static class subtract implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            txtans.setText(m1.subtract(m2).toString());
        }
    }

    static class multiply implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            txtans.setText(m1.multiply(m2).toString());
        }
    }

    static class divide implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            txtans.setText(m1.divide(m2).toString());
        }
    }

    static class sqr implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            txtans.setText(m1.multiply(m1).toString());
        }
    }

    static class cube implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            txtans.setText(m1.multiply(m1.multiply(m1)).toString());
        }
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class random implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int min, max, r, c;
            min = Integer.valueOf(JOptionPane.showInputDialog("What is the minimum value of matrix 1?"));
            max = Integer.valueOf(JOptionPane.showInputDialog("What is the max value of matrix 1?"));
            r = Integer.valueOf(JOptionPane.showInputDialog("How many rows in matrix 1?"));
            c = Integer.valueOf(JOptionPane.showInputDialog("How many columns in matrix 1?"));
            m1 = new matrix(min, max, r, c);
            min = Integer.valueOf(JOptionPane.showInputDialog("What is the minimum value of matrix 2?"));
            max = Integer.valueOf(JOptionPane.showInputDialog("What is the max value of matrix 2?"));
            r = Integer.valueOf(JOptionPane.showInputDialog("How many rows in matrix 2?"));
            c = Integer.valueOf(JOptionPane.showInputDialog("How many columns in matrix 2?"));
            m2 = new matrix(min, max, r, c);
            txtm1.setText(m1.toString());
            txtm2.setText(m2.toString());
        }
    }

    static class all implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static class clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            txtans.setText("");
            txtm1.setText("");
            txtm2.setText("");
            m1 = new matrix();
            m2 = new matrix();
        }
    }

    static class quit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
        }
    }
}
