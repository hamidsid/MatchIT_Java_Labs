import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

import java.awt.*;

public class Graphics {
    private int width;
    private int blockSize;
    private int height;
    private SimpleWindow w;

    public Graphics(int w, int h, int bs) {

        // Add statements to initialize width, blocksize and height
        width = w;
        height = h;
        blockSize = bs;

        this.w = new SimpleWindow(width * blockSize, height * blockSize, "Mole Talpa Ground Game");
    }

    public void square() {
        Square sq = new Square(100, 200, 100);
        sq.draw(w);
    }

    public void block(int x, int y, Color color) {
        w.setLineColor(color);
        int left = x * blockSize;
        int right = left + blockSize - 1;
        int top = y * blockSize;
        int bottom = top + blockSize - 1;
        for (int row = top; row <= bottom; row++) {
            w.moveTo(left, row);
            w.lineTo(right, row);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void rectangle(int x, int y, int width, int height, Color c){

        for (int yy = y; yy <y + height; yy ++) {
            for (int xx = x; xx <x + width; xx ++) {
                block (xx, yy, c);
            }
        }
    }

    public char waitForKey(){
        return w.waitForKey();
    }

}
