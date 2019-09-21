import se.lth.cs.pt.window.SimpleWindow;

import java.awt.*;
import java.util.logging.SimpleFormatter;
public class TraingleExample {

    public static void main(String[] args) {
        Point[] vertices = new Point[1];
        int x = 3;
        int x2 = 5;
        int y = 3;
        int y2 = 8;
        Point p1 = new Point(x,y);
        Point p2 = new Point(x2,y2);

        vertices[0] = p1;
       // vertices[1] = p2;
        System.out.println(vertices.length);
        System.out.println(vertices[0]);



    }
}
