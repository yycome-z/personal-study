package main.java.leetcode;

/**
 * 轮转数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 此题主要考察O(1)的空间复杂度，时间复杂度最小就是O(n)
 *
 * @author zhangyaoyuan
 * @date 2023/04/18
 */
public class Code189 {

    /**
     * [0,1,2] 2   O(n) , O(n)
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        int[] temp = new int[length];
        int step = k % length;
        for (int i = 0; i < length; i++) {
            if (i + step >= length - 1) {
                temp[(i + step) % length] = nums[i];
            } else {
                temp[i + step] = nums[i];
            }
        }
        System.arraycopy(temp, 0, nums, 0, length);
    }

    /**
     * [0,1,2,3,4,5,6,7,8,9] 2  O(n) , O(n)
     *
     * System.arraycopy()真是yyds，它是JVM的固有方法，通过手写汇编等优化方式极大的提高了性能
     * 并不是简单的for循环或者数组复制操作能比的
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        int step = k % length;
        int[] temp = new int[step];
        System.arraycopy(nums, length - step, temp, 0, step);
        System.arraycopy(nums, 0, nums, step, length - step);
        System.arraycopy(temp, 0, nums, 0, step);
    }

    /**
     * 环状替换 O(n) O(1)
     *
     * 思想：数组长度为 n，以 k 的步长从某一个元素循环遍历，最终一定会再次回到这个元素
     * 不过走完一个圈并不一定会遍历完所有的元素，所以可以维护一个count，每遍历一个元素count + 1
     * 从该元素的下一个元素再次以步长 k 遍历，直到count = n 停止遍历（每一个圈绝不会有重合的地方）
     *
     * 将第一个元素的值放在temp里，算出第一个元素应该在的位置，再将该位置的元素值放在temp里，直到遍历到起始的元素
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int length = nums.length;
        int step = k % length, count = 0, index = 0, firstIndex = 0, temp;
        while (count != length) {
            int targetIndex = index + step >= length - 1 ? (index + step) % length : index + step;
            if (firstIndex != targetIndex) {
                temp = nums[firstIndex];
                nums[firstIndex] = nums[targetIndex];
                nums[targetIndex] = temp;
                index = targetIndex;
            } else {
                firstIndex++;
                index = firstIndex;
            }
            count++;
        }
    }

    /**
     * 数组反转  O(n) O(1)
     *
     * 思想：当将数组的元素向右移动k之后，尾部的k个元素会移动到开头，其余元素向后移动k个位置。
     * 当我们首先把整个数组都反转之后，会发现后面的k个元素已经到前面了，两部分数据已经到了目标的区域，只是顺序错误
     * 我们再以k为分界线，反别反转前后区域的元素，可以看到结果就是我们期望的。
     *
     * 如 [1,2,3,4,5,6,7] k = 3
     * --> 7,6,5,4,3,2,1
     * --> 5,6,7,1,2,3,4
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length, step = k % length;
        if (length < 2) return;
        reverse(nums, 0, length);
        reverse(nums, 0, step);
        reverse(nums, step, length);
    }

    /**
     * 将 nums数组在start和end之间的元素反转（左闭右开）
     *
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        int len = (end - start) / 2, tem;
        for (int i = 0; i < len; i++) {
            tem = nums[start + i];
            nums[start + i] = nums[end - 1 - i];
            nums[end - 1 - i] = tem;
        }
    }

}
