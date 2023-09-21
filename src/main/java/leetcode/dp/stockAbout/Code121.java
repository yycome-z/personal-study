package main.java.leetcode.dp.stockAbout;

/**
 * 买卖股票的最佳时机
 *
 * 题意
 * 数组 prices 的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票，设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润，如果你不能获取任何利润，返回 0。
 *
 * 示例
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：5
 *
 * 解释：在第 2 天(股票价格 = 1)的时候买入，在第 5 天(股票价格 = 6)的时候卖出，最大利润 = 6 - 1 = 5。
 * 注意最大利润不能是 7 - 1 = 6，因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 提示
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 *
 * @author zhangyaoyuan
 * @date 2023/09/14
 */
public class Code121 {

    public int maxProfit1(int[] prices) {
        int length = prices.length;
        // dp[i]表示第i天卖出可获得的最大利润
        int[] dp = new int[length];
        int maxProfit = 0;
        int minPrices = prices[0];

        for (int i = 0; i < length; i++) {
            dp[i] = prices[i] - minPrices;
            minPrices = Math.min(minPrices, prices[i]);
            maxProfit = Math.max(maxProfit, dp[i]);
        }

        return maxProfit;
    }
}
