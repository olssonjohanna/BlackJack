package blackjack;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> listOfCards;
    private int currentBet;
    private boolean inPlay;
    private int balance;

    public Hand(int balance){
        this.balance = balance;
        this.listOfCards = new ArrayList<>();
        this.currentBet = 0;
        this.inPlay = true;
    }

    public void addCard(Card card){
        listOfCards.add(card);
    }

    public void newBet(int amount){
        //Öka currentBet med ett visst värde, behöver då en till funktion för att minska.
        //Eller ändra currentBet till ett nytt värde, då räcker det med en funktion.
        if (amount > balance){
            currentBet = balance;
        }
        currentBet = amount;
    }

    public int getHandValue(){
        //Returnera värdet av korten i handen
        int value = 0;
        for (Card card : listOfCards){
            value += card.getCardValue();
        }
        if (value > 21 && checkForAce()){
            value -= 10;
        }
        if (value > 21){
            inPlay = false;
        }
        return value;
    }

    private boolean checkForAce(){
        for (Card card : listOfCards){
            if (card.getCardValue() == 11){
                card.changeValue();
                return true;
            }
        }
        return false;
    }

    public void stopHand(){
        //Ändra så att handen inte längre är aktiv, dvs värdet har blivit över 21 alternativt så har spelaren valt att sluta ta fler kort.
        //Det här betyder inte att handen ska tas bort,  bara att den inte är i spel i nuvarande giv.
        //Behöver även en funktion för att starta handen igen vid en ny giv.
        inPlay = false;
        listOfCards.clear();
    }

    public void startHand(){
        inPlay = true;
        listOfCards.clear();
    }

    public boolean isInPlay() {
        return inPlay;
    }

    public ArrayList<Card> getListOfCards() {
        return listOfCards;
    }
}


//hej