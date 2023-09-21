package main.java.leetcode.dp.seqAbout;

/**
 * 最长公共子序列
 *
 *
 * 题意
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。如果不存在公共子序列，返回 0。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如：”ace“ 是 ”abcde“ 的子序列，但 "aec" 不是 ”abcde“ 的子序列。
 * 两个字符串的公共子序列是这两个字符串所共同拥有的子序列。
 *
 * 示例
 * 输入：text1 = ”abcde“，text2 = ”ace“
 * 输出：3
 * 解释：最长公共子序列是 ”ace“，它的长度为 3。
 *
 * 提示
 * 1 <= text1.length，text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 *
 * @author zhangyaoyuan
 * @date 2023/09/19
 */
public class Code1143 {

    /**
     * 此题和求最长重复子数组类似，只不过那个是连续的，这个是不连续的，思路都是画斜边
     * 如果相等，左上角加一
     * 如果不相等，结果为左边和上边的最大值
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        // dp[i][j] 表示第一个字符串在i位置，第二个字符串在j位置时，最长的公共子序列
        int[][] dp = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            if (chars2[0] == chars1[i]) {
                dp[i][0] = 1;
            } else if (i > 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < length2; i++) {
            if (chars1[0] == chars2[i]) {
                dp[0][i] = 1;
            } else if (i > 0 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length1 - 1][length2 - 1];
    }
}
