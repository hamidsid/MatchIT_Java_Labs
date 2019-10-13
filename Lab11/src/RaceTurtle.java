import java.util.Random;

public class RaceTurtle extends Turtle {

  private int nbr;

  Random random = new Random();

  /**
   * Skapar en sköldpadda som ska springa i fönstret w och som har start- nummer nbr. Sköldpaddan
   * startar med pennan nere och vänd åt höger.
   */

  RaceTurtle(RaceWindow w, int nbr) {
    super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));

    this.nbr = nbr; //starting point (position) for the turtle
    this.left(-90); //turtle starts with turning right
    this.penDown(); // trutle start with the pen down
  }

  /**
   * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett slumptal (heltal) mellan 1 och
   * 6.
   */
  void raceStep() {
    super.forward(random.nextInt(6) + 1);
  }

  /**
   * Returnerar en läsbar representation av denna RaceTurtle, på formen "Nummer x" där x är
   * sköldpaddans startnummer.
   */
  public String toString() {
    return ("Nummer " + nbr);
  }

}
