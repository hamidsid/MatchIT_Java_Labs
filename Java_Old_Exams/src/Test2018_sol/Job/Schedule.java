package Test2018_sol.Job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Schedule {

  private Worker[] workers;

  /**
   * Skapar ett schema (utan några jobb) för arbetarna i vektorn workers
   */
  Schedule(Worker[] workers) {

    this.workers = workers;
  }

  /**
   * Fördelar jobben i listan jobs på arbetarna. Listan jobs är inte sorterad och får ändras i
   * metoden
   */
  public void makeSchedule(ArrayList<Job> jobs) {

    // first remove all past jobs of workes
    for (int i = 0; i < workers.length; i++) {
      workers[i].clearJobs();
    }

    //while there is job, first get the longest job
    //then assign it to a free worker

    while (!jobs.isEmpty()) {
      Job longest = getLongest(jobs);
      Worker firstReady = findFreeWorker();
      firstReady.assignJob(longest);
    }
  }

  private Worker findFreeWorker() {

    //the least total time for worker is the most free one.
    return Collections.min(Arrays.asList(workers), Comparator.comparing(Worker::getTotalTime));
  }

  private Job getLongest(ArrayList<Job> jobs) {

    Job longestJob = Collections.max(jobs, Comparator.comparing(Job::getLength));
    jobs.remove(longestJob);
    return longestJob;
  }

  /**
   * Tar bort och returnerar nästa jobb som arbetaren med nummer wNbr ska utföra. Arbetarna numreras
   * med början på 1. Ger null om wNbr är felaktigt eller om arbetaren är klar med alla sina jobb
   */
  public Job getNextJob(int wNbr) {
    if (wNbr < 1 || wNbr > workers.length) {
      return null;
    }
    return workers[wNbr - 1].getNextJob();
  }

  public int getThelongest(ArrayList<Job> jobs) {

    Job longest = getLongest(jobs);
    return longest.getLength();
  }
}