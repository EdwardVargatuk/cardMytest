import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Cards extends ArrayList<Cards> {

    private static Scanner scan = new Scanner(System.in);

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(2), QUEEN(3), KING(4), ACE(11);
        private final int numVal;

        Rank(int numVal) {
            this.numVal = numVal;
        }

        public int getNumVal() {
            return numVal;
        }
    }

    public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}

    private final Rank rank;
    private final Suit suit;

    Cards(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    private static final List<Cards> protoDeck = new ArrayList<Cards>();
    static {
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values()) {
                protoDeck.add(new Cards(rank, suit));
            }
    }

    public static ArrayList<Cards> newDeck() {
        Collections.shuffle(protoDeck);
        return new ArrayList<Cards>(protoDeck);
    }

    public static int drawCard() {
        int intValueOfDeck = (protoDeck).get(0).rank.getNumVal();
//        System.out.println(protoDeck);for check deck
        protoDeck.remove(0);
//        System.out.println(protoDeck);for check deck
        return intValueOfDeck;
    }

    public static ArrayList<Integer> drawTwoCard() {
        ArrayList<Integer> cards = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            cards.add(drawCard());
        } return cards;
    }

    public static int getChoice() {
        int choice = 0;
        while (choice != 1 && choice != 2) {
            String next = scan.next();
            try {
                choice = Integer.parseInt(next);
            } catch (Exception e) {
                System.out.println("This is invalid input");
            }
        }  return choice;
    }

    public static int totalScore(ArrayList<Integer> cards) {
        int total = 0;
        for (int card : cards) {
            total += card;
        }
        return total;
    }

    public static void outputForCheckScore(ArrayList<Integer> cards) {
        int i = checkScore(cards);
        switch (i) {
            case 1:
                System.out.println("You currently have score of " + totalScore(cards));
                play(cards);
                break;
            case 2:
                System.out.println("Whoops, you loose because have too many points - " + totalScore(cards));
                break;
            default:
                break;
        }
    }

    public static int checkScore(ArrayList<Integer> cards) {
        if (totalScore(cards) < 21) {
            return 1;
        } else if (totalScore(cards) > 21) {
            return 2;
        }
        return 0;
    }

    public static void play(ArrayList<Integer> cards) {
        System.out.println("Press 1 to draw another card. Press 2 to stand");
        int plChoice = getChoice();

        if (plChoice == 1) {
            Cards beforeRemoteCard = protoDeck.get(0);
            int newCard = drawCard();
            cards.add(newCard);
            System.out.println("You drew a " + beforeRemoteCard + ".");//+ newCard
            outputForCheckScore(cards);
        } else if (plChoice == 2) {
            System.out.println("Your final score is " + totalScore(cards));
        }
    }

    public static boolean ifTwentyOne(ArrayList<Integer> cards) {
        if (totalScore(cards) == 21) return true;
        return false;
    }

    public static void opponentsTurn(ArrayList<Integer> cards) {
        while (totalScore(cards) < 21) {
            Cards beforeRemoteCard = protoDeck.get(0);
            int newCard = drawCard();
            cards.add(newCard);
            System.out.println(beforeRemoteCard + " gives to opponent " + totalScore(cards));
        }
    }

    public static void main(String[] args) {
        ArrayList<Cards> c = newDeck();
        ArrayList<Integer> cardsOfPlayer = new ArrayList(drawTwoCard());
        ArrayList<Integer> cardsOfOpponent = new ArrayList(drawTwoCard());

        System.out.println("You drew " + c.get(0) + " and " + c.get(1) + " what giving you a current score of " + totalScore(cardsOfPlayer));
        if (ifTwentyOne(cardsOfPlayer)) {
            System.out.println("Congratulations, you got 21!");
            System.exit(0);
        }
        play(cardsOfPlayer);
        if (ifTwentyOne(cardsOfPlayer)) {
            System.out.println("Congratulations, you got 21!");
            System.exit(0);
        }
        System.out.println("\nOpponents drew " + c.get(2) + " and " + c.get(3) + " giving him a current score of " + totalScore(cardsOfOpponent));

        opponentsTurn(cardsOfOpponent);
        if (ifTwentyOne(cardsOfOpponent)) {
            System.out.println("Opponents win and got 21!");
        } else
            System.out.println("Opponents final score is " + totalScore(cardsOfOpponent) + " so Opponents also lost");
    }
}

