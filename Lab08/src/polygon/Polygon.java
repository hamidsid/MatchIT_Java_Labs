package polygon;

import se.lth.cs.pt.window.SimpleWindow;
public class Polygon {

    private Point[] vertices;
    private int n; //number of vertices

    public Polygon() {
        vertices = new Point[10]; // maximum of 10 points
        n = 0;
    }

    public void addVertex(int x, int y) {
        vertices[n] = new Point(x, y);
        n++;
    }

    public void removeVertex(int pos) {
        for (int i = pos; i < n - 1; i++) {
            vertices[i] = vertices[i + 1];
        }
        vertices[n - 1] = null; // *
        n--;
    }

    public void draw(SimpleWindow w) {

        if (n == 0) {
            return;
        }

        //move to the starting point of the polygon
        Point startingPoint = vertices[0];
        w.moveTo(startingPoint.getX(), startingPoint.getY());

        //draw every line to other vertices without the starting point
        for (int i = 1; i < n; i++) {
            w.lineTo(vertices[i].getX(), vertices[i].getY());
        }

        //finally connect the drawn line to the starting point
        w.lineTo(startingPoint.getX(), startingPoint.getY());
    }
}

