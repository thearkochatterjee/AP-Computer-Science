import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui{
    private static JFrame gui = new JFrame();
    private static Container pane = new Container();
    private static JCheckBox chxcheck = new JCheckBox();

    public static void main(String args[]){
        gui.setTitle("CheckBoxes");
        gui.getContentPane().add(pane);
        gui.setSize(500,500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.add(chxcheck);
        chxcheck.setBounds(20,20,100,30);
        chxcheck.setText("check");
        gui.setVisible(true);
        chxcheck.addItemListener(new check());
    }

    static class check implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(chxcheck.isSelected()){
                chxcheck.setText("is checked");
            }
            else{
                chxcheck.setText("is not checked");
            }
        }
    }
}
