package sevncz.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程计数
 */
public class CountWordThread {

  public static void main(String[] args) {
    //
    long start = System.currentTimeMillis();
    Random random = new Random(999);
    List<Integer> arr = new ArrayList<>(100000);
    for(int i=0;i<1000000;i++) {
      arr.add(random.nextInt(100));
    }

    Map<Integer, AtomicInteger> map = new ConcurrentHashMap<>(100);
    arr.forEach(a -> {
      map.put(a, new AtomicInteger(0));
    });
    arr.parallelStream().forEach(a -> {
      System.out.println(Thread.currentThread().getName());
      AtomicInteger ai = map.get(a);
      ai.incrementAndGet();
    });
    int total = 0;
    for (Entry<Integer, AtomicInteger> entry : map.entrySet()) {
      Integer k = entry.getKey();
      AtomicInteger v = entry.getValue();
      total = v.get() + total;
//      System.out.println("k = " + k + " v = " + v.get());
    }
    System.out.println("cost : " + (System.currentTimeMillis() - start) + "ms total :" + total);

  }



}
