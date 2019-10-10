package Test2018_sol.Job;

import java.util.ArrayList;

public class Worker {

  private ArrayList<Job> jobs;

  /**
   * Skapar en ny arbetare utan tilldelade jobb
   */
  Worker() {
    jobs = new ArrayList<>();
  }

  /**
   * Tar reda på den totala tiden för arbetarens alla jobb
   */
  int getTotalTime() {
    int totalTime = 0;

    for (int i = 0; i < jobs.size(); i++) {
      totalTime += jobs.get(i).getLength();
    }

    return totalTime;
  }

  /**
   * Tilldelar jobbet j till arbetaren
   */
  void assignJob(Job j) {
    jobs.add(j);
  }

  /**
   * Tar bort och returnerar nästa jobb som arbetaren ska utföra. Ger null om arbetaren är klar med
   * alla sina jobb
   */
  Job getNextJob() {

    if (jobs.isEmpty()) {
      return null;
    }
    return jobs.remove(0);
  }

  public void clearJobs() {
    jobs.clear();
  }
}
