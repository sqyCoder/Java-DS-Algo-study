package queue;

import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        // 入队列
        queue.offer(1);
        // 出队列
        Integer ret = queue.poll();
        // 取队首元素
        Integer peek = queue.peek();
    }
}