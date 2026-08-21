package heap;

import java.util.Arrays;

public class MyHeap {
    // 先实现向下调整
    // arr 表示当前存储堆的数组.
    // subRoot 表示从哪个节点开始调整 (这个节点就是该子树的根节点)
    private static void shiftDown(int[] arr, int size, int subRoot) {
        int parent = subRoot;       // 父节点
        int child = 2 * parent + 1; // 左子树节点
        // 实际有效元素只是数组的一部分
        // int size = arr.length;      // 整个数组的长度

        while (child < size) {
            if (child + 1 < size && arr[child + 1] < arr[child]) {
                // 右子树存在, 并且右子树更小, 接下来 就需要使用右子树和根节点对比
                child = child + 1;
            }
            // 通过上面的判定之后, child 一定指向左右子树 "较小值"
            // 对比父节点和该子节点大小关系, 看是否符合 "小堆" 的要求
            if (arr[parent] < arr[child]) {
                // 父亲比孩子小, 符合小堆的要求, 不需要做任何事情
                break;
            } else {
                // 父亲比孩子大, 不符合小堆的要求, 把父和子的值进行交换
                int temp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = temp;

                // 继续向下调整
                parent = child;
                child = 2 * parent + 1;
            }
        }
    }

    // 向上调整
    private static void shiftUp(int[] arr, int child) {
        // 找到父节点
        int parent = (child - 1) / 2;

        // 如果 child == 0 就结束了. 根节点没有父亲的, 不需要继续向上调整了.
        while (child > 0) {
            if (arr[parent] < arr[child]) {
                // 符合小堆的要求
                break;
            }
            // 交换父和子元素
            int temp = arr[parent];
            arr[parent] = arr[child];
            arr[child] = temp;

            child = parent;
            parent = (child - 1) / 2;
        }
    }


    // 建立堆的操作
    // 把一个指定数组, 里面的元素调整, 使最终这个数组符合堆的要求
    // 针对任意节点, 值都 大于/小于 子节点
    // 我们此处就按照小堆的方式来实现. (为了和课件中 例子 一致)
    public static void createHeap(int[] arr, int size) {
        // root 表示当前要调整的子树的根节点下标
        for (int root = (size - 1 - 1) / 2; root >= 0; root--) {
            shiftDown(arr, size, root);
        }
    }

    // 实现一个插入元素到堆的操作
    // 需要通过这个 size 来指定当前数组中有效元素个数是多少.
    // 为了尾插, arr 数组的长度需要提前申请好的.
    // 返回结果是插入之后, 堆中的有效元素的个数
    public static int add(int[] arr, int size, int val) {
        if (size >= arr.length) {
            throw new RuntimeException("数组已满");
        }
        // 把新的元素放到 size 位置上, 进行尾插
        arr[size] = val;
        size++;

        // 从最后一个位置开始, 进行向上调整.
        shiftUp(arr, size - 1);
        return size;
    }

    // 删除堆顶元素, 返回值是删除的元素的值
    // 还是返回删除后有效元素个数. 被删除元素的值不再记录. 如果有需要, 调用者可以先获取堆顶元组, 再调用删除.
    public static int remove(int[] arr, int size) {
        if (size == 0) {
            return 0;
        }
        // 用最后一个元素, 代替堆顶元素
        arr[0] = arr[size - 1];
        size--;

        // 进行向下调整
        shiftDown(arr, size, 0);

        return size;
    }

    public static int getHeapTop(int[] arr) {
        return arr[0];
    }

    public static void main(String[] args) {
        // 根据这组数据, 构造出小堆出来
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        createHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}