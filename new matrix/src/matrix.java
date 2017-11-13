import javax.swing.*;
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
        String part[] = m.split("\n");
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
                matrix[x][y] = Math.round(matrix[x][y]*100)/100;
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

    public boolean checkdivide(matrix m){
        return m.getMyr()==m.getMyc();
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
            ans.setMatrix(temp);
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
            ans.setMatrix(temp);
            ans.setMyc(myc);
            ans.setMyr(myr);
        }
        return ans;
    }

    public matrix multiply(matrix m){
        matrix ans = new matrix();
        double temp[][] = new double[100][100];
        if(checkmult(m)){
            for(int i = 0; i < myr; i++) {
                for (int j = 0; j < m.getMyc(); j++) {
                    for (int k = 0; k < myc; k++) {
                        temp[i][j] += matrix[i][k] * m.getMatrix()[k][j];
                    }
                }
            }
        }
        ans.setMyr(myr);
        ans.setMyc(myc);
        ans.setMatrix(temp);
        return ans;
    }

    public matrix divide(matrix m){
        matrix ans = new matrix();
        if(checkdivide(m)){
            ans  = multiply(inverse(m));
        }
        return ans;
    }

    public matrix inverse(matrix m){
        matrix ans = new matrix();
        double temp[][] = new double[100][100];
        for(int x = 0;x<100;x++){
            for(int y = 0;y<100;y++){
                temp[x][y] = 0.0;
            }
        }
//        ans.setMatrix(temp);
        ans.setMyr(m.getMyr());
        ans.setMyc(m.getMyc());
        for(int x = 0;x<m.getMyr();x++){
            for(int y = 0;y<m.getMyc();y++){
                temp[x][y] = determinant(m) * flipmatrix(m).getMatrix()[x][y];
            }
        }
        ans.setMatrix(temp);
//        temp = ans.getMatrix();
//        for(int x = 0;x<ans.getMyr();x++){
//            for(int y = 0;y<ans.getMyc();y++){
//                temp[x][y] = determinant(m) * temp[x][y];
//            }
//        }
        return ans;
    }

    public double determinant(matrix m){
        double determinant = 0.0;
        if (m.getMyc()==2){
            determinant = m.getMatrix()[0][0] * m.getMatrix()[1][1] - m.getMatrix()[0][1]*m.getMatrix()[1][0];
            determinant = 1 / determinant;
        }
        else if (m.getMyc()==3){
            double add = 0.0;
            double sub = 0.0;
            double mult[] = new double[3];
            double temp[][] = new double[5][3];
            for(int i = 0;i<3;i++){
                mult[i] = 1.0;
            }
            for(int x = 0;x<3;x++){
                for(int y = 0;y<3;y++){
                    temp[x][y] = m.getMatrix()[x][y];
                }
            }
            for(int i = 0;i<3;i++){
                temp[3][i] = m.getMatrix()[0][i];
                temp[4][i] = m.getMatrix()[1][i];
            }
            for(int x = 0;x<3;x++){
                for(int i = 0;i<3;i++){
                    mult[x] *= temp[i+x][i];
                }
                add += mult[x];
            }
            for(int x = 0;x<3;x++){
                for(int i = 0;i<3;i++){
                    mult[x] *= temp[i+x][2-i];
                }
                sub += mult[x];
            }
            determinant = add - sub;
        }
        return determinant;
    }

    public matrix flipmatrix(matrix m){
        matrix ans = new matrix();
        if (m.getMyc()==2){
            double temp[][] = new double[2][2];
            ans.setMyc(m.getMyc());
            ans.setMyr(m.getMyr());
            temp[0][0] = m.getMatrix()[1][1];
            temp[1][0] = m.getMatrix()[1][0] * -1;
            temp[0][1] = m.getMatrix()[0][1] * -1;
            temp[1][1] = m.getMatrix()[0][0];
            ans.setMatrix(temp);
        }
        else if(m.getMyc()==3){
            double temp[][] = new double[5][5];
            double temp2[][] = new double[3][3];
            for(int x = 0;x<3;x++){
                for(int y = 0;y<3;y++){
                    temp[x][y] = m.getMatrix()[x][y];
                }
            }
            for(int i = 0;i<3;i++){
                temp[3][i] = m.getMatrix()[0][i];
                temp[4][i] = m.getMatrix()[1][i];
            }
            for(int i = 0;i<5;i++){
                temp[i][3] = temp[i][0];
                temp[i][4] = temp[i][1];
            }
            for(int x = 1;x<4;x++){
                for(int i = 1;i<4;i++){
                    temp2[i-1][x-1] = temp[i][x] * temp[i+1][x+1] - temp[i+1][x] * temp[x+1][i];
                }
            }
            ans.setMatrix(temp2);
        }
        return ans;
    }

    public matrix scalarmultiply(double scalar){
        double temp[][] = new double[100][100];
        matrix ans = new matrix();
        temp = matrix;
        for(int x = 0;x<myr;x++){
            for(int y = 0;y<myc;y++){
                temp[x][y] *= scalar;
            }
        }
        ans.setMatrix(temp);
        ans.setMyc(myc);
        ans.setMyr(myr);
        return ans;
    }

    public String toString(){
        String out = "";
        for(int x = 0;x<myr;x++){
            out += matrix[x][0];
            for(int y = 1;y<myc;y++){
                out += " " + matrix[x][y];
            }
            out += "\n";
        }
        return out;
    }
}
