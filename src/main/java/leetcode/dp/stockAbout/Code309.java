package main.java.leetcode.dp.stockAbout;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * 题意
 * 给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）：卖出股票后，你无法在第二天买入股票（即冷冻期为 1 天）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例
 * 输入：prices = [1,2,3,0,2]
 * 输出：3
 * 解释：对应的交易状态为：[买入，卖出，冷冻期，买入，卖出]
 *
 * 提示
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 * @author zhangyaoyuan
 * @date 2023/09/15
 */
public class Code309 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        // dp[i][0][0] 第i天没有股票，没有卖出
        // dp[i][0][1] 第i天没有股票，卖出了
        // dp[i][1][0] 第i天有股票
        int[][][] dp = new int[length][2][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][1][0] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
            dp[i][0][1] = dp[i - 1][1][0] + prices[i];
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
        }

        return Math.max(dp[length - 1][0][0], dp[length - 1][0][1]);
    }
}
