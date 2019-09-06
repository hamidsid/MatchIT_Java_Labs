import java.util.Random;

public class Mole {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final int BLOCK_SIZE = 30;

    Random random = new Random();

    public static void main(String[] args) {
        Mole m = new Mole();
        Graphics graphics = new Graphics(WIDTH, HEIGHT, BLOCK_SIZE);
        Game game = new Game(graphics, WIDTH, HEIGHT);

        m.drawWorld(graphics);  // Draw the world (Sky, Grass and under ground)
        game.dig(graphics);    // Listen the keyboard and check the border that mole can move.
    }

    public void drawWorld(Graphics graphics){

        int randNrX;
        int randNrY;

        graphics.rectangle(0, 0, WIDTH, (HEIGHT/2 - HEIGHT/4), Colors.SKY); // Draw the sky.
        graphics.rectangle(0, (HEIGHT/2 - HEIGHT/4), WIDTH, HEIGHT/20, Colors.GRASS);   // Draw the grass.
        // Draw the underground
        graphics.rectangle(0, (HEIGHT/2 - HEIGHT/5), WIDTH, (HEIGHT/2 + HEIGHT/5), Colors.SOIL);
        for (int i = 0; i < 20 ; i++) {
            randNrX = random.nextInt(WIDTH*10);
            randNrY = random.nextInt((HEIGHT/2 - HEIGHT/4)*3);
            graphics.cloud(randNrX, randNrY + 10, 40, 20, Colors.CLOUD);
        }
        graphics.stone( 10, 15, 5, 5);


    }


}
