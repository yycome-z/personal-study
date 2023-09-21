package main.java.leetcode.dp.jumpAbout;

/**
 * 跳跃游戏
 *
 * 题意
 * 给定一个非负整数数组 nums，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度，判断你是否能够到达最后一个下标。
 *
 * 示例
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 *
 * 解释：可以先跳 1 步，从下标 0 到达下标 1，然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 提示
 * 1 <= nums.length <= 3*10^4
 * 0 <= nums[i] <= 10^5
 *
 * @author zhangyaoyuan
 * @date 2023/09/14
 */
public class Code55 {

    public boolean canJump(int[] nums) {
        int length = nums.length;

        // dp[i]表示数组下标为i是是否可以到达最后一个下标，dp[i] = 0不可达，dp[i] = 1可达
        int[] dp = new int[length];
        dp[length - 1] = 1;

        for (int i = length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j > length - 1) {
                    break;
                }
                if (dp[i + j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        return dp[0] == 1;
    }
}
