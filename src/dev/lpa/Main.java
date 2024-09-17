package dev.lpa;

public class Main {

  public static void main(String[] args) {

    System.out.println("Main thread is running.");
    try {
      System.out.println("Main thread is paused for 1 second.");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Thread thread = new Thread(() -> {
      String tname = Thread.currentThread().getName();
      System.out.println(tname + " should take 10 dots to run.");
      for (int i = 0; i < 10; i++) {
        System.out.print(". ");
        try {
          Thread.sleep(500);
          System.out.println("A. State = " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
          System.out.println("\nWhoops!! " + tname + " interrupted.");
          System.out.println("A1. State = " + Thread.currentThread().getState());
          return;
        }
      }
      System.out.println("\n" + tname + " completed.");
    });

    System.out.println(thread.getName() + " starting");
    thread.start();

    System.out.println("Main thread would continue here.");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread.interrupt();
  }
}
