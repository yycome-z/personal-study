package main.java.algorithm;


/**
 * 快速排序
 *
 * 1.挑选基准值：从数列中挑出一个元素，称为“基准”（pivot），
 * 2.分割：重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（与基准值相等的数可以到任何一边）。
 *  在这个分割结束之后，对基准值的排序就已经完成，
 * 3.递归排序子序列：递归地将小于基准值元素的子序列和大于基准值元素的子序列排序。
 *
 * @author zhangyaoyuan
 * @date 2023/01/19
 */
public class QuickSort {

    public static void quick(int[] array, int leftPoint, int rightPoint) {
        // 终止条件
        if (leftPoint == rightPoint) {
            return;
        }
        int cutPoint = move(array, leftPoint, rightPoint);
        quick(array, leftPoint, cutPoint);
        quick(array, cutPoint + 1, rightPoint);
    }

    /**
     * 将小于cutPoint位置的元素的元素都挪到左边
     * 
     * @param array
     * @param cutPoint
     * @param endPoint
     * @return 基准元素的下标
     */
    public static int move(int[] array, int cutPoint, int endPoint) {
        int leftPoint = cutPoint;
        for (int i = cutPoint + 1; i < endPoint; i++) {
            if (array[i] < array[cutPoint]) {
                int tem = array[i];
                array[i] = array[leftPoint + 1];
                array[leftPoint + 1] = tem;
                leftPoint++;
            }
        }
        int tem = array[cutPoint];
        array[cutPoint] = array[leftPoint];
        array[leftPoint] = tem;
        
        return leftPoint;
    }
}
