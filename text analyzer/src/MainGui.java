import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
            open("src/assets/Gettysburg.txt");
        }
    }

    private static void open(String path){
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                text += " " + line.trim();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
