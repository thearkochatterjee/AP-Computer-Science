public class Amorttable {
    double purchaseprice, yrate, mrate, years;

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

    public void oldamorttable(){
        double p = 0;
        double monthlypayment = 0;
        double ti = 0;
        double ca = 0;
        double mi = 0;
        mrate = yrate / 12;
        p = years * 12;
        monthlypayment = (years * mrate / (1 - Math.pow(1 + mrate, -p)));
        for(int pn = 0; pn<p;pn++){
            mi = ca * mrate;
            ti += mi;
        }
    }

    public void vbamort(){
        double a, mp, emp, yrate, mrate, y, p, pn, mprin, mi, ti, ca, yn, sd;
        String DispLine;
        int sm;
        String lastname[] = new String[20];
        double pricelist[] = new double[100];
//        a = Val(txta)
//        yrate = Val(txtyrate)
//        y = Val(txty)
//        emp = Val(txtemp)
        yn = 1;
        mrate = yrate / 1200;
        p = y * 12;
        mp = (a * mrate / (1 - (1 + mrate) ^ (-p))) + emp;
        ti = 0;
        ca = a;
        For pn = 1 To p
        mi = ca * mrate;
        ti = ti + mi;
        ca = ca + mi - mp - emp;
        yn = pn / 12;
        If pn Mod 12 = 0 Then
                yn = (pn / 12) - 1;
        End If
        mprin = mp - mi;
        If ca >= mp Then
        DispLine = "    " & Format(pn, "####")
        DispLine = DispLine & "    " & Format(yn + 1, "#0")
        DispLine = DispLine & "    " & Format(ca, "Currency")
        DispLine = DispLine & "    " & Format(ti, "Currency")
        DispLine = DispLine & "    " & Format(mi, "Currency")
        DispLine = DispLine & "    " & Format(mprin, "Currency")
        amorttable(pn) = DispLine
        Else
                mi = ca * mrate;
        ti = ti + mi;
        mprin = ca;
        ca = 0;
        DispLine = "    " & Format(pn, "####")
        DispLine = DispLine & "    " & Format(yn + 1, "#0")
        DispLine = DispLine & "    " & Format(ca, "Currency")
        DispLine = DispLine & "    " & Format(ti, "Currency")
        DispLine = DispLine & "    " & Format(mi, "Currency")
        DispLine = DispLine & "    " & Format(mprin, "Currency")
        amorttable(pn) = DispLine
        Exit For
        End If
        Next pn
        sm = p - (yn * 12)
        sd = sm * mrate
        lblsm.Caption = sm
        lblsd.Caption = Format(sd, "Currency")
        hsbp.Min = 1
        If emp = 0 Then
        hsbp.Max = p
        Else
        hsbp.Max = p - sm
        End If
        hsbp.LargeChange = 12
        hsbp.Value = 1
        txtamorttable = amorttable(1)
    }

    public void everything(){

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
        for(int i = 0;i<amountofmonths();i++){

        }
        return ans;
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

    public double[] remaining(){
        double ans[] = new double[amountofmonths()];

        return ans;
    }

    public double downpayment(){
        double ans = 0.0;
        ans = 0.1 * purchaseprice;
        return ans;
    }
}
