public class Amorttable {
    double purchaseprice, totalinterest;
    double remaining[] = new double[100000];
    double annualinterestrate = 0.0;
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

    public void everything(){
        double left = purchaseprice;
        double interest = 0.0;
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
            remaining[nummonths] = left;
        }while (left<=0.0);
    }

    public double[] amountofprincipal(){
        double ans[] = new double[amountofmonths()];

        return ans;
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
}
