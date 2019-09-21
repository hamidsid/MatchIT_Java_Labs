import se.lth.cs.pt.window.SimpleWindow;

import java.awt.*;

public class Turtle {
    private double x;
    private double y;
    private boolean isPendDown;
    private SimpleWindow w;
    private double headDirection = (Math.PI / 2);

    /**
     * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
     * sköldpaddan i punkten x,y med pennan lyft och huvudet pekande rakt uppåt
     * i fönstret (i negativ y-riktning)
     */
    public Turtle(SimpleWindow w, double x, double y) {
        this.w = w;
        this.x = x;
        this.y = y;
    }

    /**
     * Sänker pennan
     */
    public void penDown() {
        isPendDown = true;
    }

    /**
     * Lyfter pennan
     */
    public void penUp() {
        isPendDown = false;
    }

    /**
     * Går rakt framåt n pixlar i den riktning som huvudet pekar
     */
    public void forward(int n) {

        //first check if pen is down
        if (isPendDown) {

            //start from the current position of x and y
            w.moveTo((int) Math.round(x), (int) Math.round(y));

            //update x and y values with accordance to the head direction
            x += n * Math.cos(headDirection);
            y -= n * Math.sin(headDirection);

            w.lineTo((int) Math.round(x), (int) Math.round(y));
        }
    }

    /**
     * Vrider beta grader åt vänster runt pennan
     */
    public void left(int beta) {

        //change degree to radian and add it to the current value of head angle direction
        this.headDirection += Math.toRadians(beta);
    }

    /**
     * Går till punkten newX,newY utan att rita. Pennans läge (sänkt eller lyft)
     * och huvudets riktning påverkas inte
     */
    public void jumpTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        w.moveTo(newX, newY);

    }

    /**
     * Återställer huvudriktningen till den ursprungliga
     */
    public void turnNorth() {
        this.headDirection = Math.PI / 2;
    }

    /**
     * Tar reda på x-koordinaten för sköldpaddans aktuella position
     */
    public int getX() {
        return (int) Math.round(x);
    }

    /**
     * Tar reda på y-koordinaten för sköldpaddans aktuella position
     */
    public int getY() {
        return (int) Math.round(y);
    }

    /**
     * Tar reda på sköldpaddans riktning, i grader från positiv x-led
     */

    public int getDirection() {
        return (int) Math.toDegrees(headDirection);
    }
}