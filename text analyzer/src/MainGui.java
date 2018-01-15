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
    private static MainPane pane = new MainPane();
    private static TextAnalyzer textAnalyzer = new TextAnalyzer();

    public MainGui(){
        setSize(500,500);
        setTitle("Text Analyzer");
        getContentPane().add(pane);
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
            switch (Integer.valueOf(JOptionPane.showInputDialog("Which text file would you like to open? (1 Gettysburg, 2 6th grader, 3 college)"))){
                case 1:
                    open("src/assets/Gettysburg.txt");
                    break;
                case 2:
                    open("src/assets/test-6th-grader.txt");
                    break;
                case 3:
                    open("src/assets/test-college-grad.txt");
                    break;
            }
            pane.getPanein().reformat(pane.getPanein().getTxttext().getWidth()/40);
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
//        JOptionPane.showMessageDialog(null,text);
        pane.getPanein().getTxttext().setText(text);
        textAnalyzer.setText(text);
        pane.getPaneout().setOutput(textAnalyzer);
    }
}
