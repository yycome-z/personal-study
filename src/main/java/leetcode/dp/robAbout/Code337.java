package main.java.leetcode.dp.robAbout;

import main.java.leetcode.TreeNode;

/**
 * 打家劫舍Ⅲ
 *
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root。
 * 除了 root 之外，每栋房子有且只有一个“父”房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 给定二叉树的 root。返回在不触动报警的情况下，小偷能够盗取的最大金额。
 *
 * 示例
 * 输入：root = [3,2,3,null,3,null,1]
 * 输出：7
 * 解释：小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7。
 *
 * 提示
 * 1 <= n <= 2^31 -1
 *
 * @author zhangyaoyuan
 * @date 2023/09/13
 */
public class Code337 {

    /**
     * 线性的dp是位置dp，即状态方程保存的是某位置的最优解
     * 非线性dp是状态dp，即状态方程保存的是某状态的最优解
     *
     * dp[i]表示位置dp时，含义是在i位置的值
     * dp[i]表示状态dp时，含义时当状态为i时的值
     *
     * 此题状态方程的顺序是二叉树的后序遍历（本质上是递归），递归这种方式无法确定深度，也就无法确定位置dp的边界，所以不合适位置dp
     * 递归的特点是每次执行确定一次结果（参数同类型、结果同类型，参数 ！= 结果），所以只需要搞一个状态记录一下每次递归的结果，用作临时参数，最终得到
     * 最后的执行结果，所以适合状态dp
     *
     * dp + 二叉树遍历（递归）
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] dp = nowNodeStatus(root);

        return Math.max(dp[0], dp[1]);
    }

    private int[] nowNodeStatus(TreeNode treeNode) {
        if (treeNode == null) {
            return new int[]{0, 0};
        }
        // dp[0]表示不偷当前房子所获得的最大金额；dp[1]表示偷当前房子获得的最大金额
        int[] dp = new int[2];
        int[] leftDp = nowNodeStatus(treeNode.left);
        int[] rightDp = nowNodeStatus(treeNode.right);
        dp[0] = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);
        dp[1] = leftDp[0] + rightDp[0] + treeNode.val;

        return dp;
    }

}
