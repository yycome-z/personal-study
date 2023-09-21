package main.java.leetcode.dp.seqAbout;

/**
 * 两个字符串的删除操作
 *
 * 题意
 * 给定两个单词 word1 和 word2，返回使得 word1 和 word2 相同所需的最小步数。
 * 每步可以删除任意一个字符串中的一个字符。
 *
 * 示例
 * 输入：word1 = “sea”，word2 = “eat”
 * 输出：2
 * 解释：第一步将“sea”变为“ea”，第二步将“eat”变为“ea”。
 *
 * 提示
 * 1 <= word1.length，word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 *
 * @author zhangyaoyuan
 * @date 2023/09/21
 */
public class Code583 {

    /**
     * 此题仍然是求最长公共子序列问题！
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
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

        return length1 + length2 - 2 * dp[length1 - 1][length2 - 1];
    }
}
