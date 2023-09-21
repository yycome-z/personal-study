package main.java.leetcode.dp.seqAbout;

/**
 * 不同的子序列
 *
 * 题意
 * 给定一个字符串 s 和一个字符串 t，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如 ACE 是 ABCDE 的一个子序列，而 AEC 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 示例
 * 输入：s = "rabbbit"，t = "rabbit"
 * 输出：3
 * 解释：有3种可以从s中得到“rabbit”的方案。
 *
 * 提示
 * 0 <= s.length，t.length <= 1000
 * s 和 t 由英文字母组成
 *
 * @author zhangyaoyuan
 * @date 2023/09/19
 */
public class Code115 {

    /**
     * 此题和求最长子序列的区别
     * 求最长子序列：相等 dp[i][j] = dp[i - 1][j - 1] + 1;
     *              不相等 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
     * 求含有子序列的个数：相等 dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
     *                   不相等 dp[i][j] = dp[i - 1][j];
     * 求最长子序列，第二个数组不一定全部包含在子序列里面，所以可以取左边和上边的最大值
     * 求含有子序列的个数，第二个数组一定包含于子序列，所以只能找左边，不能找上边
     * 同时左上方都是很重要的点，以及一个很重要的判断：该点是否包含在子序列中
     *
     * 另外，求最长子序列是找到一个子序列的最大值，所以是比较大小
     * 求含有子序列的个数是求有多少种可能，所以是求和
     *
     * 不管是什么类型的题，只要涉及到重复的序列，就画二维数据，关注左、上、左上三个点。
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (length1 == 0 && length2 == 0) {
            return 1;
        }
        if (length1 == 0 || length2 == 0) {
            return 0;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        // dp[i][j] 表示chars1[i]为结尾的字符串中有多少个以chars2[j]为结尾的字符串
        int[][] dp = new int[length1][length2];

        for (int i = 0; i < length1; i++) {
            if (chars1[i] == chars2[0]) {
                if (i > 0) {
                    dp[i][0] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = 1;
                }
            } else {
                if (i > 0) {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }

        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[length1 - 1][length2 - 1];
    }
}
