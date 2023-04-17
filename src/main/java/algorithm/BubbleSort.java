package main.java.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * 依此将最大的数移到最后
 *
 * 给定一个 N 个元素的数组，冒泡法排序将：
 * 1.比较一对相邻元素（a，b），
 * 2.如果两项的大小关系不正确，交换这两个数（在本例中为a > b），
 * 3.重复步骤1和2，直到我们到达数组的末尾（最后一对是第 N-2 和 N-1 项，因为我们的数组从零开始）
 * 4.到目前为止，最大项将在最后的位置。 然后我们将 N 减少1，并重复步骤1，直到 N = 1。
 *
 * @author zhangyaoyuan
 * @date 2023/01/18
 */
public class BubbleSort {

    /**
     * 这种写法是将最小的依此放到左边
     *
     * @param arrays
     */
//    private static void bubble(int[] arrays) {
//        for (int i = 0; i < arrays.length - 1; i++) {
//            for (int j = i + 1; j < arrays.length; j++) {
//                if (arrays[i] > arrays[j]) {
//                    int tmp = arrays[i];
//                    arrays[i] = arrays[j];
//                    arrays[j] = tmp;
//                }
//            }
//        }
//    }

    /**
     * 冒泡应该是一个“充满活力”的算法，就像打擂台似的，两个人的胜者再和第三个人打
     *
     * @param arrays
     */
    public static void bubble(int[] arrays) {
        int unsortedNumber = arrays.length;
        while (unsortedNumber > 1) {
            // 如果一次循环里没有元素的交换，则说明待排序列已经有序
            boolean flag = true;
            for (int i = 0; i < unsortedNumber - 1; i++) {
                if (arrays[i] > arrays[i + 1]) {
                    int tem = arrays[i];
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = tem;

                    flag = false;
                }
            }
            if (flag) {
                return;
            }
            unsortedNumber--;
        }

    }
}
