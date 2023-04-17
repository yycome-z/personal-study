package main.java.algorithm;

import java.util.ArrayList;

/**
 * 基数排序
 * <p>
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
 *
 * @author zhangyaoyuan
 * @date 2023/01/30
 */
public class RadixSort {

    public static void radixSort(int[] array) {
        // 确定最大的数有几位，即处理次数
        int max = array[0], count = 1;
        for (int value : array) {
            max = Math.max(max, value);
        }
        while ((max /= 10) > 0) {
            count++;
        }
        // 从最低位开始处理count次
        int dev = 1;
        for (int i = 0; i < count; i++) {
            int size = 10;
            ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(16);
            for (int j = 0; j < size; j++) {
                bucket.add(new ArrayList<>());
            }
            for (int value : array) {
                ArrayList<Integer> list = bucket.get((value / dev) % 10);
                list.add(value);
            }
            int index = 0;
            for (ArrayList<Integer> bucketArr : bucket) {
                if (bucketArr != null && !bucketArr.isEmpty()) {
                    int[] ints = bucketArr.stream().mapToInt(aVal -> aVal).toArray();
                    // 更新array
                    System.arraycopy(ints, 0, array, index, ints.length);
                    index += bucketArr.size();
                }
            }
            dev *= 10;
        }
    }
}
