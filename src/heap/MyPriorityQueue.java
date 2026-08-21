package heap;

// 优先级队列
public class MyPriorityQueue {
    private int[] arr;
    private int size;

    public MyPriorityQueue() {
        this.arr = new int[1000];
        this.size = 0;
    }

    public void offer(int val) {
        size = MyHeap.add(arr, size, val);
    }

    public int poll() {
        int ret = arr[0];
        size = MyHeap.remove(arr, size);
        return ret;
    }

    public int peek() {
        return arr[0];
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}