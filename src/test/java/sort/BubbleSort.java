package sort;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author JiffGao
 * @ClassName: BubbleSort
 * @Description:
 * @date: 2020/2/1
 */
public class BubbleSort {

    int modCount = 0;

    public static void main(String[] args) {
        // int[] arr = {5, 3, 2, 8, 4};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();

        arr = new BubbleSort().sort(arr);
        System.out.println(System.currentTimeMillis() - start);
        // System.out.println(Arrays.toString(arr));
    }

    private int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int mod = modCount;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    modCount++;
                }
                // System.out.println("第" + i + "次：" + Arrays.toString(arr));
            }
            if (mod == modCount) {
                break;
            }
        }
        return arr;
    }
}
