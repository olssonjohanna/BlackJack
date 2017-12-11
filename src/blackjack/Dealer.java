package blackjack;

import java.util.ArrayList;

public class Dealer {

    private CollectionOfCards availableCards;
    private CollectionOfCards usedCards;
    private Hand dealerHand;
    private String name;
    private String birthdate;

    public Dealer(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.availableCards = new CollectionOfCards();
        this.usedCards = new CollectionOfCards();
        this.dealerHand = new Hand(0);
    }

    public void shuffleDeck(){
        //Ta alla kort från usedCards och flytta dessa till availableCards.
        int numberOfAvailableCards = availableCards.getListOfCards().size();
        for (int i = 0; i < numberOfAvailableCards; i++){
            Card card = availableCards.removeCard();
            usedCards.addCard(card);
        }
        int numberOfUsedCards = usedCards.getListOfCards().size();
        for (int i = 0; i < numberOfUsedCards; i++){
            Card card = usedCards.removeCard();
            card.resetValue();
            availableCards.addCard(card);
        }
    }

    public void dealCard(Hand hand){
        //Ta ett kort från availableCards och lägg till detta i rätt hand och i usedCards.
        Card card = availableCards.removeCard();
        hand.addCard(card);
        usedCards.addCard(card);
    }

    public CollectionOfCards getAvailableCards() {
        return availableCards;
    }

    public CollectionOfCards getUsedCards() {
        return usedCards;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    //Har för mig att vi sa fler funktioner men kommer inte på dom nu.


}