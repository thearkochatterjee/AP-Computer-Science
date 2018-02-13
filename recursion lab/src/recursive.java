public class recursive extends calculation{

    @Override
    public int summation(int in) {
        if(in==0){
            return 0;
        }
        else{
            return in + summation(in-1);
        }
    }

    @Override
    public int expoential(int num, int pow) {
        if(pow==0){
            return 1;
        }
        else{
            return num * expoential(num, pow-1);
        }
    }

    @Override
    public int fabonacci(int in) {
        if((in==1)||(in==0)){
            return in;
        }
        else{
            return fabonacci(in-1) + fabonacci(in-2);
        }
    }

    @Override
    public boolean isPallindrome(String in) {
        if(in.length()==0||in.length()==1){
            return true;
        }
        else if (in.charAt(0)==in.charAt(in.length()-1)){
            return isPallindrome(in.substring(1,in.length()-1));
        }
        else{
            return false;
        }
    }

    @Override
    public int factorial(int in) {
        if(in == 1){
            return 1;
        }
        else {
            return in *  factorial(in - 1);
        }
    }

    @Override
    public int gcf(int num1, int num2) {
        return 0;
    }
}
