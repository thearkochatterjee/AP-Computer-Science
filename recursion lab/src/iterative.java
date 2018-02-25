import javax.swing.*;

public class iterative extends calculation{

    @Override
    public int summation(int in) {
        int ans = 0;
        for(int i = 0;i<=in;i++){
            ans+=i;
        }
        return ans;
    }

    @Override
    public int expoential(int num, int pow) {
        int ans = num;
        for(int i = 1;i<pow;i++){
            ans = ans * num;
        }
        return ans;
    }

    @Override
    public int fabonacci(int in) {
        int x = 0, y = 1, z = 1;
        for (int i = 0; i < in; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }

    @Override
    public boolean isPallindrome(String in) {
        boolean pal = true;
        for(int i = 0;i<in.length();i++){
            if(in.charAt(i)!=in.charAt(in.length()-1-i)){
                pal = false;
                break;
            }
        }
        return pal;
    }

    @Override
    public int factorial(int in) {
        int fac = 1;
        for(int i = 1;i<=in;i++){
            fac *= i;
        }
        return fac;
    }

    @Override
    public int gcf(int num1, int num2) {
        int f = 0;
        for(int i = 1;i<=smaller(num1, num2);i++){
            if(((num1%i)==0)&&(num2%i)==0){
                f = i;
            }
        }
        return f;
    }

    private int smaller(int num1, int num2){
        if(num1<num2){
            return num1;
        }
        else{
            return num2;
        }
    }

    @Override
    public String reverse(String in) {
        String reverse = "";
        for(int i = in.length()-1;i>=0;i--){
            reverse += in.charAt(i);
        }
        return reverse;
    }

    @Override
    public String tobinary(int in) {
        int container[] = new int[100];
        int i = 0;
        String bi = "";
        while (in > 0){
            container[i] = in%2;
            i++;
            in = in/2;
        }
        for (int j = i -1 ; j >= 0 ; j--){
            bi += container[j];
        }
        return bi;
    }

    @Override
    public int toarabic(String in) {
        int decimal = 0;
        int n = 0;
        int binary = Integer.valueOf(in);
        while(true){
            if(binary == 0){
                break;
            } else {
                int temp = binary%10;
                decimal += temp*Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }
}
