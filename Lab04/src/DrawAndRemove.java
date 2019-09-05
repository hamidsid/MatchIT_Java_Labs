import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class DrawAndRemove {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "Draw and Remove");
        Square sq = new Square(300, 300, 150);
        sq.draw(w);
        while (true) {
            w.waitForMouseClick();
            w.clear();
            w.waitForMouseClick();

            //make a new square with the coordinates where the user clicks the mouse
            Square mySquare= new Square(w.getMouseX(),w.getMouseY(),150);
            mySquare.draw(w);


        }
    }
}
