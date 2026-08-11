package list;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        Node cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void addFirst(int data) {
        Node cur = new Node(data);
        cur.next = head;
        head = cur;
    }

    public void addLast(int data) {
        Node cur = new Node(data);
        Node tail = head;
        if (head == null) {
            head = cur;
            return;
        } else {
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = cur;
        }

    }

    public void addIndex(int index, int data) {
        int curSize = this.size();

        if (index < 0 || index > curSize) {
            throw new IndexOutOfBoundsException("下标越界! index=" + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == curSize) {
            addLast(data);
            return;
        }

        Node cur = new Node(data);
        Node pre = head;

        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }

        cur.next = pre.next;
        pre.next = cur;
    }

    public boolean contains(int key) {
        Node cur = head;
        for (; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    public void remove(int key) {

        if (head == null) {
            return;
        }

        Node cur = head.next;
        Node pre = head;

        if (head.data == key) {
            head = head.next;
            return;
        }

        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                return;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public void removeAllKey(int key) {

        while (head != null && head.data == key) {
            head = head.next;
        }

        if (head == null) {
            return;
        }

        Node cur = head.next;
        Node pre = head;

        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        Node cur = head;

        System.out.print("[");
        for (; cur != null; cur = cur.next) {
            System.out.print(cur.data);

            if (cur.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public void clear() {
        head = null;
    }

}


