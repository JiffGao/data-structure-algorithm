package recursion;

/**
 * @author JiffGao
 * @ClassName: Queen
 * @Description:
 * @date: 2020/1/31
 */
public class Queen {
    int max = 8;
    int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        // System.out.println(Math.abs(8));
        new Queen().check(0);
    }

    /**
     * @Description 放置
     * n为行
     * i为列
     * 先固定n(行)，然后将在n行上的皇后位置依次从1-8列移动并判断是否符合规则，符合进入下一行
     * @Time 13:02 2020/1/31
     * @Param [n]
     * @Return void
     * @Author JiffGao
     */
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private void print() {
        count++;
        System.out.print("第" + count + "中摆法:\t");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * @Description 查看第n个皇后是否与已放好的皇后冲突
     * Math.abs(n - i)返回参数n - i的绝对值
     * arr[i] == arr[n]  表示y=n垂直与x轴的直线，即在同一列上
     * Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 表示平行或垂直与y=x的直线，即在同意斜线上
     * @Time 12:28 2020/1/31
     * @Param [n]
     * @Return boolean
     * @Author JiffGao
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
