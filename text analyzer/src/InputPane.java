import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InputPane extends Container{
    private JTextArea txttext = new JTextArea();
    private JLabel lbltext = new JLabel();

    public InputPane() {
        setLayout(new BorderLayout());
        add(txttext);
        add(lbltext,BorderLayout.NORTH);
        lbltext.setText("Text");
    }

    public JTextArea getTxttext() {
        return txttext;
    }

    public void reformat(int amount){
        ArrayList<String> arrline = new ArrayList<String>();
        arrline = reformat_method_1(amount);
        txttext.setText("");
        for(int i = 0;i<arrline.size();i++){
            txttext.setText(txttext.getText()+arrline.get(i)+"\n");
        }
    }

    private ArrayList<String> reformat_method_1(int amount){
        ArrayList<String> arrline = new ArrayList<String>();
        String arrwords[] = txttext.getText().trim().split(" ");
        for(int i = 0;i<arrwords.length/amount;i++){
            String temp = "";
            for(int x = 0;x<amount;x++){
                temp += arrwords[x + i*amount] + " ";
            }
            arrline.add(temp.trim());
        }
        if((arrwords.length%amount)!=0){
            String temp = "";
            for(int i = 0;i<arrwords.length%amount;i++){
                temp+=arrwords[i+arrline.size()*amount];
            }
            arrline.add(temp);
        }
        return arrline;
    }

    private ArrayList<String> reformat_method_2(int amount){
        ArrayList<String> arrline = new ArrayList<String>();
        String arrwords[] = txttext.getText().trim().split(" ");
        int total = 0;
        String temp = "";
        for(int i = 0;i<arrwords.length;i++){
            total += arrwords[i].length();
            if(total<amount){
                temp += arrwords[i] + " ";
            }
            else {
                arrline.add(temp.trim());
                temp = "";
                total = 0;
            }
        }
        return arrline;
    }
}
