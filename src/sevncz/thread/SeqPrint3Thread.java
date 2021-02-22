package sevncz.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 3个线程顺序打印A,B,C
 */
public class SeqPrint3Thread {
  private static final Object lockObject = new Object();
  private final AtomicInteger times = new AtomicInteger(9);
  private final AtomicInteger index = new AtomicInteger(0);
  private int state = 0;

  public static void main(String[] args) throws InterruptedException {
    SeqPrint3Thread seqPrint3Thread = new SeqPrint3Thread();
    // 顺序打印
    Thread threadA =
        new Thread(
            () -> {
              seqPrint3Thread.printNum("A", 0);
            },
            "A");
    Thread threadB =
        new Thread(
            () -> {
              seqPrint3Thread.printNum("B", 1);
            },
            "B");
    Thread threadC =
        new Thread(
            () -> {
              seqPrint3Thread.printNum("C", 2);
            },
            "C");
    threadA.start();
    Thread.sleep(1);
    threadB.start();
    Thread.sleep(1);
    threadC.start();
  }

  private void printNum(String name, Integer targetState) {
    while (index.get() < times.get()) {
      synchronized (lockObject) {
        while (state % 3 != targetState) {
          try {
            lockObject.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        state++;
        if(state <= times.get()) {
          index.incrementAndGet();
          System.out.println(name + ":" + state);
        }
        lockObject.notifyAll();
      }
    }
  }
}
