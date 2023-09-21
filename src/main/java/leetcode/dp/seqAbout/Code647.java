package main.java.leetcode.dp.seqAbout;

/**
 * 回文子串
 *
 * 题意
 * 给你一个字符串 s，请你统计并返回这个字符串中回文子串的数目。
 * 回文字符串是正着读和倒过来读一样的字符串；子字符串是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6 个回文子串："a", "a", "a", "aa", "aa", "aaa"
 *
 * 提示
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 * @author zhangyaoyuan
 * @date 2023/09/18
 */
public class Code647 {

    /**
     * 既然是连续的回文子串，使用二维数组记录下所有的子串是否为回文子串，统计回文子串的个数
     *
     * 如果是单个字符，必定是回文子串
     * 如果是相邻的相同字符，必定是回文子串
     * 如果子串的长度大于2，判断依据：对于回文串来说，去掉首尾元素，剩下的部分依然是回文串，同样在一个回文串首尾各加一个相同的元素，那新的串也是回文串。
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        // 在 [i, j] 区间内的字符子串是否是回文串的结果为 dp[i][j]
        boolean[][] dp = new boolean[length][length];

        int rstCount = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (array[i] == array[j]) {
                    int sub = j - i;
                    if (sub == 0 || sub == 1) {
                        dp[i][j] = true;
                        rstCount++;
                    } else if (sub > 1) {
                        boolean b = dp[i + 1][j - 1];
                        if (b) {
                            dp[i][j] = true;
                            rstCount++;
                        }
                    }
                }
            }
        }

        return rstCount;
    }
}
