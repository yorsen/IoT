package Tree;

import common.TreeNode;
import demo.Printer;

/**
 * @author yaosen.pys
 * @date 2021/06/23
 */
public class L669 {
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (null == root) {
            return root;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public static void main(String[] args) {

        /**
         *     3
         *    / \
         *   0   4
         *    \
         *     2
         *    /
         *   1
         */
        TreeNode root = new TreeNode(3);
        TreeNode temp1 = new TreeNode(0);
        TreeNode temp2 = new TreeNode(4);
        TreeNode temp3 = new TreeNode(2);
        TreeNode temp4 = new TreeNode(1);

        root.left = temp1;
        root.right = temp2;
        temp1.right = temp3;
        temp3.left = temp4;

        TreeNode newRoot = trimBST(root, 1, 3);
        Printer.inOrder(newRoot);
    }
}
