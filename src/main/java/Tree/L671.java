package Tree;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 * @author yaosen.pys
 * @date 2021/06/16
 */
public class L671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int leftValue = root.left.val;
        int rightValue = root.right.val;

        if (root.val == root.left.val) {
            leftValue = findSecondMinimumValue(root.left);
        }

        if (root.val == root.right.val) {
            rightValue = findSecondMinimumValue(root.right);
        }

        if (leftValue != -1 && rightValue != -1) {
            return Math.min(leftValue, rightValue);
        } else if (leftValue != -1) {
            return leftValue;
        } else {
            return rightValue;
        }
    }
}
