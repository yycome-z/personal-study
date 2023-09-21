package main.java.leetcode.dp.jumpAbout;

/**
 * 跳跃游戏Ⅱ
 * <p>
 * 题意
 * 给你一个非负整数数组 nums，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度，你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例
 * 输入：nums = [2,3,1,1,4]
 * 输出：2
 * <p>
 * 解释：跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 提示
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 *
 * @author zhangyaoyuan
 * @date 2023/09/14
 */
public class Code45 {


    public int canJump(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        if (nums[0] + 1 > length) {
            return 1;
        }
        // dp[i]代表从第i个位置跳到末尾所需的最小步数
        int[] dp = new int[length];

        for (int i = length - 2; i >= 0; i--) {
            int need = length - 1 - i;
            if (nums[i] >= need) {
                dp[i] = 1;
            } else {
                int tmp = 0;
                for (int j = 1; j <= nums[i]; j++) {
                    if (dp[i + j] > 0) {
                        tmp = tmp > 0 ? Math.min(tmp, dp[i + j]) : dp[i + j];
                    }
                }
                dp[i] = tmp > 0 ? tmp + 1 : 0;
            }
        }

        return dp[0];
    }
}
