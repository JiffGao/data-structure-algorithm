package sort;

import java.util.Arrays;

/**
 * @author JiffGao
 * @ClassName: SelectSort
 * @Description:
 * @date: 2020/2/1
 */
public class SelectSort {
    public static void main(String[] args) {
        // int[] arr = {5, 3, 2, 8, 4};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();
        arr = sort(arr);
        System.out.println(System.currentTimeMillis() - start);

        // System.out.println(Arrays.toString(arr));
    }

    private static int[] sort(int[] arr) {
        // for (int i = 0; i < arr.length - 1; i++) {
        //     int minIndex = i;
        //     int min = arr[i];
        //     for (int j = i + 1; j < arr.length; j++) {
        //         if (min < arr[j]) {
        //             min = arr[j];
        //             minIndex = j;
        //
        //             // arr[minIndex] = arr[i];
        //             // arr[i] = min;
        //         }
        //     }
        //     if (minIndex != i) {// 这个判断会减少交换次数
        //         arr[minIndex] = arr[i];
        //         arr[i] = min;
        //     }
        // }

        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];// 保存被比较值
            int index = i;// 保存被比较值的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (temp < arr[j]) {// 如果被比较的值小于比较值，保存比较值的下标和值
                    // temp = arr[i];
                    // arr[i] = arr[j];
                    // arr[j] = temp;
                    index = j;
                    temp = arr[j];
                }
            }
            // 判断下表是否发生变化，下标发生变化说明新的极值，
            // 则交换位置，此处交换可以避免一些中间交换步骤，对算法起到一定的优化作用
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = temp;
                // System.out.println(Arrays.toString(arr));
            }
        }
        return arr;
    }
}
