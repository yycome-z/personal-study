package main.java.algorithm;

/**
 * 插入排序
 *
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置后
 * 6.重复步骤2~5
 *
 * @author zhangyaoyuan
 * @date 2023/01/18
 */
public class InsertionSort {
    public static void insert(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int tem = arrays[i];
            for (int j = i - 1; j >= 0; j--) {
                if (tem >= arrays[j]) {
                    break;
                }
                arrays[j + 1] = arrays[j];
                if (j == 0 || tem >= arrays[j - 1]) {
                    arrays[j] = tem;
                    break;
                }
            }
        }
    }

}
