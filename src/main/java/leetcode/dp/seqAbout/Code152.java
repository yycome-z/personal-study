package main.java.leetcode.dp.seqAbout;

/**
 * 乘积最大子数组
 *
 * 题意
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32位整数。
 * 子数组是数组连续的子序列。
 *
 * 示例
 * 输入：nums = [2,3,-2,4]
 * 输出：6
 * 解释：子数组 [2,3] 有最大乘积 6。
 *
 * 提示
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都保证是一个 32位整数
 *
 * @author zhangyaoyuan
 * @date 2023/09/18
 */
public class Code152 {

    /**
     * 使用外部变量代替dp的一维
     * 由于数组含负数，所以需要维护最小的乘积和最大的乘积，且根据每次判断进行变号（不判断会溢出）
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // dp[i][0] 代表到下标为i为止的最大乘积
        // dp[i][1] 代表到下标为i为止的最小乘积
        int[][] dp = new int[length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int rstCount = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            }
            if (dp[i][0] > rstCount) {
                rstCount = dp[i][0];
            }
        }
        
        return rstCount;
    }
}
