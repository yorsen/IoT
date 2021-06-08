package Tree;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * @author yaosen.pys
 * @date 2021/06/08
 */
public class L404 {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        return sumOfLeft(root, 0);
    }

    private static int sumOfLeft(TreeNode root, int sum) {
        if (root == null) {
            return 0 + sum;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = sum + root.left.val;
        }

        sum = sumOfLeft(root.left, sum);

        sum = sumOfLeft(root.right, sum);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode temp1 = new TreeNode(9);
        TreeNode temp2 = new TreeNode(20);
        TreeNode temp3 = new TreeNode(15);
        TreeNode temp4 = new TreeNode(7);
        TreeNode temp5 = new TreeNode(12);

       // root.left = temp1;
        root.right = temp2;
        //temp2.left = temp3;
        //temp2.right = temp4;
        //
        //temp1.right = temp5;

        System.out.println(sumOfLeftLeaves(root));
    }
}
