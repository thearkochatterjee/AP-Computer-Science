public class Card {
    private char suit;
    private int value = 0;

    public Card(){
        value = 0;
    }

    public Card(char suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
