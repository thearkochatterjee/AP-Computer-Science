import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{
    private MainPane pane = new MainPane();
    private JMenuBar mnubar = new JMenuBar();
    private JMenu mnucalculation = new JMenu();
    private JMenuItem mnufabancci = new JMenuItem();
    private JMenuItem mnusummation = new JMenuItem();
    private JMenuItem mnuexponent = new JMenuItem();
    private JMenuItem mnufactorial = new JMenuItem();
    private JMenuItem mnupal = new JMenuItem();
    private JMenuItem mnugcf = new JMenuItem();
    private JMenuItem mnureverse = new JMenuItem();
    private JMenuItem mnutobinary = new JMenuItem();
    private JMenuItem mnutoarabic = new JMenuItem();

    public Gui(){
        setTitle("Recursion");
        setSize(250,300);
        setJMenuBar(mnubar);
        getContentPane().add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mnubar.add(mnucalculation);
        mnucalculation.add(mnufabancci);
        mnucalculation.add(mnusummation);
        mnucalculation.add(mnuexponent);
        mnucalculation.add(mnufactorial);
        mnucalculation.add(mnugcf);
        mnucalculation.add(mnupal);
        mnucalculation.add(mnureverse);
        mnucalculation.add(mnutoarabic);
        mnucalculation.add(mnutobinary);
        mnucalculation.setText("Calculations");
        mnuexponent.setText("Exponential");
        mnufabancci.setText("Fabancci");
        mnugcf.setText("GCF");
        mnupal.setText("Palindrome");
        mnufactorial.setText("Factorial");
        mnusummation.setText("Summation");
        mnureverse.setText("Reverse");
        mnutobinary.setText("To Binary");
        mnutoarabic.setText("To Arabic");
        setVisible(true);
        mnufactorial.addActionListener(new factorial());
        mnufabancci.addActionListener(new fab());
        mnusummation.addActionListener(new summation());
        mnupal.addActionListener(new pal());
        mnugcf.addActionListener(new gcf());
        mnuexponent.addActionListener(new exponent());
        mnureverse.addActionListener(new reverse());
        mnutoarabic.addActionListener(new arabic());
        mnutobinary.addActionListener(new binary());
    }

    class arabic implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            pane.output(c1.toarabic(pane.getTxtin().getText()), c2.toarabic(pane.getTxtin().getText()));
        }
    }

    class binary implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            int val = Integer.valueOf(pane.getTxtin().getText());
            pane.output(c1.tobinary(val), c2.tobinary(val));
        }
    }

    class reverse implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            pane.output(c1.reverse(pane.getTxtin().getText()), c2.reverse(pane.getTxtin().getText()));
        }
    }

    class fab implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            int val = Integer.valueOf(pane.getTxtin().getText());
            pane.output(c1.fabonacci(val), c2.fabonacci(val));
        }
    }

    class exponent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            int val = Integer.valueOf(pane.getTxtin().getText().split(",")[0]);
            int pow = Integer.valueOf(pane.getTxtin().getText().split(",")[1]);
            pane.output(c1.expoential(val, pow), c2.expoential(val, pow));
        }
    }

    class gcf implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            int num1 = Integer.valueOf(pane.getTxtin().getText().split(",")[0]);
            int num2 = Integer.valueOf(pane.getTxtin().getText().split(",")[1]);
            pane.output(c1.gcf(num1, num2), c2.gcf(num1, num2));
        }
    }

    class pal implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            String in = pane.getTxtin().getText();
            pane.output(c1.isPallindrome(in), c2.isPallindrome(in));
        }
    }

    class factorial implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            int val = Integer.valueOf(pane.getTxtin().getText());
            pane.output(c1.factorial(val), c2.factorial(val));
        }
    }

    class summation implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculation c1 = new iterative();
            calculation c2 = new recursive();
            int val = Integer.valueOf(pane.getTxtin().getText());
            pane.output(c1.summation(val), c2.summation(val));
        }
    }
}
