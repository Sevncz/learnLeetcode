package sevncz.arrays;

public class BSearch {
  public static void main(String[] args) {
    int[] arr = new int[]{2,5,5,6,9,9,9,10};
    int index = bsearch(arr, arr.length, 5);
    System.out.println(index);
  }

  public static int bsearch(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;

    while(low <= high) {
      int mid = low + ((high - low) >> 1);
      if(a[mid] > value) {
        high = mid - 1;
      }else if(a[mid] < value) {
        low = mid + 1;
      }else{
        if((mid == 0) || a[mid - 1] != value) {
          return mid;
        }else{
          high = mid - 1;
        }
      }
    }

    return -1;
  }

}
