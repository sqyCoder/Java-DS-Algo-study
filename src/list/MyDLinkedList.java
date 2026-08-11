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

}
