import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE MODIFIED IN ACTIVITY 11 *** */
		if (selectedCards.size() == 2) {
			return findPairSum11(selectedCards).size()>0;
		} else if (selectedCards.size() == 3) {
			return findJQK(selectedCards).size()>0;
		} else {
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE MODIFIED IN ACTIVITY 11 *** */
		List<Integer> cIndexes = cardIndexes();
		return findPairSum11(cIndexes).size() == 2 || findJQK(cIndexes).size() == 3;
	}

	/**
	 * Look for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return a list of the indexes of an 11-pair, if an 11-pair was found;
	 *         an empty list, if an 11-pair was not found.
	 */
	private List<Integer> findPairSum11(List<Integer> selectedCards) {
        List<Integer> pairs = new ArrayList<Integer>();
        Card c1, c2;
        for(int i = 0;i<selectedCards.size();i++){
            c1 = cardAt(selectedCards.get(i));
            if(selectedCards.size()>i+1){
                for(int j = i+1;j<selectedCards.size();j++){
                    c2 = cardAt(selectedCards.get(j));

                    if(c1!=null && c2!= null && c1.pointValue()+c2.pointValue()==11){
//                        System.out.println("c1 " + c1.pointValue());
//                        System.out.println("c2 " + c2.pointValue());
                        pairs.add(selectedCards.get(i));
                        pairs.add(selectedCards.get(j));
                        return pairs;
                    }
                }
            }
        }
        return pairs;
	}

	/**
	 * Look for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return a list of the indexes of a JQK, if a JQK was found;
	 *         an empty list, if a JQK was not found.
	 */
	private List<Integer> findJQK(List<Integer> selectedCards) {
        List<Integer> cardsreturn = new ArrayList<Integer>();
        int jack = -1;
        int queen = -1;
        int king = -1;
        for(Integer i: selectedCards){
            Card c = cardAt(i);
            if(c.rank().equals("jack") && c != null){
                jack = i;
            }
            if(c.rank().equals("queen") && c != null){
                queen = i;
            }
            if(c.rank().equals("king") && c != null){
                king = i;
            }
        }
        if(jack> -1 && queen > -1 && king > -1){
            cardsreturn.add(jack);
            cardsreturn.add(queen);
            cardsreturn.add(king);
        }
        return cardsreturn;
	}

	/**
	 * Looks for a legal play on the board.  If one is found, it plays it.
	 * @return true if a legal play was found (and made); false othewise.
	 */
	public boolean playIfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
		//return playJQKIfPossible() || playPairSum11IfPossible(); // REPLACE !
        for (int i = 0;i<cardIndexes().size();i++){
            System.out.print(cardAt(cardIndexes().get(i)).pointValue() + " ");
        }
        System.out.println();
        return playPairSum11IfPossible() || playJQKIfPossible();
	}

	/**
	 * Looks for a pair of non-face cards whose values sum to 11.
	 * If found, replace them with the next two cards in the deck.
	 * The simulation of this game uses this method.
	 * @return true if an 11-pair play was found (and made); false othewise.
	 */
	private boolean playPairSum11IfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
		List<Integer> pos = cardIndexes();
		List<Integer> playcard = findPairSum11(pos);
		if(playcard.size()>0){
		    replaceSelectedCards(playcard);
		    return true;
        }
        else {
		    return false;
        }
	}

	/**
	 * Looks for a group of three face cards JQK.
	 * If found, replace them with the next three cards in the deck.
	 * The simulation of this game uses this method.
	 * @return true if a JQK play was found (and made); false othewise.
	 */
	private boolean playJQKIfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
		List<Integer> pos = cardIndexes();
		List<Integer> playcard = findJQK(pos);
		if(playcard.size()>2){
		    replaceSelectedCards(playcard);
		    return true;
        }
		return false; // REPLACE !
	}
}
