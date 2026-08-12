package queue;

class LinkedNode {
    public int val;
    public LinkedNode next;

    public LinkedNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// 不打算引入傀儡节点
public class MyQueue {
    private LinkedNode head = null;
    // 为了尾插方便, 引入尾结点.
    private LinkedNode tail = null;

    // 入队列, 实现尾插
    public void offer(int val) {
        LinkedNode newNode = new LinkedNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        // 把新节点, 添加到 tail 的末尾
        tail.next = newNode;
        tail = tail.next;
    }

    // 出队列, 实现头删
    public Integer poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }

    // 取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}