package Test2018_sol.Job;

import java.util.ArrayList;
import java.util.Collections;

public class TestClass {

  public static void main(String[] args) {

    ArrayList<Job> jobs = new ArrayList<>();
    Job job1 = new Job(4);
    Job job2 = new Job(1);
    Job job3 = new Job(3);
    Job job4 = new Job(3);
    Job job5 = new Job(5);
    Job job6 = new Job(3);
    Job job7 = new Job(3);
    Job job8 = new Job(2);
    Job job9 = new Job(3);
    Job job10 = new Job(4);
    Job job11 = new Job(2);

    //add jobs to the list
    Collections.addAll(jobs, job1, job2, job3, job4, job5, job6, job7, job8, job9, job10, job11);

    Worker[] workers = new Worker[5];

    Worker w1 = new Worker();
    Worker w2 = new Worker();
    Worker w3 = new Worker();
    Worker w4 = new Worker();
    Worker w5 = new Worker();

    workers[0] = w1;
    workers[1] = w2;
    workers[2] = w3;
    workers[3] = w4;
    workers[4] = w5;
    Schedule schedule = new Schedule(workers);
    schedule.makeSchedule(jobs);

    System.out.println(workers[0].getTotalTime());
    System.out.println(workers[1].getTotalTime());
    System.out.println(workers[2].getTotalTime());
    System.out.println(workers[3].getTotalTime());
    System.out.println(workers[4].getTotalTime());

  }
}
