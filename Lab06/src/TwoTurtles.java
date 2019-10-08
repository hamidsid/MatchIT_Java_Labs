import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;
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
            int turtle1StepLength = random.nextInt(10) + 1;
            int turtle2StepLength = random.nextInt(10) + 1;

            //rotation at random number of degrees within range [-180,180]
            int turtle1Rotation = random.nextInt(360) - 180;
            int turtle2Rotation = random.nextInt(360) - 180;

            t1.forward(turtle1StepLength);
            t1.left(turtle1Rotation);
            t2.forward(turtle2StepLength);
            t2.left(turtle2Rotation);

            //Delay to show it as animation
            //SimpleWindow.delay(5);
        }
    }

    //Calculate distance between two turtles
    public static double calculateDistanceBetweenTwoTurtles(Turtle t1, Turtle t2) {
        double x1 = t1.getX();
        double y1 = t1.getY();
        double x2 = t2.getX();
        double y2 = t2.getY();

        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
