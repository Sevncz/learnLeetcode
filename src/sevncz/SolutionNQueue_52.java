package sevncz;

import java.util.HashSet;
import java.util.Set;

class SolutionNQueue_52 {
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    int res = 0;

    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        dfs(0, chess);
        return res;
    }

    private char[][] initChess(int n) {
        char[][] chess = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        return chess;
    }

    public void dfs(int row, char[][] chess) {
        // 最后一层退出
        if (row >= chess.length) {
            res = res + 1;
            return ;
        }
        for (int i = 0; i < chess.length; i++) {
            // 枚举每一个col是否可以放棋子
            if (!pie.contains(i + row) && !na.contains(i - row) && !col.contains(i)) {
                chess[row][i] = 'Q';
                // 保存状态
                col.add(i);
                pie.add(i + row);
                na.add(i - row);
                // 向下一层走
                dfs(row + 1, chess);
                // 恢复状态
                chess[row][i] = '.';
                col.remove(i);
                pie.remove(i + row);
                na.remove(i - row);
            }
        }
    }
}