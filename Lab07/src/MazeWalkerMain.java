import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

import java.util.Scanner;

public class MazeWalkerMain {
	public static void main(String[] args) {

		//Let the user choose which maze should be selected
		Scanner scanner = new Scanner(System.in);
		Maze m = new Maze(scanner.nextInt());

		SimpleWindow w = new SimpleWindow(600, 600, "MazeSolver");

		//Create the turtle object, starting point of the turtle is the entry of the maze
		Turtle turtle = new Turtle(w,m.getXEntry(), m.getYEntry());

		MazeWalker mazeWalker = new MazeWalker(turtle);
		m.draw(w);
		mazeWalker.walk(m);
	}
}