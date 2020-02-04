package recursive;

/**
 * @author Administrator
 * @ClassName: PrintOut
 * @Description:
 * @date: 2020/1/14
 */
public class PrintOut {
    public static void print(int n) {
        if (n > 10) {
            print(n / 10);
        }
        // System.out.println(n);
        //
        printDigit(n % 10);
    }

    public static void printDigit(int n) {
        System.out.println(n);
    }

    public static void main(String[] args) {
        // System.out.println(print(372896483));
        print(372896483);
        // System.out.println(372896483 / 10);
    }
}
