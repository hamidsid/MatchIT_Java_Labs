import se.lth.cs.pt.window.SimpleWindow;

import java.awt.*;
import java.util.Random;
public class TwoTurtles {

    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
        Random random = new Random();
        Turtle t1 = new Turtle(w, 350, 350);
        Turtle t2 = new Turtle(w, 250, 250);

        t1.penDown();
        t2.penDown();

        while (TwoTurtles.calculateDistanceBetweenTwoTurtles(t1,t2) >= 50){

            //random step length within range [1,10]
            int randomStepLength1 = random.nextInt(10) + 1;
            int randomStepLength2 = random.nextInt(10) + 1;

            //rotation at random number of degrees within range [-180,180]
            int randomDegreeRotation1 = random.nextInt(360) - 180;
            int randomDegreeRotation2 = random.nextInt(360) - 180;

            t1.forward(randomStepLength1);
            t1.left(randomDegreeRotation1);
            t2.forward(randomStepLength2);
            t2.left(randomDegreeRotation2);

            //Delay to show it as animation
            SimpleWindow.delay(10);
        }
    }

    public static double calculateDistanceBetweenTwoTurtles(Turtle t1, Turtle t2) {
        double x1 = t1.getX();
        double y1 = t1.getY();
        double x2 = t2.getX();
        double y2 = t2.getY();

        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
