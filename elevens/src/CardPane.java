import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardPane extends JPanel{
    private ArrayList<CardImg> cards = new ArrayList<CardImg>();

    public CardPane(){
        setLayout(new GridLayout(3,3,10,10));
        for(CardImg cimg: cards){
            add(cimg);
        }
    }

    public void display(Deck d){
        cards.clear();
        for(int i = 0;i<9;i++){
            cards.add(new CardImg(d.getCards().get(i)));
        }
        removeAll();
        for(CardImg c: cards){
            add(c);
        }
    }
}
