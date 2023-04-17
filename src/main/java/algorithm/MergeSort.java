package main.java.algorithm;


/**
 * 归并排序
 *
 * 利用递归，对一个数组排序可以转化为，一分为二后对两个数组分别排序，再合并
 * 同理分成的数组还可以再分，再合并。。。
 * 直到数组的长度为 1
 *
 * @author zhangyaoyuan
 * @date 2023/01/18
 */
public class MergeSort {
    public static int[] divide(int[] array) {
        int length = array.length;
        // 终止条件
        if (length == 1) {
            return array;
        }
//        if (length ==2) {
//            return merge(new int[]{array[0]}, new int[]{array[1]});
//        }
        int right = length % 2 == 0 ? length / 2 : length / 2 + 1;
        int[] arrLeft = new int[right];
        int[] arrRight = new int[length - right];
        System.arraycopy(array, 0, arrLeft, 0, right);
        System.arraycopy(array, right, arrRight, 0, length - right);

        return merge(divide(arrLeft), divide(arrRight));
    }


    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int leftLength = arrLeft.length, rightLength = arrRight.length;
        int[] mergeArray = new int[leftLength + rightLength];
        int left = 0, right = 0;
        for (int i = 0; i < leftLength + rightLength; i++) {
            mergeArray[i] = leftLength == left
                    ? arrRight[right++]
                    : (rightLength == right
                        ? arrLeft[left++]
                        : (arrLeft[left] > arrRight[right]
                            ? arrRight[right++]
                            : arrLeft[left++]));
        }

        return mergeArray;
    }


}
