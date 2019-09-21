package polygon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import se.lth.cs.pt.window.SimpleWindow;

public class OnePolygon {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("polygon1"));
		Polygon pol = new Polygon();
		while (scan.hasNextInt()) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			pol.addVertex(x, y);
		}
		SimpleWindow w = new SimpleWindow(600, 600, "A polygon");
		pol.draw(w);
	}

}

