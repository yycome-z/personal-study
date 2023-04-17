package main.java.algorithm;

import java.util.Arrays;

/**
 * @author zhangyaoyuan
 * @date 2023/01/18
 */
public class TestSort {
    public static void main(String[] args) {
        int[] arrays = {2, 5, 1, 8, 34, 3, 3425, 3, 10, 3, 453, 11, 1024, 1025};
//        BubbleSort.bubble(arrays);
//        SelectionSort.selection(arrays);
//        InsertionSort.insert(arrays);
//        arrays = MergeSort.divide(arrays);
//        QuickSort.quick(arrays, 0, arrays.length);
//        CountingSort.countSort(arrays);
//        BucketSort.bucketSort(arrays, 5);
        RadixSort.radixSort(arrays);
        // 希尔排序是对插入排序的优化，先隔5个选择一组数排好序，再隔3个选择一组数排序，最后隔1个选择一组数排序（即标准插入排序）
        // 堆排序是利用了堆这个数据结构，找到最大数（或最小数），与最后一个数交互，再找到新的堆的最大/最小数，再交互，依此执行即可
        System.out.println(Arrays.toString(arrays));
        int[] arr = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
//        BubbleSort.bubble(arr);
//        SelectionSort.selection(arr);
//        InsertionSort.insert(arr);
//        arr = MergeSort.divide(arr);
//        QuickSort.quick(arr, 0, arr.length);
//        CountingSort.countSort(arr);
//        BucketSort.bucketSort(arr, 3);
        RadixSort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
