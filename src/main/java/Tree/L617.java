package Tree;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/description/
 *
 * @author yaosen.pys
 * @date 2021/06/06
 */
public class L617 {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return root1;
        }

        if (root1 == null && root2 != null) {
            root1 = root2;
            return root1;
        }

        if (root1 != null && root2 == null) {
            return root1;
        }

        if (root1.left != null && root2.left != null) {
            mergeTrees(root1.left, root2.left);
        }

        if (root1.right != null && root2.right != null) {
            mergeTrees(root1.right, root2.right);
        }

        if (root1 != null && root2 != null) {
            root1.val += root2.val;
        }

        if (root1.left == null && root2.left != null) {
            root1.left = root2.left;
        }

        if (root1.right == null && root2.right != null) {
            root1.right = root2.right;
        }

        return root1;
    }

    public static void main(String[] args) {
        TreeNode rootOne = new TreeNode(1);
        TreeNode temp1 = new TreeNode(3);
        TreeNode temp2 = new TreeNode(2);
        TreeNode temp3 = new TreeNode(5);

        rootOne.left = temp1;
        temp1.left = temp3;
        rootOne.right = temp2;

        TreeNode rootTwo = new TreeNode(2);
        TreeNode temp4 = new TreeNode(1);
        TreeNode temp5 = new TreeNode(3);
        TreeNode temp6 = new TreeNode(4);
        TreeNode temp7 = new TreeNode(7);

        //rootTwo.left = temp4;
        //rootTwo.right = temp5;
        //temp4.right = temp6;
        //temp5.right = temp7;

        System.out.println("rootOne");
        TreeNode.preOrder(rootOne);

        System.out.println("rootTwo");
        TreeNode.preOrder(rootTwo);

        TreeNode root = mergeTrees(rootOne,rootTwo);

        System.out.println("rootCombine");
        TreeNode.preOrder(root);
    }
}
