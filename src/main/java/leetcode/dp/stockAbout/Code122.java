package main.java.leetcode.dp.stockAbout;

/**
 * 买卖股票的最佳时机Ⅱ
 *
 * 题意
 * 整数数组 prices，其中 prices[i] 表示某支股票第 i 天的价格、
 * 在每一天，你可以决定是否购买入/或出售股票。你在任何时候最多只能持有一股股票。你也可以先购买，然后在同一天出售。
 * 返回你能获得的最大利润。
 *
 * 示例
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 *
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 *
 * 提示
 * 1 <= prices.length <= 3*10^4
 * 0 <= prices[i] <= 10^4
 *
 * @author zhangyaoyuan
 * @date 2023/09/14
 */
public class Code122 {

    /**
     * 二叉树遍历是纯状态dp，爬楼梯（斐波那契数列）是纯位置dp，而此题的二维数组，第一维是位置，第二维是状态，就是位置dp和状态dp的结合。
     *
     * 首先，每一天有且只有两种状态：持有股票或不持有股票
     * 其次，事情的发展是线性的，从前往后，只有到了最后一天才能知道最后的结果
     * 综合分析，使用位置dp + 状态dp，将状态依此传递给下一天，最后一天的值即为结果
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // dp[i][0]表示第i天手里没有股票的利润，dp[i][1]表示第i天手里有股票的利润
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }

    /**
     * 从leetcode上找到的优化后的dp，将数组替换成了变量，学到了。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0 || n == 1){
            return 0;
        }

        // 1. dp[i][j]表示下标为i的那一天，持股状态位j时，赚到的钱。j=0时不持有，j=1表示持有
        // 2.1 dp[i][0] = max(dp[i-1][1] + prices[i], dp[i-1][0])
        // 2.2 dp[i][1] = max(dp[i-1][0] - prices[i], dp[i-1][1])
        // 3. init

        int dp0 = 0;
        int dp1 = -prices[0];

        int pre_dp0 = dp0;
        int pre_dp1 = dp1;

        for(int i = 1; i < n; i++){
            dp0 = Math.max(pre_dp0, pre_dp1 + prices[i]);
            dp1 = Math.max(pre_dp1, pre_dp0- prices[i]);

            pre_dp0 = dp0;
            pre_dp1 = dp1;
        }

        return Math.max(dp0, dp1);
    }
}
