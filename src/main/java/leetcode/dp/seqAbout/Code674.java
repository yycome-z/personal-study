package main.java.leetcode.dp.seqAbout;

/**
 * 最长连续递增序列
 *
 * 题意
 * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i <= r，都有 nums[i] < nums[i + 1]，
 * 那么子序列 [nums[l], nums[l + 1], ... , nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 * 示例
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5]，长度为 3。尽管 [1,3,5,7] 也是升序的子序列，但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 *
 * 提示
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * @author zhangyaoyuan
 * @date 2023/09/15
 */
public class Code674 {

    public int findLengthOfLCIS(int[] nums) {
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
                if (nums[j] < nums[j + 1]) {
                    len++;
                } else {
                    break;
                }
            }
            dp[i][1] = Math.max(len, Math.max(dp[i - 1][0], dp[i - 1][1]));
        }

        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
