package main.java.leetcode.dp.seqAbout;

/**
 * 不相交的线
 *
 * 题意
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * nums1[i] == nums2[j]，且绘制的直线不与其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交，每个数字只能属于一条连线。
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 * 示例
 * 输入：nums1 = [1,4,2]，nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线
 * 但无法画出第三条不相交的直线，因为从 nums1[1] = 4 到 nums2[2] = 4的直线将与从 nums1[2] = 2 到 nums2[1] = 2 的直线相交。
 *
 * 提示
 * 1 <= nums1.length, nums2.length <= 500
 * 1 <= nums1[i], nums2[j] <= 2000
 *
 * @author zhangyaoyuan
 * @date 2023/09/21
 */
public class Code1035 {

    /**
     * 此题就是求最长公共子序列问题
     * 最长公共子序列的长度几何意义就是可以绘制的最大连线数。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        // dp[i][j] 表示第一个字符串在i位置，第二个字符串在j位置时，最长的公共子序列
        int[][] dp = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            if (nums2[0] == nums1[i]) {
                dp[i][0] = 1;
            } else if (i > 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < length2; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
            } else if (i > 0 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length1 - 1][length2 - 1];
    }
}
