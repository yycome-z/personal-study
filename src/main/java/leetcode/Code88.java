package main.java.leetcode;


/**
 * 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangyaoyuan
 * @date 2023/04/15
 */
public class Code88 {
    /**
     * 时间复杂度 O(m + n)
     * 注：时间复杂度可以化抽象为具体，即指针（操作）移动了多少次
     * 这里移动了 m + n + (m + n (最后的复制数组)) = 2 (m + n) = O(m + n)
     * 空间复杂度：O(m + n)
     * 因为额外申请了 m + n 长度的数组
     *
     * 最优解是空间复杂度 O(1)
     * 即利用原数组空间，在这里是尾插法，将num1和num2依此取最大值插到num1的数组尾部
     *
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n > 0) {
                if (m > 0) {
                    int[] tmp = new int[m + n];
                    int left = 0, right = 0;
                    for (int i = 0; i < tmp.length; i++) {
                        if (left >= m) {
                            tmp[i] = nums2[right++];
                            continue;
                        }
                        if (right >= n) {
                            tmp[i] = nums1[left++];
                            continue;
                        }
                        if (nums1[left] < nums2[right]) {
                            tmp[i] = nums1[left++];
                        } else {
                            tmp[i] = nums2[right++];
                        }
                    }
                    System.arraycopy(tmp, 0, nums1, 0, tmp.length);
                } else {
                    System.arraycopy(nums2, 0, nums1, 0, nums2.length);
                }
            }
    }

    /**
     * 使用尾插法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n > 0) {
            if (m > 0) {
                int left = m -1, right = n - 1;
                for (int i = m + n - 1; i >= 0; i--) {
                    if (right == -1) {
                        nums1[i] = nums1[left--];
                        continue;
                    }
                    if (left == -1) {
                        nums1[i] = nums2[right--];
                        continue;
                    }
                    nums1[i] = nums1[left] > nums2[right] ? nums1[left--] : nums2[right--];
                }
            } else {
                System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            }
        }
    }
}
