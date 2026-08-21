package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// 定义一个比较器类
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // 这样写的含义, 就是让小的值先出队列
        // return o1 - o2;
        // 如果是让打的值先出队列
        return o2 - o1;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.age - o1.age;
    }
}

class StudentComparator2 implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.id - o2.id;
    }
}

class Student implements Comparable<Student> {
    public int id;
    public String name;
    public int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        // 按照 id 小的先出队列的方式定义的.
        return o.id - this.id;
    }
}

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Student> queue = new PriorityQueue<>();
        queue.offer(new Student(1, "张三", 18));
        queue.offer(new Student(2, "李四", 19));
        queue.offer(new Student(3, "王五", 18));
        queue.offer(new Student(4, "赵六", 19));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());


        //PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComparator());
        // 使用方式和普通队列其实是差不多
//        queue.offer(9);
//        queue.offer(5);
//        queue.offer(2);
//        queue.offer(7);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
    }
}