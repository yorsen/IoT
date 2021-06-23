package Tree;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/08
 */
public class L687 {
    /**
     *   1
     *  / \
     * 4   5
     * / \   \
     * 4   4   5
     *     \
     *      4
     * @param root
     * @return
     */
    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLength = lengthValue(root.left, root.val) + lengthValue(root.right, root.val);

        maxLength = Math.max(maxLength, longestUnivaluePath(root.left));

        maxLength = Math.max(maxLength, longestUnivaluePath(root.right));

        return maxLength;
    }

    public static int lengthValue(TreeNode root, int value) {
        if (root == null || root.val != value) {
            return 0;
        }

        return Math.max(lengthValue(root.left, value), lengthValue(root.right, value)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode temp1 = new TreeNode(4);
        TreeNode temp2 = new TreeNode(5);
        TreeNode temp3 = new TreeNode(4);
        TreeNode temp4 = new TreeNode(4);
        TreeNode temp5 = new TreeNode(5);
        TreeNode temp6 = new TreeNode(4);
        root.left = temp1;
        root.right = temp2;
        temp1.left = temp3;
        temp1.right = temp4;
        temp2.right = temp5;

        temp4.right = temp6;

        TreeNode.preOrder(root);

        System.out.println("length = " + String.valueOf(longestUnivaluePath(null)));
    }
}
