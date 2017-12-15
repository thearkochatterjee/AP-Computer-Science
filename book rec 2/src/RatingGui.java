import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RatingGui extends Container{
    private JCheckBox chxr1 = new JCheckBox();
    private JCheckBox chxr2 = new JCheckBox();
    private JCheckBox chxr3 = new JCheckBox();
    private JCheckBox chxr4 = new JCheckBox();
    private JCheckBox chxr5 = new JCheckBox();
    private JCheckBox chxr6 = new JCheckBox();

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

        }
    }

    static class r2 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class r3 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class r4 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class r5 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    static class r6 implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }
}
