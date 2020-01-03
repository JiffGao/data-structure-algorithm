package queue;

import java.util.Scanner;

/**
 * @author yangyinmei
 * @ClassName: JiffGao
 * @Description:
 * @date: 2020/1/1
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中获取数据");
            System.out.println("h(head)：查看队列头信息");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        queue.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    try {
                        queue.add(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(queue.get());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(queue.head());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

/**
 * @Description 环形数组队列
 * @Time 21:41 2020/1/2
 * @Param 
 * @Return 
 * @Author JiffGao
 */
class CircleArrayQueue {
    private int maxSize;// 数组最大容量
    private int front;// 指向队列的第一个元素，初始值为0
    private int rear;// 指向队列的最后一个元素的后一个元素
    private int[] arr;// 用于存放数据，模拟队列

    // 构造
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 队列是否已满
    public boolean isFull() {
        return ((rear + 1) % maxSize) == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能添加数据");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;// 后移，指向后一个元素，需要考虑取模，以防
    }

    // 取数据
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        // front指向队列的第一个元素
        // 1. 先把front对应的值保存到一个临时变量
        // 2. 将front后移
        // 3. 返回临时变量
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列所有元素
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        // 从front开始遍历，遍历front到rear
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 获取队列中有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}