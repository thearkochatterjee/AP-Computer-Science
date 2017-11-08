import java.util.ArrayList;
import java.util.Random;

public class matrix {
    private double matrix[][] = new double[100][100];
    private int myr, myc;

    public matrix(){
        myr = 0;
        myc = 0;
        for(int x = 0;x<100;x++){
            for(int y = 0;y<10;y++){
                matrix[x][y] = 0.0;
            }
        }
    }

    public matrix(String m){
        String part[] = m.split("\\n");
        for(int i = 0;i<part.length;i++){
            String elements[] = part[i].split(" ");
            for(int c = 0;c<elements.length;c++){
                matrix[i][c] = Double.valueOf(elements[c]);
            }
            myr = elements.length;
        }
        myc = part.length;
    }

    public matrix(int min, int max, int myr, int myc){
        this.myc = myc;
        this.myr = myr;
        Random r = new Random();
        for(int x=0;x<myr;x++){
            for(int y = 0;y<myc;y++){
                matrix[x][y] = Math.abs(max - min)*r.nextDouble() + min;
            }
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public int getMyc() {
        return myc;
    }

    public int getMyr() {
        return myr;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public void setMyc(int myc) {
        this.myc = myc;
    }

    public void setMyr(int myr) {
        this.myr = myr;
    }

    public boolean checkadd(matrix m){
        return myr == m.getMyr() && myc == m.getMyc();
    }

    public boolean checkmult(matrix m){
        return myr == m.getMyc();
    }

    public boolean checkdivide(){
        return myr == myc;
    }

    public matrix add(matrix m){
        matrix ans = new matrix();
        double temp[][] = new double[100][100];
        for(int x = 0;x<100;x++){
            for(int y = 0;y<100;y++){
                temp[x][y] = 0.0;
            }
        }
        if (checkadd(m)){
            for(int x = 0;x<myc;x++){
                for(int y = 0;y<myr;y++){
                    temp[x][y] = matrix[x][y] + m.getMatrix()[x][y];
                }
            }
            ans.setMyc(myc);
            ans.setMyr(myr);
        }
        return ans;
    }

    public matrix subtract(matrix m){
        matrix ans = new matrix();
        double temp[][] = new double[100][100];
        for(int x = 0;x<100;x++){
            for(int y = 0;y<100;y++){
                temp[x][y] = 0.0;
            }
        }
        if (checkadd(m)){
            for(int x = 0;x<myc;x++){
                for(int y = 0;y<myr;y++){
                    temp[x][y] = matrix[x][y] - m.getMatrix()[x][y];
                }
            }
            ans.setMyc(myc);
            ans.setMyr(myr);
        }
        return ans;
    }

    public matrix multiply(matrix m){
        matrix ans = new matrix();
        if(checkmult(m)){

        }
        return ans;
    }

    public matrix divide(matrix m){
        matrix ans = new matrix();
        if(checkdivide()){
            ans  = multiply(inverse(m));
        }
        return ans;
    }

    public matrix inverse(matrix m){
        matrix ans = new matrix();
        double temp[][] = new double[100][100];
        for(int i = 0;i<100;i++){
            temp[i][i] = 1;
        }
        ans.setMatrix(temp);
        ans.setMyr(myr);
        ans.setMyc(myc);
        ans = multiply(ans);
        temp = ans.getMatrix();
        for(int x = 0;x<ans.setMyr();x++){
            for(int y = 0;y<ans.setMyc();y++){
                temp[x][y] = determinant(m) * temp[x][y];
            }
        }
        ans.setMatrix(temp);
        return ans;
    }

    public double determinant(matrix m){

    }

    public String toString(){
        String out = "";

        return out;
    }
}
