package sevncz.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程模拟百米赛跑
 */
public class RunnerSport100WinnerThread {
  private static int SPORT_MAN_COUNT = 8;
  private static final Random random = new Random();
  private static final CountDownLatch readyLatch = new CountDownLatch(SPORT_MAN_COUNT);
  private static AtomicBoolean STOP = new AtomicBoolean(false);
  private static final Integer TOP_N = 3;
  private static CountDownLatch startLatch = new CountDownLatch(1);
  private static CountDownLatch endLatch = new CountDownLatch(TOP_N);

  private static Map<String, Integer> sort = new HashMap<>();

  private CyclicBarrier cyclicBarrier = new CyclicBarrier(TOP_N, new Runnable() {
    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + ": 已到达");
    }
  });

  public static void main(String[] args) throws InterruptedException {
    //百米赛跑
    ExecutorService fixedService = Executors.newFixedThreadPool(SPORT_MAN_COUNT);
    for(int i=0;i<SPORT_MAN_COUNT;i++) {
      fixedService.submit(new Runnable() {
        @Override
        public void run() {
          readyLatch.countDown();
//          System.out.println(Thread.currentThread().getName() + ": Ready");
          try {
            readyLatch.await();
            startLatch.await();
//            System.out.println(Thread.currentThread().getName() + ": Start");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          int i = 0;
          while(i<=99) {
            try {
              Thread.sleep(1);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            if(STOP.get()) {
              break;
            }
            i++;
            sort.put(Thread.currentThread().getName(), i);
          }
          endLatch.countDown();
        }
      });
    }
    Thread.sleep(100);
    startLatch.countDown();
    endLatch.await();
    STOP.set(true);
    sort.forEach((k,v) -> {
      System.out.println(k + "~:~" + v);
    });
    fixedService.shutdown();
  }
}
