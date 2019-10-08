package polygon;

import se.lth.cs.pt.window.SimpleWindow;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManyPolygon {

    public static void main(String[] args) throws FileNotFoundException {

        //let the user choose the file
        String fileName = ManyPolygon.chooseFile();

        //Create a scan object and load the file content into it
        Scanner scan = new Scanner(new File(fileName));

        //find a better way for the number of polygons
       Polygon[] polygons = new Polygon[3];
        SimpleWindow w = new SimpleWindow(600, 600, "A polygon");

        while (scan.hasNext()) { // read the whole file till the last line
            String line = scan.nextLine(); //store each line in a string

            //convert the string line to a scanner object for easy traversing
            Scanner numbers = new Scanner(line);

            //keep the track of polygons
            int counter = 0;
            polygons[counter] = new Polygon();
            while (numbers.hasNextInt()) {
                int x = numbers.nextInt();
                int y = numbers.nextInt();
                polygons[counter].addVertex(x, y);
            }
            polygons[counter].draw(w);
            counter++;
        }
        scan.close();
    }

    private static String chooseFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        return dialog.getFile();
    }
}
