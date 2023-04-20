package main.java.leetcode;

/**
 * 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangyaoyuan
 * @date 2023/04/19
 */
public class Code121 {

    /**
     * O(n^2) O(1) -- 超时
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int profit = 0, index = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] >= prices[index]) {
                continue;
            }
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                    index = i;
                }
            }
        }
        return profit;
    }

    /**
     * O(n) O(1)
     *
     * 上一种解法为假设今天我买了股票，然后我进行推演未来的某一天卖股票获得的利润，这是正常的思维，最终
     * 我会得到在哪一天买，哪一天卖出，得到的利润最高；但是题目只想知道结果，并不关心哪一天买或卖，所以
     * 我们不妨反着思考，假设今天我卖出，我获得多少利润？从头开始遍历一遍，找到最大的利润不就是期望的吗
     *
     * 假如计划在第 i 天卖出股票，那么最大利润的差值一定是在[0, i-1] 之间选最低点买入；
     * 所以遍历数组，依次求每个卖出时机的的最大差值，再从中取最大值。
     *
     * 有解释说这就是动态规划，所谓动态规划就是只看重结果而不在意具体的实现过程，注意这里的结果并不是最终答案，
     * 而是将最终答案分解为一个个小答案，通过遍历处理每一个小答案，最终得到结果。
     *
     * 以最终目标为导向，不断反推，直到最小的问题单元，最终的解，这种思想叫递归。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0, minValue = prices[0];
        for (int price : prices) {
            // 计算当前的利润
            if (price - minValue > profit) {
                profit = price - minValue;
            }
            // 更新最小值
            if (price < minValue) {
                minValue = price;
            }
        }
        return profit;
    }

}
