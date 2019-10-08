package memory;

public class MemoryGame {

    public static void main(String[] args) {
        String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
                "mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg"};
        MemoryBoard memoryBoard = new MemoryBoard(4, "back.jpg", frontFileNames);
        MemoryWindow memoryWindow = new MemoryWindow(memoryBoard);
        memoryWindow.drawBoard();

        while (!memoryBoard.hasWon()) {
            memoryWindow.waitForMouseClick();

            //make sure mouse click is recognized
            while (memoryBoard.frontUp(memoryWindow.getMouseRow(), memoryWindow.getMouseCol())) {
                memoryWindow.waitForMouseClick();
            }

            int r1 = memoryWindow.getMouseRow();
            int c1 = memoryWindow.getMouseCol();
            memoryBoard.turnCard(r1, c1);
            memoryWindow.drawCard(r1, c1);


            //do the same things for the second card
            memoryWindow.waitForMouseClick();

            while (memoryBoard.frontUp(memoryWindow.getMouseRow(), memoryWindow.getMouseCol()))
                memoryWindow.waitForMouseClick();
            int r2 = memoryWindow.getMouseRow();
            int c2 = memoryWindow.getMouseCol();
            memoryBoard.turnCard(r2, c2);
            memoryWindow.drawCard(r2, c2);


            //if cards don't match, then turn them back again
            if (!memoryBoard.same(r1, c1, r2, c2)) {
                MemoryWindow.delay(1000);
                memoryBoard.turnCard(r1, c1);
                memoryBoard.turnCard(r2, c2);
                memoryWindow.drawCard(r1, c1);
                memoryWindow.drawCard(r2, c2);

            }
        }
    }

}
