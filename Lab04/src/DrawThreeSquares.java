import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

import java.awt.*;

public class DrawThreeSquares {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
        Square sq = new Square(250, 250, 100);
        sq.draw(w);

        //set the color for the second square to be red
        w.setLineColor(Color.red);
        Square sq2 = new Square(220, 220, 100);
        sq2.draw(w);

        //set the color for the third square to be green
        w.setLineColor(Color.green);
        Square sq3 = new Square(200, 200, 100);
        sq3.draw(w);

    }
}