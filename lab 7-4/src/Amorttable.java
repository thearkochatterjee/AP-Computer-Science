import javax.swing.*;

public class Amorttable {
    double purchaseprice, totalinterest;
    double remaining[] = new double[100000];
    double annualinterestrate = 0.0;
    double amountofprincipal[] = new double[100000];
    double arrinterest[] = new double[100000];
    int nummonths = 0;

    public Amorttable(){
        purchaseprice = 0;
    }

    public Amorttable(double purchaseprice, double annualinterestrate){
        this.purchaseprice = purchaseprice;
    }

    public double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public double getAnnualinterestrate() {
        return annualinterestrate;
    }

    public void setAnnualinterestrate(double annualinterestrate) {
        this.annualinterestrate = annualinterestrate;
    }

    public double getTotalinterest() {
        return totalinterest;
    }

    public double[] getRemaining() {
        return remaining;
    }

    public int getNummonths() {
        return nummonths;
    }

    public double[] getAmountofprincipal() {
        return amountofprincipal;
    }

    public double[] getArrinterest() {
        return arrinterest;
    }

    public void everything(){
        double left = 0.0;
        double interest = 0.0;
        left = purchaseprice - downpayment();
        remaining[0] = left;
        do{
            if(nummonths%12==0){
                if(nummonths!=0){
                    interest = left * (1 + annualinterestrate);
                    totalinterest = totalinterest + interest;
                    left = left + interest;
                }
            }
            nummonths++;
            left = left - payment();
            //JOptionPane.showMessageDialog(null,left);
            remaining[nummonths] = left;
            amountofprincipal[nummonths] = payment() - interest;
            arrinterest[nummonths] = interest;
        }while (left>=0.0);
    }

    public double payment(){
        double ans = 0.0;
        ans = 0.05 * (purchaseprice - downpayment());
        return ans;
    }

    public double downpayment(){
        double ans = 0.0;
        ans = 0.1 * purchaseprice;
        return ans;
    }

    public double[] roundvalues(double values[]){
        double ans[] = new double[values.length];
        for(int i = 0;i<values.length;i++){
            ans[i] = values[i] * 100;
            ans[i] = Math.round(ans[i]);
            ans[i] = ans[i]/100;
        }
        return ans;
    }
}
