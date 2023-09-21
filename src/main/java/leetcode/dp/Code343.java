package main.java.leetcode.dp;

/**
 * 整数拆分
 *
 * 给定一个正整数 n，将其拆分为 k 个正整数的和（k >= 2），并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 *
 * 示例
 * 输入：n = 10
 * 输出：36
 *
 * 解释：10 = 3 + 3 + 4，3 * 3 * 4 = 36。
 *
 * 提示
 * 2 <= n <= 58
 *
 * @author zhangyaoyuan
 * @date 2023/09/11
 */
public class Code343 {

    public int integerBreak(int n) {
        // dp[i]表示正整数i拆分后可得到的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                int tmp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], tmp);
            }
        }

        return dp[n];
    }
}
