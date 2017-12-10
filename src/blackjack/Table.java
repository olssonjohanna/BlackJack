package blackjack;

import java.util.ArrayList;

public class Table {

    //Time to shine

    private Dealer dealer;
    private ArrayList<Hand> listOfHands;

    public Table() {
        this.listOfHands = new ArrayList<>();
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setDealer(String name, String birthdate, int numberOfDecks) {
        this.dealer = new Dealer(name, birthdate);
//            this.dealer.getAvailableCards().createDeckOfCard(numberOfDecks);
    }

    public void addHand(int balance) {
        listOfHands.add(new Hand(balance));
    }

    public void addHand(Hand hand) {
        listOfHands.add(hand);
    }

    public void newRound() {
        for (Hand hand : listOfHands) {
            hand.startHand();
        }
    }

    public void checkBets() {

    }

    public void startNewRound() {
        if (dealer.getAvailableCards().getListOfCards().size() < dealer.getAvailableCards().getListOfCards().size() / 5) {
            dealer.shuffleDeck();
        }
        for (Hand hand : listOfHands) {
            dealer.dealCard(hand);
        }

        dealer.dealCard(dealer.getDealerHand());

        for (Hand hand : listOfHands) {
            dealer.dealCard(hand);
        }
    }

    public void checkBlackJack() {
        for (Hand hand : listOfHands) {
            if (hand.getHandValue() == 21) {
                hand.stopHand();
            }
        }
    }

    public void dealCard(Hand hand) {
        if (hand.isInPlay()) {
            dealer.dealCard(hand);
        }
    }

    public void dealToDealer() {
        while (dealer.getDealerHand().getHandValue() <= 17) {
            dealer.dealCard(dealer.getDealerHand());
        }
    }

    public void checkForWinners() {
        int dealerValue = dealer.getDealerHand().getHandValue();
        for (Hand hand : listOfHands) {
            if (dealerValue > 21 && hand.getHandValue() < 22) {
                System.out.println("Hand is a winner. Hand value is " + hand.getHandValue());
            } else if (dealerValue < 22 && hand.getHandValue() == dealerValue) {
                System.out.println("Equal value, both hands got value " + dealerValue);
            } else if (dealerValue < 22 && hand.getHandValue() > dealerValue) {
                System.out.println("Hand is a winner. Hand value is " + hand.getHandValue());
            } else {
                System.out.println("Losing hand");
            }
        }
    }


}

