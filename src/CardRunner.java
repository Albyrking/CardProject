import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CardRunner {
    Scanner in = new Scanner(System.in);
    CardSystem f = new CardSystem();
    public int run(Player player, ArrayList<Card> communityCards) {
        System.out.print("5 общих карт : ");
        for (int y = 0; y < 5; y++) {
            System.out.print(y + 1 + " - " + communityCards.get(y).name + " ; ");
        }
        System.out.println("\n");
        System.out.print("Мой карты : ");
        for (int y = 0; y < 2; y++) {
            System.out.print(y + 6 + " - " + player.deck.get(y).name + " ; ");
        }
        System.out.println("\n");
        System.out.println("Выбирите 5 карты по номерам : ");
        try {
            ArrayList<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 5) {
                int num = in.nextInt();
                while (num > 0) {
                    numbers.add(num % 10);
                    num /= 10;
                }
            }
            System.out.println("Номера выбраных карт :");
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }

            ArrayList<Integer> sortedNumbers = numbers;
            Collections.sort(sortedNumbers);
            if (sortedNumbers.get(0) < 1 || sortedNumbers.get(4) > 7) {
                throw new RuntimeException("Выбрал не сушествующую карту");
            } else if (sortedNumbers.size() > 5) {
                throw new RuntimeException("Карт слишком много");
            }else {
                ArrayList<Card> chosenCards = new ArrayList<>();
                System.out.println("Карты :");
                int a = 0;
                for (Integer number : numbers) {
                    if(number > 5){
                        chosenCards.add(player.deck.get(number - 6));
                    }else{
                        chosenCards.add(communityCards.get(number-1));
                    }
                    System.out.println(chosenCards.get(a).name);
                    a++;
                }

                if(f.isPair(true, 2 , chosenCards)){
                    throw new RuntimeException("Дублирующие карты");
                }
                System.out.println("Mой выбранные карты :");
                for (int y = 0 ;y < chosenCards.size() ; y++) {
                    System.out.println(y+1 + " - " + chosenCards.get(y).name +"; ");
                }
                return f.valueOf(chosenCards);
            }
        } catch (InputMismatchException e) {
            System.out.println("Неправильный ввод\nПопробуйте снова");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + "\nПопробуйте снова");
        }
        return -1;
    }
    public int botCards(Player botPlayer, ArrayList<Card> communityCards) {
        ArrayList<Card> botsCards = new ArrayList<>();
        for (int y = 0; y < 5; y++) {
            int g = (int) (Math.random() * 7) + 1;
            if (g > 2) {
                botsCards.add(communityCards.get(g - 3));
            } else {
                botsCards.add(botPlayer.deck.get(g - 1));
            }
        }
        return f.valueOf(botsCards);
    }

}
