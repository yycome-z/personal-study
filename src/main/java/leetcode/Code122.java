package main.java.leetcode;

/**
 * 买卖股票的最佳时机 II
 *
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 * 示例 1：
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangyaoyuan
 * @date 2023/04/20
 */
public class Code122 {
    /**
     * 感觉并不适合用dp？
     *
     * 手里最多有一股，首先维护一个i之前的序列的最大利润，如果第i个是最大的，两种判断，max{买一次股票的最大值， 买两次股票的和}
     * 不管是不是最大，都需要判断
     *
     * [7,1,5,3,6,4]
     * [6,1,3,2,4,7]
     * [3,3,5,0,0,3,1,4]
     * [2,1,2,1,0,1,2]
     * [1,2,4,2,5,7,2,4,9,0]
     *
     * 177/200 算法太™难了！
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        // 最小值；最小值的下标；利润；之前的从最小值到某一值时的下标（如果不是最小值，有可能会变）；index对应的利润
        int min = prices[0], minIndex = 0, profit = 0, index = 0, tempProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
            if (i - index >= 1) {
                int profit1 = prices[i] - min;
                int profit2 = tempProfit + prices[i] - minValue(prices, index, i);
                if (Math.max(profit1, profit2) > profit) {
                    if (profit1 >= profit2) {
                        index = i;
                        tempProfit = profit1;
                    }
                    if (index < minIndex) {
                        index = i;
                        tempProfit = Math.max(profit1, profit2);
                    }
                    profit = Math.max(profit1, profit2);
                }
            }
        }

        return profit;
    }

    /**
     * 指定范围内的最小值 左闭右开
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int minValue(int[] nums, int start, int end) {
        int minValue = nums[start];
        for (int i = start + 1; i < end; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
        }
        return minValue;
    }
}
