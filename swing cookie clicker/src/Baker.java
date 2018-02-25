public class Baker {
    private int rate = 1;
    private boolean bought = false;
    private int interval = 10000;

    public Baker(){

    }

    public Baker(boolean bought, int rate, int interval){

    }

    public Baker(String line){

    }

    public void bought(){
        rate++;
    }

    public void sell(){
        rate--;
    }

    public void speed(int factor){
        interval = interval / factor;
    }

    public void restorespeed(){
        interval = 10000;
    }

    public int getInterval() {
        return interval;
    }

    public int getRate() {
        return rate;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
