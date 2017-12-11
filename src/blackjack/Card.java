package blackjack;

public class Card {

    private final int CARD_ID;
    private int cardValue;
    private static int idCounter = 0;

    public Card(int cardValue) {
        this.cardValue = cardValue;
        this.CARD_ID = Card.idCounter;
        Card.idCounter++;

    }

    public int getCardValue() {
        return cardValue;
    }

    public void changeValue(){
        if (cardValue == 11){
            cardValue = 1;
        }
    }

    public void resetValue(){
        if (cardValue == 1){
            cardValue = 11;
        }
    }

    @Override
    public String toString() {
        return "" + cardValue;
    }
}
// Måste komma på en lösning för ett kort som är ett ess. Dessa kan ha värde 1 eller 11.
// Tror det bästa sättet är att skapa en child klass av Card som heter Ace och som kan förvandla värdet.
// Kan fundera på saken, men borde kunna gå att lösa i efterhand.
// Den här klassen borde inte behöva något mer och borde därför vara klar.