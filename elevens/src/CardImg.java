import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardImg extends JLabel{
    public CardImg(){

    }

    public CardImg(Card c){
        display(c);
    }

    public void display(Card c){
        BufferedImage img = null;
        ImageIcon imgcard = new ImageIcon();
        try {
            img = ImageIO.read(new File("src/assets/"+cardpath(c)+".gif"));
            imgcard.setImage(img);
        } catch (IOException e) {
            System.out.println(cardpath(c));
        }
        setIcon(imgcard);
    }

    private String cardpath(Card c){
        return String.valueOf(c.getValue())+c.getSuit();
    }
}
