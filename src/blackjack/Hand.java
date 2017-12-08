package blackjack;

public class Hand {

    private ArrayList<Card> listOfCards;
    private int currentBet;
    private boolean inPlay;

    public Hand(int initialBet){
        this.listOfCards = new ArrayList<>();
        this.currentBet = initialBet;
        this.inPlay = true;
    }

    public void increaseBet(){
        //Öka currentBet med ett visst värde, behöver då en till funktion för att minska.
        //Eller ändra currentBet till ett nytt värde, då räcker det med en funktion.
    }

    public int handValue(){
        //Returnera värdet av korten i handen
    }

    public void stopHand(){
        //Ändra så att handen inte längre är aktiv, dvs värdet har blivit över 21 alternativt så har spelaren valt att sluta ta fler kort.
        //Det här betyder inte att handen ska tas bort,  bara att den inte är i spel i nuvarande giv.
        //Behöver även en funktion för att starta handen igen vid en ny giv.
    }

}


//hej