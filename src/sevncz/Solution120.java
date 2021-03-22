package sevncz;

import java.util.List;

public class Solution120 {
  public static void main(String[] args) {
    //
    Solution120 sol = new Solution120();

  }

  public int minSum = Integer.MAX_VALUE;

  public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle.size() == 0 || triangle.get(0).size() == 0) {
      return 0;
    }
    int min = dfs(triangle, 0, 0, "", 0);
    return minSum;
  }

  public int dfs(List<List<Integer>> triangle, int i, int j, String path, int sum) {
    if(i == triangle.size() - 1) {
      path += triangle.get(i).get(j);
      sum += triangle.get(i).get(j);
      if(minSum > sum) {
        minSum = sum;
      }
      return 0;
    }

    path += triangle.get(i).get(j);
    sum += triangle.get(i).get(j);

    dfs(triangle, i + 1, j, path, sum);
    dfs(triangle, i + 1, j + 1, path, sum);

    return sum;
  }

}
