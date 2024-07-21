import java.util.*;

public class CardGame {
    Scanner in = new Scanner(System.in);
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<Card> communityCards = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();

    public CardGame(ArrayList<Player> players) {
        this.players = players;
        for (int y = 1; y <= 13; y++) {
            for (int u = 1; u <= 4; u++) {
                cards.add(new Card(y, u));
                cards.add(new Card(y, u));
            }
        }
        Collections.shuffle(cards);
        //Раздает всем карты
        for (int y = 0; y < 4; y++) {
            players.get(y % 2).addCard(cards.get(0));
            cards.remove(0);
        }
        //Определяет общие карты
        for (int y = 0; y < 5; y++) {
            communityCards.add(cards.get(0));
            cards.remove(0);
        }
    }
    public int go(){
        CardRunner c = new CardRunner();
        SetTypes[] setTypes = SetTypes.values();
        int myValue = c.run(players.get(0), communityCards);
        System.out.println("Мой сет : " + setTypes[myValue]);
        System.out.println("\n");
        int value2= c.botCards(players.get(1), communityCards);
        System.out.println("Сет второго ирока : " + setTypes[value2]);
        if(myValue > value2){
            return 1;
        }else if(myValue == value2){
            return 0;
        }
        return -1;

    }

}
