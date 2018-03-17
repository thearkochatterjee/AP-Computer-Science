import javax.swing.*;

public class MainWindow extends JFrame{
    private MainPane pane = new MainPane();
    public MainWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Elevens");
        setSize(500,500);
        getContentPane().add(pane);
        setVisible(true);

    }
}
