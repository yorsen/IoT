package Tree;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * @author yaosen.pys
 * @date 2021/07/01
 */
public class L530 {
    private static int min = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        TreeNode maxLeft = maxLeft(root.left);
        TreeNode minRight = minRight(root.right);

        if (maxLeft != null) {
            min = Math.min(min, Math.abs(root.val - maxLeft.val));
        }

        if (minRight != null) {
            min = Math.min(min, Math.abs(root.val - minRight.val));
        }

        if (min == 1) {
            return min;
        }

        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return min;
    }

    private static TreeNode minRight(TreeNode right) {
        if (right == null) {
            return null;
        }

        TreeNode pre = right;
        while (pre.left != null) {
            pre = pre.left;
        }

        return pre;
    }

    private static TreeNode maxLeft(TreeNode left) {
        if (left == null) {
            return null;
        }

        TreeNode pre = left;
        while (pre.right != null) {
            pre = pre.right;
        }

        return pre;
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode(1);
        //TreeNode temp1 = new TreeNode(3);
        //TreeNode temp2 = new TreeNode(2);
        //root.right = temp1;
        //temp1.left = temp2;
        // System.out.println(getMinimumDifference(root));

        TreeNode root = new TreeNode(11);
        TreeNode temp1 = new TreeNode(7);
        TreeNode temp2 = new TreeNode(3);
        TreeNode temp3 = new TreeNode(9);
        TreeNode temp4 = new TreeNode(16);
        TreeNode temp5 = new TreeNode(26);

        root.left = temp1;
        temp1.left = temp2;
        temp1.right = temp3;
        root.right = temp4;
        temp4.right = temp5;

        System.out.println(getMinimumDifference(root));
    }
}
