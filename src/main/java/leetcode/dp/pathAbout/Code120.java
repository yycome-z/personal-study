package main.java.leetcode.dp.pathAbout;

import java.util.List;

/**
 * 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的节点上。相邻的节点指的是下标与上一层节点下标相同或者等于上一层节点下标 + 1 的两个节点
 * 。也就是说，如果正位于当前行的下标 i，那么下一步可以移动到下一行的下标 i 或 i + 1。
 * <p>
 * 提示
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 * @author zhangyaoyuan
 * @date 2023/09/12
 */
public class Code120 {

    /**
     * 此题和之前的不同点为状态方程的执行顺序为从最后一行到第一行，因此赋初始值时要注意赋值最后一行的值
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        // dp[i][j]代表从最后一行到第i行j列最小的路径和
        int[][] dp = new int[m][n];

        for (int i = 0; i < triangle.get(m - 1).size(); i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}
