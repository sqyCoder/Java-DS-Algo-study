package stack;

// 基于顺序表的方式实现栈. 暂时不考虑泛型, 只是存储 int 数据
public class MyStack {
    private int[] array;
    private int size;

    public MyStack() {
        array = new int[1000];
        size = 0;
    }

    // 栈的核心操作是三个
    // 入栈
    public void push(int value) {
        if (size >= array.length) {
            // 扩容
            realloc();
        }
        array[size] = value;
        size++;
    }

    // 出栈, 返回被出栈的元素
    public int pop() {
        if (size == 0) {
            throw new RuntimeException("栈为空");
        }
        int ret = array[size - 1];
        size--;
        return ret;
    }

    // 取栈顶元素
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("栈为空");
        }
        return array[size - 1];
    }

    // 栈的扩容操作
    private void realloc() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}