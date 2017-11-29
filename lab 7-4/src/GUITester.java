import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITester {
    //page 318
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static JMenuBar mnubar = new JMenuBar();
    private static JMenu mnucalculate = new JMenu();
    private static JMenuItem mnucalc = new JMenuItem();
    private static JTextArea txtout = new JTextArea();
    private static JScrollPane scrout = new JScrollPane();

    public static void main(String args[]){
        gui.setTitle("Lab 7.4");
        gui.setSize(600,500);
        txtout.setBounds(20,20,560,400);
        scrout.setViewportView(txtout);
        gui.getContentPane().add(pane);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mnubar.add(mnucalculate);
        mnucalculate.add(mnucalc);
        gui.setJMenuBar(mnubar);
        mnucalculate.setText("Calculations");
        mnucalc.setText("Calculate");
        pane.add(scrout);
        scrout.setBounds(20,20,560,400);
        gui.setVisible(true);
        mnucalc.addActionListener(new calc());
    }

    static class calc implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            double purchasepricae = 0.0;
            double ctbalence[] = new double[100000];
            double interest[] = new double[100000];
            double pricipal[] = new double[100000];
            double payment = 0.0;
            double remain[] = new double[100000];
            for(int i = 0;i<100000;i++){
                ctbalence[i] = 0.0;
                interest[i] = 0.0;
                pricipal[i] = 0.0;
                remain[i] = 0.0;
            }
            Amorttable table = new Amorttable();
            purchasepricae = Double.valueOf(JOptionPane.showInputDialog("What is the purchase price?"));
            table.setPurchaseprice(purchasepricae);
            table.setAnnualinterestrate(0.12);
            table.everything();
            //ctbalence = table.balenceowned();
            interest = table.getArrinterest();
            pricipal = table.getAmountofprincipal();
            payment = table.payment();
            remain = table.getRemaining();
            interest = table.roundvalues(interest);
            pricipal = table.roundvalues(pricipal);
            remain = table.roundvalues(remain);
            for(int i = 1;i<remain.length-1;i++){
                ctbalence[i] = remain[i-1];
            }
            txtout.setText("Month Number | Current Balance | Interest | Principal | Payment | Remaining\n");
            System.out.println("Month Number | Current Balance | Interest | Principal | Payment | Remaining");
            for(int i = 1;i<table.getNummonths()+1;i++){
                if(i==table.getNummonths()){
                    payment = remain[i-1];
                    remain[i] = 0.0;
                }
                System.out.format("%6d %20.2f %12.2f %10.2f %10.2f %10.2f%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]);
                if(i<10){
                    txtout.setText(txtout.getText()+String.format("%6d %30.2f %12.2f %10.2f %10.2f %10.2f%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]));
                }
                else{
                    txtout.setText(txtout.getText()+String.format("%5d %30.2f %12.2f %10.2f %10.2f %10.2f%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]));
                }
            }
        }
    }
}
