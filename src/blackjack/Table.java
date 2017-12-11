package blackjack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Table {

    //Time to shine

    private Dealer dealer;
    private ArrayList<Hand> listOfHands;

    public Table(){
        this.listOfHands = new ArrayList<>();
    }

    public void setDealer(Dealer dealer){
        this.dealer = dealer;
    }

    public void setDealer(String name, String birthdate, int numberOfDecks){
        this.dealer = new Dealer(name, birthdate);
        this.dealer.getAvailableCards().createDeckOfCard(numberOfDecks);
    }

    public void addHand(int balance){
        listOfHands.add(new Hand(balance));
    }

    public void addHand(Hand hand){
        listOfHands.add(hand);
    }

    public void startAllHands(){
        for (Hand hand : listOfHands){
            hand.startHand();
        }
        dealer.getDealerHand().startHand();
    }

    public void checkBets(){

    }

    public void startNewRound(){
        if (dealer.getAvailableCards().getListOfCards().size() < dealer.getAvailableCards().getListOfCards().size() / 5){
            dealer.shuffleDeck();
        }
        for (Hand hand : listOfHands){
            dealer.dealCard(hand);
        }

        dealer.dealCard(dealer.getDealerHand());

        for (Hand hand : listOfHands){
            dealer.dealCard(hand);
            System.out.println(hand.getListOfCards());
        }
    }

    public void checkBlackJack(){
        for (Hand hand : listOfHands){
            if (hand.getHandValue() == 21){
                System.out.println("BLACKJACK!");
                hand.stopHand();
            }
        }
    }

    public void dealCard(Hand hand){
        if (hand.isInPlay()){
            dealer.dealCard(hand);
        }
    }

    public void dealToDealer(){
        while (dealer.getDealerHand().getHandValue() <= 17){
            dealer.dealCard(dealer.getDealerHand());
            System.out.println(dealer.getDealerHand().getListOfCards());
            System.out.println("Dealer value: " + dealer.getDealerHand().getHandValue());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    public void checkForWinners(){
        int dealerValue = dealer.getDealerHand().getHandValue();
        for (Hand hand : listOfHands){
            if (!hand.isInPlay()){
                continue;
            }
            if (dealerValue > 21 && hand.getHandValue() < 22){
                System.out.println("Hand is a winner. Hand value is " + hand.getHandValue());
                System.out.println("Dealer busted and hand value is under 22.");
            } else if (dealerValue < 22 && hand.getHandValue() == dealerValue){
                System.out.println("Equal value, both hands got value " + dealerValue);
            } else if (dealerValue < 22 && hand.getHandValue() > dealerValue){
                System.out.println("Hand is a winner. Hand value is " + hand.getHandValue());
                System.out.println("Dealer value is lower then hand value");
            } else {
                System.out.println("Losing hand");
            }
        }
    }

    public ArrayList<Hand> getListOfHands() {
        return listOfHands;
    }

    public Dealer getDealer() {
        return dealer;
    }
}