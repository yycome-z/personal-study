package main.java.leetcode.dp.pathAbout;

/**
 * @author zhangyaoyuan
 * @date 2023/09/12
 */
public class Code63 {

    /**
     * 关键仍然是初始值的赋值，因为有障碍物，所以加了一些判断而已
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp[i][j] 代表到达(i, j)位置时可选的路径数量
        int[][] dp = new int[m][n];

        boolean flag = true;
        for (int i = 0; i < m; i++) {
            if (flag) {
                if (obstacleGrid[i][0] == 1) {
                    flag = false;
                    // 注：这里以及下面的else条件都可以简化，因为int数组如果不赋值，默认就是0
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = 1;
                }
            } else {
                dp[i][0] = 0;
            }
        }
        flag = true;
        for (int i = 0; i < n; i++) {
            if (flag) {
                if (obstacleGrid[0][i] == 1) {
                    flag = false;
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = 1;
                }
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
