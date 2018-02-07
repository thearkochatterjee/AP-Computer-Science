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
}
