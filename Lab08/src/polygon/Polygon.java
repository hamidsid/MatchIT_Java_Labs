package polygon;

import se.lth.cs.pt.window.SimpleWindow;
public class Polygon {

    private Point[] vertices;
    private int n; //number of vertices

    public Polygon() {
        vertices = new Point[1]; //start with only one point
        n = 0;
    }

    public void addVertex(int x, int y) {
        vertices[n] = new Point(x, y);
        n++;
    }

    /*private void extend(){
        Point[] oldVertices = vertices;
        vertices = new Point[2 * vertices.length]; // skapa dubbel plats
        for (int i = 0; i < oldVertices.length; i++) {  // kopiera
            vertices[i] = oldVertices[i];
        }
    }

    *//** Definierar en ny punkt med koordinaterna x,y *//*
    public void addVertex(int x, int y) {
        if (n == vertices.length) extend();
        vertices[n] = new Point(x, y);
        n++;
    }
*/
    /**
     * Flyttar polygonen avståndet dx i x-led, dy i y-led
     */
    public void move(int dx, int dy) {
        for (int i = 0; i < n; i++) {
            vertices[i].move(dx, dy);
        }
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

