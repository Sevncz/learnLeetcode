package sevncz.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 3个线程顺序打印A,B,C，用信号量实现
 */
public class SeqPrint3ThreadUsingSemaphore {
  private static final Object lockObject = new Object();
  private static Semaphore semaphoreA = new Semaphore(1);
  private static Semaphore semaphoreB = new Semaphore(0);
  private static Semaphore semaphoreC = new Semaphore(0);
  private final AtomicInteger index = new AtomicInteger(0);
  private final int times = 10;
  private int state = 0;

  public static void main(String[] args) throws InterruptedException {
    SeqPrint3ThreadUsingSemaphore seqPrint3Thread = new SeqPrint3ThreadUsingSemaphore();
    // 顺序打印
    Thread threadA =
        new Thread(
            () -> {
              seqPrint3Thread.printNum("A", semaphoreA, semaphoreB);
            },
            "A");
    Thread threadB =
        new Thread(
            () -> {
              seqPrint3Thread.printNum("B", semaphoreB, semaphoreC);
            },
            "B");
    Thread threadC =
        new Thread(
            () -> {
              seqPrint3Thread.printNum("C", semaphoreC, semaphoreA);
            },
            "C");
    threadA.start();
    Thread.sleep(1);
    threadB.start();
    Thread.sleep(1);
    threadC.start();
  }

  private void printNum(String name, Semaphore current, Semaphore next) {
    for (int i = 0; i < times; i++) {
      try {
//        System.out.println("111" + Thread.currentThread().getName());
        current.acquire();  // A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
        System.out.println(Thread.currentThread().getName() + " : " + name);
        next.release();    // B释放信号，B信号量加1（初始为0），此时可以获取B信号量
//        System.out.println("222" + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
