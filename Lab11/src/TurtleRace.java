import java.util.ArrayList;

public class TurtleRace {

  public static void main(String[] args) {

    RaceWindow w = new RaceWindow();

    ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
    ArrayList<RaceTurtle> winners = new ArrayList<RaceTurtle>();

    //Create 8 turtles and store them in the arrayList
    for (int i = 0; i < 8; i++) {
      RaceTurtle raceTurtle = new RaceTurtle(w, i + 1);
      turtles.add(raceTurtle);
    }

    //store the winners of the race in the arrayList
    while (!turtles.isEmpty()) {

      for (int j = 0; j < turtles.size(); j++) {
        turtles.get(j).raceStep();
        RaceWindow.delay(5);
        if (turtles.get(j).getX() > RaceWindow.X_END_POS) {
          winners.add(turtles.get(j)); //add to the winners list
          turtles.remove(j); //remove the winner from the winners list
        }
      }
    }

    for (int a = 1; a < 4; a++) {
      System.out.println(" på plats nummer " + a + " : " + winners.get(a - 1).toString());
    }
  }
}