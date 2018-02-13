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
        return 0;
    }
}
