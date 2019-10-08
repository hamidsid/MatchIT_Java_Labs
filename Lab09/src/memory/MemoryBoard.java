package memory;

import java.util.Random;
public class MemoryBoard {

    private int size;
    private MemoryCardImage[][] board;
    private boolean[][] isUp;
    private Random rand = new Random();

    /**
     * Skapar ett memorybräde med size * size kort. backFileName är filnamnet
     * för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen
     * för frontbilderna.
     */
    public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
        this.size = size;
        this.board = new MemoryCardImage[size][size];
        isUp = new boolean[size][size];
        createCards(frontFileNames, backFileName);

    }

    /* Skapar size * size / 2 st memorykortbilder.
       Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
    private void createCards(String[] frontFileNames, String backFileName) {
        for (int i = 0; i < frontFileNames.length; i++) {

            //make a memory card image for every file image
            MemoryCardImage cardImage = new MemoryCardImage(frontFileNames[i], backFileName);

            //firstly add the same 8 cards(frontFileNames.size = 8) at random cells on the board
            this.shuffleCards(cardImage);

            //we do the same process to add the remaining 8 cards at random cells on the board
            this.shuffleCards(cardImage);

        }

    }

    private void shuffleCards(MemoryCardImage cardImage) {

        //generate a random number for every row and column
        int r = rand.nextInt(getSize());
        int c = rand.nextInt(getSize());

        //if the cell is full then generate a random number and then put the card image
        while (board[r][c] != null) {
            r = rand.nextInt(getSize());
            c = rand.nextInt(getSize());
        }
        board[r][c] = cardImage;
    }

    /**
     * Tar reda på brädets storlek.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
     * Raderna och kolonnerna numreras från 0 och uppåt.
     */
    public MemoryCardImage getCard(int r, int c) {
        return board[r][c];
    }

    /**
     * Vänder kortet på rad r, kolonn c.
     */
    public void turnCard(int r, int c) {
        if (isUp[r][c]) //if the card is already facing up then turn it
            isUp[r][c] = false;
        else
            isUp[r][c] = true; //otherwise face up the card
    }

    /**
     * Returnerar true om kortet r, c har framsidan upp.
     */
    public boolean frontUp(int r, int c) {
        return isUp[r][c];
    }

    /**
     * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
     * kolonn c2.
     */
    public boolean same(int r1, int c1, int r2, int c2) {

        return board[r1][c1] == board[r2][c2];
    }

    /**
     * Returnerar true om alla kort har framsidan upp.
     */
    public boolean hasWon() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!isUp[i][j])
                    return false;
            }
        }
        System.out.println("Player has won the game!");
        return true;
    }
}