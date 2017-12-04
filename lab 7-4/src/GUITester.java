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
    private static JMenuItem mnuclear = new JMenuItem();
    private static JMenuItem mnuquit = new JMenuItem();
    private static JTextArea txtout = new JTextArea();
    private static JScrollPane scrout = new JScrollPane();

    public static void main(String args[]){
        gui.setTitle("Lab 7.4");
        gui.setSize(800,500);
        txtout.setBounds(20,20,760,400);
        scrout.setViewportView(txtout);
        gui.getContentPane().add(pane);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mnubar.add(mnucalculate);
        mnucalculate.add(mnucalc);
        mnucalculate.add(mnuclear);
        mnucalculate.add(mnuquit);
        gui.setJMenuBar(mnubar);
        mnucalculate.setText("Calculations");
        mnucalc.setText("Calculate");
        mnuclear.setText("Clear");
        mnuquit.setText("Quit");
        pane.add(scrout);
        scrout.setBounds(20,20,760,400);
        gui.setVisible(true);
        mnucalc.addActionListener(new calc());
        mnuclear.addActionListener(new clear());
        mnuquit.addActionListener(new quit());
    }

    static class quit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
        }
    }

    static class clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            txtout.setText("");
        }
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
            int sepbalence = 0;
            int sepint = 0;
            int sepprin = 0;
            int seppay = 0;
            int seprem = 0;
            for(int i = 1;i<table.getNummonths()+1;i++){
                if(i==table.getNummonths()){
                    payment = remain[i-1];
                    remain[i] = 0.0;
                }
                System.out.format("%6d %20.2f %12.2f %10.2f %10.2f %10.2f%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]);
//                sepbalence = String.valueOf(ctbalence[i]).indexOf(".") +30;
//                sepint = String.valueOf(interest[i]).indexOf(".") +20;
//                sepprin = String.valueOf(pricipal[i]).indexOf(".") +10;
//                seppay = String.valueOf(payment).indexOf(".") +10;
//                seprem = String.valueOf(remain[i]).indexOf(".") +10;
//                txtout.setText(txtout.getText()+String.format(Locale.ROOT,"%6d%" + sepbalence +".2f %" + sepint + ".2f %" + sepprin + ".2f %" + seppay +".2f %" + seprem+".2f%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]));
                //txtout.setText(txtout.getText()+String.format("%6s \t%10s \t%20s \t%10s \t%10s \t%10s%n", String.valueOf(i).trim(), String.valueOf(ctbalence[i]).trim(), String.valueOf(interest[i]).trim(), String.valueOf(pricipal[i]).trim(), String.valueOf(payment).trim(), String.valueOf(remain[i]).trim()));
//                if(i<10){
//                    txtout.setText(txtout.getText()+String.format("%6d %30.2f %25.2f %10.2f %10.2f %15.2f%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]));
//                }
//                else{
//                    txtout.setText(txtout.getText()+String.format("%5d %30.2f %25.2f %10.2f %10.2f %15.2f%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]));
//                }
                txtout.setFont(new Font("monospaced", Font.PLAIN, 16));
                txtout.append(String.format("%6d %20.2f %12.2f %10.2f %10.2f %10.2f%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]));
            }
        }
    }
}
