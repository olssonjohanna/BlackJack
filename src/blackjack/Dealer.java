package blackjack;

import java.util.ArrayList;

public class Dealer {

    private CollectionOfCards availableCards;
    private CollectionOfCards usedCards;
    private ArrayList<Hand> listOfHands;
    private Hand dealerHand;
    private String name;
    private String birthdate;

    public Dealer(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.availableCards = new CollectionOfCards();
        this.usedCards = new CollectionOfCards();
        this.listOfHands = new ArrayList<>();
        this.dealerHand = new Hand(0);
    }

    public void shuffleDeck(){
        //Ta alla kort från usedCards och flytta dessa till availableCards.
    }

    public void dealCard(Hand hand){
        //Ta ett kort från availableCards och lägg till detta i rätt hand och i usedCards.
    }

    public CollectionOfCards getAvailableCards() {
        return availableCards;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }



    //Har för mig att vi sa fler funktioner men kommer inte på dom nu.


}