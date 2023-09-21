package main.java.leetcode.dp.seqAbout;

/**
 * 最长重复子数组
 *
 * 题意
 * 给两个整数数组 nums1 和 nums2，返回两个数组中的公共的、长度最长的子数组的长度。
 *
 * 示例
 * 输入：nums1 = [1,2,3,2,1]，nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1]。
 *
 * 提示
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 *
 * @author zhangyaoyuan
 * @date 2023/09/15
 */
public class Code718 {

    /**
     * 此题作为dp的问题，和之前的解法相比产生了一点变化。之前的不管是位置dp还是状态dp，随着状态方程的演进，最后一个状态方程得到的结果
     * 记为要求的最优解；而此题的状态方程的结果并不是目前为止的最优解，而是当前状态的解，即把所有的可能性，所有的解都给你，你需要额外
     * 维护一个变量比较这所有的解，得到最优的解。
     *
     * 对于此题的关键，要理解：将第一个数组作为行，第二个数组作为列，最长的重复字串其实就是从左上到右下最长的斜线长度。
     * 参考：
     * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/solutions/310917/yi-zhang-biao-ba-ju-hua-kan-dong-dong-tai-gui-hua-/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        // dp[i][j]表示当nums1[i]和nums2[j]作为子串结尾时，此时的子串长度
        int[][] dp = new int[length1][length2];
        int maxLen = 0;

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (nums2[j] == nums1[i]) {
                    if (j - 1 < 0 || i - 1 < 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                    }
                }
            }
        }

        return maxLen;
    }

}
