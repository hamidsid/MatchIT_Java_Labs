import se.lth.cs.pt.window.SimpleWindow;

import java.awt.*;
import java.util.ArrayList;

public class Graphics {

    private SimpleWindow w;
    private int width;
    private int blockSize;
    private int height;
    private char key;
    private int x;
    private int y;
    private ArrayList<Map> stoneArr = new ArrayList<>();

    public Graphics(int w, int h, int bs){
        this.width = w;
        this.height = h;
        this.blockSize = bs;
        this.w = new SimpleWindow(width*blockSize, height*blockSize, "Digging");
    }

    public void square(){   // Create a square withe the size of 10.
        w.moveTo (10, 10);
        w.lineTo (10, 20);
        w.lineTo (20, 20);
        w.lineTo (20, 10);
        w.lineTo (10, 10);
    }

    /**
     * Create square line by line and set the color.
     * @param x position where it start to draw 10x10 block.
     * @param y position where it start to draw 10x10 block.
     * @param color of the block.
     */
    public void block(int x, int y, Color color, int blockSize){
        this.x = x;
        this.y = y;
        w.setLineColor (color);
        int left = x * blockSize;
        int right = left + blockSize - 1;
        int top = y * blockSize;
        int bottom = top + blockSize - 1;
        for (int row = top; row <= bottom; row ++) {
            w.moveTo (left, row);
            w.lineTo (right, row);
        }
    }

    /**
     * Create the sky, grass and underground panels with the Color c.
     * @param x position to start the rectangle.
     * @param y position to start the rectangle.
     * @param width of the rectangle.
     * @param height of the rectangle.
     * @param c is the color that paints the rectangle
     */
    public void rectangle(int x, int y, int width, int height, Color c){
        for (int yy = y; yy <y + height; yy ++) {
            for (int xx = x; xx <x + width; xx ++) {
                block (xx, yy, c, this.blockSize);
            }
        }
    }

    public Color GetLineColor(int x, int y, char key){
        this.key = key;

        if (key == 'w') {   // Listen to keyboard.
            this.y--;
            return w.getLineColor();
        } else if (key == 'a') {
            this.x--;
            return w.getLineColor();
        } else if (key == 's') {
            this.y++;
            return w.getLineColor();
        } else if (key == 'd') {
            this.x++;
            return w.getLineColor();
        }
        return w.getLineColor();
    }

    public void cloud (int x, int y, int height, int width, Color color){
        int counter = 1;
        int rectangleStartX = 0;
        //block(x, y-1, Colors.GRASS);
        for (int xx = x ; xx <= (x + (3*height)/7) && counter < (width / 2); xx++){
            for (int yy = y - counter; yy <= y + counter && counter < (width/2); yy++) {
                block(xx, yy, color, getBlockSize()/10);
            }
            counter++;
            rectangleStartX = xx +1;
        }
        counter--;
        for (int yy = y - counter; yy <= (y + counter); yy ++) {
            for (int xx = rectangleStartX; xx < (x + (4*height)/7); xx ++) {
                block (xx, yy, color, getBlockSize()/10);
            }
        }

        for (int xx = (x + (4*height)/7); xx < (x + height) && counter > 0; xx++){
            for (int yy = y - counter; (yy <= y + counter ) && counter >= 0; yy++) {
                block(xx, yy, color, getBlockSize()/10);
            }
            counter--;
        }
    }

    public void stoneRectangle(int x, int y, int width, int height, Color c){
        for (int yy = y; yy <y + height; yy ++) {
            for (int xx = x; xx <x + width; xx ++) {
                block (xx, yy, c, this.blockSize);
                Map map = new Map();
                map.x = xx;
                map.y = yy;
                stoneArr.add(map);
            }
        }
    }

    public void stone(int x, int y, int width, int height){
        stoneRectangle(x, y + height/2, width/4, height/2, Colors.STONE);
        stoneRectangle(x + (width/4), y +1, width/2, height-1, Colors.STONE);
        stoneRectangle(x + (3 * width) / 4, y + height/2, width/4, height/2, Colors.STONE);
    }

    public boolean isInStone(int x, int y){
        boolean flag = false;
        for (int i = 0; i < stoneArr.size(); i++) {
            System.out.println(stoneArr.get(i).x + "" + stoneArr.get(i).y);
            System.out.println(stoneArr.size());
            flag =  (x == stoneArr.get(i).x) && (y == stoneArr.get(i).y);
            if (flag){
                return true;
            }
        }
        return flag;
    }

    /**
     *
     * @return the keyboard out put as a character.
     */
    public char waitForKey(){
        return w.waitForKey();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() { return height; }
    public int getBlockSize() { return this.blockSize; };
    public ArrayList getStroneArr(){ return  this.stoneArr; }
}
