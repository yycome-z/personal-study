package main.java.leetcode.dp.seqAbout;

/**
 * 判断子序列
 *
 * 题意
 * 给定字符串 s 和 t，判断 s 是否为 t 的子序列。
 * 字符串中一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如 ace 是 abcde 的一个子序列，而 aec 不是）。
 *
 * 示例
 * 输入：s = "abc"，t = "ahbgdc"
 * 输出：true
 *
 * 提示
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成
 *
 * @author zhangyaoyuan
 * @date 2023/09/19
 */
public class Code392 {

    public boolean isSubsequence(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (length1 == 0) {
            return true;
        }
        if (length2 == 0) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        // dp[i][j] 表示chars1在下标i的位置，chars2在下标j的位置时包含的最长子序列长度
        int[][] dp = new int[length1][length2];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (chars1[i] == chars2[j]) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
                    }
                }
                if (dp[i][j] >= length1) {
                    return true;
                }
            }
        }

        return false;
    }
}
