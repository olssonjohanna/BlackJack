package blackjack;

import java.util.Scanner;

public class TerminalUi {

    private Table table;
    private Scanner scanner;

    public TerminalUi() {
        this.table = new Table();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        String name;
        String birthdate;
        int numberOfDecks;
        int numberOfPlayers;

        System.out.print("New table created. Enter name of dealer: ");
        name = scanner.nextLine();
        System.out.print("Enter birthdate of dealer: ");
        birthdate = scanner.nextLine();
        numberOfDecks = checkNumber("How many decks should the table have? ");
        table.setDealer(name, birthdate, numberOfDecks);
        numberOfPlayers = checkNumber("How many players? ");
        for (int i = 0; i < numberOfPlayers; i++) {
            table.addHand(0);
        }
        startRound();
        while (endOfRound()) {
            startRound();
        }
    }

    private void startRound() {
        table.startAllHands();
        table.startNewRound();
        table.checkBlackJack();
        for (Hand hand : table.getListOfHands()) {
            handleHand(hand);
            System.out.println();
        }
        table.dealToDealer();
        table.checkForWinners();
    }

    private void handleHand(Hand hand) {
        if (!hand.isInPlay()) {
            return;
        }
        while (true) {
            int choice;
            int value = hand.getHandValue();
            System.out.println("Dealer card: " + table.getDealer().getDealerHand().getListOfCards());
            System.out.println("Current cards: " + hand.getListOfCards());
            System.out.println("Current value: " + value);
            if (!hand.isInPlay()) {
                System.out.println("Bust!");
                break;
            }
            choice = checkNumber("Enter 1 for a card, 0 to stop: ");
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                table.dealCard(hand);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private boolean endOfRound() {
        String answer;
        while (true) {
            System.out.print("Would you like to continue to play? y/n");
            answer = scanner.nextLine();
            if (answer.toLowerCase().equals("y")) {
                return true;
            } else if (answer.toLowerCase().equals("n")) {
                return false;
            }
        }
    }

    private int checkNumber(String question) {
        while (true) {
            System.out.print(question);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Invalid input, must enter a number!");
            scanner.next();
        }
    }
}
