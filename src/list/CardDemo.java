package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    private String rank;
    private String suit;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit + rank;
    }
}

public class CardDemo {
    private static List<Card> buyCards() {
        List<Card> cards = new ArrayList<>();
        String[] suits = { "♠", "♥", "♣️", "♦️" };

        for (int i = 0; i < suits.length; i++) {
            for (int j = 2; j <= 10; j++) {
                Card card = new Card();
                card.setRank(j + "");
                card.setSuit(suits[i]);
                cards.add(card);
            }
            Card cardJ = new Card();
            cardJ.setSuit(suits[i]);
            cardJ.setRank("J");

            Card cardQ = new Card();
            cardQ.setSuit(suits[i]);
            cardQ.setRank("Q");

            Card cardK = new Card();
            cardK.setSuit(suits[i]);
            cardK.setRank("K");

            Card cardA = new Card();
            cardA.setSuit(suits[i]);
            cardA.setRank("A");

            cards.add(cardJ);
            cards.add(cardQ);
            cards.add(cardK);
            cards.add(cardA);
        }
        return cards;
    }

    private static void shuffle(List<Card> cards) {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int r = random.nextInt(i);
            Card temp = cards.get(r);
            cards.set(r, cards.get(i));
            cards.set(i, temp);
        }
    }

    public static void main(String[] args) {
        List<Card> cards = buyCards();
        shuffle(cards);

        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();

        List<List<Card>> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < players.size(); j++) {
                Card card = cards.remove(0);
                players.get(j).add(card);
            }
        }

        for (int i = 0; i < players.size(); i++) {
            System.out.println("玩家 " + (i + 1) + ": " + players.get(i));
        }
    }
}