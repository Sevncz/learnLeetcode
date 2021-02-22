package sevncz.thread;

public class LockLearn {
  static final Object LOCK_A = new Object();
  static final Object LOCK_B = new Object();

  public static void add() throws InterruptedException {
    System.out.println("try get lock A...");
    synchronized (LOCK_A) {
      System.out.println("lock A got.");
      Thread.sleep(1000);
      System.out.println("try get lock B...");
      synchronized (LOCK_B) {
        System.out.println("lock B got.");
        Thread.sleep(1000);
      }
    }
  }

  public static void dec() throws InterruptedException {
    System.out.println("try get lock B...");
    synchronized (LOCK_B) {
      System.out.println("lock B got.");
      Thread.sleep(1000);
      System.out.println("try get lock A...");
      synchronized (LOCK_A) {
        System.out.println("lock A got.");
        Thread.sleep(1000);
      }
    }
  }

  public static void main(String[] args) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          LockLearn.add();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          LockLearn.dec();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

  }
}
