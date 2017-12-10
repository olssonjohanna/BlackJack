package blackjack;

public class Card {

    private final int CARD_ID;
    private final int CARD_VALUE;
    private static int idCounter = 0;

    public Card(int CARD_VALUE) {
        this.CARD_VALUE = CARD_VALUE;
        this.CARD_ID = Card.idCounter;
        Card.idCounter++;
    }

    public int getCARD_VALUE() {
        return CARD_VALUE;
    }
}
// Måste komma på en lösning för ett kort som är ett ess. Dessa kan ha värde 1 eller 11.
// Tror det bästa sättet är att skapa en child klass av Card som heter Ace och som kan förvandla värdet.
// Kan fundera på saken, men borde kunna gå att lösa i efterhand.
// Den här klassen borde inte behöva något mer och borde därför vara klar.