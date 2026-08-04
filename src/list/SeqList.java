    package list;

    public class SeqList {

        private int[] data;

        private int size = 0;
        public SeqList() {
            data = new int[1024];
        }

        public SeqList(int capacity) {
            data = new int[capacity];
        }

        public void add(int value) {
            if (size == data.length) {
                realloc();
            }
            data[size] = value;
            size++;
        }

        public int getSize() {
            return size;
        }

        public void clear() {
            size = 0;
        }

        private void realloc() {
            int[] newData = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        public void add(int index, int value) {
            if (size == data.length) {
                realloc();
            }
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = value;
            size++;
        }

        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new RuntimeException("索引越界, index = " + index);
            }
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }

        public void removeByValue(int value) {
            int index = indexOf(value);
            if (index == -1) {
                return;
            }
            remove(index);
        }

        public boolean contains(int value) {
            for (int i = 0; i < size; i++) {
                if (data[i] == value) {
                    return true;
                }
            }
            return false;
        }

        public int indexOf(int value) {
            for (int i = 0; i < size; i++) {
                if (data[i] == value) {
                    return i;
                }
            }
            return -1;
        }

        public int get(int index) {
            return data[index];
        }

        public void set(int index, int value) {
            data[index] = value;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i = 0; i < size; i++) {
                stringBuilder.append("" + data[i]);
                if (i < size - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public static void main(String[] args) {
            SeqList list = new SeqList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            System.out.println(list);
        }
    }
