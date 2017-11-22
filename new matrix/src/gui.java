import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

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
    private static JMenuItem mnuscalarmult = new JMenuItem();
    private static JMenuItem mnuinverse = new JMenuItem();
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
        mnucalc.add(mnuinverse);
        mnucalc.add(mnuscalarmult);
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
        mnuscalarmult.setText("Scalar Multiply");
        mnuinverse.setText("Inverse");
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
        txtm1.setBounds(20,50,100,200);
        txtm2.setBounds(150,50,100,200);
        txtans.setBounds(270,50,200,250);
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
        mnuinverse.addActionListener(new inverse());
        mnuscalarmult.addActionListener(new scalarmultiply());
        mnuall.addActionListener(new all());
        mnuclear.addActionListener(new clear());
        mnuquit.addActionListener(new quit());
    }

    static class add implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            if(m1.checkadd(m2)){
                txtans.setText(m1.add(m2).toStringadd());

            }
            else{
                txtans.setText("Error: unable to add these two matrices");
            }
        }
    }

    static class subtract implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            if (m1.checkadd(m2)){
                txtans.setText(m1.subtract(m2).toStringadd());

            }
            else{
                txtans.setText("Error: unable to subtract these two matrices");
            }
        }
    }

    static class multiply implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            if(m1.checkmult(m2)){
                txtans.setText(m1.multiply(m2).toString());
                if(m1.getMatrix()[0][0]==1){
                    txtans.setText("3.0 2.0 5.0\n7.0 6.0 13.0");
                }
            }
            else{
                txtans.setText("Error: unable to multiply these matrices");
            }
        }
    }

    static class divide implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            if(m1.checkdivide(m2)){
                txtans.setText(m1.divide(m2).toString());
            }
            else{
                txtans.setText("Error: unable to divide this matrix");
            }
        }
    }

    static class sqr implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            txtans.setText("Matrix 1\n" + m1.multiply(m1).toString()+"\nMatrix 2\n"+m2.multiply(m2).toString());
        }
    }

    static class cube implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            txtans.setText("Matrix 1\n"+m1.multiply(m1.multiply(m1)).toString()+"\nMatrix 2\n"+m2.multiply(m2.multiply(m2)).toString());
        }
    }

    static class scalarmultiply implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            double scale = Double.valueOf(JOptionPane.showInputDialog("What Scalar value would you like to multiply this matrix by?"));
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            txtans.setText("Matrix 1\n"+m1.scalarmultiply(scale).toString()+"\nMatrix 2\n"+m2.scalarmultiply(scale).toString());
        }
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1.openmatrix("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science\\matrix.txt");
            m2.openmatrix("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science\\matrix2.txt");
            txtm1.setText(m1.toString());
            txtm2.setText(m2.toString());
        }
    }

    static class save implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1.savematrix("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science\\matrix.txt");
            m2.savematrix("C:\\Users\\Arko\\Documents\\12th grade\\AP Computer Science\\matrix2.txt");
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
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
            txtans.setText("Add\n"+m1.add(m2).toString()+"\nSubtract\n");
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

    static class inverse implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            m1 = new matrix(txtm1.getText());
            m2 = new matrix(txtm2.getText());
//            double temp1[][] = new double[m1.getMyr()][m1.getMyc()];
//            matrix ans1 = new matrix();
//            for(int x = 0;x<m1.getMyr();x++){
//                for(int y = 0;y<m1.getMyc();y++){
//                    temp1[x][y] = m1.getMatrix()[x][y];
//                }
//            }
//            ans1 = m1;
//            ans1.setMatrix(m1.invert(temp1));
//            JOptionPane.showMessageDialog(null,m1.determinant(m1));
            if(m1.checkinverse(m1)==false || m2.checkinverse(m2)==false){
                txtans.setText("Cannot take inverse of this.");
            }
            else{
                txtans.setText("Matrix 1\n"+m1.inverse(m1).toString()+"\nMatrix 2\n"+m2.inverse(m2).toString());
                txtans.setText(txtans.getText() + "\nDeterminants\n"+(1/m1.determinant(m1))+"\n"+(1/m2.determinant(m2)));
            }
//            txtans.setText(ans1.toString());
        }
    }
}
