package Tree;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/02
 */
public class L545 {
    private static int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);

        return diameter;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        diameter = Math.max(diameter, leftLength + rightLength - 1);

        return Math.max(leftLength, rightLength) + 1;
    }
}
