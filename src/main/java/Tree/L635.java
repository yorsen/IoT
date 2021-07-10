package Tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/07/01
 */
public class L635 {
    private static List<Integer> value = new ArrayList<>();

    public static boolean findTarget(TreeNode root, int k) {
        inOrder(root);

        int start = 0, end = value.size() - 1;

        while (start < end) {
            int sum = value.get(start) + value.get(end);
            if (sum < k) {
                start++;
            } else if (sum > k) {
                end--;
            } else {
                return true;
            }
        }

        return false;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        value.add(root.val);
        inOrder(root.right);
    }

    /**
     * 5
     * / \
     * 3   6
     * / \   \
     * 2   4   7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode temp1 = new TreeNode(3);
        TreeNode temp2 = new TreeNode(2);
        TreeNode temp3 = new TreeNode(4);
        TreeNode temp4 = new TreeNode(6);
        TreeNode temp5 = new TreeNode(7);

        root.left = temp1;
        temp1.left = temp2;
        temp1.right = temp3;
        root.right = temp4;
        temp4.right = temp5;

        System.out.println(findTarget(root, 28));
    }
}
