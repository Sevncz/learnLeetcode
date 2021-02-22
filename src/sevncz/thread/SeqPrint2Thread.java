package sevncz.thread;

/**
 * 两个线程顺序打印奇偶数
 */
public class SeqPrint2Thread {
  private static final Object lockObject = new Object();
  private static int count = 1;

  public static void main(String[] args) throws InterruptedException {
    // 顺序打印
    Thread threadA = new Thread(new Helper(), "A");
    Thread threadB = new Thread(new Helper(), "B");
    threadA.start();
    Thread.sleep(1);
    threadB.start();
  }

  static class Helper implements Runnable {

    @Override
    public void run() {
      while(count <= 100) {
        synchronized(lockObject) {
          System.out.println(Thread.currentThread().getName() + ":" + count++);
          lockObject.notifyAll();
          if(count <= 100) {
            try {
              lockObject.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }
  }
}
