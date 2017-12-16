import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RatingGui extends Container{
    private static JCheckBox chxr1 = new JCheckBox();
    private static JCheckBox chxr2 = new JCheckBox();
    private static JCheckBox chxr3 = new JCheckBox();
    private static JCheckBox chxr4 = new JCheckBox();
    private static JCheckBox chxr5 = new JCheckBox();
    private static JCheckBox chxr6 = new JCheckBox();
    private static int rating = 0;

    public RatingGui(){
        setLayout(new GridLayout(6,1));
        add(chxr1);
        add(chxr2);
        add(chxr3);
        add(chxr4);
        add(chxr5);
        add(chxr6);
        chxr1.setText("Loved it");
        chxr2.setText("Liked it");
        chxr3.setText("OK");
        chxr4.setText("Didn't like it");
        chxr5.setText("Hate it");
        chxr6.setText("Didn't read it");
        chxr1.addItemListener(new r1());
        chxr2.addItemListener(new r2());
        chxr3.addItemListener(new r3());
        chxr4.addItemListener(new r4());
        chxr5.addItemListener(new r5());
        chxr6.addItemListener(new r6());
    }

    static class r1 implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            chxr2.setSelected(false);
            chxr3.setSelected(false);
            chxr4.setSelected(false);
            chxr5.setSelected(false);
            chxr6.setSelected(false);
        }
    }

    static class r2 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            chxr1.setSelected(false);
            chxr3.setSelected(false);
            chxr4.setSelected(false);
            chxr5.setSelected(false);
            chxr6.setSelected(false);
        }
    }

    static class r3 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            chxr1.setSelected(false);
            chxr2.setSelected(false);
            chxr4.setSelected(false);
            chxr5.setSelected(false);
            chxr6.setSelected(false);
        }
    }

    static class r4 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            chxr1.setSelected(false);
            chxr2.setSelected(false);
            chxr3.setSelected(false);
            chxr5.setSelected(false);
            chxr6.setSelected(false);
        }
    }

    static class r5 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            chxr1.setSelected(false);
            chxr2.setSelected(false);
            chxr3.setSelected(false);
            chxr4.setSelected(false);
            chxr6.setSelected(false);
        }
    }

    static class r6 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            chxr1.setSelected(false);
            chxr2.setSelected(false);
            chxr3.setSelected(false);
            chxr4.setSelected(false);
            chxr5.setSelected(false);
        }
    }

    public static int getRating() {
        return rating;
    }
}
