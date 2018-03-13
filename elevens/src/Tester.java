import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tester {
    public static void main(String args[]){
        BufferedImage img = null;
        JFrame gui = new JFrame();
        Container pane = new Container();
        gui.getContentPane().add(pane);
        pane.setLayout(new BorderLayout());
        CardImg c = new CardImg();
        Card card = new Card('h',5);
        c.display(card);
        pane.add(c);
        gui.setVisible(true);
    }
}
