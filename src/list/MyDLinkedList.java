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

    public void addLast(int val) {
        DLinkedNode newNode = new DLinkedNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        DLinkedNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        newNode.prev = cur;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        DLinkedNode tail = null;
        for (DLinkedNode cur = head; cur != null; cur = cur.next) {
            tail = cur;
            stringBuilder.append(cur.val);
            if (cur.next != null) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] | [");

        for (DLinkedNode cur = tail; cur != null; cur = cur.prev) {
            stringBuilder.append(cur.val);
            if (cur.prev != null) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public int size() {
        int size = 0;
        for (DLinkedNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
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

    public void removeFirst() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        DLinkedNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        DLinkedNode prev = tail.prev;
        prev.next = null;
    }

    public void remove(int index) {
        int size = size();
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界: index=" + index);
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        DLinkedNode prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        DLinkedNode toDelete = prev.next;
        DLinkedNode next = toDelete.next;

        prev.next = next;
        next.prev = prev;
    }

    public void removeByValue(int value) {
        if (head == null) {
            return;
        }

        if (head.val == value) {
            removeFirst();
            return;
        }
        DLinkedNode cur = head;
        for (; cur != null; cur = cur.next) {
            if (cur.val == value) {
                break;
            }
        }
        if (cur == null) {
            return;
        }
        DLinkedNode prev = cur.prev;
        DLinkedNode next = cur.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }
}