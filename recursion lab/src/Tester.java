import javax.swing.*;

public class Tester {
    public static void main(String args[]){
        calculation c = new iterative();
        int sum = Integer.valueOf(JOptionPane.showInputDialog("What do you want to find the sum of?"));
        System.out.println(c.fabonacci(sum));
        System.out.println(c.summation(sum));
        System.out.println(c.expoential(sum, 4));
    }
}
