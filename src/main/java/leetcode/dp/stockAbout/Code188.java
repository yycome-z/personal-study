package main.java.leetcode.dp.stockAbout;

/**
 * 买卖股票的最佳时机Ⅳ
 *
 * 题意
 * 给定一个整数数组 prices，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 次交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例
 * 输入：k = 2，prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天（股票价格 = 2）的时候买入，在第 2 天（股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4 - 2 = 2。
 *
 * 提示
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * @author zhangyaoyuan
 * @date 2023/09/15
 */
public class Code188 {

    /**
     * 这种题特别要注意的是边界值
     *
     * @param prices
     * @param k
     * @return
     */
    public int maxProfit(int[] prices, int k) {
        int length = prices.length;
        // dp[i][0][k] 第i天无股票，目前共买k次
        // dp[i][1][k] 第i天有股票，目前共买k次
        int[][][] dp = new int[length][2][k + 1];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][0][1] = -10000;
        dp[0][1][0] = -10000;
        for (int i = 2; i < k + 1; i++) {
            dp[0][0][i] = -10000;
            dp[0][1][i] = -10000;
        }

        for (int i = 1; i < length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            for (int j = 1; j < k + 1; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }
        }

        int maxSum = 0;
        for (int i = 0; i < k + 1; i++) {
            maxSum = Math.max(dp[length - 1][0][i], maxSum);
        }

        return maxSum;
    }
}
