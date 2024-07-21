import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardSystem {
    Scanner in = new Scanner(System.in);

    public boolean isPair(boolean isFromBeginning, int num, ArrayList<Card> cards) {
        Collections.sort(cards, new ComparatorType());
        int g = 0;
        if (isFromBeginning) {
            Card pCard = cards.get(0);
            for (int y = 0; y < cards.size(); y++) {
                if (pCard == cards.get(y)) {
                    g++;
                } else {
                    pCard = cards.get(y);
                    g = 1;
                }
                if (g == num) {
                    return true;
                }
            }
            return false;
        } else {
            Card pCard = cards.get(cards.size() - 1);
            for (int y = cards.size() - 1; y >= 0; y--) {
                if (pCard == cards.get(y)) {
                    g++;
                } else {
                    pCard = cards.get(y);
                    g = 1;
                }
                if (g == num) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isTwoPair(ArrayList<Card> cards) {
        return isPair(true, 2, cards) && isPair(false, 2, cards);
    }

    public boolean isThreeOfKind(ArrayList<Card> cards) {
        return isPair(true, 3, cards);
    }

    public boolean isStraight(ArrayList<Card> cards, boolean isVariousSuit) {
        for (int y = 0; y < cards.size() - 1; y++) {
            if (isVariousSuit) {
                if (!(cards.get(y).suit != cards.get(y + 1).suit && cards.get(y).type + 1 == cards.get(y + 1).type)) {
                    return false;
                }
            } else {
                if (!(cards.get(y).type + 1 == cards.get(y + 1).type)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFlush(ArrayList<Card> cards) {
        int suit = cards.get(0).suit;
        for (int y = 0; y < cards.size(); y++) {
            if (cards.get(y).suit != suit) {
                return false;
            }
        }
        return true;
    }

    public boolean isFullHouse(ArrayList<Card> cards) {
        return (isPair(false, 2, cards) && isPair(true, 3, cards)) || (isPair(true, 2, cards) && isPair(false, 3, cards));
    }

    public boolean isFourOfKind(ArrayList<Card> cards) {
        return isPair(true, 4, cards);
    }

    public boolean isStraightFlush(ArrayList<Card> cards) {
        return isStraight(cards, false) && isFlush(cards);
    }

    public boolean isRoyalFlush(ArrayList<Card> cards) {
        return isStraightFlush(cards) && (cards.get(0).type == 9);
    }

    public int valueOf(ArrayList<Card> cards) {
        if (isRoyalFlush(cards)) {
            return 9;
        } else if (isStraightFlush(cards)) {
            return 8;
        } else if (isFourOfKind(cards)) {
            return 7;
        } else if (isFullHouse(cards)) {
            return 6;
        } else if (isFlush(cards)) {
            return 5;
        } else if (isStraight(cards, true)) {
            return 4;
        } else if (isThreeOfKind(cards)) {
            return 3;
        } else if (isTwoPair(cards)) {
            return 2;
        } else if (isPair(true, 2, cards)) {
            return 1;
        }
        return 0;
    }

}
