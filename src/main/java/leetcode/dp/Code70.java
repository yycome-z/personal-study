package main.java.leetcode.dp;

/**
 * 爬楼梯
 *
 * 假设你正在爬楼梯，需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶，你有多少种不同的方法可以爬到楼顶呢？
 *
 * 1 <= n <= 45
 *
 * @author zhangyaoyuan
 * @date 2023/09/11
 */
public class Code70 {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        // dp[i]代表i个台阶一共有多少种方式
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
