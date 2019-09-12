import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
        w.moveTo(0, 0);

        // vänta tills användaren klickar på en musknapp
        w.waitForMouseClick();
        // rita en linje till den punkt där användaren klickade
        int finalX = w.getMouseX();
        int finalY = w.getMouseY();
        w.lineTo(finalX, finalY);

        w.moveTo(0,0);

        w.waitForMouseClick();

        int x2 = w.getMouseX();
        int y2 = w.getMouseY();
        w.lineTo(x2, y2);


    }

}
