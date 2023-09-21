package main.java.leetcode.dp.pathAbout;

/**
 * 不同路径
 *
 * 一个机器人位于一个 m * n 网格的左上角（起点在下图中标记为 “Start”）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图标记为 “Finish”）。
 * 问总共有多少条不同的路径。
 *
 * 输入：m = 3，n = 7
 * 输出：28
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10^9
 *
 * @author zhangyaoyuan
 * @date 2023/09/12
 */
public class Code62 {

    /**
     * 此题关键是赋初始值：
     * 对于第 1 行的每个网格 (0, i)，从 (0,0) 过去只有一条路径，即 dp[0][i] = 1。
     * 同理对于第 1 列的每个网格 (i, 0)，从 (0,0) 过去也只有一条路径，即 dp[i][0] = 1。
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // dp[i][j] 代表到达(i, j)时可选路径个数
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
