import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Deck(){
//        String suit[] = {"Club", "Heart", "Diamond", "Spade"};
        char suit[] = {'c','h','d','s'};
        cards.clear();
        for(int s = 0;s<4;s++){
            for(int v = 1;v<14;v++){
                cards.add(new Card(suit[s], v));
            }
        }
        shuffle();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle(){
        Card temp = new Card();
        Random r = new Random();
        int pos = 0;
        for(int i = 0;i<cards.size();i++){
            pos = r.nextInt(51);
            temp = cards.get(pos);
            cards.set(pos,cards.get(i));
            cards.set(i,temp);
        }
    }
}
