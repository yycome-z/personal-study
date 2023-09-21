package main.java.leetcode.dp;

/**
 * 使用最小花费爬楼梯
 *
 * 给你一个整数数组 cost，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标 0 或下标 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * 示例
 *
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 *
 * 解释：你将从下标为 0 的台阶开始。
 *
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 *
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 *
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 *
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 *
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 *
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 *
 * 总花费为 6 。
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 *
 * @author zhangyaoyuan
 * @date 2023/09/11
 */
public class Code746 {

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        // dp[i]表示到i + 1个台阶的时候，花费的最少费用
        int[] dp = new int[length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < length + 1; i++) {
            int min = Math.min(dp[i - 1], dp[i - 2]);
            dp[i] = (i == length) ? min : (min + cost[i]);
        }

        return dp[length];
    }
}
