package list;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);

        // 获取 list 中的 "子集"
        // 包含下标为 1, 2 这两个元素
        System.out.println(list.subList(1, 3));

        // 使用 indexOf 判定当前元素处于集合类的哪个位置上.
//        // 从左往右找的.
//        System.out.println(list.indexOf(1));
//        // 从右往左找
//        System.out.println(list.lastIndexOf(1));

        // 使用 contains 方法判定, 某个元素是否在集合类中存在
        // System.out.println(list.contains(100));

        // clear 清空集合类中的所有元素
//        list.clear();
//        list = null;

        // 通过下标来读/写元素 (类似于数组)
        // 不是通过 [ ]  而是, get 和 set 方法
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, 100 + i);
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }


        // 按照下标来删除
//        list.remove(0);
//        System.out.println(list);

        // 按照值来删除
//        list.remove(Integer.valueOf(1));
//        System.out.println(list);


        // 添加元素
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        // 往指定下标位置 / 指定下标元素之前, 添加元素
//        list.add(2, 100);
//
//        System.out.println(list);
    }
}