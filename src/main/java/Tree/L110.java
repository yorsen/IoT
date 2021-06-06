package Tree;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * @author yaosen.pys
 * @date 2021/06/02
 */
public class L110 {
    private static Boolean balance = true;

    public Boolean isBlanced(TreeNode root) {
        maxDepth(root);
        return balance;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);

        if (Math.abs(leftLength - rightLength) > 1) {
            balance = false;
        }

        return Math.max(leftLength, rightLength) + 1;
    }
}
