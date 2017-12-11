package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class CollectionOfCards {

    private ArrayList<Card> listOfCards;

    public CollectionOfCards() {
        this.listOfCards = new ArrayList<>();
    }

    public void addCard(int cardValue){
        listOfCards.add(new Card(cardValue));
        //Skapa ett kort med ett visst värde och lägg till i listan med kort
    }

    public void addCard(Card card){
        listOfCards.add(card);
    }

    public Card removeCard(){
        //Returnera ett slumpmässigt kort från listan och ta bort den från lista. Kolla ifall listan är tom först.
        if (listOfCards.isEmpty()){
            return null;
        }
        Random random = new Random();
        Card card = listOfCards.get(random.nextInt(listOfCards.size()));
        listOfCards.remove(card);
        return card;
    }

    public void createDeckOfCard(int numberOfDecks){
        //Skapa 52st kort som motsvarar en kortlek och lägg till dessa i listan.
        //Antalet kort ska vara 4st med värde 1 till och med 9.
        //Tior och klädda kort är värda 10. Så 4x10 + 4xKnekt + 4xDam + 4xKung == 16xKortMedVärdet10
        //Ess blir specialfall, just nu kan vi skapa 4st med värde 11.
        //Fundera över möjligheten ifall vi vill skapa flera lekar. Ta emot en parameter över hur många gånger vi ska köra funktionen?

        for (int i = 0; i < numberOfDecks; i++){
            for (int i2 = 2; i2 < 10; i2++){
                addCard(i2);
                addCard(i2);
                addCard(i2);
                addCard(i2);
            }
            for (int i2 = 0; i2 < 16; i2++){
                addCard(10);
            }
            addCard(11);
            addCard(11);
            addCard(11);
            addCard(11);
        }

    }

    public ArrayList<Card> getListOfCards() {
        return listOfCards;
    }
}