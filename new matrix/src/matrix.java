import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

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
                temp[x][y] *= 100;
                temp[x][y] = Math.round(temp[x][y]);
                temp[x][y] /= 100;
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
            double a, b, c, d, e, f, g, h, i;
            a = m.getMatrix()[0][0];
            b = m.getMatrix()[1][0];
            c = m.getMatrix()[2][0];
            d = m.getMatrix()[0][1];
            e = m.getMatrix()[1][1];
            f = m.getMatrix()[2][1];
            g = m.getMatrix()[0][2];
            h = m.getMatrix()[1][2];
            i = m.getMatrix()[2][2];
            determinant = (a * e * i) + (b *f *g) + (c *d * h) - (g *e *c) - (h*f*c) - (i*d*b);
            determinant = 1/determinant;
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
            double temp2[][] = new double[3][3];
            double a, b, c, d, e, f, g, h, u;
            a = m.getMatrix()[0][0];
            b = m.getMatrix()[1][0];
            c = m.getMatrix()[2][0];
            d = m.getMatrix()[0][1];
            e = m.getMatrix()[1][1];
            f = m.getMatrix()[2][1];
            g = m.getMatrix()[0][2];
            h = m.getMatrix()[1][2];
            u = m.getMatrix()[2][2];
            temp2[0][0] = e * u - h * f;
            temp2[1][0] = h * c - b * u;
            temp2[2][0] = b * f - e * c;
            temp2[0][1] = f * g - u * d;
            temp2[1][1] = u * a - c * g;
            temp2[2][1] = c * d - f * a;
            temp2[0][2] = d * h - g * e;
            temp2[1][2] = g * b - a * h;
            temp2[2][2] = a * e - d * b;
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

    public void openmatrix(String path){
        ArrayList<String> arrin = new ArrayList<String>();
        double temp[][] = new double[100][100];
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine())!= null){
                arrin.add(line);
            }
            br.close();
        } catch (FileNotFoundException e1){
            e1.printStackTrace();
        } catch (IOException e1){
            e1.printStackTrace();
        }
        for(int i = 0;i<arrin.size();i++){
            String parts[] = arrin.get(i).split(" ");
            for(int x = 0;x<parts.length;x++){
                temp[i][x] = Double.valueOf(parts[x]);
            }
            myc = parts.length;
        }
        myr = arrin.size();
        matrix = temp;
    }

    public void savematrix(String path){
        try(PrintWriter out = new PrintWriter(path)  ){
            String tempout = "";
            for(int i = 0;i<myr;i++){
                tempout = String.valueOf(matrix[i][0]);
                for(int x = 1;x<myr;x++){
                    tempout = tempout + " " + String.valueOf(matrix[i][x]);
                }
                out.println(tempout);
            }
            out.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
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

    public static double[][] invert(double a[][]){
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];
        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    public static void gaussian(double a[][], int index[]){
        int n = index.length;
        double c[] = new double[n];
        for(int i = 0;i<n;++i){
            index[i] = i;
        }
        for(int i = 0;i<n;++i){
            double c1 = 0;
            for(int j = 0;j<n;++j){
                double c0 = Math.abs(a[i][j]);
                if(c0>c1){
                    c1 = c0;
                }
            }
            c[i] = c1;
        }
        int k = 0;
        for(int j = 0;j<n-1;++j){
            double pi1 = 0;
            for(int i=j;i<n;++i){
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if(pi0>pi1){
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    public void usinginverse(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the dimension of square matrix: ");
        int n = input.nextInt();
        double a[][]= new double[n][n];
        System.out.println("Enter the elements of matrix: ");
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                a[i][j] = input.nextDouble();

        double d[][] = invert(a);

        System.out.println("The inverse is: ");
        for (int i=0; i<n; ++i)
        {
            for (int j=0; j<n; ++j)
            {
                System.out.print(d[i][j]+"  ");
            }
            System.out.println();
        }
        input.close();
    }
}
