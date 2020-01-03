package queue;

import java.util.Stack;

/**
 * @author JiffGao
 * @ClassName: LinkedListDemo
 * @Description:单链表小练习
 * @date: 2020/1/2
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add("rewrew");
        list.add("fdsa");
        list.add("asf");
        list.add("ngytt");
        list.add(5433);
        System.out.println(list.size());
        System.out.println(list);
        list.reversePrint();
    }
}

class Node<E> {
    E item;
    Node<E> next;

    Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }
}

class SingleLinkedList<E> {
    private Node<E> head;
    private int size;


    public Node add(E node) {

        if (head == null) {
            head = new Node(node, null);
            size++;
            return head;
        }
        Node<E> cur = new Node(node, null);
        Node<E> last = head;
        boolean loop = true;
        while (loop) {
            if (last.next == null) {
                loop = false;
            } else {
                last = last.next;
            }
        }
        last.next = cur;
        size++;
        return cur;
    }

    public int size() {
        return size;
    }

    // 倒序输出
    public void reversePrint() {
        Stack stack = new Stack();
        Node<E> last = head;
        while (last != null) {
            stack.push(last.item);
            last = last.next;
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + ", ");
        }
    }

    @Override
    public String toString() {
        Node<E> last = head;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (last != null) {
            sb.append(last.item).append(", ");
            last = last.next;
        }
        sb.append("}");
        return sb.toString();
    }
}