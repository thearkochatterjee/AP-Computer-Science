import javax.swing.*;
import java.awt.*;

public class InputPane extends Container{
    private JLabel imgbook = new JLabel();
    private RatingGui rating = new RatingGui();
    private JList lstbook = new JList();
    private DefaultListModel dlm = new DefaultListModel();

    public InputPane(){
        setLayout(new GridLayout(1,3));
        add(rating);
        add(lstbook);
        add(imgbook);
    }

    public void setcovers(String path){
        imgbook.setIcon(new ImageIcon(path));
    }

    public DefaultListModel getDlm() {
        return dlm;
    }

    public JLabel getImgbook() {
        return imgbook;
    }

    public JList getLstbook() {
        return lstbook;
    }

    public RatingGui getRating() {
        return rating;
    }

    public void setRating(RatingGui rating) {
        this.rating = rating;
    }

    public void setDlm(DefaultListModel dlm) {
        this.dlm = dlm;
    }

    public void setImgbook(JLabel imgbook) {
        this.imgbook = imgbook;
    }

    public void setLstbook(JList lstbook) {
        this.lstbook = lstbook;
    }
}
