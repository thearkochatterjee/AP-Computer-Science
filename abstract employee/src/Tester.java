import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tester {
    public static void main(String args[]){
//        String again = "";
//        int numemps = 0;
//        Scanner reader = new Scanner(System.in);
//        ArrayList<Emp> arremps = new ArrayList<Emp>();
        new Gui();
//        do{
//            Random r = new Random();
//            ValueRounding vhr = new ValueRounding();
//            ValueRounding vwage = new ValueRounding();
//            ValueRounding vunion = new ValueRounding();
//            arremps.clear();
//            System.out.println("How many employees do you have?");
//            numemps = reader.nextInt();
//            for(int i = 0;i<numemps;i++){
//                vhr.setValue(r.nextDouble()*1000+1);
//                vwage.setValue(r.nextDouble()*1000+1);
//                vunion.setValue(vwage.getValue()*.05);
//                boolean fulltime = false;
//                fulltime = r.nextBoolean();
//                if(fulltime){
//                    arremps.add(new FTEmp(i+1, vhr.roundtodecnum(2), vwage.roundtodecnum(2), vunion.roundtodecnum(2)));
//                }
//                else{
//                    arremps.add(new PTEmp(i+1, vhr.roundtodecnum(2), vwage.roundtodecnum(2), r.nextInt(4)+1));
//                }
//            }
//            System.out.println("Part Time");
//            for(Emp e: arremps){
//                if(e instanceof PTEmp){
//                    System.out.println(e.toString());
//                }
//            }
//            System.out.println("Full Time");
//            for(Emp e: arremps){
//                if(e instanceof FTEmp){
//                    System.out.println(e.toString());
//                }
//            }
////            again = JOptionPane.showInputDialog("Run again?").toLowerCase().trim();
//        }while (again.equals("yes"));
    }
}
