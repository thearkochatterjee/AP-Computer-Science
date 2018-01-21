public class ValueRounding {
    private double value = 0.0;

    public ValueRounding(){
        value = 0.0;
    }

    public ValueRounding(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double roundtodecnum(int num){
        double v = value * Math.pow(10,num);
        v = Math.round(v);
        v = v / Math.pow(10,num);
        return v;
    }
}
