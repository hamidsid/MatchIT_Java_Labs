import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class gg {


    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");

        int xold = 0;
        int yold = 0;
        while (true) {


            w.waitForMouseClick();
            w.clear();
            int x = w.getMouseX() - xold;
            int y = w.getMouseY() - yold;

            for (int i = 1; i < 11; i++) {
                Square sq = new Square((int) (i * x / 10f) + xold, (int) (i * y / 10f) + yold, 100);
                w.clear();
                sq.draw(w);
                w.delay(100);


            }

            w.delay(20);
            xold = w.getMouseX();
            yold = w.getMouseY();
        }

    }
}