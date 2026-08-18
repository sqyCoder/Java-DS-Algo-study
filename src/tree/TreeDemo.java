package tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}


public class TreeDemo {


    public static TreeNode buildTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }


    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            // 把左右子树入队列
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }



    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public static int getLeafCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {

            return 1;
        }
        return getLeafCount(root.left) + getLeafCount(root.right);
    }

    public static int getKLevelCount(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelCount(root.left, k - 1) + getKLevelCount(root.right, k - 1);
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));

    }

    public static TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {

            return root;
        }

        TreeNode leftResult = find(root.left, val);
        if (leftResult != null) {

            return leftResult;
        }

        return find(root.right, val);
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isSecondStep = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode cur = queue.poll();
            if (!isSecondStep) {

                if (cur.left != null && cur.right != null) {

                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {

                    return false;
                } else if (cur.left != null && cur.right == null) {

                    queue.offer(cur.left);
                    isSecondStep = true;
                } else {

                    isSecondStep = true;
                }
            } else {

                if (cur.left != null || cur.right != null) {

                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();

        System.out.println(find(root, 5));
    }
}