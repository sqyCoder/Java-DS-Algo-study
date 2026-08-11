package list;

class LinkedNode {
    public int val;
    public LinkedNode next;

    public LinkedNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MyLinkedList {
    private LinkedNode head = null;

    public LinkedNode getHead() {
        return head;
    }

    public void add(int index, int value) {
        int size = this.size();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界! index=" + index);
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        LinkedNode preNode = head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        LinkedNode newNode = new LinkedNode(value);
        newNode.next = preNode.next;
        preNode.next = newNode;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        LinkedNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void addFirst(int value) {
        LinkedNode newNode = new LinkedNode(value);
        if (head == null) {
            this.head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

            public void addLast(int value) {
                LinkedNode newNode = new LinkedNode(value);
                if (head == null) {
                    head = newNode;
                    return;
                }
                LinkedNode cur = head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = newNode;
            }

    public boolean contains(int value) {
        for (LinkedNode cur = head; cur != null; cur = cur.next) {
            if (cur.val == value) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int value) {
        int index = 0;
        for (LinkedNode cur = head; cur != null; cur = cur.next) {
            if (cur.val == value) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("下标越界! index=" + index);
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        LinkedNode prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        LinkedNode toDelete = prev.next;
        prev.next = toDelete.next;
    }

    public void removeByValue(int value) {
        if (head == null) {
            return;
        }
        if (head.val == value) {
            head = head.next;
            return;
        }
        LinkedNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == value) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next == null) {
            return;
        }
        LinkedNode toDelete = prev.next;
        prev.next = toDelete.next;
    }

    public void removeAllValue(int value) {
        if (head == null) {
            return;
        }
        LinkedNode cur = head.next;
        LinkedNode prev = head;
        while (cur != null) {
            if (cur.val == value) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == value) {
            head = head.next;
        }
    }

    public void clear() {
        head = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        for (LinkedNode cur = head; cur != null; cur = cur.next) {
            if (i == index) {
                return cur.val;
            }
            i++;
        }
        return 0;
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        for (LinkedNode cur = head; cur != null; cur = cur.next) {
            if (i == index) {
                cur.val = value;
                return;
            }
            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        LinkedNode cur = head;
        while (cur != null) {
            stringBuilder.append(cur.val);
            if (cur.next != null) {
                stringBuilder.append(",");
            }
            cur = cur.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // ==================== main 方法，直接运行测试 ====================
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        System.out.println("===== 添加元素 =====");
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.add(1, 15);
        System.out.println("列表: " + list);   // [10,15,20,30]
        System.out.println("大小: " + list.size());

        System.out.println("\n===== 查询 =====");
        System.out.println("索引1的元素: " + list.get(1));
        System.out.println("是否包含20: " + list.contains(20));
        System.out.println("20的索引: " + list.indexOf(20));

        System.out.println("\n===== 修改 =====");
        list.set(2, 25);
        System.out.println("修改后: " + list);   // [10,15,25,30]

        System.out.println("\n===== 删除 =====");
        list.remove(0);
        System.out.println("删除索引0后: " + list);  // [15,25,30]
        list.removeByValue(25);
        System.out.println("按值删25后: " + list);   // [15,30]

        list.addLast(15);
        list.addLast(15);
        list.addLast(40);
        System.out.println("添加重复值后: " + list); // [15,30,15,15,40]
        list.removeAllValue(15);
        System.out.println("删除所有15后: " + list); // [30,40]

        System.out.println("\n===== 清空 =====");
        list.clear();
        System.out.println("清空后大小: " + list.size());
        System.out.println("列表: " + list);

        System.out.println("\n===== 边界测试 =====");
        try {
            list.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("异常捕获: " + e.getMessage());
        }
    }
}