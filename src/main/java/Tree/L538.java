package Tree;

import common.TreeNode;
import demo.Printer;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 *
 * @author yaosen.pys
 * @date 2021/06/27
 */
public class L538 {
    private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        return sum(root);
    }

    private static TreeNode sum(TreeNode root) {
        if (root == null) {
            return null;
        }
        sum(root.right);
        root.val += sum;
        sum = root.val;
        sum(root.left);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode temp1 = new TreeNode(1);
        TreeNode temp2 = new TreeNode(0);
        TreeNode temp3 = new TreeNode(2);
        TreeNode temp4 = new TreeNode(3);
        TreeNode temp5 = new TreeNode(6);
        TreeNode temp6 = new TreeNode(5);
        TreeNode temp7 = new TreeNode(7);
        TreeNode temp8 = new TreeNode(8);

        root.left = temp1;
        temp1.left = temp2;
        temp1.right = temp3;
        temp3.right = temp4;

        root.right = temp5;
        temp5.left = temp6;
        temp5.right = temp7;
        temp7.right = temp8;

        Printer.inOrder(root);
        root = convertBST(root);


        Printer.inOrder(root);


    }
}
