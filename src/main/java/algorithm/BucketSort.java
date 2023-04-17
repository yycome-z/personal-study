package main.java.algorithm;

import java.util.ArrayList;

/**
 * 桶排序
 * <p>
 * 1.设置一个定量的数组当作空桶子。
 * 2.寻访序列，并且把项目一个一个放到对应的桶子去。
 * 3.对每个不是空的桶子进行排序。
 * 4.从不是空的桶子里把项目再放回原来的序列中。
 *
 * @author zhangyaoyuan
 * @date 2023/01/30
 */
public class BucketSort {

    public static void bucketSort(int[] array, int bucketSize) {
        // 将元素放到桶里
        int min = array[0], max = array[0];
        for (int value : array) {
            if (min > value) {
                min = value;
            } else if (max < value) {
                max = value;
            }
        }
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(1024);
        for (int i = 0; i < ((max - min) / bucketSize + 1); i++) {
            bucket.add(new ArrayList<>());
        }
        for (int value : array) {
            ArrayList<Integer> aList = bucket.get((value - min) / bucketSize);
            if (aList == null) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(value);
                bucket.set((value - min) / bucketSize, integers);
            } else {
                aList.add(value);
            }
        }
        // 对每一个不是空的桶排序，并合并
        int index = 0;
        for (ArrayList<Integer> bucketArr : bucket) {
            if (bucketArr != null && !bucketArr.isEmpty()) {
                int[] ints = bucketArr.stream().mapToInt(aVal -> aVal).toArray();
                // 桶内使用其他的排序方法
                InsertionSort.insert(ints);
                System.arraycopy(ints, 0, array, index, ints.length);
                index += bucketArr.size();
            }
        }
    }
}
