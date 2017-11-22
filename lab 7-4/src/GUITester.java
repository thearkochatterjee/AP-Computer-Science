import javax.swing.*;

public class GUITester {
    //page 318
    public static void main(String args[]){
        String again = "";
        do {
            double purchasepricae = 0.0;
            Amorttable table = new Amorttable();
            purchasepricae = Double.valueOf(JOptionPane.showInputDialog("What is the purchase price?"));
            table.setPurchaseprice(purchasepricae);
            double ctbalence[] = new double[table.amountofmonths()];
            double interest[] = new double[table.amountofmonths()];
            double pricipal[] = new double[table.amountofmonths()];
            double payment[] = new double[table.amountofmonths()];
            double remain[] = new double[table.amountofmonths()];
            ctbalence = table.balenceowned();
            interest = table.interestowned();
            pricipal = table.amountofprincipal();
            payment = table.payment();
            remain = table.remaining();
            for(int i = 0;i<table.amountofmonths();i++){
                System.out.format("%-5s %20s %11s %16s %19s %12s%n", i, ctbalence[i], interest[i], pricipal[i], payment[i], remain[i]);
            }
            again = JOptionPane.showInputDialog("Do you want to run again?")
        }while (again.equals("yes"))
    }
}
