import java.util.Random;

public class Mole {

    private static int width = 60;
    private static int height = 30;
    private static int bs = 30;

    public static void main(String[] args) {
        Mole m = new Mole();
        Graphics graphics = new Graphics(width, height, bs);
        Talpa talpa = new Talpa(graphics, width, height);

        m.drawWorld(graphics);
        talpa.move(graphics);
    }

    public void drawWorld(Graphics graphics){

        graphics.rectangle(0, 0, width, height, Colors.SOIL);


    }


}
