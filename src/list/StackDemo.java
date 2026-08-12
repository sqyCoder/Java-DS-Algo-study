package list;

import java.util.Stack;

public class StackDemo {

    public static void reversePrint(LinkedNode head) {
        // 创建一个栈
        Stack<LinkedNode> stack = new Stack<>();
        // 遍历链表, 依次入栈
        for (LinkedNode cur = head; cur != null; cur = cur.next) {
            stack.push(cur);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop().val);
        }
    }

    // 通过递归的方式实现反向打印
    public static void reversePrintR(LinkedNode head) {
        if (head == null) {
            return;
        }
        reversePrintR(head.next);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        reversePrintR(list.getHead());

        System.out.println(list);
    }
}