import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.*;;




public class DrawSquare {
	
	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(600, 600, "Square");
		Square sq = new Square(200,200,300);
		sq.draw(w);
		System.out.println(sq.getArea());
	}

}
