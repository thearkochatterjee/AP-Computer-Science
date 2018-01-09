import javax.swing.*;
import java.util.Random;

public class Tile extends JLabel{
    private int value = 0;

    public Tile(){
        value = 0;
        super.setVerticalAlignment(JLabel.CENTER);
        super.setHorizontalAlignment(JLabel.CENTER);
    }

    public int getValue() {
        return value;
    }

    public int generatevalue(){
        Random r = new Random();
        value = r.nextInt()+1;
        switch (value){
            case 1:
                value = 2;
                break;
            case 2:
                value = 4;
                break;
        }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
