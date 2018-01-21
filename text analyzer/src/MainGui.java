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
    private JMenuItem mnuopengettysburg = new JMenuItem();
    private JMenuItem mnuopen6thgrade = new JMenuItem();
    private JMenuItem mnuopencollege = new JMenuItem();
    private static MainPane pane = new MainPane();
    private static TextAnalyzer textAnalyzer = new TextAnalyzer();

    public MainGui(){
        setSize(520,500);
        setTitle("Text Analyzer");
        getContentPane().add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(mnubar);
        mnubar.add(mnufile);
        mnufile.add(mnuopengettysburg);
        mnufile.add(mnuopen6thgrade);
        mnufile.add(mnuopencollege);
        mnufile.setText("File");
        mnuopengettysburg.setText("Open Gettysburg");
        mnuopen6thgrade.setText("Open 6th Grade");
        mnuopencollege.setText("Open College");
        setVisible(true);
        mnuopengettysburg.addActionListener(new opengettysburg());
        mnuopencollege.addActionListener(new opencollege());
        mnuopen6thgrade.addActionListener(new open6thgrade());
    }

    static class opengettysburg implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            open("src/assets/Gettysburg.txt");
            pane.getPanein().reformat(pane.getPanein().getTxttext().getWidth()/40);
        }
    }

    static class open6thgrade implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            open("src/assets/test-6th-grader.txt");
            pane.getPanein().reformat(pane.getPanein().getTxttext().getWidth()/40);
        }
    }

    static class opencollege implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            open("src/assets/test-college-grad.txt");
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
