public class Mole {

    private static int width = 60;
    private static int height = 30;
    private static int blockSize = 30;

    public static void main(String[] args) {
        Mole m = new Mole();
        Graphics graphics = new Graphics(width, height, blockSize);

        m.drawWorld(graphics);
        m.move(graphics);
    }

    private void drawWorld(Graphics graphics) {
        graphics.rectangle(0, 0, width, height, Colors.SOIL);
        //graphics.rectangle(0,0,width,height, Colors.SKY);
    }


    private void move(Graphics graphics) {

        // To start in the middle
        int x = width / 2;
        int y = height / 2;

        while (true) {

            // Border for the mole.
            if (x > (width - 1)) {
                x -= 1;
            } else if (y > (height - 1)) {
                y -= 1;
            } else if (x < 0) {
                x += 1;
            } else if (y < 0) {
                y += 1;
            }

            graphics.block(x, y, Colors.MOLE);
            char key = graphics.waitForKey();

            //once the movement is started, change the color.
            graphics.block(x, y, Colors.TUNNEL);

            //Move according to the keyboard keys
            if (key == 'w') {
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
