package main.java.leetcode.dp.seqAbout;

/**
 * 最长递增子序列
 *
 * 题意
 * 给你一个整数数组 nums，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如 [3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4。
 *
 * 提示
 * 1 <= num.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 *
 * @author zhangyaoyuan
 * @date 2023/09/15
 */
public class Code300 {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        // dp[i][0] 第i个数（含i）之前存在的最长子序列的长度，且子序列不包含nums[i]
        // dp[i][1] 第i个数（含i）之前存在的最长子序列的长度，且子序列包含nums[i]
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            int len = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    len = Math.max(dp[j][1] + 1, len);
                }
            }
            dp[i][1] = len;
        }

        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
