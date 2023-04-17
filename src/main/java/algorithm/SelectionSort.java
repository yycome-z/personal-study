package main.java.algorithm;

/**
 * 选择排序
 *
 * 选择排序（Selection sort）是一种简单直观的排序算法。
 * 它的工作原理如下。首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * @author zhangyaoyuan
 * @date 2023/01/18
 */
public class SelectionSort {
    public static void selection(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            int index = i, tem = arrays[i];
            for (int j = i + 1; j < arrays.length; j++) {
                if (tem > arrays[j]) {
                    tem = arrays[j];
                    index = j;
                }
            }
            if (tem != arrays[i]) {
                arrays[index] = arrays[i];
                arrays[i] = tem;
            }
        }
    }
}
