import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;
public class MazeWalker {
    private Turtle turtle;

    public MazeWalker(Turtle turtle) {
        this.turtle = turtle;

    }

    /**
     * Allows the turtle to wander through the Maze maze, from
     * the entrance to the exit.
     */
    public void walk(Maze maze) {

        //down the pen to start drawing
        turtle.penDown();

        //Continue till the point where turtle is at (or near) the exit
        while (!maze.atExit(turtle.getX(), turtle.getY())) {

            //if there is no wall to the left, make turtle turn 90 to the left
            if (!maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY())) {
                turtle.left(90);
            } else if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY())) {

                //if there is a wall to the left then continue straight
                turtle.left(0);

                //but if there is wall both in front and to the left then make turtle turn -90 degrees
                if (maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY()) &&
                        maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY())) {
                    turtle.left(-90);
                }

            }

            turtle.forward(1);
            SimpleWindow.delay(10);
        }

        turtle.penUp();
    }
} 