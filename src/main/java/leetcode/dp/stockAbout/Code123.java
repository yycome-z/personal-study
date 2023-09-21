package main.java.leetcode.dp.stockAbout;

/**
 * 买卖股票的最佳时机Ⅲ
 *
 * 题意
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。设计一个算法来计算你所能获取的最大利润，你最多可以完成两笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天(股票价格 = 0)的时候买入，在第 6 天(股票价格 = 3)的时候卖出，这笔交易所能获得利润 =  3 - 0 = 3。
 * 随后在第 7 天(股票价格 = 1)的时候买入，在第 8 天(股票价格 = 4)的时候卖出，这笔交易所能获得利润 = 4 - 1 = 3。
 *
 * 提示
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 *
 * @author zhangyaoyuan
 * @date 2023/09/15
 */
public class Code123 {

    /**
     * 此题加了购买次数的限制，第一想法可能是在循环外部加一个次数变量，每次购买了股票就加一，不能超过2次
     * 但仔细想后发现，按照循环的方向判断次数只能限制前两次的买入，如果已经买了两次，以后再也没有机会买了，这显然不正确。
     * 怎么让每一次循环都能计算当天买入或不买入的利润呢？答案是将买入的次数加入状态方程，即三维dp。
     * 每一天的买入不买入、买入0、1、2次，都将成为该天的状态！
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        // dp[i][0][0] 第i天无股票，目前共买0次
        // dp[i][0][1] 第i天无股票，目前共买1次
        // dp[i][0][2] 第i天无股票，目前共买2次
        // dp[i][1][1] 第i天有股票，目前共买1次
        // dp[i][1][2] 第i天有股票，目前共买2次
        int[][][] dp = new int[length][2][3];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = -1000000;
        dp[0][0][1] = -1000000;
        dp[0][0][2] = -1000000;

        for (int i = 1; i < length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1] + prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][2] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][2] = Math.max(dp[i - 1][1][2], dp[i - 1][0][1] - prices[i]);
        }

        return Math.max(dp[length - 1][0][0], Math.max(dp[length - 1][0][1], dp[length - 1][0][2]));
    }
}
