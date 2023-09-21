package main.java.leetcode.dp.robAbout;

/**
 * 打家劫舍Ⅱ
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋紧挨着。
 * 同时相邻的房屋装有互相连通的防盗系统，如果两间相邻的房屋在同一晚被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动报警装置的情况下，今晚能够偷窃到的最高金额。
 *
 * 示例
 * 输入：nums = [1,2,3,1]
 * 输出：4
 *
 * 解释：你可以先偷窃 1 号房屋(金额 = 1)，然后偷窃 3 号房屋(金额 = 3)。偷窃到的最高金额 = 1 + 3 = 4。
 *
 * 提示
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * @author zhangyaoyuan
 * @date 2023/09/13
 */
public class Code213 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (length == 3) {
            return Math.max(nums[2], Math.max(nums[0], nums[1]));
        }
        // dp[i] 代表到第i个房屋时，可获得的最大金额
        int[] dp = new int[length];
        
        dp[0] = nums[0];
        dp[1] = nums[0];
        dp[2] = nums[0] + nums[2];
        int firstSum, secondSum, thirdSum;

        for (int i = 3; i < length; i++) {
            if (i == length - 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        firstSum = dp[length - 1];

        dp[0] = 0;
        dp[1] = nums[1];
        dp[2] = nums[1];

        for (int i = 3; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        secondSum = dp[length - 1];

        // [1,2,3,4,5,1,2,3,4,5] 前两个都不选才能得到最大的16
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = nums[2];
        for (int i = 3; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        thirdSum = dp[length - 1];

        return Math.max(firstSum, Math.max(secondSum, thirdSum));
    }
}
