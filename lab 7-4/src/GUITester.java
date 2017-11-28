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

    public static void main(String args[]){
        gui.setTitle("Lab 7.4");
        gui.getContentPane().add(pane);
        mnubar.add(mnucalculate);
        mnucalculate.add(mnucalc);
        gui.setJMenuBar(mnubar);
        mnucalc.addActionListener(new calc());
    }

    static class calc implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            double purchasepricae = 0.0;
            Amorttable table = new Amorttable();
            purchasepricae = Double.valueOf(JOptionPane.showInputDialog("What is the purchase price?"));
            table.setPurchaseprice(purchasepricae);
            table.everything();
            double ctbalence[] = new double[table.getNummonths()];
            double interest[] = new double[table.getNummonths()];
            double pricipal[] = new double[table.getNummonths()];
            double payment = 0.0;
            double remain[] = new double[table.getNummonths()];
            ctbalence = table.balenceowned();
            interest = table.interestowned();
            pricipal = table.amountofprincipal();
            payment = table.payment();
            remain = table.remaining();
            for(int i = 0;i<table.amountofmonths();i++){
                System.out.format("%-5s %20s %11s %16s %19s %12s%n", i, ctbalence[i], interest[i], pricipal[i], payment, remain[i]);
            }
        }
    }
}
