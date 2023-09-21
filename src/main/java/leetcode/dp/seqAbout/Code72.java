package main.java.leetcode.dp.seqAbout;

/**
 * 编辑距离
 *
 * 题意
 * 给你两个单词 word1 和 word2，请返回将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符；删除一个字符；替换一个字符。
 *
 * 示例
 * 输入：word1 = “horse”, word2 = “ros”
 * 输出：3
 *
 * 解释：
 * horse -> rorse（将 h 替换成 r）
 * rorse -> rose（删除 r）
 * rose -> ros（删除 e）
 *
 * 提示
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * @author zhangyaoyuan
 * @date 2023/09/21
 */
public class Code72 {

    /**
     * dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
     *
     * 所以，
     * 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
     * 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
     *
     * 作者：powcai
     * 链接：https://leetcode.cn/problems/edit-distance/solutions/6455/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length1;
        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        // dp[i][j] 以chars1[i]结尾、chars2[j]结尾时，chars1转换成chars2的最少次数
        int[][] dp = new int[length1 + 1][length2 + 1];
        dp[1][0] = 1;
        for (int i = 2; i < length1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        dp[0][1] = 1;
        for (int i = 2; i < length2 + 1; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[length1][length2];
    }
}
