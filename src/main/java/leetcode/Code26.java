package main.java.leetcode;

import java.util.HashSet;

/**
 * 删除有序数组中的重复项
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangyaoyuan
 * @date 2023/04/17
 */
public class Code26 {

    /**
     * 注意已经升序排列了！ 这个适用于所有的情况 O(n^2)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean isContains = false;
            for (int j = 0; j < left; j++) {
                if (nums[j] == nums[i]) {
                    isContains = true;
                    break;
                }
            }
            if (!isContains) {
                nums[left++] = nums[i];
            }
        }
        return left;
    }

    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == i) {
                continue;
            }
            if (nums[left] != nums[i]) {
                nums[++left] = nums[i];
            }
        }
        return nums.length == 0 ? 0 : left + 1;
    }
}
