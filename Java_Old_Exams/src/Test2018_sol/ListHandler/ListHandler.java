package Test2018_sol.ListHandler;

import java.util.ArrayList;

public class ListHandler {

  /**
   * Lägger till ordet word sist i listan wordList om det inte redan finns där. Returnerar true om
   * ordet har lagts till, annars false.
   */

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("ett");
    list.add("två");
    list.add("tre");
    ListHandler.add(list, "tre");

    System.out.println(list.toString());

    int sum = 0;
    for (int k = 0; k < 2; k++) {
      for (int i = 0; i < 3; i++) {
        sum = sum + 1;
        if (i == 1) {
          break;
        }
      }
      sum = sum + 10;
    }
    System.out.println(sum);
  }

  public static boolean add(ArrayList<String> wordList, String word) {

    for (int i = 0; i < wordList.size(); i++) {
      if (wordList.get(i).equals(word)) {
        return false;
      }
    }
    wordList.add(word);
    return true;
  }
}
