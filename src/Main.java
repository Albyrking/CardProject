import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player player2 = new Player();
        Player player1 = new Player();
        String choice = "1";
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        while (choice.equals("1") || choice.equals("Да")) {
            System.out.println(player1.score + " : " + player2.score);
            CardGame game = new CardGame(players);
            int result = game.go();
            if (result == 1) {
                System.out.println("Выйграл");
                player1.won();
            } else if (result == 0) {
                System.out.println("Ничья");
            } else {
                System.out.println("Пройграл");
                player2.won();
            }
            System.out.println("Продолжить?");
            System.out.println("1 - Да");
            System.out.println("2 - Нет");
            System.out.println("\n\n\n\n\n\n");
            choice = in.next();
        }
    }
}