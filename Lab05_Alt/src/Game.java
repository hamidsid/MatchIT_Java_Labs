import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    Map map = new Map();
    private int x;
    private int y;
    private int WIDTH;
    private int HEIGHT;

    public Game (Graphics graphics, int WIDTH, int HEIGHT){
        this.x = graphics.getWidth () / 2; // To start in the middle
        this.y = graphics.getHeight () / 2;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void dig(Graphics graphics){

        while (true) {
            // Set the border that mole can go.
            if(x > (WIDTH -1)) {
                x -= 1;
            }else if(y > (HEIGHT -1)){
                y -= 1;
            }else if(x < 0){
                x += 1;
            }else if (y < (HEIGHT/2 - HEIGHT/4)){
                y += 1;
            }

            graphics.block(x, y, Colors.MOLE, graphics.getBlockSize());
            char key = graphics.waitForKey();
            graphics.block(x, y, getColor(y), graphics.getBlockSize());  // Check for the color after Mole pass a point.

            if (key == 'w') {   // Listen to keyboard.
                y--;
            } else if (key == 'a') {
                x--;
            } else if (key == 's') {
                y++;
            } else if (key == 'd') {
                x++;
            }
            System.out.println(x + "   " + y);
            if(graphics.isInStone(x, y)){
                if (key == 'w') {   // Listen to keyboard.
                    y++;
                } else if (key == 'a') {
                    x++;
                } else if (key == 's') {
                    y--;
                } else if (key == 'd') {
                    x--;
                }
            }
        }
    }

    public Color getColor(int y){
        if (y < (HEIGHT/2 - HEIGHT/4)) {
            return Colors.SKY;
        }
        if ( y < (HEIGHT/2 - HEIGHT/5)){
            return Colors.GRASS;
        }else {
            return Colors.TUNNEL;
        }
    }


}
