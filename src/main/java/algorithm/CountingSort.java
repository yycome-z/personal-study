package main.java.algorithm;

import java.util.Arrays;

/**
 * 计数排序  https://www.51cto.com/article/657327.html
 *
 * 思想是，如果知道比一个数小于等于的数（包括这个数本身）有n个，则这个数就排在第n个位置
 *
 * 1.找出待排序的数组中最大和最小的元素
 * 2.统计数组中每个值为i的元素出现的次数，存入数组C 的第i项
 * 3.对所有的计数累加（从C 中的第一个元素开始，每一项和前一项相加）
 * 4.反向填充目标数组：将每个元素i放在新数组的第C[i]项，每放一个元素就将C[i]减去1
 *
 * @author zhangyaoyuan
 * @date 2023/01/30
 */
public class CountingSort {
    public static void countSort(int[] array) {
        int[] temArr = Arrays.copyOf(array, array.length);
        // 使用偏移量确定最小长度的前缀和数组
        int max = temArr[0], min = temArr[0];
        for (int i = 1; i < temArr.length; i++) {
            if (max < temArr[i]) {
                max = temArr[i];
            } else if (min > temArr[i]) {
                min = temArr[i];
            }
        }
        int[] prefixSum = new int[max - min + 1];
        for (int value : temArr) {
            prefixSum[value - min]++;
        }
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i-1];
        }
        // 从后向前遍历原数组，重新赋值
        for (int i = temArr.length - 1; i >= 0; i--) {
            array[prefixSum[temArr[i] - min] - 1] = temArr[i];
            // 注意：前缀和数组的记录要同步修改
            prefixSum[temArr[i] - min]--;
        }
    }
}
