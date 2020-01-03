package queue;

/**
 * @author JiffGao
 * @ClassName: Josephu
 * @Description:
 * @date: 2020/1/3
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addNods(5);
        list.getNods();
        list.popList(4);
    }
}

// 创建一个环形链表
class CircleSingleLinkedList {
    // 定义一个头结点
    private Nod first;

    public void addNods(int nos) {
        if (nos < 1) {
            System.out.println("nos值不对");
            return;
        }

        Nod curNod = new Nod(0);
        for (int i = 1; i <= nos; i++) {
            Nod newNod = new Nod(i);
            if (first == null) {
                first = newNod;
                curNod = first;
            } else {
                curNod.next = newNod;
                curNod = newNod;
            }
            curNod.next = first;
        }
    }

    public void getNods() {
        if (first == null) {
            System.out.println("list is null");
            return;
        }
        Nod curNod = first;
        while (true) {
            System.out.printf("xuhao %d\n", curNod.no);
            if (curNod.next == first) {
                break;
            }
            curNod = curNod.next;
        }
    }

    // 数到k时弹出顺序
    public void popList(int k) {
        Nod helper = first;
        while (helper.next != first) {// let helper point the last nod
            helper = helper.next;
        }
        for (; ; ) {
            for (int i = 0; i < k - 1; i++) {
                first = first.next;
                helper = helper.next;
                // System.out.printf("%d get out \n", first.no);
            }
            System.out.printf("%d get out \n", first.no);
            if (first == helper) {
                break;
            }
            first = first.next;
            helper.next = first;
        }
    }
}

// 节点
class Nod {
    int no;
    Nod next;

    public Nod(int no) {
        this.no = no;
    }
}