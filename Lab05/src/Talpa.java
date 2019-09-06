public class Talpa {
    private int x;
    private int y;
    private int WIDTH;
    private int HEIGHT;

    public Talpa(Graphics graphics, int WIDTH, int HEIGHT) {
        this.x = graphics.getWidth() / 2; // To start in the middle
        this.y = graphics.getHeight() / 2;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void move(Graphics graphics) {

        while (true) {

            graphics.block(x, y, Colors.MOLE);
            char key = graphics.waitForKey();

            if (key == 'w') {   // Listen to keyboard.
                y--;
            } else if (key == 'a') {
                x--;
            } else if (key == 's') {
                y++;
            } else if (key == 'd') {
                x++;
            }
        }
    }


}
