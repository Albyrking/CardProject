public class Card{
    int type, suit;
    String name;
    public Card(int type, int suit) {
        this.type = type;
        this.suit = suit;
        CardTypes[] types = CardTypes.values();
        CardSuits[] suits = CardSuits.values();
        name = types[type - 1] + " " + suits[suit - 1];
    }
}
