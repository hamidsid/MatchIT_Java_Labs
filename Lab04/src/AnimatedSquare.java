import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(1000, 800, "Square Step by Ste");

        //get the initial coordinates ( At first step ,x = 0, y = 0 )
        int xOld = w.getX();
        int yOld = w.getY();

        Square mySquare = new Square(xOld, yOld, 100);


        while (true) {
            mySquare.draw(w);
            w.waitForMouseClick();

            //Get new coordinates after mouse click.
            int xNew = w.getMouseX();
            int yNew = w.getMouseY();

            //get the distance between each square
            int x = (xNew - xOld) / 10;
            int y = (yNew - yOld) / 10;

            //Draw the squares in 10 steps
            for (int i = 0; i < 10; i++) {

                SimpleWindow.delay(100);
                mySquare.erase(w);
                mySquare.move(x, y);
                mySquare.draw(w);
            }

            xOld = xNew;
            yOld = yNew;
            mySquare.erase(w);

        }

    }
}
