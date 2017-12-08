package blackjack;

public class CollectionOfCards {

    private ArrayList<Card> listOfCards;

    public CollectionOfCards() {
        this.listOfCards = new ArrayList<>();
    }

    public void addCard(){
        //Skapa ett kort med ett visst värde och lägg till i listan med kort
    }

    public Card removeCard(){
        //Returnera ett slumpmässigt kort från listan och ta bort den från lista. Kolla ifall listan är tom först.
    }

    public void createDeckOfCard(){
        //Skapa 52st kort som motsvarar en kortlek och lägg till dessa i listan.
        //Antalet kort ska vara 4st med värde 1 till och med 9.
        //Tior och klädda kort är värda 10. Så 4x10 + 4xKnekt + 4xDam + 4xKung == 16xKortMedVärdet10
        //Ess blir specialfall, just nu kan vi skapa 4st med värde 11.
        //Fundera över möjligheten ifall vi vill skapa flera lekar. Ta emot en parameter över hur många gånger vi ska köra funktionen?
    }

}