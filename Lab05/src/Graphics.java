import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

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

        this.w = new SimpleWindow(width * blockSize, height * blockSize, "Digging");
    }

    public void square() {
        Square sq = new Square(100, 200, 100);
        sq.draw(w);
    }

    public void block(int x, int y) {
        int left = x * blockSize;
        int right = left + blockSize - 1;
        int top = y * blockSize;
        int bottom = top + blockSize - 1;
        for (int row = top; row <= bottom; row++) {
            w.moveTo(left, row);
            w.lineTo(right, row);
        }
    }

}
