package sevncz;

public class FibMain {

  public static void main(String[] args) {
    //
    System.out.println(fib(10));
  }

  public static int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int last1 = 0;
    int last2 = 1;
    int res = 0;
    for (int i = 2; i <= n; i++) {
      res = last1 + last2;
      last1 = last2;
      last2 = res;
    }
    return res;
  }
}
