package main.java.leetcode.dp.robAbout;

/**
 * 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有互相连通的防盗系统
 * ，如果两间相邻的房屋在同一晚被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动报警装置的情况下，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例
 * 输入：[2,7,9,3,1]
 * 输出：12
 * <p>
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * @author zhangyaoyuan
 * @date 2023/09/13
 */
public class Code198 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // dp[i] 表示到第i个房间的时候，可获得的最高金额
        int[] dp = new int[length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[length - 1];
    }
}
