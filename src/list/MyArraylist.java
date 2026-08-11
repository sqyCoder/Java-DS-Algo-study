package list;

public class MyArraylist {
    public int[] elem;
    public int usedSize;
    private static final int DEFAULT_SIZE = 10;

    public MyArraylist() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.println(elem[i]);
        }
    }

    public void add(int data) {
        elem[usedSize] = data;
        usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        if (usedSize == elem.length) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPosInAdd(int pos) {
        if (pos >= 0 && pos <= usedSize) {
            return true;//合法
        } else {
            return false;
        }

    }

    public void add(int pos, int data) {
        if (!checkPosInAdd(pos)) {
            throw new RuntimeException("下标不合法");
        }
        for (int i = usedSize; i > pos; i--) {
            elem[i] = elem[i - 1];
        }
        elem[pos] = data;
        usedSize++;
    }

    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toFind) {
                return i;
            }

        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        if (!(pos >= 0 && pos < usedSize)) {
            throw new RuntimeException("下标不合法");
        }
        return elem[pos];
    }

    private boolean isEmpty() {
        if (usedSize == 0) {
            return true;
        }
        return false;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        if (!(pos >= 0 && pos < usedSize)) {
            throw new RuntimeException("下标不合法");
        }
        elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == key) {
                for (int j = i; j < usedSize - 1; j++) {
                    elem[j] = elem[j + 1];
                }
                usedSize--;
                break;
            }
        }
    }

    public int size() {
        return usedSize;
    }

    public void clear() {
        usedSize = 0;
    }

}
