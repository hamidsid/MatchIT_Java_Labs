import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class MoveStepByStep {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "Square Step by Ste");

        //get the initial coordinates
        int xOld = 0;
        int yOld = 0;

        while (true) {
            w.waitForMouseClick();

            //After mouse click clear the canvas
            w.clear();


            //Get the new coordinates distanced from the previous ones
            int xNew = w.getMouseX() - xOld;
            int yNew = w.getMouseY() - yOld;


            //Draw the squares in 10 steps
            for (int i = 0; i < 10; i++) {
                Square my_square = new Square((int) (i * xNew / 10) + xOld, (int) (i * yNew / 10) + yOld, 100);
                my_square.draw(w);
            }

            //update the old coordinates with the recent ones
            xOld = w.getMouseX();
            yOld = w.getMouseY();

        }

    }
}
