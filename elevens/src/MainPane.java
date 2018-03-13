import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainPane extends Container{
    private JLabel lblcardremain = new JLabel();
    private JButton cmdreplace = new JButton();
    private JButton cmdrestart = new JButton();
    private ArrayList<CardImg> cardplay = new ArrayList<CardImg>();

    public MainPane(){

    }
}
