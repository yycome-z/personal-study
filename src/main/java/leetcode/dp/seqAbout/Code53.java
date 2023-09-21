package main.java.leetcode.dp.seqAbout;

/**
 * 最大子数组和
 *
 * 题意
 * 给你一个整数数组 nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 *
 * 示例
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大为 6。
 *
 * 提示
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * @author zhangyaoyuan
 * @date 2023/09/19
 */
public class Code53 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        // dp[i][0] 表示到下表为i的数字时，不包含数字nums[i]的最大和
        // dp[i][1] 表示到下表为i的数字时，包含数字nums[i]的最大和
        int[][] dp = new int[length][2];
        dp[0][0] = Integer.MIN_VALUE / 2;
        dp[0][1] = nums[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(nums[i], dp[i - 1][1] + nums[i]);
        }

        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
