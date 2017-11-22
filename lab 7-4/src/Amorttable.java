public class Amorttable {
    double purchaseprice;

    public Amorttable(){
        purchaseprice = 0;
    }

    public Amorttable(double purchaseprice){
        this.purchaseprice = purchaseprice;
    }

    public double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public int amountofmonths(){
        int nummonths = 0;

        return nummonths;
    }

    public double[] balenceowned(){
        double ans[] = new double[amountofmonths()];
        ans[0] = purchaseprice * 1.1;
        for(int i = 1;i<amountofmonths();i++){

        }
        return ans;
    }

    public double[] interestowned(){
        double ans[] = new double[amountofmonths()];

        return ans;
    }

    public double[] amountofprincipal(){
        double ans[] = new double[amountofmonths()];

        return ans;
    }

    public double[] payment(){
        double ans[] = new double[amountofmonths()];

        return ans;
    }

    public double[] remaining(){
        double ans[] = new double[amountofmonths()];

        return ans;
    }
}
