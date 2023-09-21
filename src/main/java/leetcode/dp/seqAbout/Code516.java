package main.java.leetcode.dp.seqAbout;


/**
 * 最长回文子序列
 *
 * 题意
 * 给你一个字符串 s，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 示例
 * 输入：s = “bbbab”
 * 输出：4
 * 解释：一个可能的最长回文子序列为“bbbb”。
 *
 * 提示
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 *
 * @author zhangyaoyuan
 * @date 2023/09/16
 */
public class Code516 {

    /**
     * 所谓回文就是正着读反着读都是一样；
     * 解题的重要依据：对于回文串来说，去掉首尾元素，剩下的部分依然是回文串，同样在一个回文串首尾各加一个相同的元素，那新的串也是回文串。
     * 如果两边的元素不相同，则最终结果为分别加边上一个元素形成的子序列的最大值。
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        // dp[i][j] 表示在(i, j)范围内最长回文子序列的长度
        int[][] dp = new int[length][length];

        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][length - 1];
    }
}
