import javax.swing.*;

public class MainGui extends JFrame {
    private JMenuBar mnubar = new JMenuBar();
    private JMenu mnufile = new JMenu();
    private JMenuItem mnuopen = new JMenuItem();

    public MainGui(){
        setSize(500,500);
        setTitle("Text Analyzer");
        getContentPane().add(new MainPane());
        setJMenuBar(mnubar);
        mnubar.add(mnufile);
        mnufile.add(mnuopen);
        mnufile.setText("File");
        mnuopen.setText("Open");
        setVisible(true);
    }
}
