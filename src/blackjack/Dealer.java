package blackjack;

public class Dealer {

    private ArrayList<Card> availableCards;
    private ArrayList<Card> usedCards;
    private ArrayList<Hands> listOfHands;
    private Hand dealerHand;
    private String name;
    private String birthdate;

    public Dealer(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.availableCards = new ArrayList<>();
        this.usedCards = new ArrayList<>();
        this.listOfHands = new ArrayList<>();
        this.dealerHand = new Hand();
    }

    public void shuffleDeck(){
        //Ta alla kort från usedCards och flytta dessa till availableCards.
    }

    public void dealCard(Hand hand){
        //Ta ett kort från availableCards och lägg till detta i rätt hand och i usedCards.
    }

    //Har för mig att vi sa fler funktioner men kommer inte på dom nu.


}