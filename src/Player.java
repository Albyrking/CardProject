import java.util.ArrayList;

public class Player {
    int score;
    ArrayList<Card> deck = new ArrayList<>();
    public void addCard(Card card){
        deck.add(card);
    }
    public Player(){
        score = 0 ;
    }
    public void clearDeck(){
        this.deck.clear();
    }
    public void won(){
        score++;
    }
}
