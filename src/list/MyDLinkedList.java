package list;

class DLinkedNode {
    public int val;
    public DLinkedNode prev;
    public DLinkedNode next;

    public DLinkedNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class MyDLinkedList {
    private DLinkedNode head;

    public void addFirst(int val) {
        DLinkedNode newNode = new DLinkedNode(val);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        // 定义一个 tail, 当循环结束, tail 就指向最后一个节点.
        DLinkedNode tail = null;
        for (DLinkedNode cur = head; cur != null; cur = cur.next) {
            tail = cur;
            stringBuilder.append(cur.val);
            if (cur.next != null) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] | [");

        // 添加一份反向打印的结果. 使用 | 来分割一下两份结果
        for (DLinkedNode cur = tail; cur != null; cur = cur.prev) {
            stringBuilder.append(cur.val);
            if (cur.prev != null) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public void add(int index, int val) {
        int size = size();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界: index=" + index);
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addLast(val);
            return;
        }

        DLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        DLinkedNode prev = cur.prev;
        DLinkedNode newNode = new DLinkedNode(val);


        prev.next = newNode;
        newNode.prev = prev;


        newNode.next = cur;
        cur.prev = newNode;
    }


    public boolean contains(int value) {
        for (DLinkedNode cur = head; cur != null; cur = cur.next) {
            if (cur.val == value) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int value) {
        int index = 0;
        for (DLinkedNode cur = head; cur != null; cur = cur.next) {
            if (cur.val == value) {
                return index;
            }
            index++;
        }

        return -1;
    }

}
