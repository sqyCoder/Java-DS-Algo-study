package list;
import java.util.ArrayList;
import java.util.List;

public class YangHuiByArrayList {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        triangle.add(row1);

        if (numRows == 1) {
            return triangle;
        }

        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        triangle.add(row2);

        // i从0开始，总共还要构建 numRows-2 行
        for (int i = 0; i < numRows - 2; i++) {
            // 获取上一行
            List<Integer> prevRow = triangle.get(triangle.size() - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < prevRow.size() - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    // main方法测试
    public static void main(String[] args) {
        YangHuiByArrayList demo = new YangHuiByArrayList();
        List<List<Integer>> result = demo.generate(6);
        for (List<Integer> line : result) {
            System.out.println(line);
        }
    }
}