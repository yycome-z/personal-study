package main.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 多数元素
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangyaoyuan
 * @date 2023/04/17
 */
public class Code169 {
    /**
     * 知识范围内想到的最好解法 -》 用一个map记录每一个数字出现的次数
     * 显然不符合题目最优解 O(n)和 O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
///        使用数组的工具类先排序再输出比使用hashMap更快，我猜测Arrays根据数组长度不同选择最优的排序算法O(nlogn)，
///        hashMap的key和value必须使用包装类且要做加法运算，耗时比较厉害。不过这个方法不推荐，既然做算法题就尽量不使用现成的api
///        Arrays.sort(nums);
///        return nums[nums.length / 2];
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                if (count + 1 > nums.length / 2) {
                    return num;
                }
                map.put(num, count + 1);
            }
        }
        return nums[0];
    }

    /**
     * 最优解用到的算法：
     *
     * 摩尔投票法：
     *
     * 核心就是对拼消耗。
     *
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
     *
     * 那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
     *
     * 最后能剩下的必定是自己人。
     *
     * 思路：从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int rst = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (rst == nums[i]) {
                count++;
            } else {
                if (--count == 0) {
                    rst = nums[++i];
                    count = 1;
                }
            }
        }
        return rst;
    }
}
