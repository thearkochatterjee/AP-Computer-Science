import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JFrame {
    private JMenuBar mnubar = new JMenuBar();
    private JMenu mnufile = new JMenu();
    private JMenuItem mnuopen = new JMenuItem();

    public MainGui(){
        setSize(500,500);
        setTitle("Text Analyzer");
        getContentPane().add(new MainPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(mnubar);
        mnubar.add(mnufile);
        mnufile.add(mnuopen);
        mnufile.setText("File");
        mnuopen.setText("Open");
        setVisible(true);
        mnuopen.addActionListener(new open());
    }

    static class open implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
