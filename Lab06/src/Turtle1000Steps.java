import se.lth.cs.pt.window.SimpleWindow;

import java.awt.*;
import java.util.Random;

public class Turtle1000Steps {

    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
        Random random = new Random();
        Turtle t = new Turtle(w, 300, 300);

        t.penDown();

        for (int i = 0; i < 1000; i++) {

            //random step length within range [1,10]
            int randomStepLength = random.nextInt(10) + 1;
            //rotation at random number of degrees within range [-180,180]
            int randomDegreeRotation = random.nextInt(360) - 180;
            t.forward(randomStepLength);
            t.left(randomDegreeRotation);

            //Delay to show it as animation
            SimpleWindow.delay(10);
        }
    }
}
